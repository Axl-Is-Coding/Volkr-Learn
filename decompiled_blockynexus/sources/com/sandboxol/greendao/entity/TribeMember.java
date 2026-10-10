package com.sandboxol.greendao.entity;

/* JADX INFO: loaded from: classes3.dex */
public class TribeMember {
    public Long ID;
    private int experience;
    private String expireDate;
    private String headPic;
    private long localUserId;
    private String nickName;
    private int role;
    private int status;
    private long userId;
    private int vip;

    public TribeMember(Long l, long j, long j2, int i, String str, String str2, String str3, int i2, int i3, int i4) {
        this.ID = l;
        this.userId = j;
        this.localUserId = j2;
        this.experience = i;
        this.expireDate = str;
        this.headPic = str2;
        this.nickName = str3;
        this.role = i2;
        this.status = i3;
        this.vip = i4;
    }

    public int getExperience() {
        return this.experience;
    }

    public String getExpireDate() {
        return this.expireDate;
    }

    public String getHeadPic() {
        return this.headPic;
    }

    public Long getID() {
        return this.ID;
    }

    public long getLocalUserId() {
        return this.localUserId;
    }

    public String getNickName() {
        return this.nickName;
    }

    public int getRole() {
        return this.role;
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

    public void setExperience(int i) {
        this.experience = i;
    }

    public void setExpireDate(String str) {
        this.expireDate = str;
    }

    public void setHeadPic(String str) {
        this.headPic = str;
    }

    public void setID(Long l) {
        this.ID = l;
    }

    public void setLocalUserId(long j) {
        this.localUserId = j;
    }

    public void setNickName(String str) {
        this.nickName = str;
    }

    public void setRole(int i) {
        this.role = i;
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

    public TribeMember() {
    }
}
