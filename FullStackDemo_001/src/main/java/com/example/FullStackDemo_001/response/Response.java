package com.example.FullStackDemo_001.response;

import com.example.FullStackDemo_001.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Response {
    String message;
    String stsusCode;
    User user;
}
