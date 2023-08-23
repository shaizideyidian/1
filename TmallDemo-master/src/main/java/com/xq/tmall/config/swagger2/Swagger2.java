package com.xq.tmall.config.swagger2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
//@EnableSwagger2是springfox提供的一个注解，代表Swagger2相关技术开启。会扫描当前类所在的包，及子包中所有类型的swagger相关注解，做swagger文档的定制
@EnableSwagger2
//Profile注解的作用是指定类或方法在特定的profile环境生成
@Profile({"dev","test","prod"})
public class Swagger2 {
//在Spring应用中使用Swagger来自动生成API文档
	@Bean
//	Docket是Swagger的主要配置类，用于定制生成的API文档的内容和展现形式
	public Docket createRestApi() {
//		创建一个Docket对象，并指定使用Swagger2规范
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(apiInfo())//设置API文档的基本信息，使用APIInfo方法返回ApiInfo对象来定义文档的标题、描述和版本等信息
				.select()//通过select方法开始定义哪些接口和方法会生成api文档
				.apis(RequestHandlerSelectors.basePackage("com.xq.tmall.controller"))//设置只扫描指定包下的Controller类生成API文档
				.paths(PathSelectors.any())//设置生成API文档的路径，这里设置为匹配所有路径
				.build();//构建Docket对象，返回最终用于生成API文档的配置
	}
	//定义API文档的基本信息，返回一个ApiInfo对象。
	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				.title("接口API文档")
				.description("简单优雅的RESTful API")
				.version("1.0")
				.build();
	}

}
