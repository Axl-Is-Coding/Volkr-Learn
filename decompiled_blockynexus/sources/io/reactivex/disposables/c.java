package io.reactivex.disposables;

import io.reactivex.internal.disposables.EmptyDisposable;

/* JADX INFO: compiled from: Disposables.java */
/* JADX INFO: loaded from: classes5.dex */
public final class c {
    public static b a(Runnable runnable) {
        io.reactivex.internal.functions.a.a(runnable, "run is null");
        return new RunnableDisposable(runnable);
    }

    public static b a() {
        return EmptyDisposable.INSTANCE;
    }
}
