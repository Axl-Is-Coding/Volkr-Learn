package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.EmptyDisposable;

/* JADX INFO: compiled from: ObservableNever.java */
/* JADX INFO: loaded from: classes5.dex */
public final class ba extends io.reactivex.p<Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final io.reactivex.p<Object> f22365a = new ba();

    private ba() {
    }

    @Override // io.reactivex.p
    protected void subscribeActual(io.reactivex.w<? super Object> wVar) {
        wVar.onSubscribe(EmptyDisposable.NEVER);
    }
}
