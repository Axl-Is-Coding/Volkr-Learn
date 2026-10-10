package com.sandboxol.center.entity;

import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class AppEngineResourceUpdateResult {
    private boolean needUpdate;
    private long resVersion;
    private String resourceType;
    private List<AppEngineResourceUpdateItem> updates;

    public long getResVersion() {
        return this.resVersion;
    }

    public String getResourceType() {
        return this.resourceType;
    }

    public List<AppEngineResourceUpdateItem> getUpdates() {
        return this.updates;
    }

    public boolean isNeedUpdate() {
        return this.needUpdate;
    }

    public void setNeedUpdate(boolean z) {
        this.needUpdate = z;
    }

    public void setResVersion(long j) {
        this.resVersion = j;
    }

    public void setResourceType(String str) {
        this.resourceType = str;
    }

    public void setUpdates(List<AppEngineResourceUpdateItem> list) {
        this.updates = list;
    }
}
