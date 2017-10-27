package com.zhongsou.util

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.ApplicationContext
import org.springframework.core.annotation.Order
import org.springframework.stereotype.Service

import javax.annotation.PostConstruct

/**
 * Created by Administrator on 2017/8/23.
 */
@Service
@Order(0)
class App {
    @Autowired
    ApplicationContext context
    static App instance;
    @PostConstruct
    void init(){
        instance = this
    }
}
