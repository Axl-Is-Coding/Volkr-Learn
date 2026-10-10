package io.reactivex;

/* JADX INFO: compiled from: MaybeObserver.java */
/* JADX INFO: loaded from: classes5.dex */
public interface k<T> {
    void onComplete();

    void onError(Throwable th);

    void onSubscribe(io.reactivex.disposables.b bVar);

    void onSuccess(T t);
}
