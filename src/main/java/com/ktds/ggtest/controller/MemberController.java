package com.ktds.ggtest.controller;

import com.ktds.ggtest.domain.Member;
import com.ktds.ggtest.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequiredArgsConstructor
//@RequestMapping("/members")
public class MemberController {

    @Autowired
    private final MemberService memberService;

    @GetMapping("/")
    public String home() {
        return "/html/02_member_01_login.html";
    }


    @GetMapping("/login")
    public String loginForm() {
        return "/html/02_member_01_login.html";
    }

    @GetMapping("/main")
    public String main() {
        return "/html/03_project_03_list.html";
    }

//    @GetMapping("/logout")
//    public String logout(HttpSession session) {
//        session.invalidate();
//        return "redirect:/members/login";
//    }

    @PostMapping("/login")
    @ResponseBody
    public String login(@RequestParam("memberId") String memberId,
                        @RequestParam("password") String password,
                        HttpSession session) {
        // 로그인 로직 구현

        Member member = memberService.findByMemberId(memberId);
        if (member != null && member.getPassword().equals(password)) {
            session.setAttribute("userId", memberId);
            String responseBody="OK";
            ResponseEntity<String> response = ResponseEntity.ok().body(responseBody);
            return response.getBody();
        } else {
            String responseBody="FAIL";
            ResponseEntity<String> response = ResponseEntity.badRequest().body(responseBody);
            ResponseEntity.badRequest().build(); // 실패 response 반환
            return response.getBody();
        }
    }

}
