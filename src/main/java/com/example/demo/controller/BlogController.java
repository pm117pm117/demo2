package com.example.demo.controller;

// import java.util.List;
import java.util.Optional;
// import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.example.demo.model.domain.Board;
import com.example.demo.model.service.AddBoardRequest;
import com.example.demo.model.service.BlogService;

import jakarta.servlet.http.HttpSession;

@Controller
public class BlogController {

    private final BlogService blogService;

    // @Autowired
    public BlogController(BlogService blogService) {
        this.blogService = blogService;
    }

    // @GetMapping("/board_list")
    // public String board_list(Model model) {
    //     List<Board> list = blogService.findAll();
    //     model.addAttribute("boards", list);
    //     return "board_list";
    // }

    @GetMapping("/board_view/{id}")
    public String board_view(Model model, @PathVariable Long id) {
        Optional<Board> board = blogService.findById(id);
        board.ifPresent(value -> model.addAttribute("boards", value));
        return board.isPresent() ? "board_view" : "error_page/article_error";
    }

    @GetMapping("/board_edit/{id}") // 게시판 링크 지정
    public String board_edit(Model model, @PathVariable Long id) {
        Optional<Board> list = blogService.findById(id); // 선택한 게시판 글
        if (list.isPresent()) {
            model.addAttribute("boards", list.get()); // 존재하면 Article 객체를 모델에 추가
            } else {
                // 처리할 로직 추가 (예: 오류 페이지로 리다이렉트, 예외 처리 등)
                return "/error_page/article_error"; //오류 처리 페이지로 연결(이름 수정됨)
            }
        return "board_edit"; // .HTML 연결
    }

    @PutMapping("/board_edit/{id}")
    public String updateBoard(@PathVariable Long id, @ModelAttribute AddBoardRequest request) {
        blogService.update(id, request);
        return "redirect:/board_view/" + id;
    }

    @DeleteMapping("/board_delete/{id}")
    public String deleteBoard(@PathVariable Long id) {
        blogService.delete(id);
        return "redirect:/board_list";
    }

    @GetMapping("/board_write")
    public String board_write() {
        return "board_write";
    }

    @PostMapping("/api/boards") // 글쓰기 게시판 저장
    public String addboards(@ModelAttribute AddBoardRequest request) {
        blogService.save(request);
        return "redirect:/board_list"; // .HTML 연결
    }

    @GetMapping("/board_list")
    public String board_list(
        Model model,
        @RequestParam(defaultValue = "0") int page,
        @RequestParam(defaultValue = "") String keyword,
        HttpSession session) {
        String userId = (String) session.getAttribute("userId");
        String email = (String) session.getAttribute("email");
        if (userId == null) {
            return "redirect:/member_login";
        }

        PageRequest pageable = PageRequest.of(page, 3); // 한 페이지의 게시글 수
        Page<Board> list;
        
        if (keyword.isEmpty()) {
            list = blogService.findAll(pageable);
        } else {
            list = blogService.searchByKeyword(keyword, pageable);
        }

        int startNum = page * pageable.getPageSize() + 1;

        model.addAttribute("boards", list);
        model.addAttribute("totalPages", list.getTotalPages());
        model.addAttribute("currentPage", page);
        model.addAttribute("keyword", keyword);
        model.addAttribute("startNum", startNum);
        model.addAttribute("email", email);

        return "board_list";
    }
}