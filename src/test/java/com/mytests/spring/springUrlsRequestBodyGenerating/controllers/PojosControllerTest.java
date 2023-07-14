package com.mytests.spring.springUrlsRequestBodyGenerating.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
class PojosControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @Test
    void m4() throws Exception {
        String jsonString = """
                [ {
                  "id": 1,
                  "name": "foo"
                },
                 {
                   "name" : "aaa"
                 }
                ]""";
        String mvcResult = mockMvc.perform(post("/pojos/listOfPojos")
                        .content(jsonString)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString();

        assertEquals("i've got the pojo list:  MyPojo{name='foo', id=1} MyPojo{name='aaa', id=0}",
                mvcResult);
    }
}