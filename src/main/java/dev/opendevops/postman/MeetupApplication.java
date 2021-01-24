package dev.opendevops.postman;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.socket.client.WebSocketClient;
import org.springframework.web.socket.client.standard.StandardWebSocketClient;

/**
 * The Spring Boot application communicates to an open API of Meetups
 * in order to use Apache Kafka and Spring Boot framework (Java)
 * as a thread scheduler and Postman hacks are coming into our world.
 *
 * @author Orestis Pantazos
 * @version 1.0
 * @date 2020-01-25
 */
@SpringBootApplication
public class MeetupApplication {

    // open API for Meetup
    private static final String MEETUP_ENDPOINT = "ws://stream.meetup.com/2/rsvps";

    // main method for run the program
    public static void main(String[] args) {
        SpringApplication.run(MeetupApplication.class, args);
    }

    // initialize connection
    @Bean
    public ApplicationRunner initializeConnection(
            MeetupWebSocketHandler meetupWebSocketHandler) {
        return args -> {
            WebSocketClient socketClient = new StandardWebSocketClient();

            socketClient.doHandshake(
                    meetupWebSocketHandler, MEETUP_ENDPOINT);
        };
    }
}
