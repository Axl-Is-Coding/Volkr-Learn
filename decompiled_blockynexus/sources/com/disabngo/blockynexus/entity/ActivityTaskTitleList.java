package com.disabngo.blockynexus.entity;

import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class ActivityTaskTitleList {
    private List<ActivityTaskTitle> activityTitleList;
    private long cumulativeTime;
    private long serverTime;

    public List<ActivityTaskTitle> getActivityTitleList() {
        return this.activityTitleList;
    }

    public long getCumulativeTime() {
        return this.cumulativeTime;
    }

    public long getServerTime() {
        return this.serverTime;
    }

    public void setActivityTitleList(List<ActivityTaskTitle> list) {
        this.activityTitleList = list;
    }

    public void setCumulativeTime(long j) {
        this.cumulativeTime = j;
    }

    public void setServerTime(long j) {
        this.serverTime = j;
    }
}
