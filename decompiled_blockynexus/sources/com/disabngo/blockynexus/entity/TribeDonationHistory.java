package com.disabngo.blockynexus.entity;

import com.sandboxol.common.utils.DateUtils;

/* JADX INFO: loaded from: classes2.dex */
public class TribeDonationHistory {
    private long date;
    private int experienceGot;
    private String nickName;
    private int quantity;
    private int tribeCurrencyGot;
    private int type;
    private long userId;

    public String getDate() {
        return DateUtils.timeStamp2Date(this.date, null);
    }

    public String getExperienceGot() {
        return String.valueOf(this.experienceGot);
    }

    public String getNickName() {
        return this.nickName;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public String getTribeCurrencyGot() {
        return String.valueOf(this.tribeCurrencyGot);
    }

    public int getType() {
        return this.type;
    }

    public long getUserId() {
        return this.userId;
    }

    public void setDate(long j) {
        this.date = j;
    }

    public void setExperienceGot(int i) {
        this.experienceGot = i;
    }

    public void setNickName(String str) {
        this.nickName = str;
    }

    public void setQuantity(int i) {
        this.quantity = i;
    }

    public void setTribeCurrencyGot(int i) {
        this.tribeCurrencyGot = i;
    }

    public void setType(int i) {
        this.type = i;
    }

    public void setUserId(long j) {
        this.userId = j;
    }
}
