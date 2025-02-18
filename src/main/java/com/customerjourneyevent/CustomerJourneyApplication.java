package com.customerjourneyevent;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication(scanBasePackages = "com.customerjourneyevent")
@EnableTransactionManagement
@EntityScan(basePackages = {"com.customerjourneyevent"})
@EnableJpaRepositories
public class CustomerJourneyApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(CustomerJourneyApplication.class);
    }

    public static void main(String[] args) {

        ConfigurableApplicationContext ctx = SpringApplication.run(CustomerJourneyApplication.class, args);
    }

}

