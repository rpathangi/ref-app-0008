package com.rpathangi.spring;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/sayHello")
@RestController
public class HelloWorldService {

    @RequestMapping(method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    public HelloWorldResponse index() {
        return new HelloWorldResponse("Hello World!");
    }
}
