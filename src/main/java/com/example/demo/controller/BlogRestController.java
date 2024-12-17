// package com.example.demo.controller;

// import org.springframework.web.bind.annotation.RestController;
// import com.example.demo.model.service.AddBoardRequest;
// import com.example.demo.model.service.BlogService;
// import lombok.RequiredArgsConstructor;
// import org.springframework.http.HttpStatus;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.*;

// @RequiredArgsConstructor
// @RestController
// public class BlogRestController {
//     private final BlogService blogService;

//     @PostMapping("/api/board")
//     public ResponseEntity<Board> addBoard(@ModelAttribute AddBoardRequest request) {
//         Board savedBoard = blogService.save(request);
//         return ResponseEntity.status(HttpStatus.CREATED).body(savedBoard);
//     }
// }

package com.example.demo.controller;

// import com.example.demo.model.domain.Board;
// import com.example.demo.model.service.AddBoardRequest;
import com.example.demo.model.service.BlogService;
import lombok.RequiredArgsConstructor;
// import org.springframework.http.HttpStatus;
// import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class BlogRestController {
    private final BlogService blogService;

    // @PostMapping("/api/boards/")
    // public ResponseEntity<Board> addBoard(@ModelAttribute AddBoardRequest request) {
    //     Board savedBoard = blogService.save(request);
    //     return ResponseEntity.status(HttpStatus.CREATED)
    //     .body(savedBoard);
    // }
}