package com.sandboxol.center.entity;

import com.sandboxol.file.entity.CdnConfigDetail;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class GameResInfo {
    private List<CdnConfigDetail> cdns;
    private String durl;
    private int resVersion;

    public List<CdnConfigDetail> getCdns() {
        return this.cdns;
    }

    public String getDurl() {
        return this.durl;
    }

    public int getResVersion() {
        return this.resVersion;
    }

    public void setCdns(List<CdnConfigDetail> list) {
        this.cdns = list;
    }

    public void setDurl(String str) {
        this.durl = str;
    }

    public void setResVersion(int i) {
        this.resVersion = i;
    }
}
