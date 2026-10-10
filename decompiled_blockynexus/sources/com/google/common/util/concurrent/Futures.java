package com.google.common.util.concurrent;

import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes2.dex */
public final class Futures extends m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final h<n<Object>, Object> f14036a = new k();

    private Futures() {
    }

    public static <V> void addCallback(n<V> nVar, j<? super V> jVar) {
        addCallback(nVar, jVar, MoreExecutors.a());
    }

    public static <V> void addCallback(n<V> nVar, j<? super V> jVar, Executor executor) {
        com.google.common.base.m.a(jVar);
        nVar.addListener(new l(nVar, jVar), executor);
    }
}
