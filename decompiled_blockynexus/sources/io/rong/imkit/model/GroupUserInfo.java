package io.rong.imkit.model;

/* JADX INFO: loaded from: classes5.dex */
public class GroupUserInfo {
    private String groupId;
    private String nickname;
    private String userId;

    public GroupUserInfo(String str, String str2, String str3) {
        this.groupId = str;
        this.nickname = str3;
        this.userId = str2;
    }

    public String getGroupId() {
        return this.groupId;
    }

    public String getNickname() {
        return this.nickname;
    }

    public String getUserId() {
        return this.userId;
    }

    public void setGroupId(String str) {
        this.groupId = str;
    }
}
