package com.sandboxol.greendao.entity;

import java.io.Serializable;

/* JADX INFO: loaded from: classes3.dex */
public class ResourceLatestVersionData implements Serializable {
    private long cresVersion;
    private long dresVersion;
    private long gresVersion;

    public ResourceLatestVersionData() {
    }

    public long getCresVersion() {
        return this.cresVersion;
    }

    public long getDresVersion() {
        return this.dresVersion;
    }

    public long getGresVersion() {
        return this.gresVersion;
    }

    public void setCresVersion(long j) {
        this.cresVersion = j;
    }

    public void setDresVersion(long j) {
        this.dresVersion = j;
    }

    public void setGresVersion(long j) {
        this.gresVersion = j;
    }

    public ResourceLatestVersionData(long j, long j2, long j3) {
        this.cresVersion = j;
        this.dresVersion = j2;
        this.gresVersion = j3;
    }
}
