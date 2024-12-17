package com.example.demo.model.service;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.example.demo.model.domain.Member;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class AddMemberRequest {
    @NotBlank(message = "이름을 입력해주세요.")
    @Pattern(regexp = "^[가-힣A-Za-z]+$", message = "이름은 한글 또는 영문만 가능합니다.")
    private String name;

    @NotBlank(message = "이메일을 입력해주세요.")
    @Email(message = "올바른 이메일 형식이 아닙니다.")
    private String email;

    @NotBlank(message = "비밀번호를 입력해주세요.")
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{8,}$", message = "비밀번호는 8자 이상이며, 대소문자와 숫자를 포함해야 합니다.")
    private String password;

    @NotBlank(message = "나이를 입력해주세요.")
    @Pattern(regexp = "^(?:1[9-9]|[2-8][0-9]|90)$", message = "나이는 19세 이상 90세 이하여야 합니다.")
    private String age;

    @Pattern(regexp = "^\\d{3}-\\d{3,4}-\\d{4}$", message = "올바른 전화번호 형식이 아닙니다.")
    private String mobile;

    @NotBlank(message = "주소를 입력해주세요.")
    private String address;

    public Member toEntity() {
        return Member.builder()
            .name(name)
            .email(email)
            .password(password)
            .age(age)
            .mobile(mobile)
            .address(address)
            .build();
    }
}