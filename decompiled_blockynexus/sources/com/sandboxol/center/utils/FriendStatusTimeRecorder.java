package com.sandboxol.center.utils;

/* JADX INFO: loaded from: classes3.dex */
public class FriendStatusTimeRecorder {
    private long systemCurrentTime;

    private static class InstanceHolder {
        private static final FriendStatusTimeRecorder instance = new FriendStatusTimeRecorder();

        private InstanceHolder() {
        }
    }

    public static FriendStatusTimeRecorder getInstance() {
        return InstanceHolder.instance;
    }

    public long getSystemCurrentTime() {
        return this.systemCurrentTime;
    }

    public void setSystemCurrentTime(long j) {
        this.systemCurrentTime = j;
    }

    private FriendStatusTimeRecorder() {
    }
}
