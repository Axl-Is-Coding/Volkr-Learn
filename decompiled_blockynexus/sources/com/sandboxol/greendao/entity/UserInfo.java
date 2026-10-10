package com.sandboxol.greendao.entity;

/* JADX INFO: loaded from: classes3.dex */
public class UserInfo {
    private String id;
    private String name;
    private String portraitUri;

    public UserInfo(String str, String str2, String str3) {
        this.id = str;
        this.name = str2;
        this.portraitUri = str3;
    }

    public String getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getPortraitUri() {
        return this.portraitUri;
    }

    public void setId(String str) {
        this.id = str;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setPortraitUri(String str) {
        this.portraitUri = str;
    }

    public UserInfo() {
    }
}
