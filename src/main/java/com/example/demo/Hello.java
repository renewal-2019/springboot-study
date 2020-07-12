package com.example.demo;

import com.example.demo.response.AjaxResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Hello {

//    @Resource
//    Jobs jobs;

    @RequestMapping("/hello")
    public String hello(String name) throws InterruptedException {
//        jobs.fixedDelayJob();
        return "hello world, " +name;
    }

    @RequestMapping("/test")
    public AjaxResponse test(){
        return AjaxResponse.successDone();
    }

    @GetMapping("/person")
    public AjaxResponse testPerson(){
        Person person = Person.builder().name("Dinky").age(18).build();
        return AjaxResponse.successDone(person);
    }

}
