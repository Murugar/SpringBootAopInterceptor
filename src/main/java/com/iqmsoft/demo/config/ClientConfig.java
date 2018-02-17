package com.iqmsoft.demo.config;

import org.springframework.aop.framework.ProxyFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.iqmsoft.demo.domain.Client;

@Configuration
public class ClientConfig {

    @Bean
    @Primary
    public ProxyFactoryBean customerProxy() {
        ProxyFactoryBean pfb = new ProxyFactoryBean();
        pfb.setTarget(this.customer());
        pfb.setInterceptorNames("appInterceptor");
        pfb.setProxyTargetClass(true);
        return pfb;
    }

    @Bean
    public Client customer() {
    	return new Client();
    }
    
}
