package com.example.toursystem.entity.chat;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
public class ChatHistory {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "chat_id")
    private int chatId;
    @Basic
    @Column(name = "time")
    private Timestamp time;
    @Basic
    @Column(name = "username")
    private String username;
    @Basic
    @Column(name = "content")
    private String content;


    public ChatHistory() {
    }

    public ChatHistory(int chatId, Timestamp time, String username, String content) {
        this.chatId = chatId;
        this.time = time;
        this.username = username;
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getChatId() {
        return chatId;
    }

    public void setChatId(int chatId) {
        this.chatId = chatId;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
