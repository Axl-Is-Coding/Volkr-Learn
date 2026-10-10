package com.sandboxol.greendao.entity;

import java.io.Serializable;

/* JADX INFO: loaded from: classes3.dex */
public class BannerPic implements Serializable {
    private String describe;
    private String gameDetail;
    private boolean isFirst;
    private String picUrl;

    public BannerPic() {
        this.isFirst = false;
    }

    public String getDescribe() {
        return this.describe;
    }

    public String getGameDetail() {
        return this.gameDetail;
    }

    public String getPicUrl() {
        return this.picUrl;
    }

    public boolean isFirst() {
        return this.isFirst;
    }

    public void setDescribe(String str) {
        this.describe = str;
    }

    public void setFirst(boolean z) {
        this.isFirst = z;
    }

    public void setGameDetail(String str) {
        this.gameDetail = str;
    }

    public void setPicUrl(String str) {
        this.picUrl = str;
    }

    public BannerPic(String str, boolean z) {
        this.isFirst = false;
        this.gameDetail = str;
        this.isFirst = z;
    }
}
