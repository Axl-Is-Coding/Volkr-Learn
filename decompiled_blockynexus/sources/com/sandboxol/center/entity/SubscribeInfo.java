package com.sandboxol.center.entity;

import android.text.TextUtils;
import com.sandboxol.center.config.VipSubscribeStatus;

/* JADX INFO: loaded from: classes3.dex */
public class SubscribeInfo {
    private String appType;
    private String subBeginDate;
    private String subBeginDateStr;
    private String subOverDate;
    private String subOverDateStr;
    private String subStatus;
    private Long userId;
    private int vipType;

    public String getAppType() {
        return this.appType;
    }

    public String getSubBeginDate() {
        return this.subBeginDate;
    }

    public String getSubBeginDateStr() {
        return this.subBeginDateStr;
    }

    public String getSubOverDate() {
        return this.subOverDate;
    }

    public String getSubOverDateStr() {
        return this.subOverDateStr;
    }

    public String getSubStatus() {
        return this.subStatus;
    }

    public Long getUserId() {
        return this.userId;
    }

    public int getVipType() {
        return this.vipType;
    }

    public boolean isSubscribe() {
        return !TextUtils.isEmpty(this.subStatus) && (this.subStatus.equals("1") || this.subStatus.equals("2") || this.subStatus.equals(VipSubscribeStatus.SUBSCRIPTION_PURCHASED) || this.subStatus.equals(VipSubscribeStatus.SUBSCRIPTION_RESTARTED) || this.subStatus.equals(VipSubscribeStatus.SUBSCRIPTION_PRICE_CHANGE_CONFIRMED));
    }

    public void setAppType(String str) {
        this.appType = str;
    }

    public void setSubBeginDate(String str) {
        this.subBeginDate = str;
    }

    public void setSubBeginDateStr(String str) {
        this.subBeginDateStr = str;
    }

    public void setSubOverDate(String str) {
        this.subOverDate = str;
    }

    public void setSubOverDateStr(String str) {
        this.subOverDateStr = str;
    }

    public void setSubStatus(String str) {
        this.subStatus = str;
    }

    public void setUserId(Long l) {
        this.userId = l;
    }

    public void setVipType(int i) {
        this.vipType = i;
    }
}
