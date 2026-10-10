package com.ironsource.mediationsdk.b;

import com.facebook.ads.AdError;
import com.ironsource.mediationsdk.utils.m;

/* JADX INFO: compiled from: InterstitialEventsManager.java */
/* JADX INFO: loaded from: classes2.dex */
public class h extends f {
    private static h M;
    private String N;

    private h() {
        this.E = "ironbeast";
        this.D = 2;
        this.F = "IS";
        this.N = "";
    }

    public static synchronized h g() {
        if (M == null) {
            M = new h();
            M.e();
        }
        return M;
    }

    @Override // com.ironsource.mediationsdk.b.f
    protected int a(b.f.b.b bVar) {
        return m.a().a(bVar.c() >= 3000 && bVar.c() < 4000 ? 3 : 2);
    }

    @Override // com.ironsource.mediationsdk.b.f
    protected boolean b(b.f.b.b bVar) {
        int iC = bVar.c();
        return iC == 2204 || iC == 2004 || iC == 2005 || iC == 2301 || iC == 2300 || iC == 3005 || iC == 3015;
    }

    @Override // com.ironsource.mediationsdk.b.f
    protected void d(b.f.b.b bVar) {
        this.N = bVar.b().optString("placement");
    }

    @Override // com.ironsource.mediationsdk.b.f
    protected boolean e(b.f.b.b bVar) {
        return false;
    }

    @Override // com.ironsource.mediationsdk.b.f
    protected boolean f(b.f.b.b bVar) {
        return false;
    }

    @Override // com.ironsource.mediationsdk.b.f
    protected void d() {
        this.G.add(2001);
        this.G.add(2002);
        this.G.add(Integer.valueOf(AdError.INTERNAL_ERROR_2004));
        this.G.add(2211);
        this.G.add(2212);
    }

    @Override // com.ironsource.mediationsdk.b.f
    protected String a(int i) {
        return this.N;
    }
}
