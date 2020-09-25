package com.belajar.topic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication
public class TopicApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(TopicApplication.class, args);
		TopicRepository topicRepository = (TopicRepository) context.getBean("topicRepository");


	}

}
