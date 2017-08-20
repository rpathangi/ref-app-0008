package com.rpathangi.spring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
@RequestMapping("/greeting")
@RestController
public class HelloWorldService {
    private Logger logger = LoggerFactory.getLogger(HelloWorldService.class);

    @Value("${greeting}")
    private String greeting;

    @RequestMapping(value = "/english", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    public HelloWorldResponse sayHello() {
        logger.info("Info: sayHello()");
        return new HelloWorldResponse(greeting);
    }
}
