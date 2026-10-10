package com.google.android.datatransport.runtime;

import java.util.concurrent.Executor;

/* JADX INFO: compiled from: ExecutionModule_ExecutorFactory.java */
/* JADX INFO: loaded from: classes.dex */
public final class n implements com.google.android.datatransport.runtime.a.a.b<Executor> {

    /* JADX INFO: compiled from: ExecutionModule_ExecutorFactory.java */
    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final n f12955a = new n();
    }

    public static n a() {
        return a.f12955a;
    }

    public static Executor b() {
        Executor executorA = m.a();
        com.google.android.datatransport.runtime.a.a.d.a(executorA, "Cannot return null from a non-@Nullable @Provides method");
        return executorA;
    }

    @Override // e.a.a
    public Executor get() {
        return b();
    }
}
