package com.sandboxol.center.entity;

/* JADX INFO: loaded from: classes3.dex */
public class SystemAnnouncementInfo {
    private String content;
    private int id;
    private boolean isShow;
    private boolean isShowInGame;
    private String title;
    private long updateTime;

    public String getContent() {
        return this.content;
    }

    public int getId() {
        return this.id;
    }

    public String getTitle() {
        return this.title;
    }

    public long getUpdateTime() {
        return this.updateTime;
    }

    public boolean isIsShow() {
        return this.isShow;
    }

    public boolean isIsShowInGame() {
        return this.isShowInGame;
    }

    public void setContent(String str) {
        this.content = str;
    }

    public void setId(int i) {
        this.id = i;
    }

    public void setIsShow(boolean z) {
        this.isShow = z;
    }

    public void setIsShowInGame(boolean z) {
        this.isShowInGame = z;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public void setUpdateTime(long j) {
        this.updateTime = j;
    }
}
