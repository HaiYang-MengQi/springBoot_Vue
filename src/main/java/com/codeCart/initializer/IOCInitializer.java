package com.codeCart.initializer;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MapPropertySource;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.env.PropertiesPropertySource;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;

/**
 * ioc容器初始化完成后调用
 * 配置上下文环境
 */
public class IOCInitializer implements ApplicationContextInitializer {
    /**
     * @param applicationContext 上下文环境
     */
    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {
        System.out.println("IOC初始化完成"+applicationContext.getEnvironment());
    }
}
