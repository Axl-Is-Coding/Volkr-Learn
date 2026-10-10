package com.google.android.datatransport.runtime;

import java.util.concurrent.Executor;

/* JADX INFO: compiled from: SafeLoggingExecutor.java */
/* JADX INFO: loaded from: classes.dex */
class o implements Executor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Executor f12956a;

    /* JADX INFO: compiled from: SafeLoggingExecutor.java */
    static class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Runnable f12957a;

        a(Runnable runnable) {
            this.f12957a = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.f12957a.run();
            } catch (Exception e2) {
                com.google.android.datatransport.runtime.b.a.a("Executor", "Background execution failure.", (Throwable) e2);
            }
        }
    }

    o(Executor executor) {
        this.f12956a = executor;
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        this.f12956a.execute(new a(runnable));
    }
}
