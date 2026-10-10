package com.sandboxol.halloween.entity;

/* JADX INFO: loaded from: classes4.dex */
public class HalloweenTask {
    private int candy;
    private int complete;
    private int require;
    private int status;
    private String taskName;
    private String taskType;

    public int getCandy() {
        return this.candy;
    }

    public int getComplete() {
        return this.complete;
    }

    public int getRequire() {
        return this.require;
    }

    public int getStatus() {
        return this.status;
    }

    public String getTaskName() {
        return this.taskName;
    }

    public String getTaskType() {
        return this.taskType;
    }

    public void setCandy(int i) {
        this.candy = i;
    }

    public void setComplete(int i) {
        this.complete = i;
    }

    public void setRequire(int i) {
        this.require = i;
    }

    public void setStatus(int i) {
        this.status = i;
    }

    public void setTaskName(String str) {
        this.taskName = str;
    }

    public void setTaskType(String str) {
        this.taskType = str;
    }
}
