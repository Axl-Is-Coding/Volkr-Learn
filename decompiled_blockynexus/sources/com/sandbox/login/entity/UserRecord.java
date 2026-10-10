package com.sandbox.login.entity;

import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public class UserRecord implements Serializable, Cloneable {
    public static final String LOGIN_TYPE_ACCOUNT = "acccout";
    public static final String LOGIN_TYPE_ID = "userId";
    private static final long serialVersionUID = 1010634120321127685L;
    public Long ID;
    private String account;
    private boolean hasPassword;
    private long loginTime;
    private String loginType;
    private String nickName;
    private String password;
    private String userIcon;
    private String userId;

    public UserRecord(String str, String str2, String str3, String str4, String str5, String str6, boolean z, long j) {
        this.userId = str;
        this.account = str2;
        this.password = str3;
        this.userIcon = str4;
        this.loginType = str5;
        this.nickName = str6;
        this.loginTime = j;
        this.hasPassword = z;
    }

    public String getAccount() {
        return this.account;
    }

    public boolean getHasPassword() {
        return this.hasPassword;
    }

    public Long getID() {
        return this.ID;
    }

    public long getLoginTime() {
        return this.loginTime;
    }

    public String getLoginType() {
        return this.loginType;
    }

    public String getNickName() {
        return this.nickName;
    }

    public String getPassword() {
        return this.password;
    }

    public String getUid() {
        return "userId".equals(this.loginType) ? this.userId : LOGIN_TYPE_ACCOUNT.equals(this.loginType) ? this.account : this.userId;
    }

    public String getUserIcon() {
        return this.userIcon;
    }

    public String getUserId() {
        return this.userId;
    }

    public boolean isHasPassword() {
        return this.hasPassword;
    }

    public void setAccount(String str) {
        this.account = str;
    }

    public void setHasPassword(boolean z) {
        this.hasPassword = z;
    }

    public void setID(Long l) {
        this.ID = l;
    }

    public void setLoginTime(long j) {
        this.loginTime = j;
    }

    public void setLoginType(String str) {
        this.loginType = str;
    }

    public void setNickName(String str) {
        this.nickName = str;
    }

    public void setPassword(String str) {
        this.password = str;
    }

    public void setUserIcon(String str) {
        this.userIcon = str;
    }

    public void setUserId(String str) {
        this.userId = str;
    }

    /* JADX INFO: renamed from: clone, reason: merged with bridge method [inline-methods] */
    public UserRecord m81clone() {
        try {
            return (UserRecord) super.clone();
        } catch (CloneNotSupportedException e2) {
            e2.printStackTrace();
            return this;
        }
    }

    public UserRecord(Long l, String str, String str2, String str3, String str4, String str5, String str6, long j, boolean z) {
        this.ID = l;
        this.userId = str;
        this.nickName = str2;
        this.account = str3;
        this.password = str4;
        this.userIcon = str5;
        this.loginType = str6;
        this.loginTime = j;
        this.hasPassword = z;
    }

    public UserRecord() {
    }
}
