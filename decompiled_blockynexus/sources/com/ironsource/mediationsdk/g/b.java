package com.ironsource.mediationsdk.g;

import java.util.Timer;

/* JADX INFO: compiled from: AbstractTimer.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class b<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Timer f14826a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f14827b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected T f14828c;

    public b(long j) {
        this.f14827b = j;
    }

    protected boolean a() {
        return this.f14827b <= 0;
    }

    abstract void b();

    protected void c() {
        Timer timer = this.f14826a;
        if (timer != null) {
            timer.cancel();
            this.f14826a = null;
        }
    }

    protected void a(T t) {
        if (a() || t == null) {
            return;
        }
        this.f14828c = t;
        c();
        this.f14826a = new Timer();
        this.f14826a.schedule(new a(this), this.f14827b);
    }
}
