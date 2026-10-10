package com.sandboxol.blocky.entity;

/* JADX INFO: loaded from: classes.dex */
public class ResVersion {
    private String commit;
    private long engineVersion;
    private int version;

    public String getCommit() {
        return this.commit;
    }

    public long getEngineVersion() {
        return this.engineVersion;
    }

    public int getVersion() {
        return this.version;
    }

    public void setCommit(String str) {
        this.commit = str;
    }

    public void setEngineVersion(long j) {
        this.engineVersion = j;
    }

    public void setVersion(int i) {
        this.version = i;
    }
}
