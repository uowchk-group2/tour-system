package com.example.toursystem.service.chat;

import com.example.toursystem.model.ChatHistory;

import java.util.List;

public interface ChatHistoryServices {
    public void newMessage(ChatHistory chatHistory);

    public List<ChatHistory> findWithChatId(int id);

}
