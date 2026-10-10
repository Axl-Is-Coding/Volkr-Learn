package com.bytedance.sdk.openadsdk.c;

import com.bytedance.sdk.openadsdk.f.b.c;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: StatsDispatcher4MultiProcess.java */
/* JADX INFO: loaded from: classes.dex */
public class m extends b<c.a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private AtomicBoolean f5789a = new AtomicBoolean(false);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f5790b;

    public m(boolean z) {
        this.f5790b = true;
        this.f5790b = z;
    }

    @Override // com.bytedance.sdk.openadsdk.c.b
    public void b() {
    }

    @Override // com.bytedance.sdk.openadsdk.c.b
    public void a() {
        if (this.f5789a.getAndSet(true)) {
            return;
        }
        com.bytedance.sdk.openadsdk.multipro.c.a.a(this.f5790b);
    }

    @Override // com.bytedance.sdk.openadsdk.c.b
    public void a(c.a aVar) {
        if (this.f5789a.get()) {
            com.bytedance.sdk.openadsdk.multipro.c.a.a(aVar.a(), this.f5790b);
        }
    }
}
