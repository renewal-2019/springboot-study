package com.example.demo;

import com.example.demo.service.TestService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpMethod;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import javax.annotation.Resource;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@Slf4j
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest
public class ControllerTest2 {
    /**
     * 遗留问题: 当我在响应后做处理,要求输出表格时,测试时期望的$.obj.name属性路径提示不存在,什么原因
     * 是否因为响应是表格形式,根本没有jsonpath这个说法
     */

    @Resource
    private MockMvc mockMvc;

    @MockBean
    private TestService testService;

//    //初始化mockMvc
//    @BeforeAll//表示在所有测试动作之前执行-------表示对Hello这个controller进行测试
//    static void setMockMvc() {
//        mockMvc = MockMvcBuilders.standaloneSetup(new Hello()).build();
//    }

    @Test//测试方法必须是public void
    public void getPerson() throws Exception {

        String ajaxResponseStr = "{\"name\":\"Dinky\",\"age\":24,\"date\":\"11-07-2020 12:00:00\"}";

        //模拟http请求
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.request(HttpMethod.GET, "/person")
                .content("application/json").content(ajaxResponseStr))
                //期望返回的状态
                .andExpect(MockMvcResultMatchers.status().isOk())
                //期望返回的响应中的obj属性,在这个响应中就相当于是person,也就是期望person的name属性为Dinky
//                .andExpect(MockMvcResultMatchers.jsonPath("$.obj.name").value("Dinky"))
                .andDo(print())
                .andReturn();

        mvcResult.getResponse().setCharacterEncoding("UTF-8");//防止log乱码
        log.info(mvcResult.getResponse().getContentAsString());

    }

    @Test
    public void testMOck() throws Exception {

        /**
         * 打桩,在测试时针对该接口我给一个值
         */
        when(testService.test("mock")).thenReturn("稳了稳了");

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.request(HttpMethod.GET, "/mock"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(print())
                .andReturn();

        mvcResult.getResponse().setCharacterEncoding("UTF-8");//防止log乱码
        log.info(mvcResult.getResponse().getContentAsString());

    }


}
