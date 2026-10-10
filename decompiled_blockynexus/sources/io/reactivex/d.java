package io.reactivex;

/* JADX INFO: compiled from: Emitter.java */
/* JADX INFO: loaded from: classes5.dex */
public interface d<T> {
    void onComplete();

    void onError(Throwable th);

    void onNext(T t);
}
