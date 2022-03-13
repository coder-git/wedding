package com.tx.demo.common.config;


import com.tx.demo.common.utils.BinderSupplier;
import com.tx.demo.common.utils.SpringUtil;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Supplier;

/**
 * 工具配置类
 *
 * @author Chill
 */
@Configuration(proxyBeanMethods = false)
public class ToolConfiguration {

	/**
	 * Spring上下文缓存
	 */
	@Bean
	public SpringUtil springUtil() {
		return new SpringUtil();
	}

	/**
	 * Binder支持类
	 */
	@Bean
	@ConditionalOnMissingBean
	public Supplier<Object> binderSupplier() {
		return new BinderSupplier();
	}

}
