package com.sandboxol.report.entity;

import java.io.Serializable;

/* JADX INFO: loaded from: classes4.dex */
public class NewEvent implements Serializable {
    private static final long serialVersionUID = 1010634120321127673L;
    private String event;
    private int weight;

    public NewEvent(String str) {
        this.event = str;
    }

    public String getEvent() {
        return this.event;
    }

    public int getWeight() {
        return this.weight;
    }

    public void setEvent(String str) {
        this.event = str;
    }

    public void setWeight(int i) {
        this.weight = i;
    }
}
