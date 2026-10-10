package com.disabngo.blockynexus.entity;

/* JADX INFO: loaded from: classes2.dex */
public class GroupRequest {
    private long groupId;
    private String groupName;
    private String msg;
    private String nickName;
    private String picUrl;
    private long requestId;
    private int status;
    private int type;
    private long userId;
    private int vip;

    public long getGroupId() {
        return this.groupId;
    }

    public String getGroupName() {
        return this.groupName;
    }

    public String getMsg() {
        return this.msg;
    }

    public String getNickName() {
        return this.nickName;
    }

    public String getPicUrl() {
        return this.picUrl;
    }

    public long getRequestId() {
        return this.requestId;
    }

    public int getStatus() {
        return this.status;
    }

    public int getType() {
        return this.type;
    }

    public long getUserId() {
        return this.userId;
    }

    public int getVip() {
        return this.vip;
    }

    public void setGroupId(long j) {
        this.groupId = j;
    }

    public void setGroupName(String str) {
        this.groupName = str;
    }

    public void setMsg(String str) {
        this.msg = str;
    }

    public void setNickName(String str) {
        this.nickName = str;
    }

    public void setPicUrl(String str) {
        this.picUrl = str;
    }

    public void setRequestId(long j) {
        this.requestId = j;
    }

    public void setStatus(int i) {
        this.status = i;
    }

    public void setType(int i) {
        this.type = i;
    }

    public void setUserId(long j) {
        this.userId = j;
    }

    public void setVip(int i) {
        this.vip = i;
    }
}
