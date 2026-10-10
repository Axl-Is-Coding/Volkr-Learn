package io.reactivex.c.a;

import java.util.concurrent.Callable;

/* JADX INFO: compiled from: ScalarCallable.java */
/* JADX INFO: loaded from: classes5.dex */
public interface i<T> extends Callable<T> {
    @Override // java.util.concurrent.Callable
    T call();
}
