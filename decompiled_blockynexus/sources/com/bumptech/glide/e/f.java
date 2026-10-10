package com.bumptech.glide.e;

import java.util.concurrent.Executor;

/* JADX INFO: compiled from: Executors.java */
/* JADX INFO: loaded from: classes.dex */
class f implements Executor {
    f() {
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        runnable.run();
    }
}
