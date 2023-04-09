package com.cyl.ctrbt.controller;

import com.cyl.ctrbt.openai.ChatGPTUtil;
import com.cyl.ctrbt.openai.entity.chat.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/chat")
@RestController
public class ChatbotController {

    @Autowired
    private ChatGPTUtil chatGPTUtil;

    @RequestMapping(value = "/chatgpt", method = RequestMethod.GET)
    public String helloRobots(String ask) {
        System.out.println("ask:" + ask);
        Message message = chatGPTUtil.chat(ask, "web");
        System.out.println("response:" + message.getContent());
        return message.getContent();
    }
}
