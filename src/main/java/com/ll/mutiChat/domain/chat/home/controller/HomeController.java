package com.ll.mutiChat.domain.chat.home.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home(){
        return "redirect:/chat/room/list";
    }
}
