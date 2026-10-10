package io.reactivex.internal.operators.maybe;

import io.reactivex.i;
import io.reactivex.k;

/* JADX INFO: compiled from: MaybeError.java */
/* JADX INFO: loaded from: classes5.dex */
public final class b<T> extends i<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final Throwable f21942a;

    public b(Throwable th) {
        this.f21942a = th;
    }

    @Override // io.reactivex.i
    protected void b(k<? super T> kVar) {
        kVar.onSubscribe(io.reactivex.disposables.c.a());
        kVar.onError(this.f21942a);
    }
}
