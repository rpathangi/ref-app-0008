package com.rpathangi.spring;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Configuration
@ComponentScan(basePackages = { "com.rpathangi.spring" })
@PropertySource("classpath:application.properties")
@RequestMapping("/sayHello")
@RestController
public class HelloWorldService {

    @Value("${greeting}")
    private String greeting;

    @RequestMapping(method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    public HelloWorldResponse sayHello() {
        return new HelloWorldResponse(greeting);
    }
}
