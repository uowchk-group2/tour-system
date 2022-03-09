package com.example.toursystem.dao.chat;

import com.example.toursystem.entity.chat.ChatUsers;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class ChatUsersDAOService implements ChatUsersDAO {

    private EntityManager entityManager;

    public ChatUsersDAOService(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void newChat(ChatUsers newChat) {
        Session currentSession = entityManager.unwrap(Session.class);
        currentSession.saveOrUpdate(newChat);
    }

    @Override
    public Boolean checkExistance(ChatUsers chatUsers) {
        Session currentSession = entityManager.unwrap(Session.class);
        Query<ChatUsers> query = currentSession.createQuery("FROM ChatUsers c WHERE (c.user1 = :user1 AND c.user2 = :user2) OR (c.user1 = :user2 AND c.user2 = :user1)", ChatUsers.class);
        query.setParameter("user1",chatUsers.getUser1());
        query.setParameter("user2",chatUsers.getUser2());
        List<ChatUsers> resultList = query.getResultList();

        if (resultList.isEmpty()) {
            return false;
        }

        return true;
    }

    @Override
    public List<ChatUsers> findWithUsername(String username) {
        Session currentSession = entityManager.unwrap(Session.class);
        Query<ChatUsers> query = currentSession.createQuery( "from ChatUsers c " +
                "WHERE c.user1 = '" + username + "' OR c.user2 = '" + username + "'", ChatUsers.class);
        List<ChatUsers> resultList = query.getResultList();

        return resultList;
    }

    @Override
    public ChatUsers findWithId(int id) {
        Session currentSession = entityManager.unwrap(Session.class);
        ChatUsers chatUsers = currentSession.get(ChatUsers.class, id);
        return chatUsers;
    }
}
