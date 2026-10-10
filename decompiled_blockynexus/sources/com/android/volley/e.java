package com.android.volley;

import android.os.Handler;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: ExecutorDelivery.java */
/* JADX INFO: loaded from: classes.dex */
class e implements Executor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Handler f3996a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ f f3997b;

    e(f fVar, Handler handler) {
        this.f3997b = fVar;
        this.f3996a = handler;
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        this.f3996a.post(runnable);
    }
}
