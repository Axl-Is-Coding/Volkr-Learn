package io.reactivex;

/* JADX INFO: compiled from: MaybeEmitter.java */
/* JADX INFO: loaded from: classes5.dex */
public interface j<T> {
    void onError(Throwable th);

    void onSuccess(T t);
}
