package com.sandboxol.greendao.entity;

/* JADX INFO: loaded from: classes3.dex */
public class RegisterInfo {
    private String inviteCode = "";
    private String nickName;
    private int sex;

    public String getInviteCode() {
        return this.inviteCode;
    }

    public String getNickName() {
        return this.nickName;
    }

    public int getSex() {
        return this.sex;
    }

    public void setInviteCode(String str) {
        this.inviteCode = str;
    }

    public void setNickName(String str) {
        this.nickName = str;
    }

    public void setSex(int i) {
        this.sex = i;
    }
}
