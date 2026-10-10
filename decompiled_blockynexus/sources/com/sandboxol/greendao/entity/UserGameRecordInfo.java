package com.sandboxol.greendao.entity;

/* JADX INFO: loaded from: classes3.dex */
public class UserGameRecordInfo {
    private boolean isPlayed;
    private boolean isSignIn;
    private long userId;

    public UserGameRecordInfo(long j, boolean z, boolean z2) {
        this.userId = j;
        this.isPlayed = z;
        this.isSignIn = z2;
    }

    public boolean getIsPlayed() {
        return this.isPlayed;
    }

    public boolean getIsSignIn() {
        return this.isSignIn;
    }

    public long getUserId() {
        return this.userId;
    }

    public void setIsPlayed(boolean z) {
        this.isPlayed = z;
    }

    public void setIsSignIn(boolean z) {
        this.isSignIn = z;
    }

    public void setUserId(long j) {
        this.userId = j;
    }

    public UserGameRecordInfo() {
    }
}
