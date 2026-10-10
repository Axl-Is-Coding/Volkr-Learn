package io.reactivex;

/* JADX INFO: compiled from: CompletableObserver.java */
/* JADX INFO: loaded from: classes5.dex */
public interface b {
    void onComplete();

    void onError(Throwable th);

    void onSubscribe(io.reactivex.disposables.b bVar);
}
