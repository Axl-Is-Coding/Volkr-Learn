package com.sandboxol.greendao.entity;

/* JADX INFO: loaded from: classes3.dex */
public class TopRankInfo {
    private long quantity;
    private String topName;
    private String topPic;
    private String type;
    private long userId;

    public long getQuantity() {
        return this.quantity;
    }

    public String getTopName() {
        return this.topName;
    }

    public String getTopPic() {
        return this.topPic;
    }

    public String getType() {
        return this.type;
    }

    public long getUserId() {
        return this.userId;
    }

    public void setQuantity(long j) {
        this.quantity = j;
    }

    public void setTopName(String str) {
        this.topName = str;
    }

    public void setTopPic(String str) {
        this.topPic = str;
    }

    public void setType(String str) {
        this.type = str;
    }

    public void setUserId(long j) {
        this.userId = j;
    }
}
