package com.dev.road.controller;

import com.dev.road.entity.User;
import com.dev.road.repository.UserRepository;
import com.dev.road.service.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class UserController {

    @Autowired
    private CustomUserDetailsService customUserDetailsService;
    private UserRepository userRepository;

    // 가입 폼
    @GetMapping("/register")
    public String showRegisterForm(){
        return "register";
    }

    // 사용자 등록 로직
    @PostMapping("/register")
    public String register(User user) {
        userRepository.save(user);
        return "redirect:/register";
    }
    // 로그인 폼
    @GetMapping("/login")
    public String login(){
        return "login";
    }
    //비밀번호 재설정 페이지 뷰
    @GetMapping("/forgot-password")
    public String forgetPassword(){
        return "forgot-password";
    }

}
