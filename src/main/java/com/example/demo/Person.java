package com.example.demo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonPropertyOrder(value = "{age,name}")//用来确定返回属性的顺序
public class Person {

    public static final Logger logger = LoggerFactory.getLogger(Person.class);

    //@JsonProperty("gName")此注解可以改变返回属性的名称
    private String name;

    //@JsonIgnore//让响应数据忽略此属性,针对敏感数据不呈现给用户
    private int age;

    @JsonInclude(JsonInclude.Include.NON_NULL)//只有此属性不为空时才返回
    @JsonFormat(pattern = "MM-dd-yyyy HH:mm:ss", timezone = "GMT+8")
    private Date date;


}
