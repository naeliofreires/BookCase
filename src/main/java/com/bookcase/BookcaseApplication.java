package com.bookcase;

import com.bookcase.configuration.EmbeddedTomcatConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import({EmbeddedTomcatConfiguration.class})
public class BookcaseApplication {

    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(BookcaseApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(BookcaseApplication.class, args);
    }
}
