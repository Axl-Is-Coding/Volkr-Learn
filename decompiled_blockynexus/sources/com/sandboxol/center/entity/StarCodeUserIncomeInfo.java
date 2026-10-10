package com.sandboxol.center.entity;

/* JADX INFO: loaded from: classes3.dex */
public class StarCodeUserIncomeInfo {
    private long createTime;
    private long gdiamonds;
    private boolean isTitle;
    private String nickName;
    private int status;

    public StarCodeUserIncomeInfo() {
    }

    public long getCreateTime() {
        return this.createTime;
    }

    public long getGdiamonds() {
        return this.gdiamonds;
    }

    public String getNickName() {
        return this.nickName;
    }

    public int getStatus() {
        return this.status;
    }

    public boolean isTitle() {
        return this.isTitle;
    }

    public void setCreateTime(long j) {
        this.createTime = j;
    }

    public void setGdiamonds(long j) {
        this.gdiamonds = j;
    }

    public void setNickName(String str) {
        this.nickName = str;
    }

    public void setStatus(int i) {
        this.status = i;
    }

    public void setTitle(boolean z) {
        this.isTitle = z;
    }

    public StarCodeUserIncomeInfo(long j, boolean z) {
        this.createTime = j;
        this.isTitle = z;
    }
}
