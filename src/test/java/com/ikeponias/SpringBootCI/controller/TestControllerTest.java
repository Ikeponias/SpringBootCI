package com.ikeponias.SpringBootCI.controller;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;


@SpringBootTest
class TestControllerTest {

    private MockMvc mockMvc;

    @InjectMocks
    TestController testController;

    @BeforeEach
    void beforeEach() {
        mockMvc = MockMvcBuilders.standaloneSetup(testController).build();
    }

    @Test
    public void successTest() throws Exception {
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/test"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();
        Assertions.assertEquals(mvcResult.getResponse().getContentAsString(), "Hello World!");
    }
// 失敗用テスト
//    @Test
//    public void failedTest() throws Exception {
//        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/test"))
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andReturn();
//        Assertions.assertEquals(mvcResult.getResponse().getContentAsString(), "Hello World");
//    }
}