package com.disabngo.blockynexus.entity;

/* JADX INFO: loaded from: classes2.dex */
public class DownloadProgress {
    private long currentSize;
    private int progress;
    private long totalSize;

    public long getCurrentSize() {
        return this.currentSize;
    }

    public int getProgress() {
        return this.progress;
    }

    public long getTotalSize() {
        return this.totalSize;
    }

    public void setCurrentSize(long j) {
        this.currentSize = j;
    }

    public void setProgress(int i) {
        this.progress = i;
    }

    public void setTotalSize(long j) {
        this.totalSize = j;
    }
}
