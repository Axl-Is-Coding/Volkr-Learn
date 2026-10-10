package com.sandboxol.center.entity;

import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class ScrapTreasureBoxConfig {
    private List<ScrapTreasureBoxInfo> boxList;
    private String date;
    private int probsNum;
    private int rewardValue;
    private long secondsLeft;

    public List<ScrapTreasureBoxInfo> getBoxList() {
        return this.boxList;
    }

    public String getDate() {
        return this.date;
    }

    public int getProbsNum() {
        return this.probsNum;
    }

    public int getRewardValue() {
        return this.rewardValue;
    }

    public long getSecondsLeft() {
        return this.secondsLeft;
    }

    public void setBoxList(List<ScrapTreasureBoxInfo> list) {
        this.boxList = list;
    }

    public void setDate(String str) {
        this.date = str;
    }

    public void setProbsNum(int i) {
        this.probsNum = i;
    }

    public void setRewardValue(int i) {
        this.rewardValue = i;
    }

    public void setSecondsLeft(long j) {
        this.secondsLeft = j;
    }
}
