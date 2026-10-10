package com.google.common.util.concurrent;

/* JADX INFO: compiled from: FutureCallback.java */
/* JADX INFO: loaded from: classes2.dex */
public interface j<V> {
    void onFailure(Throwable th);

    void onSuccess(V v);
}
