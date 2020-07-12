package com.example.demo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

public class JsonTest {

    @Test
    void testJackson() throws JsonProcessingException {

        //用来实现java对象与json字符串的转换
        ObjectMapper objectMapper = new ObjectMapper();

        //构造一个java对象
        Person person = Person.builder().name("Dinky").age(24).build();

        String jsonStr = objectMapper.writeValueAsString(person);

        System.out.println(jsonStr);

        //转换的java对象必须要有有参构造和无参构造函数,否则报错
        Person p = objectMapper.readValue("{\"name\":\"Dinky\",\"age\":24}",Person.class);

        System.out.println(p);

    }


}
