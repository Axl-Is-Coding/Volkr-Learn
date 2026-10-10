package com.sandboxol.center.entity;

import com.sandboxol.file.entity.CdnConfigDetail;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class AppEngineResourceUpdateItem {
    private List<CdnConfigDetail> cdns;
    private long fileCount;
    private long fileSize;
    private String hash;
    private String type;
    private String url;

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

    public String getType() {
        return this.type;
    }

    public String getUrl() {
        return this.url;
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

    public void setType(String str) {
        this.type = str;
    }

    public void setUrl(String str) {
        this.url = str;
    }
}
