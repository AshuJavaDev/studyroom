package com.example.studyroom;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.studyroom.UserService;



@RestController
public class HelloController        {
    private UserService userService;

    public HelloController(UserService userService)   {
        this.userService = userService;
    }

    @GetMapping("/greet")
    public String greetMessage(@RequestParam String name)    {
        return userService.greetWelcome(name);
    }


    @GetMapping("/goodbye/{name}")
    public String goodbye(@RequestBody String name)     {
        return userService.getGoodbyeMessage(name);
    }

   @PostMapping("/login")
    public String login(@RequestBody String username)   {
       return userService.getWelcomeMessage(username);
    }


}

