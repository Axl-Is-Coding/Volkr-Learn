package io.reactivex.internal.util;

import io.reactivex.w;
import io.reactivex.z;

/* JADX INFO: loaded from: classes5.dex */
public enum EmptyComponent implements io.reactivex.h<Object>, w<Object>, io.reactivex.k<Object>, z<Object>, io.reactivex.b, f.b.d, io.reactivex.disposables.b {
    INSTANCE;

    public static <T> w<T> asObserver() {
        return INSTANCE;
    }

    public static <T> f.b.c<T> asSubscriber() {
        return INSTANCE;
    }

    @Override // f.b.d
    public void cancel() {
    }

    @Override // io.reactivex.disposables.b
    public void dispose() {
    }

    @Override // io.reactivex.disposables.b
    public boolean isDisposed() {
        return true;
    }

    @Override // f.b.c
    public void onComplete() {
    }

    @Override // f.b.c
    public void onError(Throwable th) {
        io.reactivex.e.a.b(th);
    }

    @Override // f.b.c
    public void onNext(Object obj) {
    }

    @Override // io.reactivex.w
    public void onSubscribe(io.reactivex.disposables.b bVar) {
        bVar.dispose();
    }

    @Override // io.reactivex.k
    public void onSuccess(Object obj) {
    }

    @Override // f.b.d
    public void request(long j) {
    }

    @Override // io.reactivex.h, f.b.c
    public void onSubscribe(f.b.d dVar) {
        dVar.cancel();
    }
}
