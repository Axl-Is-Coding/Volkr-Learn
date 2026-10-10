package com.sandboxol.greendao.entity;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes3.dex */
public class FriendFollowResponse {
    private String alias;
    private long friendId;
    private String gameId;
    private String gameName;
    private String gamePic;
    private String nickName;
    private String picUrl;
    private int status;

    public String getAlias() {
        return this.alias;
    }

    public long getFriendId() {
        return this.friendId;
    }

    public String getGameId() {
        return this.gameId;
    }

    public String getGameName() {
        return this.gameName;
    }

    public String getGamePic() {
        return this.gamePic;
    }

    public String getNickName() {
        return this.nickName;
    }

    public String getPicUrl() {
        return this.picUrl;
    }

    public int getStatus() {
        return this.status;
    }

    public boolean isShowGame() {
        return !TextUtils.isEmpty(this.gameName);
    }

    public void setAlias(String str) {
        this.alias = str;
    }

    public void setFriendId(long j) {
        this.friendId = j;
    }

    public void setGameId(String str) {
        this.gameId = str;
    }

    public void setGameName(String str) {
        this.gameName = str;
    }

    public void setGamePic(String str) {
        this.gamePic = str;
    }

    public void setNickName(String str) {
        this.nickName = str;
    }

    public void setPicUrl(String str) {
        this.picUrl = str;
    }

    public void setStatus(int i) {
        this.status = i;
    }
}
