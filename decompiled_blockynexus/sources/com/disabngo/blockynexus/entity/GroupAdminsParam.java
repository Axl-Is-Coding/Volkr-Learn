package com.disabngo.blockynexus.entity;

import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class GroupAdminsParam {
    private long groupId;
    private long inviterId;
    private List<Long> memberIds;
    private int operationType;

    public long getGroupId() {
        return this.groupId;
    }

    public long getInviterId() {
        return this.inviterId;
    }

    public List<Long> getMemberIds() {
        return this.memberIds;
    }

    public int getOperationType() {
        return this.operationType;
    }

    public void setGroupId(long j) {
        this.groupId = j;
    }

    public void setInviterId(long j) {
        this.inviterId = j;
    }

    public void setMemberIds(List<Long> list) {
        this.memberIds = list;
    }

    public void setOperationType(int i) {
        this.operationType = i;
    }
}
