package com.goorp.backend.configuration;

import lombok.Getter;

@Getter
public class MemberDetails {
    private Long memberId;
    private String accountId;
    private String memberName;
    private RoleType roleType;

    public MemberDetails(Long memberId, String accountId, String memberName, RoleType roleType) {
        this.memberId = memberId;
        this.accountId = accountId;
        this.memberName = memberName;
        this.roleType = roleType;
    }

    public MemberDetails(Long memberId) {
        this.memberId = memberId;
    }
}