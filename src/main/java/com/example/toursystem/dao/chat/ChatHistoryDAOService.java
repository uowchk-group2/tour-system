package com.example.toursystem.dao.chat;

import com.example.toursystem.entity.ChatHistory;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class ChatHistoryDAOService implements ChatHistoryDAO{

    private EntityManager entityManager;

    @Autowired
    public ChatHistoryDAOService(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void newMessage(ChatHistory chatHistory) {
        Session currentSession = entityManager.unwrap(Session.class);
        currentSession.saveOrUpdate(chatHistory);
    }

    @Override
    public List<ChatHistory> findWithChatId(int id) {
        Session currentSession = entityManager.unwrap(Session.class);
        Query<ChatHistory> query = currentSession.createQuery( "from ChatHistory h " +
                "WHERE h.chatId = '" + id +"'", ChatHistory.class);
        List<ChatHistory> resultList = query.getResultList();

        return resultList;

    }
}
