package com.disabngo.blockynexus.entity;

import android.text.TextUtils;
import com.disabngo.blockynexus.R;
import com.sandboxol.common.base.app.BaseApplication;
import com.sandboxol.common.utils.CommonHelper;

/* JADX INFO: loaded from: classes2.dex */
public class FriendRequests {
    private int age;
    private String country;
    private String language;
    private String msg;
    private String nickName;
    private String picUrl;
    private long requestId;
    private int sex;
    private int status;
    private long userId;
    private int vip;

    public int getAge() {
        return this.age;
    }

    public String getAgeText() {
        return this.age == 0 ? BaseApplication.getContext().getString(R.string.friend_new_age, "—") : BaseApplication.getContext().getString(R.string.friend_new_age, String.valueOf(this.age));
    }

    public String getCountry() {
        return this.country;
    }

    public String getCountryAndLanguage() {
        if (TextUtils.isEmpty(this.country)) {
            this.country = "—";
        }
        if (TextUtils.isEmpty(this.language)) {
            this.language = "—";
        }
        return BaseApplication.getContext().getString(R.string.friend_new_come_from, CommonHelper.getCountryDetail(this.country), CommonHelper.getLanguageDetail(this.language));
    }

    public String getLanguage() {
        return this.language;
    }

    public String getMsg() {
        return TextUtils.isEmpty(this.msg) ? BaseApplication.getContext().getString(R.string.friend_apply_default_tip) : this.msg;
    }

    public String getNickName() {
        return this.nickName;
    }

    public String getPicUrl() {
        return this.picUrl;
    }

    public long getRequestId() {
        return this.requestId;
    }

    public int getSex() {
        return this.sex;
    }

    public int getStatus() {
        return this.status;
    }

    public long getUserId() {
        return this.userId;
    }

    public int getVip() {
        return this.vip;
    }

    public void setAge(int i) {
        this.age = i;
    }

    public void setCountry(String str) {
        this.country = str;
    }

    public void setLanguage(String str) {
        this.language = str;
    }

    public void setMsg(String str) {
        this.msg = str;
    }

    public void setNickName(String str) {
        this.nickName = str;
    }

    public void setPicUrl(String str) {
        this.picUrl = str;
    }

    public void setRequestId(long j) {
        this.requestId = j;
    }

    public void setSex(int i) {
        this.sex = i;
    }

    public void setStatus(int i) {
        this.status = i;
    }

    public void setUserId(long j) {
        this.userId = j;
    }

    public void setVip(int i) {
        this.vip = i;
    }
}
