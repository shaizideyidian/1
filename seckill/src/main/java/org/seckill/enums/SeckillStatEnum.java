package org.seckill.enums;

/**
 * 使用枚举表示常量数据
 * Created by hujiayu on 2017/6/28.
 */
//定义一个枚举类，表示秒杀状态的枚举常量
public enum SeckillStatEnum {
    SUCCESS(1,"秒杀成功"),
    END(0,"秒杀结束"),
    REPEAT_KILL(-1,"重复秒杀"),
    INNER_ERROR(-2,"系统异常"),
    DATA_REWRITE(-3,"数据篡改");


    private int state;

    private String stateInfo;

    SeckillStatEnum(int state, String stateInfo) {
        this.state = state;
        this.stateInfo = stateInfo;
    }
//获取状态码
    public int getState() {
        return state;
    }
//获取状态信息
    public String getStateInfo() {
        return stateInfo;
    }
//用于根据给定的状态码返回相应的枚举常量
    public static SeckillStatEnum startOf(int index){
        for(SeckillStatEnum state : values()){
            if(state.getState() == index){
                return state;
            }
        }
        return null;
    }
}
