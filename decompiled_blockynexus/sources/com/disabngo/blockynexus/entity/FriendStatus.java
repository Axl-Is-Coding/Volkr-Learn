package com.disabngo.blockynexus.entity;

import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class FriendStatus {
    private int curFriendCount;
    private long currentTime;
    private int maxFriendCount;
    private List<StatusBean> status;

    public FriendStatus(int i, int i2) {
        this.curFriendCount = i;
        this.maxFriendCount = i2;
    }

    public int getCurFriendCount() {
        return this.curFriendCount;
    }

    public long getCurrentTime() {
        return this.currentTime;
    }

    public int getMaxFriendCount() {
        return this.maxFriendCount;
    }

    public List<StatusBean> getStatus() {
        return this.status;
    }

    public void setCurFriendCount(int i) {
        this.curFriendCount = i;
    }

    public void setCurrentTime(long j) {
        this.currentTime = j;
    }

    public void setMaxFriendCount(int i) {
        this.maxFriendCount = i;
    }

    public void setStatus(List<StatusBean> list) {
        this.status = list;
    }
}
