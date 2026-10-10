package com.sandboxol.imchat.entity;

/* JADX INFO: loaded from: classes4.dex */
public class UserMessage {
    private String message;
    private String nickname;
    private long sentTime;
    private String userId;

    public String getMessage() {
        return this.message;
    }

    public String getNickname() {
        return this.nickname;
    }

    public long getSentTime() {
        return this.sentTime;
    }

    public String getUserId() {
        return this.userId;
    }

    public void setMessage(String str) {
        this.message = str;
    }

    public void setNickname(String str) {
        this.nickname = str;
    }

    public void setSentTime(long j) {
        this.sentTime = j;
    }

    public void setUserId(String str) {
        this.userId = str;
    }
}
