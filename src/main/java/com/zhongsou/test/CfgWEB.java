package com.zhongsou.test;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CfgWEB {

    @Bean
    ServletRegistrationBean groovy() {
        ServletRegistrationBean srb = new ServletRegistrationBean(new CGrvServlet(), "*.groovy", "/groovy/*");
        srb.setLoadOnStartup(1);
        return srb;
    }

}
