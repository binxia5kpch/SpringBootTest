package com.zhongsou.springboot.test

import org.springframework.stereotype.Component
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 * Created by Administrator on 2017/4/25.
 */
@RestController
class HelloWorldTest {
    @RequestMapping("/a")
    void printlnTest(){
        println("jjjj");
    }


    public static void main(String[] args) {
        System.out.println(System.getProperty("sun.boot.class.path"));
        println "kkkkkkkkk"
        println System.getProperty("java.ext.dirs");
        println "kkkkkkkkk"
        println System.getProperty("java.class.path");
        Map m = new HashMap();
    }
}
