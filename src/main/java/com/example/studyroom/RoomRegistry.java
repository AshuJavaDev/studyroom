package com.example.studyroom;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;


@Component
    public class RoomRegistry   {

        private final Map<String, List<ChatMessage>> roomParticipants = new ConcurrentHashMap<>();
        private final Map<String, ChatMessage> sessionToParticipant = new ConcurrentHashMap<>();

        public void addParticipant(String sessionId, ChatMessage message)   {
            String roomId = message.getRoomId();

            roomParticipants.computeIfAbsent(roomId, key -> new CopyOnWriteArrayList<>());
            List<ChatMessage> list = roomParticipants.get(roomId);

            boolean alreadyExists = list.stream().
                    anyMatch(p -> p.getStudentName().equals(message.getStudentName()));

            if(!alreadyExists) {
                list.add(message);
            }

            sessionToParticipant.put(sessionId, message);
        }

        public List<ChatMessage> getParticipants(String roomId)  {
            return roomParticipants.getOrDefault(roomId, List.of());
        }

        public ChatMessage removeBySession(String sessionId) {
            ChatMessage participant = sessionToParticipant.remove(sessionId);

            if(participant != null) {
                List<ChatMessage> list = roomParticipants.get(participant.getRoomId());
                if(list != null) {
                    list.removeIf(p -> p.getStudentName().equals(participant.getStudentName()));
                }
            }

            return participant;
        }

    }

