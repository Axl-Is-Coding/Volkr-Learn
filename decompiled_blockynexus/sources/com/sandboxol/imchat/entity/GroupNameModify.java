package com.sandboxol.imchat.entity;

/* JADX INFO: loaded from: classes4.dex */
public class GroupNameModify {
    private long groupId;
    private String groupName;
    private long memberSize;

    public GroupNameModify(long j, String str) {
        this.groupId = j;
        this.groupName = str;
    }

    public long getGroupId() {
        return this.groupId;
    }

    public String getGroupName() {
        return this.groupName;
    }

    public long getMemberSize() {
        return this.memberSize;
    }

    public void setGroupId(long j) {
        this.groupId = j;
    }

    public void setGroupName(String str) {
        this.groupName = str;
    }

    public void setMemberSize(long j) {
        this.memberSize = j;
    }

    public GroupNameModify(long j, String str, long j2) {
        this.groupId = j;
        this.groupName = str;
        this.memberSize = j2;
    }
}
