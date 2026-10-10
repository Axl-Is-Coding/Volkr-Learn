package com.sandboxol.greendao.entity;

/* JADX INFO: loaded from: classes3.dex */
public class TeamMember {
    private long captainId;
    private int clazz;
    private int cur;
    private boolean isEmpty;
    private boolean isLast;
    private boolean isPlaceholder;
    private int lv;
    private int max;
    private String nickName;
    private String picUrl;
    private int position;
    private int sex;
    private int status;
    private String teamId;
    private long userId;
    private int vip;

    public TeamMember() {
    }

    public long getCaptainId() {
        return this.captainId;
    }

    public int getClazz() {
        return this.clazz;
    }

    public int getCur() {
        return this.cur;
    }

    public int getLv() {
        return this.lv;
    }

    public int getMax() {
        return this.max;
    }

    public String getNickName() {
        return this.nickName;
    }

    public String getPicUrl() {
        return this.picUrl;
    }

    public int getPosition() {
        return this.position;
    }

    public int getSex() {
        return this.sex;
    }

    public int getStatus() {
        return this.status;
    }

    public String getTeamId() {
        return this.teamId;
    }

    public long getUserId() {
        return this.userId;
    }

    public int getVip() {
        return this.vip;
    }

    public boolean isCaptain() {
        long j = this.captainId;
        return j != 0 && j == this.userId;
    }

    public boolean isEmpty() {
        return this.isEmpty;
    }

    public boolean isLast() {
        return this.isLast;
    }

    public boolean isPlaceholder() {
        return this.isPlaceholder;
    }

    public void setCaptainId(long j) {
        this.captainId = j;
    }

    public void setClazz(int i) {
        this.clazz = i;
    }

    public void setCur(int i) {
        this.cur = i;
    }

    public void setEmpty(boolean z) {
        this.isEmpty = z;
    }

    public void setLast(boolean z) {
        this.isLast = z;
    }

    public void setLv(int i) {
        this.lv = i;
    }

    public void setMax(int i) {
        this.max = i;
    }

    public void setNickName(String str) {
        this.nickName = str;
    }

    public void setPicUrl(String str) {
        this.picUrl = str;
    }

    public void setPlaceholder(boolean z) {
        this.isPlaceholder = z;
    }

    public void setPosition(int i) {
        this.position = i;
    }

    public void setSex(int i) {
        this.sex = i;
    }

    public void setStatus(int i) {
        this.status = i;
    }

    public void setTeamId(String str) {
        this.teamId = str;
    }

    public void setUserId(long j) {
        this.userId = j;
    }

    public void setVip(int i) {
        this.vip = i;
    }

    public TeamMember(boolean z, boolean z2, String str, int i) {
        this.nickName = str;
        this.isLast = z;
        this.isEmpty = z2;
        this.position = i;
    }

    public TeamMember(boolean z, boolean z2) {
        this.isPlaceholder = z;
        this.isEmpty = z2;
    }
}
