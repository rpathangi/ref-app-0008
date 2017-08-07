package com.rpathangi.spring;

public class HelloWorldResponse {
    private String greeting;

    public HelloWorldResponse(String s) {
        this.greeting=s;
    }

    public String getGreeting() {
        return greeting;
    }

    public void setGreeting(String greeting) {
        this.greeting = greeting;
    }
}
