package com.example.demo.controller;

import java.util.UUID;
// import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import com.example.demo.model.domain.Member;
import com.example.demo.model.service.AddMemberRequest;
import com.example.demo.model.service.MemberService;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import jakarta.servlet.http.Cookie;

@Controller
public class MemberController {

    private final MemberService memberService;

    // @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/join_new")
    public String joinNew(Model model) {
        model.addAttribute("addMemberRequest", new AddMemberRequest());
        return "join_new";
    }

    @PostMapping("/api/members")
    public String addmembers(@Valid @ModelAttribute AddMemberRequest request, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "join_new";
        }
        memberService.saveMember(request);
        return "join_end";
    }

    @GetMapping("/member_login") // 로그인 페이지 연결
    public String member_login() {
        return "login"; // .HTML 연결
    }
    
    @PostMapping("/api/login_check")
    public String checkMembers(@Valid @ModelAttribute AddMemberRequest request, BindingResult bindingResult, Model model, HttpServletRequest request2) {
        try {
        HttpSession session = request2.getSession(false);
        if (session != null) {
            session.invalidate(); // 기존 세션 무효화
        }
            session = request2.getSession(true); // 새로운 세션 생성

            Member member = memberService.loginCheck(request.getEmail(), request.getPassword());
            session.setAttribute("userId", UUID.randomUUID().toString()); // 임의의 고유 ID로 세션 생성
            session.setAttribute("email", request.getEmail()); // 이메일 설정
            model.addAttribute("member", member); // 로그인 성공 시 회원 정보 전달

            return "redirect:/board_list"; // 로그인 성공 후 이동할 페이지
        } catch (IllegalArgumentException e) {
            model.addAttribute("error", e.getMessage()); // 에러 메시지 전달
            return "login"; // 로그인 실패 시 로그인 페이지로 리다이렉트
        }
    }

    @GetMapping("/api/logout")
    public String member_logout(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }
        Cookie cookie = new Cookie("JSESSIONID", null);
        cookie.setPath("/");
        cookie.setMaxAge(0);
        response.addCookie(cookie);
        return "redirect:/member_login";
    }
}