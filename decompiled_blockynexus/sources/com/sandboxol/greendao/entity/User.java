package com.sandboxol.greendao.entity;

/* JADX INFO: loaded from: classes3.dex */
public class User {
    private String accessToken;
    private String account;
    private String birthday;
    private String details;
    private long diamonds;
    private String email;
    private String expireDate;
    private long gDiamonds;
    private long golds;
    private boolean hasPassword;
    private boolean isFirstLogin;
    private String nickName;
    private String password;
    private String picUrl;
    private String platform;
    private int sex;
    private String starCode;
    private String telephone;
    private long userId;
    private int vip;

    public User(long j, String str, String str2, int i, String str3, String str4, String str5, String str6, String str7, String str8, long j2, long j3, long j4, String str9, boolean z, String str10, int i2, boolean z2, String str11, String str12) {
        this.userId = j;
        this.account = str;
        this.nickName = str2;
        this.sex = i;
        this.picUrl = str3;
        this.accessToken = str4;
        this.details = str5;
        this.telephone = str6;
        this.email = str7;
        this.birthday = str8;
        this.golds = j2;
        this.diamonds = j3;
        this.gDiamonds = j4;
        this.password = str9;
        this.isFirstLogin = z;
        this.expireDate = str10;
        this.vip = i2;
        this.hasPassword = z2;
        this.platform = str11;
        this.starCode = str12;
    }

    public String getAccessToken() {
        return this.accessToken;
    }

    public String getAccount() {
        return this.account;
    }

    public String getBirthday() {
        return this.birthday;
    }

    public String getDetails() {
        return this.details;
    }

    public long getDiamonds() {
        return this.diamonds;
    }

    public String getEmail() {
        return this.email;
    }

    public String getExpireDate() {
        return this.expireDate;
    }

    public long getGDiamonds() {
        return this.gDiamonds;
    }

    public long getGolds() {
        return this.golds;
    }

    public boolean getHasPassword() {
        return this.hasPassword;
    }

    public boolean getIsFirstLogin() {
        return this.isFirstLogin;
    }

    public String getNickName() {
        return this.nickName;
    }

    public String getPassword() {
        return this.password;
    }

    public String getPicUrl() {
        return this.picUrl;
    }

    public String getPlatform() {
        return this.platform;
    }

    public int getSex() {
        return this.sex;
    }

    public String getStarCode() {
        return this.starCode;
    }

    public String getTelephone() {
        return this.telephone;
    }

    public long getUserId() {
        return this.userId;
    }

    public int getVip() {
        return this.vip;
    }

    public boolean isFirstLogin() {
        return this.isFirstLogin;
    }

    public void setAccessToken(String str) {
        this.accessToken = str;
    }

    public void setAccount(String str) {
        this.account = str;
    }

    public void setBirthday(String str) {
        this.birthday = str;
    }

    public void setDetails(String str) {
        this.details = str;
    }

    public void setDiamonds(long j) {
        this.diamonds = j;
    }

    public void setEmail(String str) {
        this.email = str;
    }

    public void setExpireDate(String str) {
        this.expireDate = str;
    }

    public void setFirstLogin(boolean z) {
        this.isFirstLogin = z;
    }

    public void setGDiamonds(long j) {
        this.gDiamonds = j;
    }

    public void setGolds(long j) {
        this.golds = j;
    }

    public void setHasPassword(boolean z) {
        this.hasPassword = z;
    }

    public void setIsFirstLogin(boolean z) {
        this.isFirstLogin = z;
    }

    public void setNickName(String str) {
        this.nickName = str;
    }

    public void setPassword(String str) {
        this.password = str;
    }

    public void setPicUrl(String str) {
        this.picUrl = str;
    }

    public void setPlatform(String str) {
        this.platform = str;
    }

    public void setSex(int i) {
        this.sex = i;
    }

    public void setStarCode(String str) {
        this.starCode = str;
    }

    public void setTelephone(String str) {
        this.telephone = str;
    }

    public void setUserId(long j) {
        this.userId = j;
    }

    public void setVip(int i) {
        this.vip = i;
    }

    public User() {
    }
}
