package com.sandboxol.center.entity;

/* JADX INFO: loaded from: classes3.dex */
public class AdsCdConfig {
    private int adsCdTimeFirst;
    private int adsCdTimeSecond;

    public int getAdsCdTimeFirst() {
        int i = this.adsCdTimeFirst;
        if (i == 0) {
            i = 300;
        }
        return i * 1000;
    }

    public int getAdsCdTimeSecond() {
        int i = this.adsCdTimeSecond;
        if (i == 0) {
            i = 1800;
        }
        return i * 1000;
    }

    public void setAdsCdTimeFirst(int i) {
        this.adsCdTimeFirst = i;
    }

    public void setAdsCdTimeSecond(int i) {
        this.adsCdTimeSecond = i;
    }
}
