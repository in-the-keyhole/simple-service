package com.keyholesoftware.devops.simpleservice.api;

public class HelloResponse {

    public HelloResponse(String name, String datetime) {
        this.greeting = "Hello " + name + " from Spring Boot";
        this.time = datetime;
    }

    private String greeting;
    private String time;

    public String getGreeting() {
        return greeting;
    }

    public void setGreeting(String greeting) {
        this.greeting = greeting;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}