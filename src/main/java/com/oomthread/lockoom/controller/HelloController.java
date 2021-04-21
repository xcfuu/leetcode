package com.oomthread.lockoom.controller;

import com.oomthread.lockoom.bean.TestAllocation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Autowired
    private TestAllocation testAllocation;

    @RequestMapping("/hello")
    public String say() {
        return "Hello SpringBoot!";
    }

    @RequestMapping("/bigObject")
    public String bigObject() {
        testAllocation.testAllocation();
        return "Hello SpringBoot!";
    }
}
