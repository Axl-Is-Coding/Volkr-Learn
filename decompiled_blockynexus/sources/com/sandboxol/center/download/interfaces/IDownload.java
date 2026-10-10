package com.sandboxol.center.download.interfaces;

/* JADX INFO: loaded from: classes3.dex */
public interface IDownload<T> {
    void doOnBefore();

    void doOnCompleted();

    void doOnFinally();

    void doOnNext();

    void onComplete(T t);

    void onError(Throwable th);

    void onNext(T t);
}
