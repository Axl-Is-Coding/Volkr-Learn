package com.sandboxol.greendao.entity;

import androidx.databinding.BaseObservable;

/* JADX INFO: loaded from: classes3.dex */
public class ChristmasRewardInfo extends BaseObservable {
    private String desc;
    private int level;
    private int needShow;
    private String picUrl;
    private int status;
    private String type;

    public ChristmasRewardInfo(String str, int i, String str2, int i2, String str3) {
        this.desc = str;
        this.level = i;
        this.picUrl = str2;
        this.status = i2;
        this.type = str3;
    }

    public String getDesc() {
        return this.desc;
    }

    public int getLevel() {
        return this.level;
    }

    public int getNeedShow() {
        return this.needShow;
    }

    public String getPicUrl() {
        String str = this.picUrl;
        return str == null ? "1" : str;
    }

    public int getStatus() {
        return this.status;
    }

    public String getText() {
        return "x" + this.desc;
    }

    public String getType() {
        return this.type;
    }

    public void setDesc(String str) {
        this.desc = str;
    }

    public void setLevel(int i) {
        this.level = i;
    }

    public void setNeedShow(int i) {
        this.needShow = i;
    }

    public void setPicUrl(String str) {
        this.picUrl = str;
    }

    public void setStatus(int i) {
        this.status = i;
        notifyChange();
    }

    public void setType(String str) {
        this.type = str;
    }
}
