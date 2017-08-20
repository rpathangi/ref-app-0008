package com.rpathangi.spring;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;


@RunWith(SpringRunner.class)
@WebMvcTest(value = Application.class, secure = false)
public class HelloWorldServiceTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private HelloWorldService helloWorldService;

    HelloWorldResponse hwr = new HelloWorldResponse("Hello World!");

    @Test
    public void sayHello() throws Exception {

        Mockito.when(
                helloWorldService.sayHello()).thenReturn(hwr);

        RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
                "/greeting/english").accept(
                MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        System.out.println(result.getResponse());

        String expected = "{greeting: \"Hello World!\"}";

        JSONAssert.assertEquals(expected, result.getResponse()
                .getContentAsString(), false);
    }


}
