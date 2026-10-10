package com.sandboxol.center.entity;

/* JADX INFO: loaded from: classes3.dex */
public class ReportInfo {
    private int status;
    private String stopReason;
    private String stopToTime;
    private long userId;

    public int getStatus() {
        return this.status;
    }

    public String getStopReason() {
        return this.stopReason;
    }

    public String getStopToTime() {
        return this.stopToTime;
    }

    public long getUserId() {
        return this.userId;
    }

    public void setStatus(int i) {
        this.status = i;
    }

    public void setStopReason(String str) {
        this.stopReason = str;
    }

    public void setStopToTime(String str) {
        this.stopToTime = str;
    }

    public void setUserId(long j) {
        this.userId = j;
    }
}
