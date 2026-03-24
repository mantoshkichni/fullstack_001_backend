package com.example.FullStackDemo_001.controller;

import com.example.FullStackDemo_001.model.ChatMessage;
import com.example.FullStackDemo_001.repository.ChatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import java.time.LocalDateTime;

@Controller
public class ChatController {

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    @Autowired
    private ChatRepository chatRepository;

    @MessageMapping("/sendMessage")
    public void sendMessage(ChatMessage message) {

        message.setTimestamp(LocalDateTime.now());
        chatRepository.save(message); // ✅ save in DB

        // send to receiver only
        messagingTemplate.convertAndSendToUser(
                message.getReceiverId().toString(),
                "/queue/messages",
                message
        );
    }
}
