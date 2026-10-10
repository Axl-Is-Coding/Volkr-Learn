package com.ironsource.mediationsdk.model;

import java.util.ArrayList;

/* JADX INFO: compiled from: InterstitialConfigurations.java */
/* JADX INFO: loaded from: classes2.dex */
public class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ArrayList<i> f14899a = new ArrayList<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private c f14900b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f14901c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f14902d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f14903e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f14904f;
    private String g;
    private String h;
    private com.ironsource.mediationsdk.utils.a i;
    private i j;

    public h(int i, boolean z, int i2, c cVar, com.ironsource.mediationsdk.utils.a aVar, int i3) {
        this.f14901c = i;
        this.f14902d = z;
        this.f14903e = i2;
        this.f14900b = cVar;
        this.i = aVar;
        this.f14904f = i3;
    }

    public void a(i iVar) {
        if (iVar != null) {
            this.f14899a.add(iVar);
            if (this.j == null) {
                this.j = iVar;
            } else if (iVar.b() == 0) {
                this.j = iVar;
            }
        }
    }

    public i b() {
        for (i iVar : this.f14899a) {
            if (iVar.d()) {
                return iVar;
            }
        }
        return this.j;
    }

    public void c(String str) {
        this.h = str;
    }

    public int d() {
        return this.f14901c;
    }

    public int e() {
        return this.f14903e;
    }

    public boolean f() {
        return this.f14902d;
    }

    public com.ironsource.mediationsdk.utils.a g() {
        return this.i;
    }

    public c h() {
        return this.f14900b;
    }

    public String i() {
        return this.h;
    }

    public int c() {
        return this.f14904f;
    }

    public void b(String str) {
        this.g = str;
    }

    public i a(String str) {
        for (i iVar : this.f14899a) {
            if (iVar.c().equals(str)) {
                return iVar;
            }
        }
        return null;
    }

    public String a() {
        return this.g;
    }
}
