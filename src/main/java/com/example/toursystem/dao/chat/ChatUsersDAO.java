package com.example.toursystem.dao.chat;

import com.example.toursystem.entity.ChatUsers;

import java.util.List;

public interface ChatUsersDAO {

    public void newChat(ChatUsers newChat);

    public List<ChatUsers> findWithUsername(String username);

    public ChatUsers findWithId(int id);

    public Boolean checkExistance(ChatUsers chatUsers);


}
