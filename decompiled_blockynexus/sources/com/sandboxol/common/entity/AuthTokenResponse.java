package com.sandboxol.common.entity;

import java.io.Serializable;

/* JADX INFO: loaded from: classes3.dex */
public class AuthTokenResponse implements Serializable {
    private String accessToken;
    private boolean hasBinding;
    private boolean hasPassword;
    private long userId;

    public String getAccessToken() {
        return this.accessToken;
    }

    public long getUserId() {
        return this.userId;
    }

    public boolean isHasBinding() {
        return this.hasBinding;
    }

    public boolean isHasPassword() {
        return this.hasPassword;
    }

    public void setAccessToken(String str) {
        this.accessToken = str;
    }

    public void setHasBinding(boolean z) {
        this.hasBinding = z;
    }

    public void setHasPassword(boolean z) {
        this.hasPassword = z;
    }

    public void setUserId(long j) {
        this.userId = j;
    }
}
