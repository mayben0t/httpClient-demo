package com.example.httpclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
public class HttpclientApplication {

    public static void main(String[] args) {
        SpringApplication.run(HttpclientApplication.class, args);
    }

}
