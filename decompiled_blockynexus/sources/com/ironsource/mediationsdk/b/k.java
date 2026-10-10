package com.ironsource.mediationsdk.b;

import com.ironsource.mediationsdk.utils.m;

/* JADX INFO: compiled from: RewardedVideoEventsManager.java */
/* JADX INFO: loaded from: classes2.dex */
public class k extends f {
    private static k M;
    private String N;

    private k() {
        this.E = "outcome";
        this.D = 3;
        this.F = "RV";
        this.N = "";
    }

    public static synchronized k g() {
        if (M == null) {
            M = new k();
            M.e();
        }
        return M;
    }

    @Override // com.ironsource.mediationsdk.b.f
    protected int a(b.f.b.b bVar) {
        return (bVar.c() == 15 || (bVar.c() >= 300 && bVar.c() < 400)) ? m.a().a(0) : m.a().a(1);
    }

    @Override // com.ironsource.mediationsdk.b.f
    protected boolean b(b.f.b.b bVar) {
        int iC = bVar.c();
        return iC == 14 || iC == 514 || iC == 305 || iC == 1003 || iC == 1005 || iC == 1203 || iC == 1010 || iC == 1301 || iC == 1302;
    }

    @Override // com.ironsource.mediationsdk.b.f
    protected void d(b.f.b.b bVar) {
        if (bVar.c() == 15 || (bVar.c() >= 300 && bVar.c() < 400)) {
            this.N = bVar.b().optString("placement");
        }
    }

    @Override // com.ironsource.mediationsdk.b.f
    protected boolean e(b.f.b.b bVar) {
        return false;
    }

    @Override // com.ironsource.mediationsdk.b.f
    protected boolean f(b.f.b.b bVar) {
        return bVar.c() == 305;
    }

    @Override // com.ironsource.mediationsdk.b.f
    protected void d() {
        this.G.add(1001);
        this.G.add(1209);
        this.G.add(1210);
        this.G.add(1211);
    }

    @Override // com.ironsource.mediationsdk.b.f
    protected String a(int i) {
        return (i == 15 || (i >= 300 && i < 400)) ? this.N : "";
    }
}
