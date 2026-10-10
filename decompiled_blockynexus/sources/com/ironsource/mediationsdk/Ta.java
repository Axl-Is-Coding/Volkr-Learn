package com.ironsource.mediationsdk;

import java.util.Timer;

/* JADX INFO: compiled from: RvLoadTrigger.java */
/* JADX INFO: loaded from: classes2.dex */
public class Ta {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.ironsource.mediationsdk.utils.a f14730a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Ua f14731b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Timer f14732c = null;

    public Ta(com.ironsource.mediationsdk.utils.a aVar, Ua ua) {
        this.f14730a = aVar;
        this.f14731b = ua;
    }

    private void e() {
        Timer timer = this.f14732c;
        if (timer != null) {
            timer.cancel();
            this.f14732c = null;
        }
    }

    public synchronized void b() {
        if (!this.f14730a.d()) {
            e();
            this.f14732c = new Timer();
            this.f14732c.schedule(new Ra(this), this.f14730a.j());
        }
    }

    public void c() {
        synchronized (this) {
            e();
        }
        this.f14731b.c();
    }

    public synchronized void d() {
        if (this.f14730a.d()) {
            e();
            this.f14732c = new Timer();
            this.f14732c.schedule(new Qa(this), this.f14730a.j());
        }
    }

    public synchronized void a() {
        e();
        this.f14732c = new Timer();
        this.f14732c.schedule(new Sa(this), this.f14730a.b());
    }
}
