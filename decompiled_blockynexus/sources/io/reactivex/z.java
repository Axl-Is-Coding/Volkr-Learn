package io.reactivex;

/* JADX INFO: compiled from: SingleObserver.java */
/* JADX INFO: loaded from: classes5.dex */
public interface z<T> {
    void onError(Throwable th);

    void onSubscribe(io.reactivex.disposables.b bVar);

    void onSuccess(T t);
}
