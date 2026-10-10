package com.ironsource.mediationsdk.f;

/* JADX INFO: compiled from: Server.java */
/* JADX INFO: loaded from: classes2.dex */
class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f14814a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ boolean f14815b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ int f14816c;

    b(String str, boolean z, int i) {
        this.f14814a = str;
        this.f14815b = z;
        this.f14816c = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        c.c(this.f14814a, this.f14815b, this.f14816c);
    }
}
