package com.ironsource.mediationsdk.g;

/* JADX INFO: compiled from: BannerTimeoutTimer.java */
/* JADX INFO: loaded from: classes2.dex */
public class d extends b<a> {

    /* JADX INFO: compiled from: BannerTimeoutTimer.java */
    public interface a {
        void onTimeout();
    }

    public d(long j) {
        super(j);
    }

    public void a(a aVar) {
        a(aVar);
    }

    @Override // com.ironsource.mediationsdk.g.b
    void b() {
        T t = this.f14828c;
        if (t != 0) {
            ((a) t).onTimeout();
        }
    }

    public void d() {
        c();
    }
}
