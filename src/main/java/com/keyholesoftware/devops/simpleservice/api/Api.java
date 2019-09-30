package com.keyholesoftware.devops.simpleservice.api;


import com.keyholesoftware.devops.simpleservice.client.DateServiceClient;
import com.keyholesoftware.devops.simpleservice.model.DateTimeResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/api/v1")
public class Api {

    private static final Logger LOG = LoggerFactory.getLogger(Api.class);

    private DateServiceClient dateServiceClient;

    public Api(@Autowired DateServiceClient dateServiceClient) {
        this.dateServiceClient = dateServiceClient;
    }

    @GetMapping(value="/hello", params= {"name"}, produces="application/json")
    public HelloResponse sayHello(@RequestParam("name") String name) {
        LOG.debug("/api/vi/hello called with name: {}", name);
        DateTimeResponse dateTimeResponse = this.dateServiceClient.getCurrentDateTime();
        return new HelloResponse(name, dateTimeResponse.getDatetime());
    }
}