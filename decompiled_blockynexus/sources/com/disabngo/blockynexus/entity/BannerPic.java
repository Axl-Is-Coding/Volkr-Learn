package com.disabngo.blockynexus.entity;

import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public class BannerPic implements Serializable {
    private String describe;
    private String picUrl;

    public String getDescribe() {
        return this.describe;
    }

    public String getPicUrl() {
        return this.picUrl;
    }

    public void setDescribe(String str) {
        this.describe = str;
    }

    public void setPicUrl(String str) {
        this.picUrl = str;
    }
}
