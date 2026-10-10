package com.sandboxol.center.entity;

import androidx.databinding.BaseObservable;
import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class DailyTaskResponse extends BaseObservable implements Serializable {
    private int count;
    private int hours;
    private int minutes;
    private int seconds;
    private List<TaskBase> tasks;

    public int getCount() {
        return this.count;
    }

    public int getHours() {
        return this.hours;
    }

    public int getMinutes() {
        return this.minutes;
    }

    public int getSeconds() {
        return this.seconds;
    }

    public List<TaskBase> getTasks() {
        return this.tasks;
    }

    public void notifyData(DailyTaskResponse dailyTaskResponse) {
        setCount(dailyTaskResponse.getCount());
        setHours(dailyTaskResponse.getHours());
        setMinutes(dailyTaskResponse.getMinutes());
        setSeconds(dailyTaskResponse.getSeconds());
        setTasks(dailyTaskResponse.getTasks());
        notifyChange();
    }

    public void setCount(int i) {
        this.count = i;
    }

    public void setHours(int i) {
        this.hours = i;
    }

    public void setMinutes(int i) {
        this.minutes = i;
    }

    public void setSeconds(int i) {
        this.seconds = i;
    }

    public void setTasks(List<TaskBase> list) {
        this.tasks = list;
    }
}
