package com.bookcase;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class BookcaseApplication {

    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(BookcaseApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(BookcaseApplication.class, args);
    }
}
