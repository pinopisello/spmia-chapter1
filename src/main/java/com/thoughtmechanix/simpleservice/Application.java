package com.thoughtmechanix.simpleservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@RequestMapping(value="hello")
//@EnableCircuitBreaker      //Enable uso Hystrix-Ribbon
//@EnableEurekaClient        //Registra service presso Eureka service discovery agent e indica che il service
                             //usera' Service discovery to “lookup” the location of remote services
public class Application {

    public static void main(String[] args) {
    	ApplicationContext configuredSpringContext  = SpringApplication.run(Application.class, args);
    	System.out.println(configuredSpringContext);
    }

    @RequestMapping(value="/{firstName}/{lastName}",method = RequestMethod.GET)
    public String hello( @PathVariable("firstName") String firstName,
                         @PathVariable("lastName") String lastName) {

        return String.format("{\"message\":\"Hello %s %s\"}", firstName, lastName);
    }
}
