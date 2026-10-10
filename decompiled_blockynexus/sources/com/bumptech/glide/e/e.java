package com.bumptech.glide.e;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: Executors.java */
/* JADX INFO: loaded from: classes.dex */
class e implements Executor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Handler f4164a = new Handler(Looper.getMainLooper());

    e() {
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        this.f4164a.post(runnable);
    }
}
