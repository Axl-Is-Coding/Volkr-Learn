package io.reactivex.internal.util;

import io.reactivex.w;

/* JADX INFO: compiled from: ObservableQueueDrain.java */
/* JADX INFO: loaded from: classes5.dex */
public interface h<T, U> {
    int a(int i);

    void a(w<? super U> wVar, T t);

    boolean a();

    boolean done();

    Throwable error();
}
