package com.sandboxol.center.entity;

import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class UserVerifySettingsInfo {
    private boolean bindEmail;
    private String email;
    private List<Integer> ids;
    private List<SecretQuestionInfo> secretQuestionList;
    private long userId;

    public String getEmail() {
        return this.email;
    }

    public List<Integer> getIds() {
        return this.ids;
    }

    public List<SecretQuestionInfo> getSecretQuestionList() {
        return this.secretQuestionList;
    }

    public long getUserId() {
        return this.userId;
    }

    public boolean isBindEmail() {
        return this.bindEmail;
    }

    public void setBindEmail(boolean z) {
        this.bindEmail = z;
    }

    public void setEmail(String str) {
        this.email = str;
    }

    public void setIds(List<Integer> list) {
        this.ids = list;
    }

    public void setSecretQuestionList(List<SecretQuestionInfo> list) {
        this.secretQuestionList = list;
    }

    public void setUserId(long j) {
        this.userId = j;
    }
}
