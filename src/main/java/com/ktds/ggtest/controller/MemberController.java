package com.ktds.ggtest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MemberController {

    @GetMapping
    public String login(){
        return "/html/02_member_01_login.html";
    }

}