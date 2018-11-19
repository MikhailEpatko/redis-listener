package ru.epatko.redislistener.consumer;



import org.springframework.stereotype.Component;

@Component
public class Consumer {
        public void handleMessage(String message) {
            System.out.println("Consumer.messageHandler");
            System.out.println("message = [" + message + "]");
        }
    }
