package org.seckill.dto;

/**
 * 暴露秒杀地址DTO，出参类
 * Created by hujiayu on 2017/5/28.
 */
//这是一个名为ExposerRsp的Java类，她表示一个响应对象，用于暴露秒杀商品的状态信息
//    这个类用来封装秒杀商品暴露状态信息的，通过设置和获取对象的属性值，可以获取秒杀商品是否暴露，加密措施，秒杀商品ID，系统当前时间以及秒杀的开始和结束时间等信息
public class ExposerRsp {
    //是否暴露，是否开启秒杀
    private boolean exposed;
    //    一种加密措施
    private String md5;
    //    id
    private long seckillId;
    //    系统当前时间(毫秒)
    private long now;
    //    开启时间
    private long start;
    //    结束时间
    private long end;
    //是否开启 md5 ，seckillId
    public ExposerRsp(boolean exposed, String md5, long seckillId) {
        this.exposed = exposed;
        this.md5 = md5;
        this.seckillId = seckillId;
    }

    public ExposerRsp(boolean exposed, long seckillId, long now, long start, long end) {
        this.exposed = exposed;
        this.seckillId = seckillId;
        this.now = now;
        this.start = start;
        this.end = end;
    }

    public ExposerRsp(boolean exposed, long seckillId) {
        this.exposed = exposed;
        this.seckillId = seckillId;
    }

    @Override
    public String toString() {
        return "ExposerRsp{" +
                "exposed=" + exposed +
                ", md5='" + md5 + '\'' +
                ", seckillId=" + seckillId +
                ", now=" + now +
                ", start=" + start +
                ", end=" + end +
                '}';
    }

    public boolean isExposed() {
        return exposed;
    }

    public void setExposed(boolean exposed) {
        this.exposed = exposed;
    }

    public String getMd5() {
        return md5;
    }

    public void setMd5(String md5) {
        this.md5 = md5;
    }

    public long getSeckillId() {
        return seckillId;
    }

    public void setSeckillId(long seckillId) {
        this.seckillId = seckillId;
    }

    public long getNow() {
        return now;
    }

    public void setNow(long now) {
        this.now = now;
    }

    public long getStart() {
        return start;
    }

    public void setStart(long start) {
        this.start = start;
    }

    public long getEnd() {
        return end;
    }

    public void setEnd(long end) {
        this.end = end;
    }
}
