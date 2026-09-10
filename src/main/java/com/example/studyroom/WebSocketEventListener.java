package com.example.studyroom;


import org.springframework.context.ApplicationListener;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;

@Component
public class WebSocketEventListener implements ApplicationListener<SessionDisconnectEvent> {

    private final RoomRegistry roomRegistry;
    private final SimpMessagingTemplate messagingTemplate;

    public WebSocketEventListener(RoomRegistry roomRegistry, SimpMessagingTemplate messagingTemplate)   {
         this.roomRegistry = roomRegistry;
         this.messagingTemplate = messagingTemplate;
    }

    @Override
    public void onApplicationEvent(SessionDisconnectEvent event)  {
        SimpMessageHeaderAccessor headerAccessor = SimpMessageHeaderAccessor.wrap(event.getMessage());
        String sessionId = headerAccessor.getSessionId();

        ChatMessage leftParticipant = roomRegistry.removeBySession(sessionId);

         if(leftParticipant != null)  {
             ChatMessage leaveMessage = new ChatMessage();
             leaveMessage.setType("LEAVE");
             leaveMessage.setStudentName(leftParticipant.getStudentName());
             leaveMessage.setRoomId(leftParticipant.getRoomId());

             String destination = "/topic/room/" + leftParticipant.getRoomId();
             messagingTemplate.convertAndSend(destination, leaveMessage);
         }
    }
}
