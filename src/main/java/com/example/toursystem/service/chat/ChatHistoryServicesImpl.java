package com.example.toursystem.service.chat;

import com.example.toursystem.dao.chat.ChatHistoryDAOService;
import com.example.toursystem.entity.chat.ChatHistory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ChatHistoryServicesImpl implements ChatHistoryServices{

    private ChatHistoryDAOService chatHistoryDAOService;

    @Autowired
    public ChatHistoryServicesImpl(ChatHistoryDAOService chatHistoryDAOService) {
        this.chatHistoryDAOService = chatHistoryDAOService;
    }

    @Override
    @Transactional
    public void newMessage(ChatHistory chatHistory) {
        chatHistoryDAOService.newMessage(chatHistory);
    }

    @Override
    @Transactional
    public List<ChatHistory> findWithChatId(int id) {
        List<ChatHistory> result = chatHistoryDAOService.findWithChatId(id);
        return result;
    }
}
