package com.keyholesoftware.devops.simpleservice.api;

import com.keyholesoftware.devops.simpleservice.client.DateServiceClient;
import com.keyholesoftware.devops.simpleservice.model.DateTimeResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/api/v1")
public class Api {

    private DateServiceClient dateServiceClient;

    public Api(@Autowired DateServiceClient dateServiceClient) {
        this.dateServiceClient = dateServiceClient;
    }

    @GetMapping(value="/hello", params= {"name"}, produces="application/json")
    public HelloResponse sayHello(@RequestParam("name") String name) {
        DateTimeResponse dateTimeResponse = this.dateServiceClient.getCurrentDateTime();
        return new HelloResponse(name, dateTimeResponse.getDatetime());
    }
}