package io.reactivex.internal.operators.maybe;

import io.reactivex.b.o;
import io.reactivex.m;

/* JADX INFO: loaded from: classes5.dex */
public enum MaybeToPublisher implements o<m<Object>, f.b.b<Object>> {
    INSTANCE;

    public static <T> o<m<T>, f.b.b<T>> instance() {
        return INSTANCE;
    }

    @Override // io.reactivex.b.o
    public f.b.b<Object> apply(m<Object> mVar) throws Exception {
        return new MaybeToFlowable(mVar);
    }
}
