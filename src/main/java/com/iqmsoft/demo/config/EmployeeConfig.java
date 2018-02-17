package com.iqmsoft.demo.config;

import org.springframework.aop.framework.ProxyFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.iqmsoft.demo.domain.Employee;
import com.iqmsoft.demo.domain.EmployeeImpl;

@Configuration
public class EmployeeConfig {

    @Bean
    @Primary
    public ProxyFactoryBean personProxy() {
        ProxyFactoryBean pfb = new ProxyFactoryBean();
        pfb.setTarget(this.person());
        pfb.setInterceptorNames("appInterceptor");
        return pfb;
    }
    
    @Bean
    public Employee person() {
    	return new EmployeeImpl();
    }

}
