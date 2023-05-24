package com.formatiom.kafka.notification.notificationservice;

import com.formatiom.kafka.notification.notificationservice.impl.UserPlacedEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.KafkaListener;

@SpringBootApplication
@Slf4j
public class NotificationServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(NotificationServiceApplication.class, args);
	}

	@KafkaListener(topics="notificationTopic")
	public void handlerNotification(UserPlacedEvent userPlacedEvent){
		log.info("Notificacion recibida desde user: "+userPlacedEvent.getUserId());
	}

}
