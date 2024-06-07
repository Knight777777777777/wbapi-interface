package com.waterbird.wbapiinterface;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
public class WbapiInterfaceApplication {

    public static void main(String[] args) {
        SpringApplication.run(WbapiInterfaceApplication.class, args);
    }

}
