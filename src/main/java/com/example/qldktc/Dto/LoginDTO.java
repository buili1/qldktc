package com.example.qldktc.Dto;

public class LoginDTO {
    private String masv;
    private String password;
    private String role;


    public LoginDTO(String masv, String password, String role) {
        this.masv = masv;
        this.password = password;
        this.role = role;
    }

    public LoginDTO() {
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getMasv() {
        return masv;
    }

    public void setMasv(String masv) {
        this.masv = masv;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
