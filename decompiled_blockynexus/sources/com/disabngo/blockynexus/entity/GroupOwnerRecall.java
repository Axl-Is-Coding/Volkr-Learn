package com.disabngo.blockynexus.entity;

/* JADX INFO: loaded from: classes2.dex */
public class GroupOwnerRecall {
    private long groupId;
    private long memberId;
    private String sendTime;
    private String uid;
    private long userId;

    public long getGroupId() {
        return this.groupId;
    }

    public long getMemberId() {
        return this.memberId;
    }

    public String getSendTime() {
        return this.sendTime;
    }

    public String getUid() {
        return this.uid;
    }

    public long getUserId() {
        return this.userId;
    }

    public void setGroupId(long j) {
        this.groupId = j;
    }

    public void setMemberId(long j) {
        this.memberId = j;
    }

    public void setSendTime(String str) {
        this.sendTime = str;
    }

    public void setUid(String str) {
        this.uid = str;
    }

    public void setUserId(long j) {
        this.userId = j;
    }
}
