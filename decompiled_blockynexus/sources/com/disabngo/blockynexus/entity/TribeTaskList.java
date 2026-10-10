package com.disabngo.blockynexus.entity;

import com.umeng.umcrash.UMCustomLogInfoBuilder;

/* JADX INFO: loaded from: classes2.dex */
public class TribeTaskList {
    private int currencyReward;
    private int experienceReward;
    private int finished;
    private int id;
    private String name;
    private long need;
    private int status;
    private int taskId;
    private String type;

    public String getCurrencyReward() {
        return String.valueOf(this.currencyReward);
    }

    public String getExperienceReward() {
        return String.valueOf(this.experienceReward);
    }

    public int getFinished() {
        return this.finished;
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        if (this.name.contains(UMCustomLogInfoBuilder.LINE_SEP)) {
            this.name = this.name.replaceAll(UMCustomLogInfoBuilder.LINE_SEP, " ");
        }
        return this.name;
    }

    public long getNeed() {
        return this.need;
    }

    public int getStatus() {
        return this.status;
    }

    public int getTaskId() {
        return this.taskId;
    }

    public String getTaskName() {
        return this.name + "(" + this.finished + "/" + this.need + ")";
    }

    public String getType() {
        return this.type;
    }

    public void setCurrencyReward(int i) {
        this.currencyReward = i;
    }

    public void setExperienceReward(int i) {
        this.experienceReward = i;
    }

    public void setFinished(int i) {
        this.finished = i;
    }

    public void setId(int i) {
        this.id = i;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setNeed(long j) {
        this.need = j;
    }

    public void setStatus(int i) {
        this.status = i;
    }

    public void setTaskId(int i) {
        this.taskId = i;
    }

    public void setType(String str) {
        this.type = str;
    }
}
