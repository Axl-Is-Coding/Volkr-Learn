package com.sandboxol.vip.entity;

/* JADX INFO: loaded from: classes4.dex */
public class PrivilegeInfo {
    private String desc;
    private String detailDesc;
    private int detailRes;
    private int thumbnailRes;
    private String title;
    private int vipType;

    public String getDesc() {
        return this.desc;
    }

    public String getDetailDesc() {
        return this.detailDesc;
    }

    public int getDetailRes() {
        return this.detailRes;
    }

    public int getThumbnailRes() {
        return this.thumbnailRes;
    }

    public String getTitle() {
        return this.title;
    }

    public int getVipType() {
        return this.vipType;
    }

    public void setDesc(String str) {
        this.desc = str;
    }

    public void setDetailDesc(String str) {
        this.detailDesc = str;
    }

    public void setDetailRes(int i) {
        this.detailRes = i;
    }

    public void setThumbnailRes(int i) {
        this.thumbnailRes = i;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public void setVipType(int i) {
        this.vipType = i;
    }
}
