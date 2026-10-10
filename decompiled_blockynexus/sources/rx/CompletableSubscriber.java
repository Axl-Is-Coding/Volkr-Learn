package rx;

/* JADX INFO: loaded from: classes5.dex */
public interface CompletableSubscriber {
    void onCompleted();

    void onError(Throwable th);

    void onSubscribe(Subscription subscription);
}
