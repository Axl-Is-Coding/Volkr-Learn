package com.disabngo.blockynexus.entity;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class GroupInfo implements Parcelable {
    public static final Parcelable.Creator<GroupInfo> CREATOR = new Parcelable.Creator<GroupInfo>() { // from class: com.disabngo.blockynexus.entity.GroupInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public GroupInfo createFromParcel(Parcel parcel) {
            return new GroupInfo(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public GroupInfo[] newArray(int i) {
            return new GroupInfo[i];
        }
    };
    private int forbiddenWordsStatus;
    private long groupId;
    private List<GroupMember> groupMembers;
    private String groupName;
    private String groupNotice;
    private String groupPic;
    private int inviteStatus;
    private List<String> noticePic;
    private int officialGroup;
    private String ownerId;
    private String releaseTime;

    public GroupInfo() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getForbiddenWordsStatus() {
        return this.forbiddenWordsStatus;
    }

    public long getGroupId() {
        return this.groupId;
    }

    public List<GroupMember> getGroupMembers() {
        List<GroupMember> list = this.groupMembers;
        return list == null ? new ArrayList() : list;
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

    public List<String> getNoticePic() {
        return this.noticePic;
    }

    public int getOfficialGroup() {
        return this.officialGroup;
    }

    public String getOwnerId() {
        return this.ownerId;
    }

    public String getReleaseTime() {
        return this.releaseTime;
    }

    public void setForbiddenWordsStatus(int i) {
        this.forbiddenWordsStatus = i;
    }

    public void setGroupId(long j) {
        this.groupId = j;
    }

    public void setGroupMembers(List<GroupMember> list) {
        this.groupMembers = list;
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

    public void setNoticePic(List<String> list) {
        this.noticePic = list;
    }

    public void setOfficialGroup(int i) {
        this.officialGroup = i;
    }

    public void setOwnerId(String str) {
        this.ownerId = str;
    }

    public void setReleaseTime(String str) {
        this.releaseTime = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.groupId);
        parcel.writeString(this.groupName);
        parcel.writeString(this.groupNotice);
        parcel.writeString(this.ownerId);
        parcel.writeInt(this.officialGroup);
        parcel.writeTypedList(this.groupMembers);
        parcel.writeString(this.releaseTime);
        parcel.writeString(this.groupPic);
        parcel.writeInt(this.inviteStatus);
        parcel.writeStringList(this.noticePic);
        parcel.writeInt(this.forbiddenWordsStatus);
    }

    protected GroupInfo(Parcel parcel) {
        this.groupId = parcel.readLong();
        this.groupName = parcel.readString();
        this.groupNotice = parcel.readString();
        this.ownerId = parcel.readString();
        this.officialGroup = parcel.readInt();
        this.groupMembers = parcel.createTypedArrayList(GroupMember.CREATOR);
        this.releaseTime = parcel.readString();
        this.groupPic = parcel.readString();
        this.inviteStatus = parcel.readInt();
        this.noticePic = parcel.createStringArrayList();
        this.forbiddenWordsStatus = parcel.readInt();
    }
}
