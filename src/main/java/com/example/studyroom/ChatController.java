package com.example.studyroom;

import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
public class ChatController {

    private final SimpMessagingTemplate messagingTemplate;
    private final RoomRegistry roomRegistry;

    public ChatController(SimpMessagingTemplate messagingTemplate, RoomRegistry roomRegistry)  {
        this.messagingTemplate = messagingTemplate;
        this.roomRegistry = roomRegistry;
    }


    @MessageMapping("/chat/{roomId}")
    public void sendMessage(@DestinationVariable String roomId, ChatMessage message, SimpMessageHeaderAccessor headerAccessor)    {
            if("JOIN".equals(message.getType()))    {
                String sessionId = headerAccessor.getSessionId();
                roomRegistry.addParticipant(sessionId, message);
            }

            String destination = "/topic/room/" + roomId;
            messagingTemplate.convertAndSend(destination, message);
    }
}





