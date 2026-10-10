package com.tencent.mapsdk.rastercore.c;

import com.tencent.tencentmap.mapsdk.map.CancelableCallback;

/* JADX INFO: loaded from: classes5.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected boolean f19466a = true;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected long f19467b = 1000;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected CancelableCallback f19468c = null;

    public final void a(long j) {
        this.f19467b = j;
    }

    public abstract void a(com.tencent.mapsdk.rastercore.d.f fVar);

    public final void a(CancelableCallback cancelableCallback) {
        this.f19468c = cancelableCallback;
    }

    public final void a(boolean z) {
        this.f19466a = false;
    }

    public boolean a() {
        return true;
    }
}
