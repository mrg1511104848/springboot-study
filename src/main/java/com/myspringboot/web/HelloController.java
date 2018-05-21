package com.myspringboot.web;


import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.hypermedia.DiscoveredResource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class HelloController {
    @Autowired
    private DiscoveryClient discoveryClient;
    @RequestMapping("/hello")
    public String hello(){
        List<ServiceInstance> list = discoveryClient.getInstances("STORES");
        for (ServiceInstance instance: list
             ) {
            System.out.println("host: "+instance.getHost() +" service_id:"+ instance.getServiceId());
        }
        return "hello world";
    }


}
