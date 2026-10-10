package com.disabngo.blockynexus.entity;

import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class GroupInfoParam implements Serializable {
    private long groupId;
    private String groupName;
    private String groupNotice;
    private String groupPic;
    private int inviteStatus;
    private long inviterId;
    private List<String> noticePic;

    public long getGroupId() {
        return this.groupId;
    }

    public String getGroupName() {
        return this.groupName;
    }

    public String getGroupNotice() {
        return this.groupNotice;
    }

    public String getGroupPic() {
        return this.groupPic;
    }

    public int getInviteStatus() {
        return this.inviteStatus;
    }

    public long getInviterId() {
        return this.inviterId;
    }

    public List<String> getNoticePic() {
        return this.noticePic;
    }

    public void setGroupId(long j) {
        this.groupId = j;
    }

    public void setGroupName(String str) {
        this.groupName = str;
    }

    public void setGroupNotice(String str) {
        this.groupNotice = str;
    }

    public void setGroupPic(String str) {
        this.groupPic = str;
    }

    public void setInviteStatus(int i) {
        this.inviteStatus = i;
    }

    public void setInviterId(long j) {
        this.inviterId = j;
    }

    public void setNoticePic(List<String> list) {
        this.noticePic = list;
    }

    public String toString() {
        return "GroupInfoParam{groupId=" + this.groupId + ", groupName='" + this.groupName + "', groupNotice='" + this.groupNotice + "', groupPic='" + this.groupPic + "', inviteStatus=" + this.inviteStatus + ", inviterId=" + this.inviterId + ", noticePic=" + this.noticePic + '}';
    }
}
