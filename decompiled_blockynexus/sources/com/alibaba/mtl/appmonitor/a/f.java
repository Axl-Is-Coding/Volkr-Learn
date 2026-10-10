package com.alibaba.mtl.appmonitor.a;

import com.alibaba.mtl.log.d.i;

/* JADX INFO: compiled from: EventType.java */
/* JADX INFO: loaded from: classes.dex */
public enum f {
    ALARM(65501, 30, "alarmData", 5000),
    COUNTER(65502, 30, "counterData", 5000),
    OFFLINE_COUNTER(65133, 30, "counterData", 5000),
    STAT(65503, 30, "statData", 5000);

    static String TAG = "EventType";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f3569e;
    private int h;
    private int k;
    private String t;
    private int i = 25;
    private int j = 180;
    private boolean m = true;

    f(int i, int i2, String str, int i3) {
        this.f3569e = i;
        this.h = i2;
        this.t = str;
        this.k = i3;
    }

    public int a() {
        return this.f3569e;
    }

    public void b(boolean z) {
        this.m = z;
    }

    public int c() {
        return this.i;
    }

    public int d() {
        return this.j;
    }

    public int e() {
        return this.k;
    }

    public boolean isOpen() {
        return this.m;
    }

    public void setStatisticsInterval(int i) {
        this.i = i;
        this.j = i;
    }

    public static f a(int i) {
        for (f fVar : values()) {
            if (fVar != null && fVar.a() == i) {
                return fVar;
            }
        }
        return null;
    }

    public int b() {
        return this.h;
    }

    public void c(int i) {
        this.k = i;
    }

    public void b(int i) {
        i.a(TAG, "[setTriggerCount]", this.t, i + "");
        this.h = i;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public String m14a() {
        return this.t;
    }
}
