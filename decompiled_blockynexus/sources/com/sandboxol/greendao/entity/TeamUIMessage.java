package com.sandboxol.greendao.entity;

/* JADX INFO: loaded from: classes3.dex */
public class TeamUIMessage {
    public Long ID;
    private int messageId;
    private long sentTime;
    private long userId;

    public TeamUIMessage(Long l, long j, int i, long j2) {
        this.ID = l;
        this.userId = j;
        this.messageId = i;
        this.sentTime = j2;
    }

    public Long getID() {
        return this.ID;
    }

    public int getMessageId() {
        return this.messageId;
    }

    public long getSentTime() {
        return this.sentTime;
    }

    public long getUserId() {
        return this.userId;
    }

    public void setID(Long l) {
        this.ID = l;
    }

    public void setMessageId(int i) {
        this.messageId = i;
    }

    public void setSentTime(long j) {
        this.sentTime = j;
    }

    public void setUserId(long j) {
        this.userId = j;
    }

    public TeamUIMessage() {
    }
}
