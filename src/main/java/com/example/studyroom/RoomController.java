package com.example.studyroom;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RoomController {

    private final RoomRegistry roomRegistry;

    public RoomController(RoomRegistry roomRegistry)  {
        this.roomRegistry = roomRegistry;
    }

    @GetMapping("/api/rooms/{roomId}/participants")
    public List<ChatMessage> getParticipants(@PathVariable String roomId)  {
          return roomRegistry.getParticipants(roomId);
     }
 }
