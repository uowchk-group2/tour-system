package com.example.toursystem.dao.chat;

import com.example.toursystem.entity.chat.ChatHistory;

import java.util.List;

public interface ChatHistoryDAO {

    public void newMessage(ChatHistory chatHistory);

    public List<ChatHistory> findWithChatId(int id);

}
