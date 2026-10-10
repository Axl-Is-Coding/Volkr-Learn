package f.b;

/* JADX INFO: compiled from: Subscriber.java */
/* JADX INFO: loaded from: classes5.dex */
public interface c<T> {
    void onComplete();

    void onError(Throwable th);

    void onNext(T t);

    void onSubscribe(d dVar);
}
