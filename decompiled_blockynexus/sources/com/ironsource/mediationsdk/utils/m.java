package com.ironsource.mediationsdk.utils;

/* JADX INFO: compiled from: SessionDepthManager.java */
/* JADX INFO: loaded from: classes2.dex */
public class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static m f15049a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f15050b = 1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f15051c = 1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f15052d = 1;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f15053e = 1;

    public static synchronized m a() {
        if (f15049a == null) {
            f15049a = new m();
        }
        return f15049a;
    }

    public synchronized void b(int i) {
        if (i == 0) {
            this.f15052d++;
        } else if (i == 1) {
            this.f15050b++;
        } else if (i == 2) {
            this.f15051c++;
        } else if (i == 3) {
            this.f15053e++;
        }
    }

    public synchronized int a(int i) {
        if (i == 0) {
            return this.f15052d;
        }
        if (i == 1) {
            return this.f15050b;
        }
        if (i == 2) {
            return this.f15051c;
        }
        if (i != 3) {
            return -1;
        }
        return this.f15053e;
    }
}
