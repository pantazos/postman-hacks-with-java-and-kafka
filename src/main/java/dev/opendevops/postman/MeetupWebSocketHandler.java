package dev.opendevops.postman;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.AbstractWebSocketHandler;

/**
 * The component is for web socket communication and
 * handles the msg for payload response.
 */
@Component
class MeetupWebSocketHandler extends AbstractWebSocketHandler {

    /**
     * This handle the message from an open API.
     *
     * @param session The web socket session
     * @param message The web socket msg
     */
    @Override
    public void handleMessage(WebSocketSession session,
                              WebSocketMessage<?> message) {
        System.out.println(message.getPayload());
    }
}
