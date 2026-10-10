package com.android.volley;

/* JADX INFO: compiled from: Request.java */
/* JADX INFO: loaded from: classes.dex */
class k implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f4015a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ long f4016b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ Request f4017c;

    k(Request request, String str, long j) {
        this.f4017c = request;
        this.f4015a = str;
        this.f4016b = j;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f4017c.f3970a.a(this.f4015a, this.f4016b);
        this.f4017c.f3970a.a(this.f4017c.toString());
    }
}
