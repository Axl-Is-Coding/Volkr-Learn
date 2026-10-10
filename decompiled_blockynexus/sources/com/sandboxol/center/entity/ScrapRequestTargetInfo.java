package com.sandboxol.center.entity;

/* JADX INFO: loaded from: classes3.dex */
public class ScrapRequestTargetInfo {
    private long friendId;
    private String friendName;
    private String friendPic;
    private int helpStatus;
    private int scrapNum;

    public long getFriendId() {
        return this.friendId;
    }

    public String getFriendName() {
        return this.friendName;
    }

    public String getFriendPic() {
        return this.friendPic;
    }

    public int getHelpStatus() {
        return this.helpStatus;
    }

    public int getScrapNum() {
        return this.scrapNum;
    }

    public void setFriendId(long j) {
        this.friendId = j;
    }

    public void setFriendName(String str) {
        this.friendName = str;
    }

    public void setFriendPic(String str) {
        this.friendPic = str;
    }

    public void setHelpStatus(int i) {
        this.helpStatus = i;
    }

    public void setScrapNum(int i) {
        this.scrapNum = i;
    }
}
