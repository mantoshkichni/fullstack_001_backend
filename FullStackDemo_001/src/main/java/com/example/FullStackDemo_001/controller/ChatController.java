package com.example.FullStackDemo_001.controller;

import com.example.FullStackDemo_001.model.ChatMessage;
import com.example.FullStackDemo_001.repository.ChatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import java.time.LocalDateTime;

@Controller
public class ChatController {

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    @Autowired
    private ChatRepository chatRepository;

    @MessageMapping("/sendQuickMessage")
    @SendTo("/topic/public")
    public void sendMessage(ChatMessage message) {
        message.setTimestamp(LocalDateTime.now());
        messagingTemplate.convertAndSend(
                "/topic/quickMessages",
                message
        );
    }
}
