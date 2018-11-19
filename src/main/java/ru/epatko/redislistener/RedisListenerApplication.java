package ru.epatko.redislistener;

import ru.epatko.redislistener.publisher.Publisher;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class RedisListenerApplication {

	public static void main(String[] args) {
		SpringApplication.run(RedisListenerApplication.class, args);
	}

	@Value("${topicName}")
	private String topicName;

	@Bean
	CommandLineRunner sendMessages(Publisher publisher) {
		return args -> {
			for(int i = 0; i < 10; i++) {
				publisher.sendTo(topicName, String.format("message %s", i));
				Thread.sleep(1000);
			}
		};
	}
}