package com.trifail.customizedxsd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootCustomizedXsdApplication {

    public static void main(String[] args) {
        System.setProperty("java.version","1.7.0");

        SpringApplication.run(SpringbootCustomizedXsdApplication.class, args);
    }


}
