package com.example.demo.model.service;

import java.util.List;
import java.util.Optional;

// import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.example.demo.model.domain.Board;
// import com.example.demo.model.repository.BlogRepository;
// import com.example.demo.model.service.AddBoardRequest;
import com.example.demo.model.repository.BoardRepository;

@Service
public class BlogService {

    private final BoardRepository boardRepository;

    // @Autowired
    public BlogService(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    public List<Board> findAll() {
        return boardRepository.findAll();
    }
    
    public Optional<Board> findById(Long id) {
        return boardRepository.findById(id);
    }

    public void update(Long id, AddBoardRequest request) {
        boardRepository.findById(id).ifPresent(board -> {
            board.update(request.getTitle(), request.getContent(), board.getUser(), board.getNewdate(), board.getCount(), board.getLikec());
            boardRepository.save(board);
        });
    }

    public void delete(Long id) {
        boardRepository.deleteById(id);
    }

    public Board save(AddBoardRequest request){
        // DTO가 없는 경우 이곳에 직접 구현 가능
        return boardRepository.save(request.toEntity());
    }

    public Page<Board> findAll(Pageable pageable) {
        return boardRepository.findAll(pageable);
    }

    public Page<Board> searchByKeyword(String keyword, Pageable pageable) {
        return boardRepository.findByTitleContainingIgnoreCase(keyword, pageable);
    } // LIKE 검색 제공(대소문자 무시)
}
