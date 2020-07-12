package com.example.demo.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class TestService {

    public String test(String str) {

        log.info(str + "经过真实的service");

        return "奥利给";

    }


}
