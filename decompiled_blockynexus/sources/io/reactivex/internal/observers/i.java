package io.reactivex.internal.observers;

/* JADX INFO: compiled from: InnerQueuedObserverSupport.java */
/* JADX INFO: loaded from: classes5.dex */
public interface i<T> {
    void drain();

    void innerComplete(InnerQueuedObserver<T> innerQueuedObserver);

    void innerError(InnerQueuedObserver<T> innerQueuedObserver, Throwable th);

    void innerNext(InnerQueuedObserver<T> innerQueuedObserver, T t);
}
