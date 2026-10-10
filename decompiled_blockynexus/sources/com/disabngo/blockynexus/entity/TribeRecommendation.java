package com.disabngo.blockynexus.entity;

import com.umeng.umcrash.UMCustomLogInfoBuilder;

/* JADX INFO: loaded from: classes2.dex */
public class TribeRecommendation {
    private long chiefId;
    private String chiefNickName;
    private int clanId;
    private int currentCount;
    private String detail;
    private int freeVerify;
    private String headPic;
    private boolean isFirst = false;
    private int level;
    private int maxCount;
    private String name;

    public long getChiefId() {
        return this.chiefId;
    }

    public String getChiefNickName() {
        return this.chiefNickName;
    }

    public int getClanId() {
        return this.clanId;
    }

    public int getCurrentCount() {
        return this.currentCount;
    }

    public String getDetail() {
        return this.detail;
    }

    public int getFreeVerify() {
        return this.freeVerify;
    }

    public String getHeadPic() {
        return this.headPic;
    }

    public int getLevel() {
        return this.level;
    }

    public int getMaxCount() {
        return this.maxCount;
    }

    public String getName() {
        if (this.name.contains(UMCustomLogInfoBuilder.LINE_SEP)) {
            this.name = this.name.replaceAll(UMCustomLogInfoBuilder.LINE_SEP, " ");
        }
        return this.name;
    }

    public boolean isFirst() {
        return this.isFirst;
    }

    public void setChiefId(int i) {
        this.chiefId = i;
    }

    public void setChiefNickName(String str) {
        this.chiefNickName = str;
    }

    public void setClanId(int i) {
        this.clanId = i;
    }

    public void setCurrentCount(int i) {
        this.currentCount = i;
    }

    public void setDetail(String str) {
        this.detail = str;
    }

    public void setFirst(boolean z) {
        this.isFirst = z;
    }

    public void setFreeVerify(int i) {
        this.freeVerify = i;
    }

    public void setHeadPic(String str) {
        this.headPic = str;
    }

    public void setLevel(int i) {
        this.level = i;
    }

    public void setMaxCount(int i) {
        this.maxCount = i;
    }

    public void setName(String str) {
        this.name = str;
    }
}
