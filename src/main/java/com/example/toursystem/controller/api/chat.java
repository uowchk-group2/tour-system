package com.example.toursystem.controller.api;

import com.example.toursystem.model.ChatHistory;
import com.example.toursystem.model.ChatUsers;
import com.example.toursystem.service.chat.ChatHistoryServices;
import com.example.toursystem.service.chat.ChatUsersServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/chat")
public class chat {

    private ChatUsersServices chatUsersServices;
    private ChatHistoryServices chatHistoryServices;

    @Autowired
    public chat(ChatUsersServices chatUsersServices, ChatHistoryServices chatHistoryServices) {
        this.chatUsersServices = chatUsersServices;
        this.chatHistoryServices = chatHistoryServices;
    }

    @GetMapping("/list/{username}")
    public List<ChatUsers> getChatListOfUser(@PathVariable String username) {

        List<ChatUsers> chats = chatUsersServices.findWithUsername(username);
        return chats;
    }

    @GetMapping("/message/{chatId}")
    public List<ChatHistory> getMessages(@PathVariable Integer chatId) {
        List<ChatHistory> chatHistory = new ArrayList<>();
        try {
            chatHistory = chatHistoryServices.findWithChatId(chatId);

            return chatHistory;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return new ArrayList<>();
        }
    }

    @PostMapping("/message/{chatId}")
    public String newMessage(@PathVariable int chatId,@RequestBody ChatHistory chatHistory) {
        try {
            chatHistory.setId(0);
            chatHistory.setTime(new Timestamp(System.currentTimeMillis()));
            chatHistory.setChatId(chatId);
            chatHistoryServices.newMessage(chatHistory);

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return e.getMessage();
        }

        return "success";
    }

    @PostMapping("/newChat")
    public String newChat(@RequestBody ChatUsers chatUsers) {
        //Find exist history
        Boolean exist = chatUsersServices.checkExistance(chatUsers);
        if (exist == true) {
            return "exist";
        }

        //Start saving
        chatUsers.setId(0);
        try {
            chatUsersServices.newChat(chatUsers);
        } catch (Exception e) {
            return e.getMessage();
        }

        return "success";
    }

}
