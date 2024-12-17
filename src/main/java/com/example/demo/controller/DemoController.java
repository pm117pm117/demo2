// // package com.example.demo;

// // import org.springframework.stereotype.Controller;
// // import org.springframework.ui.Model;
// // import org.springframework.web.bind.annotation.GetMapping;

// // @Controller // 컨트롤러 어노테이션 명시
// // public class DemoController 
// // { 
// //     @GetMapping("/hello") // 전송 방식 GET
// //     public String hello(Model model) 
// //     {
// //         model.addAttribute("data", " 방갑습니다."); // model 설정
// //         return "hello"; // hello.html 연결
// //     }
// // }

// // 이 클래스가 속한 패키지를 선언합니다.
// package com.example.demo.controller;

// import org.springframework.beans.factory.annotation.Autowired;

// // Spring Framework에서 제공하는 Controller 애노테이션을 임포트합니다.
// import org.springframework.stereotype.Controller;
// import org.springframework.stereotype.Repository;
// // Spring의 Model 인터페이스를 임포트합니다. 이는 뷰에 데이터를 전달하는 데 사용됩니다.
// import org.springframework.ui.Model;
// // HTTP GET 요청을 특정 메서드에 매핑하기 위한 애노테이션을 임포트합니다.
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.RequestParam;

// import com.example.demo.model.domain.TestDB;
// import com.example.demo.model.service.TestService;


// // 이 클래스가 Spring MVC의 컨트롤러임을 나타냅니다.
// // 이 애노테이션은 Spring에게 이 클래스가 웹 요청을 처리할 수 있음을 알려줍니다.
// @Controller
// public class DemoController {

//     @GetMapping("/hello")
//     public String hello(Model model) {
//         model.addAttribute("data", " 방갑습니다.");
//         return "hello";
//     }

//     @GetMapping("/hello2")
//     public String hello2(Model model2) {
//         model2.addAttribute("data2", "홍길동님.");
//         model2.addAttribute("data3", "방갑습니다.");
//         model2.addAttribute("data4", "오늘.");
//         model2.addAttribute("data5", "날씨는.");
//         model2.addAttribute("data6", "매우 좋습니다.");
//         return "hello2";
//     }

//     @GetMapping("/about_detailed")
//     public String about() {
//     return "about_detailed";
//     }

//     @GetMapping("/thymeleaf_test1")
//     public String thymeleaf_test1(Model model) 
//     {
//         model.addAttribute("data1", "<h2> 방갑습니다 </h2>");
//         model.addAttribute("data2", "태그의 속성 값");
//         model.addAttribute("link", 01);
//         model.addAttribute("name", "홍길동");
//         model.addAttribute("para1", "001");
//         model.addAttribute("para2", 002);
//     return "thymeleaf_test1";
//     }

//     @Autowired
//     private TestService testService;
    

//     @GetMapping("/testdb")
//     public String getAllTestDBs(Model model) {
//         TestDB test = testService.findByName("홍길동");
//         TestDB test1 = testService.findByName("아저씨");
//         TestDB test2 = testService.findByName("꾸러기");
//         model.addAttribute("data4", test);
//         model.addAttribute("data5", test1);
//         model.addAttribute("data6", test2);
//         System.out.println("데이터 출력 디버그 : " + test);
//         System.out.println("데이터 출력 디버그 : " + test1);
//         System.out.println("데이터 출력 디버그 : " + test2);
//         return "testdb";
//     }
// }