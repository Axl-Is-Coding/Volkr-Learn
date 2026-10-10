package com.sandboxol.halloween.entity;

import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class HalloweenInfoResponse {
    private String activityDesc;
    private String activityTitle;
    private int candy;
    private int candyRate;
    private List<HalloweenReward> rewardList;
    private int status;
    private int surplusGCube;
    private long surplusSeconds;
    private long surplusTime;
    private List<HalloweenTask> taskList;
    private String taskRewardIcon;

    public String getActivityDesc() {
        return this.activityDesc;
    }

    public String getActivityTitle() {
        return this.activityTitle;
    }

    public int getCandy() {
        return this.candy;
    }

    public int getCandyRate() {
        return this.candyRate;
    }

    public List<HalloweenReward> getRewardList() {
        return this.rewardList;
    }

    public int getStatus() {
        return this.status;
    }

    public int getSurplusGCube() {
        return this.surplusGCube;
    }

    public long getSurplusSeconds() {
        return this.surplusSeconds;
    }

    public long getSurplusTime() {
        return this.surplusTime;
    }

    public List<HalloweenTask> getTaskList() {
        return this.taskList;
    }

    public String getTaskRewardIcon() {
        return this.taskRewardIcon;
    }

    public void setActivityDesc(String str) {
        this.activityDesc = str;
    }

    public void setActivityTitle(String str) {
        this.activityTitle = str;
    }

    public void setCandy(int i) {
        this.candy = i;
    }

    public void setCandyRate(int i) {
        this.candyRate = i;
    }

    public void setRewardList(List<HalloweenReward> list) {
        this.rewardList = list;
    }

    public void setStatus(int i) {
        this.status = i;
    }

    public void setSurplusGCube(int i) {
        this.surplusGCube = i;
    }

    public void setSurplusSeconds(long j) {
        this.surplusSeconds = j;
    }

    public void setSurplusTime(long j) {
        this.surplusTime = j;
    }

    public void setTaskList(List<HalloweenTask> list) {
        this.taskList = list;
    }

    public void setTaskRewardIcon(String str) {
        this.taskRewardIcon = str;
    }
}
