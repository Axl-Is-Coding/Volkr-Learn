package com.sandboxol.center.entity;

/* JADX INFO: loaded from: classes3.dex */
public class GameRankingInfo {
    private int iconResId;
    private String iconUrl;
    private String sortType;
    private long typeId;
    private String typeName;

    public GameRankingInfo(long j, String str, String str2, int i, String str3) {
        this.typeId = j;
        this.typeName = str;
        this.iconUrl = str2;
        this.iconResId = i;
        this.sortType = str3;
    }

    public int getIconResId() {
        return this.iconResId;
    }

    public String getIconUrl() {
        return this.iconUrl;
    }

    public String getSortType() {
        return this.sortType;
    }

    public long getTypeId() {
        return this.typeId;
    }

    public String getTypeName() {
        return this.typeName;
    }

    public void setIconResId(int i) {
        this.iconResId = i;
    }

    public void setIconUrl(String str) {
        this.iconUrl = str;
    }

    public void setSortType(String str) {
        this.sortType = str;
    }

    public void setTypeId(long j) {
        this.typeId = j;
    }

    public void setTypeName(String str) {
        this.typeName = str;
    }
}
