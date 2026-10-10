package com.bytedance.sdk.openadsdk.i;

import java.util.UUID;

/* JADX INFO: compiled from: TTRunnable.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class b implements Comparable<b>, Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f6992a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f6993b;

    public b(int i) {
        this.f6992a = -1;
        this.f6992a = i == -1 ? 5 : i;
        this.f6993b = UUID.randomUUID().toString() + "-" + String.valueOf(System.nanoTime());
    }

    public int a() {
        return this.f6992a;
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(b bVar) {
        if (a() < bVar.a()) {
            return 1;
        }
        return a() > bVar.a() ? -1 : 0;
    }

    public b() {
        this.f6992a = -1;
        this.f6992a = 5;
        this.f6993b = UUID.randomUUID().toString() + "-" + String.valueOf(System.nanoTime());
    }
}
