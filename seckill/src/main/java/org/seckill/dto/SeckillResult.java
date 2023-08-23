package org.seckill.dto;

/**
 * Created by hujiayu on 2017/7/27.
 */
//所有ajax的请求返回类型，封装json结果
//    表示秒杀结果的响应对象，它使用了泛型
//    创建这个对象并设置相应的属性值，可以获取秒杀操作的结果信息，包括成功标识，相关数据和错误信息，其中，如果秒杀操作成功，可以通过getdata方法获取成功执行的对象或者其他数据，如果发生错误，可以通过geterror方法获取错误信息
public class SeckillResult<T> {
    private boolean success;//表示秒杀操作是否成功
    private T data;//泛型类型的数据，可以是成功执行的对象或者其他需要返回的数据
    private String error; //错误信息
    public SeckillResult(boolean status, T data) {
        this.success = status;
        this.data = data;
    }
    public SeckillResult(boolean status, String error) {
        this.success = status;
        this.error = error;
    }
    public boolean isSuccess() {
        return success;
    }
    public void setSuccess(boolean status) {
        this.success = status;
    }
    public T getData() {
        return data;
    }
    public void setData(T data) {
        this.data = data;
    }
    public String getError() {
        return error;
    }
    public void setError(String error) {
        this.error = error;
    }
}
