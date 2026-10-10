package com.disabngo.blockynexus.entity;

/* JADX INFO: loaded from: classes2.dex */
public class CampaignTask {
    private int finished;
    private long id;
    private int integralReward;
    private String name;
    private int need;
    private int status;
    private long taskId;
    private int type;

    public int getFinished() {
        return this.finished;
    }

    public long getId() {
        return this.id;
    }

    public int getIntegralReward() {
        return this.integralReward;
    }

    public String getName() {
        return this.name;
    }

    public int getNeed() {
        return this.need;
    }

    public int getStatus() {
        return this.status;
    }

    public long getTaskId() {
        return this.taskId;
    }

    public String getTaskName() {
        return this.name;
    }

    public int getType() {
        return this.type;
    }

    public void setFinished(int i) {
        this.finished = i;
    }

    public void setId(long j) {
        this.id = j;
    }

    public void setIntegralReward(int i) {
        this.integralReward = i;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setNeed(int i) {
        this.need = i;
    }

    public void setStatus(int i) {
        this.status = i;
    }

    public void setTaskId(long j) {
        this.taskId = j;
    }

    public void setType(int i) {
        this.type = i;
    }
}
