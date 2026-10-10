package com.google.common.util.concurrent;

import com.google.common.util.concurrent.b;

/* JADX INFO: compiled from: SettableFuture.java */
/* JADX INFO: loaded from: classes2.dex */
public final class r<V> extends b.h<V> {
    private r() {
    }

    @Override // com.google.common.util.concurrent.b
    public boolean set(V v) {
        return super.set(v);
    }

    @Override // com.google.common.util.concurrent.b
    public boolean setException(Throwable th) {
        return super.setException(th);
    }

    @Override // com.google.common.util.concurrent.b
    public boolean setFuture(n<? extends V> nVar) {
        return super.setFuture(nVar);
    }
}
