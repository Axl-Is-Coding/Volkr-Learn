package com.sandboxol.greendao.entity;

/* JADX INFO: loaded from: classes3.dex */
public class PartyMemberInfo {
    public Long ID;
    private long localUserId;
    private String nickName;
    private String picUrl;
    private long userId;

    public PartyMemberInfo(Long l, long j, long j2, String str, String str2) {
        this.ID = l;
        this.userId = j;
        this.localUserId = j2;
        this.nickName = str;
        this.picUrl = str2;
    }

    public Long getID() {
        return this.ID;
    }

    public long getLocalUserId() {
        return this.localUserId;
    }

    public String getNickName() {
        return this.nickName;
    }

    public String getPicUrl() {
        return this.picUrl;
    }

    public long getUserId() {
        return this.userId;
    }

    public void setID(Long l) {
        this.ID = l;
    }

    public void setLocalUserId(long j) {
        this.localUserId = j;
    }

    public void setNickName(String str) {
        this.nickName = str;
    }

    public void setPicUrl(String str) {
        this.picUrl = str;
    }

    public void setUserId(long j) {
        this.userId = j;
    }

    public PartyMemberInfo() {
    }
}
