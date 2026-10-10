package io.reactivex.internal.subscribers;

import f.b.c;
import f.b.d;
import io.reactivex.h;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.g;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes5.dex */
public class StrictSubscriber<T> extends AtomicInteger implements h<T>, d {
    private static final long serialVersionUID = -4945028590049415624L;
    volatile boolean done;
    final c<? super T> downstream;
    final AtomicThrowable error = new AtomicThrowable();
    final AtomicLong requested = new AtomicLong();
    final AtomicReference<d> upstream = new AtomicReference<>();
    final AtomicBoolean once = new AtomicBoolean();

    public StrictSubscriber(c<? super T> cVar) {
        this.downstream = cVar;
    }

    @Override // f.b.d
    public void cancel() {
        if (this.done) {
            return;
        }
        SubscriptionHelper.cancel(this.upstream);
    }

    @Override // f.b.c
    public void onComplete() {
        this.done = true;
        g.a(this.downstream, this, this.error);
    }

    @Override // f.b.c
    public void onError(Throwable th) {
        this.done = true;
        g.a((c<?>) this.downstream, th, (AtomicInteger) this, this.error);
    }

    @Override // f.b.c
    public void onNext(T t) {
        g.a(this.downstream, t, this, this.error);
    }

    @Override // io.reactivex.h, f.b.c
    public void onSubscribe(d dVar) {
        if (this.once.compareAndSet(false, true)) {
            this.downstream.onSubscribe(this);
            SubscriptionHelper.deferredSetOnce(this.upstream, this.requested, dVar);
        } else {
            dVar.cancel();
            cancel();
            onError(new IllegalStateException("§2.12 violated: onSubscribe must be called at most once"));
        }
    }

    @Override // f.b.d
    public void request(long j) {
        if (j > 0) {
            SubscriptionHelper.deferredRequest(this.upstream, this.requested, j);
            return;
        }
        cancel();
        onError(new IllegalArgumentException("§3.9 violated: positive request amount required but it was " + j));
    }
}
