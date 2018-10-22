package com.inderjit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.support.SpringBootServletInitializer;

import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.inderjit", "com.cust"})
public class InventoryApplication extends SpringBootServletInitializer{

    public static void main(String[] args) throws Exception {
        SpringApplication.run(InventoryApplication.class, args);
    }

}
