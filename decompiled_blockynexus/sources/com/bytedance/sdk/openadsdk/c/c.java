package com.bytedance.sdk.openadsdk.c;

import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: AdEventDispatcher4MultiProcess.java */
/* JADX INFO: loaded from: classes.dex */
public class c extends b<a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private AtomicBoolean f5748a = new AtomicBoolean(false);

    @Override // com.bytedance.sdk.openadsdk.c.b
    public void b() {
    }

    @Override // com.bytedance.sdk.openadsdk.c.b
    public void a() {
        if (this.f5748a.getAndSet(true)) {
            return;
        }
        com.bytedance.sdk.openadsdk.multipro.c.a.c();
    }

    @Override // com.bytedance.sdk.openadsdk.c.b
    public void a(a aVar) {
        if (this.f5748a.get()) {
            com.bytedance.sdk.openadsdk.multipro.c.a.a(aVar.a());
        }
    }
}
