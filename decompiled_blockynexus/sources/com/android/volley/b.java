package com.android.volley;

/* JADX INFO: compiled from: CacheDispatcher.java */
/* JADX INFO: loaded from: classes.dex */
class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Request f3982a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ c f3983b;

    b(c cVar, Request request) {
        this.f3983b = cVar;
        this.f3982a = request;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.f3983b.f3986c.put(this.f3982a);
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
        }
    }
}
