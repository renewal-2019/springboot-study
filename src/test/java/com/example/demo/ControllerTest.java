package com.example.demo;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpMethod;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@Slf4j
public class ControllerTest {

    //可以用来模拟http请求
    //可用于进行自动化测试,点击右上角maven中的package,就会在打包直接自动进行测试,所有测试通过才进行打包
    private static MockMvc mockMvc;

    //初始化mockMvc
    @BeforeAll//表示在所有测试动作之前执行-------表示对Hello这个controller进行测试
    static void setMockMvc() {
        mockMvc = MockMvcBuilders.standaloneSetup(new HelloController()).build();
    }

    @Test//测试方法必须是public void
    public void getPerson() throws Exception {

        String ajaxResponseStr = "{\"name\":\"Dinky\",\"age\":24}";

        //模拟http请求
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.request(HttpMethod.GET, "/person")
                .content("application/json").content(ajaxResponseStr))
                //期望返回的状态
                .andExpect(MockMvcResultMatchers.status().isOk())
                //期望返回的响应中的obj属性,在这个响应中就相当于是person,也就是期望person的name属性为Dinky
                .andExpect(MockMvcResultMatchers.jsonPath("$.obj.name").value("Dinky"))
                .andDo(print())
                .andReturn();

        mvcResult.getResponse().setCharacterEncoding("UTF-8");//防止log乱码
        log.info(mvcResult.getResponse().getContentAsString());

    }

}
