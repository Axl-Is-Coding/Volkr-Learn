package com.ironsource.mediationsdk.model;

import java.util.ArrayList;

/* JADX INFO: compiled from: BannerConfigurations.java */
/* JADX INFO: loaded from: classes2.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private c f14888a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f14889b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f14890c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private ArrayList<f> f14891d = new ArrayList<>();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private f f14892e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f14893f;
    private int g;
    private com.ironsource.mediationsdk.utils.a h;

    public e(int i, long j, c cVar, int i2, com.ironsource.mediationsdk.utils.a aVar, int i3) {
        this.f14889b = i;
        this.f14890c = j;
        this.f14888a = cVar;
        this.f14893f = i2;
        this.g = i3;
        this.h = aVar;
    }

    public long a() {
        return this.f14890c;
    }

    public com.ironsource.mediationsdk.utils.a b() {
        return this.h;
    }

    public int c() {
        return this.g;
    }

    public c d() {
        return this.f14888a;
    }

    public int e() {
        return this.f14893f;
    }

    public f f() {
        for (f fVar : this.f14891d) {
            if (fVar.d()) {
                return fVar;
            }
        }
        return this.f14892e;
    }

    public void a(f fVar) {
        if (fVar != null) {
            this.f14891d.add(fVar);
            if (this.f14892e == null) {
                this.f14892e = fVar;
            } else if (fVar.b() == 0) {
                this.f14892e = fVar;
            }
        }
    }

    public f a(String str) {
        for (f fVar : this.f14891d) {
            if (fVar.c().equals(str)) {
                return fVar;
            }
        }
        return null;
    }
}
