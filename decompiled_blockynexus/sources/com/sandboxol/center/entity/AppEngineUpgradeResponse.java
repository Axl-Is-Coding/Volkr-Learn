package com.sandboxol.center.entity;

/* JADX INFO: loaded from: classes3.dex */
public class AppEngineUpgradeResponse {
    private String downloadUrl;
    private String hash;
    private boolean needUpgrade;
    private int resVersion;

    public String getDownloadUrl() {
        return this.downloadUrl;
    }

    public String getHash() {
        return this.hash;
    }

    public int getResVersion() {
        return this.resVersion;
    }

    public boolean isNeedUpgrade() {
        return this.needUpgrade;
    }

    public void setDownloadUrl(String str) {
        this.downloadUrl = str;
    }

    public void setHash(String str) {
        this.hash = str;
    }

    public void setNeedUpgrade(boolean z) {
        this.needUpgrade = z;
    }

    public void setResVersion(int i) {
        this.resVersion = i;
    }
}
