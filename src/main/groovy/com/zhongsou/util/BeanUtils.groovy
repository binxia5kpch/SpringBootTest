package com.zhongsou.util

import groovy.transform.CompileStatic
import org.springframework.context.ApplicationContext

/**
 * Created by Administrator on 2017/10/14.
 */
class BeanUtils {

    @CompileStatic
    static <T> T getBean(String name) {
        ApplicationContext ctx = App.instance.context
        Object o = ctx.getBean(name)
        return o == null ? null : (o as T)
    }
}
