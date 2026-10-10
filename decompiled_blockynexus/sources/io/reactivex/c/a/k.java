package io.reactivex.c.a;

/* JADX INFO: compiled from: SimpleQueue.java */
/* JADX INFO: loaded from: classes5.dex */
public interface k<T> {
    void clear();

    boolean isEmpty();

    boolean offer(T t);

    T poll() throws Exception;
}
