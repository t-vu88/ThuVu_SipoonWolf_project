package com.example.thuvuFinalproject.domain;

import org.springframework.security.core.authority.AuthorityUtils;

public class CustomUserDetails extends org.springframework.security.core.userdetails.User {
    private final AppUser appUser;

    public CustomUserDetails(AppUser appUser) {
        super(appUser.getUsername(), appUser.getPasswordHash(), AuthorityUtils.createAuthorityList(appUser.getRole()));
        this.appUser = appUser;
    }

    public AppUser getAppUser() {
        return appUser;
    }
}

