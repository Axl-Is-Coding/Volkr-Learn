package com.bytedance.sdk.openadsdk.g;

import android.graphics.Bitmap;
import com.bytedance.sdk.adnet.b.d;
import com.bytedance.sdk.adnet.core.m;
import com.bytedance.sdk.openadsdk.core.g;

/* JADX INFO: compiled from: StatsImageListener.java */
/* JADX INFO: loaded from: classes.dex */
public class b implements d.InterfaceC0070d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f6804a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.f.a.c f6805b;

    public b(boolean z) {
        this.f6804a = z;
        if (this.f6804a) {
            this.f6805b = com.bytedance.sdk.openadsdk.f.a.c.b();
        }
    }

    @Override // com.bytedance.sdk.adnet.b.d.InterfaceC0070d
    public void a() {
    }

    @Override // com.bytedance.sdk.adnet.core.m.a
    public void a(m<Bitmap> mVar) {
    }

    public void a(String str) {
        com.bytedance.sdk.openadsdk.f.a.c cVar;
        if (!this.f6804a || (cVar = this.f6805b) == null) {
            return;
        }
        cVar.c(str);
    }

    @Override // com.bytedance.sdk.adnet.b.d.InterfaceC0070d
    public void b() {
    }

    public void b(String str) {
        com.bytedance.sdk.openadsdk.f.a.c cVar;
        if (!this.f6804a || (cVar = this.f6805b) == null) {
            return;
        }
        cVar.e(str);
    }

    public void c(String str) {
        com.bytedance.sdk.openadsdk.f.a.c cVar;
        if (!this.f6804a || (cVar = this.f6805b) == null) {
            return;
        }
        cVar.d(str);
    }

    public void d(String str) {
        com.bytedance.sdk.openadsdk.f.a.c cVar;
        if (!this.f6804a || (cVar = this.f6805b) == null) {
            return;
        }
        cVar.g(str);
    }

    public void a(int i) {
        com.bytedance.sdk.openadsdk.f.a.c cVar;
        if (!this.f6804a || (cVar = this.f6805b) == null) {
            return;
        }
        cVar.a(i);
    }

    @Override // com.bytedance.sdk.adnet.core.m.a
    public void b(m<Bitmap> mVar) {
        com.bytedance.sdk.openadsdk.f.a.c cVar;
        if (!this.f6804a || (cVar = this.f6805b) == null) {
            return;
        }
        cVar.b(201).f(g.a(201));
        com.bytedance.sdk.openadsdk.f.a.a().f(this.f6805b);
    }

    @Override // com.bytedance.sdk.adnet.b.d.InterfaceC0070d
    public void a(d.c cVar, boolean z) {
        if (!this.f6804a || this.f6805b == null) {
            return;
        }
        if (cVar == null || cVar.a() == null) {
            this.f6805b.b(202).f(g.a(202));
            com.bytedance.sdk.openadsdk.f.a.a().f(this.f6805b);
        }
    }
}
