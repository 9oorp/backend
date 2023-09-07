package com.goorp.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class MemberJoinDto {
    private String memberId;
    private String memberName;
    private String password;
    private String passwordConfirm;
}
