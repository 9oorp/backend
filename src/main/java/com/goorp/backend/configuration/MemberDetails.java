package com.goorp.backend.configuration;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
public class MemberDetails {
    private String accountId;
    private String memberName;
    private RoleType roleType;

    public MemberDetails(String accountId, String memberName, RoleType roleType) {
        this.accountId = accountId;
        this.memberName = memberName;
        this.roleType = roleType;
    }

    public MemberDetails(String accountId) {
        this.accountId = accountId;
    }
}