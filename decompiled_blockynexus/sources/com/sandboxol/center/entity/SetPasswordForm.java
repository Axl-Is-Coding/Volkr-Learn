package com.sandboxol.center.entity;

/* JADX INFO: loaded from: classes3.dex */
public class SetPasswordForm {
    private String account;
    private String confirmPassword;
    private String password;
    private Long userId;

    public SetPasswordForm() {
    }

    public String getAccount() {
        return this.account;
    }

    public String getConfirmPassword() {
        return this.confirmPassword;
    }

    public String getPassword() {
        return this.password;
    }

    public Long getUserId() {
        return this.userId;
    }

    public void setAccount(String str) {
        this.account = str;
    }

    public void setConfirmPassword(String str) {
        this.confirmPassword = str;
    }

    public void setPassword(String str) {
        this.password = str;
    }

    public void setUserId(Long l) {
        this.userId = l;
    }

    public SetPasswordForm(SetPasswordForm setPasswordForm) {
        this.userId = setPasswordForm.getUserId();
        this.account = setPasswordForm.getAccount();
        this.password = setPasswordForm.getPassword();
        this.confirmPassword = setPasswordForm.getConfirmPassword();
    }
}
