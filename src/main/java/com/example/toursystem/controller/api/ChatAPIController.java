package com.example.toursystem.controller.api;

import com.example.toursystem.entity.chat.ChatHistory;
import com.example.toursystem.entity.chat.ChatUsers;
import com.example.toursystem.entity.User;
import com.example.toursystem.service.UserServices;
import com.example.toursystem.service.chat.ChatHistoryServices;
import com.example.toursystem.service.chat.ChatUsersServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/chat")
public class ChatAPIController {

    private ChatUsersServices chatUsersServices;
    private ChatHistoryServices chatHistoryServices;
    private UserServices userServices;

    @Autowired
    public ChatAPIController(ChatUsersServices chatUsersServices, ChatHistoryServices chatHistoryServices, UserServices userServices) {
        this.chatUsersServices = chatUsersServices;
        this.chatHistoryServices = chatHistoryServices;
        this.userServices = userServices;
    }

    @GetMapping("/lsitAvailableUsers/{username}")
    public List<String> getAvailableUsers(@PathVariable String username){
        List<User> allUsers = userServices.findAll();
        List<ChatUsers> chatUsersList = chatUsersServices.findWithUsername(username);
        List<String> excludeUser = new ArrayList<>();
        excludeUser.add(username);

        for(ChatUsers chatUser:chatUsersList){
            String user1 = chatUser.getUser1();
            String user2 = chatUser.getUser2();

            if(!username.equals(user1)){
                excludeUser.add(user1);
            }else{
                excludeUser.add(user2);
            }
        }

        List<String> usernameList = new ArrayList<String>();
        for(User user:allUsers){
            String listUsername = user.getUsername();

            if ( excludeUser.contains(listUsername) ){
//                System.out.println("Matched.");
            }else{
                usernameList.add(listUsername);
            }
        }

        return usernameList;
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
