package com.sandboxol.greendao.entity;

/* JADX INFO: loaded from: classes3.dex */
public class UserCache {
    private boolean isDiamondsOver100;
    private boolean isExistGamePay;
    private boolean isShowGoldDiamondDialog;
    private boolean isShowPasswordSettingDialog;
    private long userId;

    public UserCache(long j, boolean z, boolean z2, boolean z3, boolean z4) {
        this.userId = j;
        this.isShowGoldDiamondDialog = z;
        this.isShowPasswordSettingDialog = z2;
        this.isDiamondsOver100 = z3;
        this.isExistGamePay = z4;
    }

    public boolean getIsDiamondsOver100() {
        return this.isDiamondsOver100;
    }

    public boolean getIsExistGamePay() {
        return this.isExistGamePay;
    }

    public boolean getIsShowGoldDiamondDialog() {
        return this.isShowGoldDiamondDialog;
    }

    public boolean getIsShowPasswordSettingDialog() {
        return this.isShowPasswordSettingDialog;
    }

    public long getUserId() {
        return this.userId;
    }

    public void setIsDiamondsOver100(boolean z) {
        this.isDiamondsOver100 = z;
    }

    public void setIsExistGamePay(boolean z) {
        this.isExistGamePay = z;
    }

    public void setIsShowGoldDiamondDialog(boolean z) {
        this.isShowGoldDiamondDialog = z;
    }

    public void setIsShowPasswordSettingDialog(boolean z) {
        this.isShowPasswordSettingDialog = z;
    }

    public void setUserId(long j) {
        this.userId = j;
    }

    public UserCache() {
    }
}
