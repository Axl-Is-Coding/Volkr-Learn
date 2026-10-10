package com.sandboxol.center.entity;

import com.sandboxol.file.entity.CdnConfigDetail;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class DecorationResourcesResponse {
    private List<CdnConfigDetail> cdns;
    private long fileCount;
    private long fileSize;
    private String hash;
    private boolean needUpdate;
    private String url;
    private int version;

    public List<CdnConfigDetail> getCdns() {
        return this.cdns;
    }

    public long getFileCount() {
        return this.fileCount;
    }

    public long getFileSize() {
        return this.fileSize;
    }

    public String getHash() {
        return this.hash;
    }

    public String getUrl() {
        return this.url;
    }

    public int getVersion() {
        return this.version;
    }

    public boolean isNeedUpdate() {
        return this.needUpdate;
    }

    public void setCdns(List<CdnConfigDetail> list) {
        this.cdns = list;
    }

    public void setFileCount(long j) {
        this.fileCount = j;
    }

    public void setFileSize(long j) {
        this.fileSize = j;
    }

    public void setHash(String str) {
        this.hash = str;
    }

    public void setNeedUpdate(boolean z) {
        this.needUpdate = z;
    }

    public void setUrl(String str) {
        this.url = str;
    }

    public void setVersion(int i) {
        this.version = i;
    }
}
