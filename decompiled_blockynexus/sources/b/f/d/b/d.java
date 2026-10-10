package b.f.d.b;

import b.f.d.b.c;

/* JADX INFO: compiled from: ISNAdunitWebView.java */
/* JADX INFO: loaded from: classes2.dex */
class d implements c.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f2652a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ h f2653b;

    d(h hVar, String str) {
        this.f2653b = hVar;
        this.f2652a = str;
    }

    @Override // b.f.d.b.c.a
    public void a(String str) {
        com.ironsource.sdk.utils.f.c(this.f2653b.g, "createWebView failed!");
        this.f2653b.f2666d.a(this.f2652a, str);
    }
}
