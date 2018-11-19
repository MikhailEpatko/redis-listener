package ru.epatko.redislistener.publisher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

@Component
public class Publisher {
    private StringRedisTemplate template;

    @Autowired
    public Publisher(StringRedisTemplate template) {
        this.template = template;
    }

    public void sendTo(String topicName, String message) {
        System.out.println("Publisher.sendTo");
        System.out.println("topicName = [" + topicName + "], message = [" + message + "]");
        this.template.convertAndSend(topicName, message);
    }
}
