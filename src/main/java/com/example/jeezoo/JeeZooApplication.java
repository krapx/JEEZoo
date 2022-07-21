package com.example.jeezoo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
//@ConfigurationPropertiesScan
public class JeeZooApplication {

  public static void main(String[] args) {
    SpringApplication.run(JeeZooApplication.class, args);
  }

}
  