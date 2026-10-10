package io.reactivex.internal.operators.flowable;

/* JADX INFO: compiled from: AbstractFlowableWithUpstream.java */
/* JADX INFO: loaded from: classes5.dex */
abstract class a<T, R> extends io.reactivex.e<R> implements io.reactivex.c.a.e<T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected final io.reactivex.e<T> f21902b;

    a(io.reactivex.e<T> eVar) {
        io.reactivex.internal.functions.a.a(eVar, "source is null");
        this.f21902b = eVar;
    }
}
