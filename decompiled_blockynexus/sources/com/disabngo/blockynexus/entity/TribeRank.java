package com.disabngo.blockynexus.entity;

import com.umeng.umcrash.UMCustomLogInfoBuilder;

/* JADX INFO: loaded from: classes2.dex */
public class TribeRank {
    private int clanId;
    private int experience;
    private String headPic;
    private String name;
    private int rank;

    public int getClanId() {
        return this.clanId;
    }

    public String getExperience() {
        return String.valueOf(this.experience);
    }

    public String getHeadPic() {
        return this.headPic;
    }

    public String getName() {
        if (this.name.contains(UMCustomLogInfoBuilder.LINE_SEP)) {
            this.name = this.name.replaceAll(UMCustomLogInfoBuilder.LINE_SEP, " ");
        }
        return this.name;
    }

    public String getRank() {
        return String.valueOf(this.rank);
    }

    public void setClanId(int i) {
        this.clanId = i;
    }

    public void setExperience(int i) {
        this.experience = i;
    }

    public void setHeadPic(String str) {
        this.headPic = str;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setRank(int i) {
        this.rank = i;
    }
}
