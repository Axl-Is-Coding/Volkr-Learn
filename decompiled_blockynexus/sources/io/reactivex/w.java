package io.reactivex;

/* JADX INFO: compiled from: Observer.java */
/* JADX INFO: loaded from: classes5.dex */
public interface w<T> {
    void onComplete();

    void onError(Throwable th);

    void onNext(T t);

    void onSubscribe(io.reactivex.disposables.b bVar);
}
