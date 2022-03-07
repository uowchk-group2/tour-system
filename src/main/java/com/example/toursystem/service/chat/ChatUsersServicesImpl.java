package com.example.toursystem.service.chat;

import com.example.toursystem.dao.chat.ChatUsersDAOService;
import com.example.toursystem.model.ChatUsers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ChatUsersServicesImpl implements ChatUsersServices{

    private ChatUsersDAOService chatUsersDAOService;

    @Autowired
    public ChatUsersServicesImpl(ChatUsersDAOService chatUsersDAOService) {
        this.chatUsersDAOService = chatUsersDAOService;
    }

    @Override
    @Transactional
    public void newChat(ChatUsers newChat) {
        chatUsersDAOService.newChat(newChat);
    }


    @Override
    @Transactional
    public List<ChatUsers> findWithUsername(String username) {
        return chatUsersDAOService.findWithUsername(username);
    }


    @Override
    @Transactional
    public Boolean checkExistance(ChatUsers chatUsers) {
        return chatUsersDAOService.checkExistance(chatUsers);
    }
}
