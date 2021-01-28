package com.tjh.task.controller;

import com.tjh.task.service.AsyncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AsyncController {

    @Autowired
    AsyncService asyncService;

    /**
     * 准备工作：
     *  1、@EnableAsync    //SpringBoot04TaskApplication中开启异步注解功能
     *  2、@Async         //AsyncService方法上添加异步方法注解
     *  3、测试
     * 测试方法：http://localhost:8080/hello
     *
     */
    @GetMapping("/hello")
    public String hello() {
        asyncService.hello();
        return "success";
    }
}
