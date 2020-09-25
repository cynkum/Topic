package com.belajar.topic.config;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "mail")
@Data
public class PropertiesConfig {
    private String hostName;
    private int port;
    private String from;
}
