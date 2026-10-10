package com.disabngo.blockynexus.entity;

/* JADX INFO: loaded from: classes2.dex */
public class JoinGroupRequest {
    private long groupId;
    private long operateId;
    private int type;
    private long userId;

    public long getGroupId() {
        return this.groupId;
    }

    public long getOperateId() {
        return this.operateId;
    }

    public int getType() {
        return this.type;
    }

    public long getUserId() {
        return this.userId;
    }

    public void setGroupId(long j) {
        this.groupId = j;
    }

    public void setOperateId(long j) {
        this.operateId = j;
    }

    public void setType(int i) {
        this.type = i;
    }

    public void setUserId(long j) {
        this.userId = j;
    }
}
