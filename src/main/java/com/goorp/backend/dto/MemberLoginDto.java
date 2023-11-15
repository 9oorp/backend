package com.goorp.backend.dto;

import javax.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class MemberLoginDto {

    @NotBlank(message = "{NotBlank.memberId}")
    private String accountId;
    @NotBlank(message = "{NotBlank.password}")
    private String password;
}
