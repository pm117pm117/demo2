// package com.example.demo.model.service; //서비스

// import java.util.List; //자바 라이브러리 list 클래스 임포트
// import java.util.Optional; // 자바 라이브러리 Optional 클래스 임포트

// // import org.springframework.beans.factory.annotation.Autowired; //오토와이어 임포트
// //autowired 의존성 자동주입 어노테이션
// import org.springframework.stereotype.Service; //서비스 임포트
// import com.example.demo.model.domain.Article; //아티클 임포트
// import com.example.demo.model.domain.Board;
// // import com.example.demo.model.repository.BlogRepository; // 리포스토리지 임포트
// import com.example.demo.model.repository.BoardRepository;

// // import lombok.RequiredArgsConstructor; 
// //requiredArgsConstructor: 최종 반환 필드에 대한 생성자 자동생성 << 을 임포트

// @Service //서비스역할 선언 어노테이션
// // @RequiredArgsConstructor // 생성자 자동 생성(오토와이어 생략 가능)

// public class BlogService {
//     // private final BlogRepository blogRepository;
//     private final BoardRepository blogRepository;

//     // public List<Article> findAll() { // 게시판 전체 목록 조회
//     //     return blogRepository.findAll(); //블로그리포토리지 내부에서 findall 메서드 반환
//     // }

//     // public Optional<Article> findById(Long id) { // 게시판 특정 글 조회
//     //     return blogRepository.findById(id); //DB에서 id로 찾은 값 반환 
//     // }

//     public List<Board> findAll() { // 게시판 전체 목록 조회
//         return blogRepository.findAll();
//     }
    
//     public Optional<Board> findById(Long id) { // 게시판 특정 글 조회
//         return blogRepository.findById(id);
//     }

//     // public Article save(AddArticleRequest request){ //애드 아티클 리퀘스트 = 게시물 저장
//     //     // DTO가 없는 경우 이곳에 직접 구현 가능
//     //     // public ResponseEntity<Article> addArticle(@RequestParam String title, @RequestParam String content) {
//     //     // Article article = Article.builder()
//     //     // .title(title)
//     //     // .content(content)
//     //     // .build();
//     //     return blogRepository.save(request.toEntity()); //DB에 요청한 엔티티 저장 (게시물 DB에 저장)
//     // }

//     // public void update(Long id, AddArticleRequest request) { //필요한 객체 아이디(롱 변수), 아티클리퀘스트 정의 
//     //     //long 자료형 변수에 id 저장, addArticleRequest에 요청 저장
//     //     Optional<Article> optionalArticle = blogRepository.findById(id); // 단일 글 조회, 아티클 = DB에서 찾은 id
//     //     optionalArticle.ifPresent(article -> { // 아티클 값이 있으면. 
//     //         //ifpresent -> 조회된 아티클 객체(id, 게시물)가 있으면 업데이트 및 저장 작업 실행
//     //         //없으면 Optional<article>값 => Optional.empty()로 반환해서 null 방지
//     //         article.update(request.getTitle(), request.getContent()); // 제목과 콘텐츠 값을 수정
//     //         blogRepository.save(article); // Article 객체에 저장
//     //     });
//     // }

//     public void delete(Long id) {
//         blogRepository.deleteById(id); // 특정 id의 아티클 엔티티(저장된 값/제목 및 콘텐츠) 게시물 삭제
//     }
// }