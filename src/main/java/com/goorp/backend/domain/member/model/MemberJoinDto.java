package com.goorp.backend.domain.member.model;

import com.goorp.backend.domain.member.Member;
import java.time.LocalDate;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class MemberJoinDto {

    @Size(min = 5, max = 20, message = "{Size.memberId}")
    private String accountId;
    @Size(min = 5, max = 20, message = "{Size.memberName}")
    private String memberName;
    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d).+$", message = "{Pattern.password}")  // 영어, 숫자 포함
    @Size(min = 5, max = 30, message = "{Size.password}")
    private String password;
    @NotBlank(message = "{NotBlank.passwordConfirm}")
    private String passwordConfirm;

    public void setEncodingPassword(String password) {
        this.password = password;
    }

    public static Member joinDtoToMember(MemberJoinDto dto) {
        LocalDate now = LocalDate.now();
        return Member.builder()
            .accountId(dto.getAccountId())
            .password(dto.getPassword())
            .name(dto.getMemberName())
            .createdAt(now)
            .updatedAt(now)
            .build();
    }
}