package io.reactivex.internal.observers;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.w;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes5.dex */
public final class BlockingObserver<T> extends AtomicReference<io.reactivex.disposables.b> implements w<T>, io.reactivex.disposables.b {
    public static final Object TERMINATED = new Object();
    private static final long serialVersionUID = -4875965440900746268L;
    final Queue<Object> queue;

    public BlockingObserver(Queue<Object> queue) {
        this.queue = queue;
    }

    @Override // io.reactivex.disposables.b
    public void dispose() {
        if (DisposableHelper.dispose(this)) {
            this.queue.offer(TERMINATED);
        }
    }

    @Override // io.reactivex.disposables.b
    public boolean isDisposed() {
        return get() == DisposableHelper.DISPOSED;
    }

    @Override // io.reactivex.w
    public void onComplete() {
        this.queue.offer(NotificationLite.complete());
    }

    @Override // io.reactivex.w
    public void onError(Throwable th) {
        this.queue.offer(NotificationLite.error(th));
    }

    @Override // io.reactivex.w
    public void onNext(T t) {
        Queue<Object> queue = this.queue;
        NotificationLite.next(t);
        queue.offer(t);
    }

    @Override // io.reactivex.w
    public void onSubscribe(io.reactivex.disposables.b bVar) {
        DisposableHelper.setOnce(this, bVar);
    }
}
