package com.google.common.util.concurrent;

import java.util.concurrent.ExecutionException;

/* JADX INFO: compiled from: Futures.java */
/* JADX INFO: loaded from: classes2.dex */
class l implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ n f14063a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ j f14064b;

    l(n nVar, j jVar) {
        this.f14063a = nVar;
        this.f14064b = jVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.f14064b.onSuccess(u.a(this.f14063a));
        } catch (Error e2) {
            this.f14064b.onFailure(e2);
        } catch (RuntimeException e3) {
            this.f14064b.onFailure(e3);
        } catch (ExecutionException e4) {
            this.f14064b.onFailure(e4.getCause());
        }
    }
}
