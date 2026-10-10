package com.sandboxol.center.entity;

import androidx.databinding.BaseObservable;
import java.io.Serializable;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class WeekTaskResponse extends BaseObservable implements Serializable {
    private int count;
    private int hours;
    private int minutes;
    private int seconds;
    private Map<Integer, Integer> taskMap;

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

    public Map<Integer, Integer> getTaskMap() {
        return this.taskMap;
    }

    public void notifyData(WeekTaskResponse weekTaskResponse) {
        setCount(weekTaskResponse.getCount());
        setHours(weekTaskResponse.getHours());
        setMinutes(weekTaskResponse.getMinutes());
        setSeconds(weekTaskResponse.getSeconds());
        setTaskMap(weekTaskResponse.getTaskMap());
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

    public void setTaskMap(Map<Integer, Integer> map) {
        this.taskMap = map;
    }
}
