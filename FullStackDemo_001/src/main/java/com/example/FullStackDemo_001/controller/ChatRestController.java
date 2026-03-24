package com.example.FullStackDemo_001.controller;

import com.example.FullStackDemo_001.model.ChatMessage;
import com.example.FullStackDemo_001.repository.ChatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/chat")
public class ChatRestController {

    @Autowired
    private ChatRepository chatRepository;

    @GetMapping("/{user1}/{user2}")
    public List<ChatMessage> getChat(@PathVariable Long user1, @PathVariable Long user2) {
        return chatRepository.findBySenderIdAndReceiverIdOrReceiverIdAndSenderId(
                user1, user2, user2, user1
        );
    }
}
