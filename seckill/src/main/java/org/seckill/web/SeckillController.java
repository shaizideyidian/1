package org.seckill.web;

import org.seckill.dto.ExposerRsp;
import org.seckill.dto.SeckillExecutionRsp;
import org.seckill.dto.SeckillResult;
import org.seckill.entity.Seckill;
import org.seckill.enums.SeckillStatEnum;
import org.seckill.exception.RepeatKillException;
import org.seckill.exception.SeckillCloseException;
import org.seckill.service.SeckillService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * Created by hujiayu on 2017/7/27.
 */
//控制器组件
@Controller //@Service @Component
@RequestMapping("/seckill")//url:模块/资源/{id}/细分 /seckill/list
//这是一个秒杀模块的控制器类SeckillController，他处理与秒杀相关的请求
public class SeckillController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private SeckillService seckillService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String list(Model model) {
//        seckillService.getSeckillList方法获取秒杀商品列表，然后将列表存储再model中，供视图使用
        //获取列表页
        List<Seckill> list = seckillService.getSeckillList();
        model.addAttribute("list", list);
        //list.jsp + model = ModelAndView
        return "list"; ///WEB-INF/jsp/"list".jsp
    }
    @RequestMapping(value = "/{seckillId}/detail", method = RequestMethod.GET)
    public String detail(@PathVariable("seckillId") Long seckillId, Model model) {
//        方法检测seckillId是否为空，若为空则重定向
        if (seckillId == null) {
            return "redirect:/seckill/list";
        }
//        然后通过seckillService.getById方法获取指定ID的秒杀商品信息，若商品不存在，则转发到页面
        Seckill seckill = seckillService.getById(seckillId);
        if (seckill == null) {
            return "forward:/seckill/list";
        }
//        最后将查询到的商品信息存储到model中，供视图使用
        model.addAttribute("seckill", seckill);
        return "detail";  //WEB-INF/jsp/"detail".jsp
    }
    //ajax json
    @RequestMapping(value = "/{seckillId}/exposer", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public SeckillResult<ExposerRsp> exposer(@PathVariable Long seckillId) {
        SeckillResult<ExposerRsp> result;
        try {
//            通过seckillService.exprotSeckillUrl方法获取暴露秒杀接口的结果ExposerRsp，然后将结果包装成SeckillResult<ExposerRsp>对象
            ExposerRsp exposer = seckillService.exprotSeckillUrl(seckillId);
            result = new SeckillResult<ExposerRsp>(true, exposer);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            result = new SeckillResult<ExposerRsp>(false, e.getMessage());
        }
        return result;
    }
    @RequestMapping(value = "/{seckillId}/{md5}/execution", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public SeckillResult<SeckillExecutionRsp> execute(@PathVariable("seckillId") Long seckillId,
                                                      @PathVariable("md5") String md5,
                                                      @CookieValue(value = "killPhone") Long phone) {
        // springmvc valid
//        首先校验用户是否注册，若手机号为空，则返回一个未注册的错误信息
        if (phone == null) {
            return new SeckillResult<SeckillExecutionRsp>(false, "未注册");
        }
        SeckillResult<SeckillExecutionRsp> resullt;
        try {
//        然后调用seckillService.executeSeckill方法执行秒杀操作，并将执行结果包装成SeckillResult<SeckillExecutionRsp>对象返回
            SeckillExecutionRsp executionRsp = seckillService.executeSeckill(seckillId, phone, md5);
            return new SeckillResult<SeckillExecutionRsp>(true, executionRsp);
        } catch (RepeatKillException e) {
            SeckillExecutionRsp executionRsp = new SeckillExecutionRsp(seckillId, SeckillStatEnum.REPEAT_KILL);
            return new SeckillResult<SeckillExecutionRsp>(true, executionRsp);
        } catch (SeckillCloseException e) {
            SeckillExecutionRsp executionRsp = new SeckillExecutionRsp(seckillId, SeckillStatEnum.END);
            return new SeckillResult<SeckillExecutionRsp>(true, executionRsp);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            SeckillExecutionRsp executionRsp = new SeckillExecutionRsp(seckillId, SeckillStatEnum.INNER_ERROR);
            return new SeckillResult<SeckillExecutionRsp>(true, executionRsp);
        }
    }
    @RequestMapping(value = "/time/now", method = RequestMethod.GET)
    @ResponseBody
//    获取当前时间，并将时间戳作为响应返回
    public SeckillResult<Long> time(){
        Date now = new Date();
        return new SeckillResult(true, now.getTime());
    }

}

