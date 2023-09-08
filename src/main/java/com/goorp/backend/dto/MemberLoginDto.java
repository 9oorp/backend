package com.goorp.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class MemberLoginDto {
    @NotBlank(message = "{NotBlank.memberId}")
    private String memberId;
    @NotBlank(message = "{NotBlank.password}")
    private String password;
}
