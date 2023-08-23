package org.seckill.service.impl;

import org.seckill.dao.SeckillDao;
import org.seckill.dao.SuccessKilledDao;
import org.seckill.dto.ExposerRsp;
import org.seckill.dto.SeckillExecutionRsp;
import org.seckill.entity.Seckill;
import org.seckill.entity.SuccessKilled;
import org.seckill.enums.SeckillStatEnum;
import org.seckill.exception.RepeatKillException;
import org.seckill.exception.SeckillCloseException;
import org.seckill.exception.SeckillException;
import org.seckill.service.SeckillService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.test.annotation.Repeat;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;

import java.util.Date;
import java.util.List;

/**
 * Created by hujiayu on 2017/5/29.
 */
// @Component @Service @Dao @Conroller
@Service
public class SeckillServiceImpl implements SeckillService {
//创建一个logger对象用于记录日志，通过LoggerFactory.getLogger(this.getClass())来获取具体类的Logger对象
    private Logger logger = LoggerFactory.getLogger(this.getClass());

//    注入Service依赖  //@Resource,@Inject
    @Autowired
    private SeckillDao seckillDao;

    @Autowired
    private SuccessKilledDao successKilledDao;

//    md5盐值字符串，用于混淆MD5
//    一个字符串盐值，用于在生成MD5时进行混淆，增强安全性
    private final String slat = "sdaafdalk21dsaasmdl^&%^";
//    从数据库中查询秒杀商品列表
    public List<Seckill> getSeckillList() {
        return seckillDao.queryAll(0, 6);
    }
//    根据秒杀商品ID从数据库中获取对应的商品信息
    public Seckill getById(long seckillId) {
        return seckillDao.queryById(seckillId);
    }
//    暴露秒杀的URL。根据传入的秒杀商品ID，判断是否可以进行秒杀操作，根据秒杀开始时间，结束时间和当前系统时间，生成一个ExposerRsp对象作为响应
    public ExposerRsp exprotSeckillUrl(long seckillId) {
        Seckill seckill = seckillDao.queryById(seckillId);
        if (seckill == null) {
            return new ExposerRsp(false, seckillId);
        }
        //秒杀时间
        Date startTime = seckill.getStartTime();
        Date endTime = seckill.getEndTime();
//        系统时间
        Date nowTime = new Date();
        if (nowTime.getTime() < startTime.getTime() || nowTime.getTime() > endTime.getTime()) {
            return new ExposerRsp(false, seckillId, nowTime.getTime(), startTime.getTime(), endTime.getTime());
        }
//        转化特定字符串的过程，不可逆
//        根据传入的秒杀商品ID和盐值slat，生成对应的MD5字符串
        String md5 = getMD5(seckillId);
        return new ExposerRsp(true,md5,seckillId);
    }
//        根据传入的秒杀商品ID和盐值slat，生成对应的MD5字符串
    private String getMD5(long seckillId){
        String base = seckillId + "/" + slat;
        String md5 = DigestUtils.md5DigestAsHex(base.getBytes());
        return md5;
    }

    @Transactional
    /**
     * 使用注解控制事务方法的优点
     * 1.开发团队达成一致约定，明确标注事务方法的编程风格
     * 2.保证事务方法的执行时间尽可能短，不要穿插其他网络操作，RPC/HTTP请求 或者 剥离到事务方法之外
     * 3.不是所有的方法都需要事务，如只有一条修改操作，只读操作不需要事务控制。
     */
//    执行秒杀操作的方法executeSeckill，他接受秒杀商品ID，用户手机号和MD5字符串作为参数，返回一个SeckillExceptionRsp对象作为响应
    public SeckillExecutionRsp executeSeckill(long seckillId, long userPhone, String md5) throws SeckillException, RepeatKillException, SeckillCloseException {
//        验证MD5：首先通过判断传入的MD5是否为空，以及是否与生成的MD5相等，来确保秒杀数据没有被篡改。如果不相等，抛出异常，提示秒杀数据被篡改
        if (md5 == null || !md5.equals(getMD5(seckillId))) {
            throw new SeckillException("seckill data rewrite");
        }
        //执行秒杀逻辑：减库存 + 记录购买行为，根据当前系统时间进行业务处理
        Date nowTime = new Date();
//        调用seckillDao.reduceNumber方法，将库存数量减少，如果返回的更新记录数小于等于0，表示秒杀结束，抛出异常提示秒杀已关闭
        try {
            //减库存
            int updateCount = seckillDao.reduceNumber(seckillId, nowTime);
            if (updateCount <= 0) {
                //没有更新到记录
                throw new SeckillCloseException("seckill is closed");
            } else {
//                否则同时记录购买行为，调用successKilledDao.insertSuccessKilled方法插入购买记录，如果返回的插入记录数小于等于0，表示用户重复秒杀，抛出异常
                // 记录购买行为
                int insertCount = successKilledDao.insertSuccessKilled(seckillId, userPhone);
                if (insertCount <= 0) {
                    //重复秒杀
                    throw new RepeatKillException("seckill repeated");
                } else {
//                    如果购买行为记录成功插入，则根据seckillId和userPhone查询购买明细，并创建一个SuccessKilled对象作为秒杀成功的响应
                    //秒杀成功
                    SuccessKilled successKilled = successKilledDao.queryByIdWithSeckill(seckillId, userPhone);
                    return new SeckillExecutionRsp(seckillId, SeckillStatEnum.SUCCESS, successKilled);
                }
            }
        } catch (SeckillCloseException e1) {
            throw e1;
        } catch (RepeatKillException e2) {
            throw e2;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
//            所有编译期异常转化为运行期异常
            throw new SeckillException("seckill inner error:" + e.getMessage());
        }
    }
}
