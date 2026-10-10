package com.iab.omid.library.ironsrc.adsession;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final g f14526a;

    private a(g gVar) {
        this.f14526a = gVar;
    }

    public static a a(b bVar) {
        g gVar = (g) bVar;
        b.e.a.a.a.d.e.a(bVar, "AdSession is null");
        b.e.a.a.a.d.e.b(gVar);
        b.e.a.a.a.d.e.a(gVar);
        a aVar = new a(gVar);
        gVar.j().a(aVar);
        return aVar;
    }

    public void a() {
        b.e.a.a.a.d.e.a(this.f14526a);
        b.e.a.a.a.d.e.c(this.f14526a);
        if (!this.f14526a.f()) {
            try {
                this.f14526a.b();
            } catch (Exception unused) {
            }
        }
        if (this.f14526a.f()) {
            this.f14526a.d();
        }
    }
}
