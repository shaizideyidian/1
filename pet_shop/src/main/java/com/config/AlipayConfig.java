package com.config;

import java.io.FileWriter;
import java.io.IOException;

/* *
 *类名：AlipayConfig
 *功能：基础配置类
 *详细：设置帐户有关信息及返回路径
 *修改日期：2017-04-05
 *说明：
 *以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 *该代码仅供学习和研究支付宝接口使用，只是提供一个参考。
 */

public class AlipayConfig {
//↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓
	// 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
	public static String app_id = "2021000122679604";
	
	// 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvwIBADANBgkqhkiG9w0BAQEFAASCBKkwggSlAgEAAoIBAQCvaNA+Y6TUecITNwcPQzDZmALnLALYEvW+DAIWjz5zdrbLGdSt+TWK74kd6bSQJLK0O3LJChQcZUcKkUA4znpiSfXrtOJURvZTfACy+D7aa93orPBcAUbVWkS+AVrURsWIGaCYN+LJzVnbVPlD+A7yGLRquaD7tKdHAu7LkHXPU8X/FaEGUYFwp0k9/Roh3WLTHe+JeUvQCvnyKGN/jmUnSDK4j+T5ZvKFeNMGknnIQ2qNXe21u3dBUxzwLFl0yqq/JVMLA0YXsqbCZQkFI0iYqpKSobIZ5E4tRkAa63/bt+d8uVpyCeORfCuVZNPV8QLpkJDNQvKgm5ZEhMwQVqvDAgMBAAECggEBAKmJhdT3XEYdVO5bflBLIfj+CrhC+pC7apeAZbhGRRc2g6C0W7K3LwAVWxL1Ypb7UVoQJ3aWbi+v18Un9MmzD+jWEYH7N9I7MDQqo0ZX1/Am17nfBQX4Ge12rQB0sMSBjsRn+KeHRITGHPZ4H+CI7nEiXabVufnudsuU0xcfji6O63/9bDW3/A96pUFBQdC6Z+FTYi4u2WbB4b0RRjdxghPNlEsQzv1GO2u9JZ0BtgHUuEh0CP6zs+BxdGPxH8UeQGR9bjSPE9389I8zmJFYXuVpikusYMEskR03K3FlHikr0r0oahr03sIVbOlOB1Xgb8rN62ueN9vlh9o6nduSyVkCgYEA+jZZttfnI5GxsIg0f+LRKUlnbvDjaS3pS9RbcqJO7al6Dy3xVyE1cZ6KRygOf5QanHQwYdwnvjOnjSfCmIzpUV7aA1WYJ9STzePJG0CvP19tssl2YlKtzb+g/X7s/SGQDcE5eY4CBkmAY8xzlHXJImKprW4EH/xjsX2y01iPos0CgYEAs3eDN0azNAom5UrrqHn2s40zG4IO4INc0TaAiAZvkxTXURD1QHpbcXrZFrOohTuYyktroDMqeuxKSKB3BuY7M5PAShhXPpb8c62a/PB7QuBU1ElzjjiSQSGi2UtBTl5XWLEarKxX2LoDbEIosr+UjMtfvGCqWUZuEypy9sHKKM8CgYEA22zIdmmWoQHG4zo/WBuQM/XUiF0mAXoqyr47SCeAsjla+m7e4/sShEZ1m3tMY6N9RtE6EMfh7pIcENTaea+xeROGe0AYBG4PBJMLLSQny5qjeBPnBsjc9L9lrokdycsiKn3WKnxX2C2jM2H7xikZL1d418fQRECxKNlD9sYGiM0CgYBpzQ9CSx/ikgmUK7L6Q8y41YlHskjq+waBIExt5L1qTGMTm5e6R2gZYn8Q7yFuSlAtEoGElCV7CkpQvqjtHFXSdkxqYics8v4phDNW4r8IEhBwhkzlj1xJoXbL+52ogd2kn+RF3+R6FE9oRyiPGHqO9maeO66xqt/B1MipyF1R6QKBgQDtGZPdOUb8kA6ERt9MG+1g8xuENXuP3HZxNrbdmOERRrOeQAXRymhw64adfckRX6oQLplqJ/QkiSQ4jPK5VL8Ccu8+j2uKjVK0bjF/TpEhDuCfMkp/ta1ag/hOI7AGElMldbf19xQ/5CltPxp0ODuoNIjg3ovnD8JVgShtUSCZAA==";
	
	// 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAr2jQPmOk1HnCEzcHD0Mw2ZgC5ywC2BL1vgwCFo8+c3a2yxnUrfk1iu+JHem0kCSytDtyyQoUHGVHCpFAOM56Ykn167TiVEb2U3wAsvg+2mvd6KzwXAFG1VpEvgFa1EbFiBmgmDfiyc1Z21T5Q/gO8hi0armg+7SnRwLuy5B1z1PF/xWhBlGBcKdJPf0aId1i0x3viXlL0Ar58ihjf45lJ0gyuI/k+WbyhXjTBpJ5yENqjV3ttbt3QVMc8CxZdMqqvyVTCwNGF7KmwmUJBSNImKqSkqGyGeROLUZAGut/27fnfLlacgnjkXwrlWTT1fEC6ZCQzULyoJuWRITMEFarwwIDAQAB";

    // 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String notify_url = "https://m471r99152.imdo.co/pet_shop/";

    // 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String return_url = "http://localhost:8080/pet_shop/jsp/modules/";
    public static String return_url2 = "http://localhost:8080/pet_shop/front/dist/index.html#/index/shop-order/order";

	// 签名方式
	public static String sign_type = "RSA2";
	
	// 字符编码格式
	public static String charset = "utf-8";
	
	// 支付宝网关
	public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";
	
	// 支付宝网关
	public static String log_path = "C:\\";


//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

    /** 
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     * @param sWord 要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis()+".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

