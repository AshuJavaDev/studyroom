package com.example.studyroom;

import org.springframework.stereotype.Service;

@Service
public class UserService {

    public String greetWelcome(String name)     {
        return "Welcome "  +name+  " in the room";
    }

    public String getWelcomeMessage(String name)  {
        return "Welcome "   +name+  " to study room";
    }

        public String getGoodbyeMessage(String name)    {
        return "Goodbye "   +name+  "! See you soon!";
        }
}


