package com.ssafy.enjoytrip.config;

import java.util.Arrays;
import java.util.List;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.ssafy.enjoytrip.interceptor.ConfirmInterceptor;


@Configuration
@MapperScan(basePackages = {"com.ssafy.enjoytrip.**.mapper"})
public class WebMvcConfiguration implements WebMvcConfigurer{

	private final List<String> patterns = Arrays.asList("/article/*", "/admin", "/user/list");
	private ConfirmInterceptor confirmInterceptor;
	
	@Autowired
	public WebMvcConfiguration(ConfirmInterceptor confirmInterceptor) {
		super();
		this.confirmInterceptor = confirmInterceptor;
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(confirmInterceptor).addPathPatterns(patterns);
	}

	@Override
	public void addCorsMappings(CorsRegistry registry) {
		
	}

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/").setViewName("index");
		registry.addViewController("/error").setViewName("error/error");
		registry.addViewController("/search").setViewName("trip/search");
		registry.addViewController("/schedule").setViewName("trip/schedule");
		registry.addViewController("/hotplace").setViewName("trip/hotplace");
	}
	
}
