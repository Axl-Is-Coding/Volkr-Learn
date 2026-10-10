package com.sandboxol.blockmango.entity;

import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public class ChristmasLevel implements Serializable {
    private int addExp;
    private int curExp;
    private int curLv;
    private int status;
    private int toExp;
    private int toLv;
    private int upExp;

    public ChristmasLevel(int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        this.curLv = i;
        this.toLv = i2;
        this.addExp = i3;
        this.curExp = i4;
        this.toExp = i5;
        this.upExp = i6;
        this.status = i7;
    }

    public int getAddExp() {
        return this.addExp;
    }

    public int getCurExp() {
        return this.curExp;
    }

    public int getCurLv() {
        return this.curLv;
    }

    public int getStatus() {
        return this.status;
    }

    public String getStringAddExp() {
        return "+" + this.addExp;
    }

    public int getToExp() {
        return this.toExp;
    }

    public int getToLv() {
        return this.toLv;
    }

    public int getUpExp() {
        return this.upExp;
    }

    public void setAddExp(int i) {
        this.addExp = i;
    }

    public void setCurExp(int i) {
        this.curExp = i;
    }

    public void setCurLv(int i) {
        this.curLv = i;
    }

    public void setStatus(int i) {
        this.status = i;
    }

    public void setToExp(int i) {
        this.toExp = i;
    }

    public void setToLv(int i) {
        this.toLv = i;
    }

    public void setUpExp(int i) {
        this.upExp = i;
    }

    public String toString() {
        return "ChristmasLevel{当前等级=" + this.curLv + ", 目标等级=" + this.toLv + ", 当前经验=" + this.curExp + ", 增加的经验=" + this.addExp + ", 目标经验=" + this.toExp + ", 经验上限值=" + this.upExp + ", 状态1=" + this.status + '}';
    }
}
