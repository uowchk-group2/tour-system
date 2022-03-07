package com.example.toursystem.service.chat;

import com.example.toursystem.model.ChatUsers;

import java.util.List;

public interface ChatUsersServices {

    public void newChat(ChatUsers newChat);

    public List<ChatUsers> findWithUsername(String username);

    public Boolean checkExistance(ChatUsers chatUsers);

}
