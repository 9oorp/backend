package com.goorp.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class MemberJoinDto {
    @Size(min = 5, max = 20, message = "{Size.memberId}")
    private String accountId;
    @Size(min = 5, max = 20, message = "{Size.memberName}")
    private String memberName;
    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d).+$", message = "{Pattern.password}")  // 영어, 숫자 포함
    @Size(min = 10, max = 30, message = "{Size.password}")
    private String password;
    @NotBlank(message = "{NotBlank.passwordConfirm}")
    private String passwordConfirm;
}