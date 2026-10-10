package com.ironsource.mediationsdk.model;

import java.util.ArrayList;

/* JADX INFO: compiled from: RewardedVideoConfigurations.java */
/* JADX INFO: loaded from: classes2.dex */
public class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ArrayList<l> f14947a = new ArrayList<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private c f14948b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f14949c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f14950d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f14951e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f14952f;
    private String g;
    private int h;
    private l i;
    private com.ironsource.mediationsdk.utils.a j;

    public r(int i, boolean z, int i2, int i3, c cVar, com.ironsource.mediationsdk.utils.a aVar) {
        this.f14949c = i;
        this.f14950d = z;
        this.f14951e = i2;
        this.h = i3;
        this.f14948b = cVar;
        this.j = aVar;
    }

    public void a(l lVar) {
        if (lVar != null) {
            this.f14947a.add(lVar);
            if (this.i == null) {
                this.i = lVar;
            } else if (lVar.b() == 0) {
                this.i = lVar;
            }
        }
    }

    public l b() {
        for (l lVar : this.f14947a) {
            if (lVar.f()) {
                return lVar;
            }
        }
        return this.i;
    }

    public int c() {
        return this.h;
    }

    public String d() {
        return this.g;
    }

    public int e() {
        return this.f14949c;
    }

    public int f() {
        return this.f14951e;
    }

    public boolean g() {
        return this.f14950d;
    }

    public com.ironsource.mediationsdk.utils.a h() {
        return this.j;
    }

    public c i() {
        return this.f14948b;
    }

    public void c(String str) {
        this.g = str;
    }

    public void b(String str) {
        this.f14952f = str;
    }

    public l a(String str) {
        for (l lVar : this.f14947a) {
            if (lVar.c().equals(str)) {
                return lVar;
            }
        }
        return null;
    }

    public String a() {
        return this.f14952f;
    }
}
