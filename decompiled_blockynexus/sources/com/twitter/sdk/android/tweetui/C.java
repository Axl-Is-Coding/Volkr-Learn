package com.twitter.sdk.android.tweetui;

import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: TimelineStateHolder.java */
/* JADX INFO: loaded from: classes5.dex */
class C {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    y f20321a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    y f20322b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AtomicBoolean f20323c = new AtomicBoolean(false);

    C() {
    }

    public void a(y yVar) {
        if (this.f20321a == null) {
            this.f20321a = yVar;
        }
        if (this.f20322b == null) {
            this.f20322b = yVar;
        }
    }

    public Long b() {
        y yVar = this.f20321a;
        if (yVar == null) {
            return null;
        }
        return yVar.f20467b;
    }

    public Long c() {
        y yVar = this.f20322b;
        if (yVar == null) {
            return null;
        }
        return yVar.f20466a;
    }

    public void d() {
        this.f20321a = null;
        this.f20322b = null;
    }

    public boolean e() {
        return this.f20323c.compareAndSet(false, true);
    }

    public void b(y yVar) {
        this.f20321a = yVar;
        a(yVar);
    }

    public void c(y yVar) {
        this.f20322b = yVar;
        a(yVar);
    }

    public void a() {
        this.f20323c.set(false);
    }
}
