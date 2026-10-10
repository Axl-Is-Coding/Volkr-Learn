package com.sandboxol.center.entity;

/* JADX INFO: loaded from: classes3.dex */
public class ChangePasswordForm {
    private String confirmPassword;
    private String newPassword;
    private String oldPassword;

    public ChangePasswordForm() {
    }

    public String getConfirmPassword() {
        return this.confirmPassword;
    }

    public String getNewPassword() {
        return this.newPassword;
    }

    public String getOldPassword() {
        return this.oldPassword;
    }

    public void setConfirmPassword(String str) {
        this.confirmPassword = str;
    }

    public void setNewPassword(String str) {
        this.newPassword = str;
    }

    public void setOldPassword(String str) {
        this.oldPassword = str;
    }

    public ChangePasswordForm(ChangePasswordForm changePasswordForm) {
        this.oldPassword = changePasswordForm.getOldPassword();
        this.newPassword = changePasswordForm.getNewPassword();
        this.confirmPassword = changePasswordForm.getConfirmPassword();
    }
}
