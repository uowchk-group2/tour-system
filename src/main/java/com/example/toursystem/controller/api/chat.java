package com.example.toursystem.controller.api;

import com.example.toursystem.model.ChatUsers;
import com.example.toursystem.service.chat.ChatUsersServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/chat")
public class chat {

    private ChatUsersServices chatUsersServices;

    @Autowired
    public chat(ChatUsersServices chatUsersServices) {
        this.chatUsersServices = chatUsersServices;
    }

    @GetMapping("/list/{username}")
    public List<ChatUsers> getChatListOfUser(@PathVariable String username){

        List<ChatUsers> chats = chatUsersServices.findWithUsername(username);
        return chats;
    }

    

    @PostMapping("/newChat")
    public String newChat(@RequestBody ChatUsers chatUsers){
        //Find exist history
        Boolean exist = chatUsersServices.checkExistance(chatUsers);
        if (exist == true){
            return "exist";
        }

        //Start saving
        chatUsers.setId(0);
        try {
            chatUsersServices.newChat(chatUsers);
        }catch (Exception e){
            return e.getMessage();
        }

        return "success";
    }

}
