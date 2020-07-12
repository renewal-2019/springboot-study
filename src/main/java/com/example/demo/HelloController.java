package com.example.demo;

import com.example.demo.response.AjaxResponse;
import com.example.demo.service.TestService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class HelloController {

    @Resource
    private TestService testService;

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

    @GetMapping("/mock")
    public AjaxResponse testMock(){

        testService.test("测试");

        return AjaxResponse.successDone();
    }

}
