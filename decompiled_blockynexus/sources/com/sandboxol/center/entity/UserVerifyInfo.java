package com.sandboxol.center.entity;

/* JADX INFO: loaded from: classes3.dex */
public class UserVerifyInfo {
    private String authCode;
    private int count;
    private boolean right;

    public String getAuthCode() {
        return this.authCode;
    }

    public int getCount() {
        return this.count;
    }

    public boolean isRight() {
        return this.right;
    }

    public void setAuthCode(String str) {
        this.authCode = str;
    }

    public void setCount(int i) {
        this.count = i;
    }

    public void setRight(boolean z) {
        this.right = z;
    }
}
