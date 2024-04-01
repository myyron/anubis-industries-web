package com.anubisindustries.web.dto;

import com.anubisindustries.web.model.ERole;

/**
 *
 * @author altrax
 */
public class SignupRequestDto {

    private String username;
    private String password;
    private ERole role;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ERole getRole() {
        return role;
    }

    public void setRole(ERole role) {
        this.role = role;
    }
}
