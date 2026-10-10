package com.sandboxol.greendao.entity;

import java.io.Serializable;

/* JADX INFO: loaded from: classes3.dex */
public class AuthorInfo implements Serializable {
    private String headPic;
    private int isAddFriend;
    private boolean isLast;
    private int isTeam;
    private String nickName;
    private long teamId;
    private long userId;

    public String getHeadPic() {
        return this.headPic;
    }

    public int getIsAddFriend() {
        return this.isAddFriend;
    }

    public int getIsTeam() {
        return this.isTeam;
    }

    public String getNickName() {
        return this.nickName;
    }

    public long getTeamId() {
        return this.teamId;
    }

    public long getUserId() {
        return this.userId;
    }

    public boolean isLast() {
        return this.isLast;
    }

    public void setHeadPic(String str) {
        this.headPic = str;
    }

    public void setIsAddFriend(int i) {
        this.isAddFriend = i;
    }

    public void setIsTeam(int i) {
        this.isTeam = i;
    }

    public void setLast(boolean z) {
        this.isLast = z;
    }

    public void setNickName(String str) {
        this.nickName = str;
    }

    public void setTeamId(long j) {
        this.teamId = j;
    }

    public void setUserId(long j) {
        this.userId = j;
    }
}
