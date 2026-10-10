package com.disabngo.blockynexus.entity;

import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class TribeTask {
    private int currencyCost;
    private int currencyType;
    private int nextFreeFlushTime;
    private long remainTime;
    private List<TribeTaskList> tasks;

    public int getCurrencyCost() {
        return this.currencyCost;
    }

    public int getCurrencyType() {
        return this.currencyType;
    }

    public int getNextFreeFlushTime() {
        return this.nextFreeFlushTime;
    }

    public long getRemainTime() {
        return this.remainTime;
    }

    public List<TribeTaskList> getTasks() {
        return this.tasks;
    }

    public void setCurrencyCost(int i) {
        this.currencyCost = i;
    }

    public void setCurrencyType(int i) {
        this.currencyType = i;
    }

    public void setNextFreeFlushTime(int i) {
        this.nextFreeFlushTime = i;
    }

    public void setRemainTime(long j) {
        this.remainTime = j;
    }

    public void setTasks(List<TribeTaskList> list) {
        this.tasks = list;
    }
}
