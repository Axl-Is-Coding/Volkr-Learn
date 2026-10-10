package io.reactivex.internal.operators.observable;

/* JADX INFO: compiled from: ObservableFromUnsafeSource.java */
/* JADX INFO: loaded from: classes5.dex */
public final class N<T> extends io.reactivex.p<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final io.reactivex.u<T> f22050a;

    public N(io.reactivex.u<T> uVar) {
        this.f22050a = uVar;
    }

    @Override // io.reactivex.p
    protected void subscribeActual(io.reactivex.w<? super T> wVar) {
        this.f22050a.subscribe(wVar);
    }
}
