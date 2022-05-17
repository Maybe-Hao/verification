package com.hao.test.duanxin.Entity;

public class User {
    private String email;
    private String verificationCode;

    @Override
    public String toString() {
        return "User{" +
                "email='" + email + '\'' +
                ", verificationCode='" + verificationCode + '\'' +
                '}';
    }

    public User() {
    }

    public User(String email, String verificationCode) {
        this.email = email;
        this.verificationCode = verificationCode;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getVerificationCode() {
        return verificationCode;
    }

    public void setVerificationCode(String verificationCode) {
        this.verificationCode = verificationCode;
    }
}