package com.sandboxol.center.entity;

import androidx.databinding.BaseObservable;

/* JADX INFO: loaded from: classes3.dex */
public class ScrapInfo extends BaseObservable {
    private String scrapDesc;
    private String scrapId;
    private String scrapName;
    private int scrapNum;
    private String scrapPic;
    private int scrapValue;

    public String getNumString() {
        return "x" + this.scrapNum;
    }

    public String getScrapDesc() {
        return this.scrapDesc;
    }

    public String getScrapId() {
        return this.scrapId;
    }

    public String getScrapName() {
        return this.scrapName;
    }

    public int getScrapNum() {
        return this.scrapNum;
    }

    public String getScrapPic() {
        return this.scrapPic;
    }

    public int getScrapValue() {
        return this.scrapValue;
    }

    public void setScrapDesc(String str) {
        this.scrapDesc = str;
    }

    public void setScrapId(String str) {
        this.scrapId = str;
    }

    public void setScrapName(String str) {
        this.scrapName = str;
    }

    public void setScrapNum(int i) {
        this.scrapNum = i;
    }

    public void setScrapPic(String str) {
        this.scrapPic = str;
    }

    public void setScrapValue(int i) {
        this.scrapValue = i;
    }
}
