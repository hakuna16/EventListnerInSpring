package com.rituj.event;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.DomainEvents;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableAsync;

import javax.annotation.PostConstruct;
import java.util.TimeZone;

@EnableAsync
@SpringBootApplication
@EnableJpaRepositories
public class EventExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(EventExampleApplication.class, args);
	}

	@Value("${server.time.zone}")
	private String timeZone;


	@PostConstruct
	public void init() {
		TimeZone.setDefault(TimeZone.getTimeZone(timeZone));
	}
}
