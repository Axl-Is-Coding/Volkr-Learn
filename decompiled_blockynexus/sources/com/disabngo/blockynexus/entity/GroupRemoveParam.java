package com.disabngo.blockynexus.entity;

import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class GroupRemoveParam {
    private long groupId;
    private String groupName;
    private long inviterId;
    private List<Long> memberIds;

    public long getGroupId() {
        return this.groupId;
    }

    public String getGroupName() {
        return this.groupName;
    }

    public long getInviterId() {
        return this.inviterId;
    }

    public List<Long> getMemberIds() {
        return this.memberIds;
    }

    public void setGroupId(long j) {
        this.groupId = j;
    }

    public void setGroupName(String str) {
        this.groupName = str;
    }

    public void setInviterId(long j) {
        this.inviterId = j;
    }

    public void setMemberIds(List<Long> list) {
        this.memberIds = list;
    }
}
