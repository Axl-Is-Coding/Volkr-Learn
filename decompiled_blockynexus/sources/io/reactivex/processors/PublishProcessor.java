package io.reactivex.processors;

import f.b.c;
import f.b.d;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes5.dex */
public final class PublishProcessor<T> extends a<T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static final PublishSubscription[] f22760b = new PublishSubscription[0];

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    static final PublishSubscription[] f22761c = new PublishSubscription[0];

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final AtomicReference<PublishSubscription<T>[]> f22762d = new AtomicReference<>(f22761c);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    Throwable f22763e;

    static final class PublishSubscription<T> extends AtomicLong implements d {
        private static final long serialVersionUID = 3562861878281475070L;
        final c<? super T> downstream;
        final PublishProcessor<T> parent;

        PublishSubscription(c<? super T> cVar, PublishProcessor<T> publishProcessor) {
            this.downstream = cVar;
            this.parent = publishProcessor;
        }

        @Override // f.b.d
        public void cancel() {
            if (getAndSet(Long.MIN_VALUE) != Long.MIN_VALUE) {
                this.parent.b(this);
            }
        }

        public boolean isCancelled() {
            return get() == Long.MIN_VALUE;
        }

        boolean isFull() {
            return get() == 0;
        }

        public void onComplete() {
            if (get() != Long.MIN_VALUE) {
                this.downstream.onComplete();
            }
        }

        public void onError(Throwable th) {
            if (get() != Long.MIN_VALUE) {
                this.downstream.onError(th);
            } else {
                io.reactivex.e.a.b(th);
            }
        }

        public void onNext(T t) {
            long j = get();
            if (j == Long.MIN_VALUE) {
                return;
            }
            if (j != 0) {
                this.downstream.onNext(t);
                io.reactivex.internal.util.b.d(this, 1L);
            } else {
                cancel();
                this.downstream.onError(new MissingBackpressureException("Could not emit value due to lack of requests"));
            }
        }

        @Override // f.b.d
        public void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                io.reactivex.internal.util.b.b(this, j);
            }
        }
    }

    PublishProcessor() {
    }

    public static <T> PublishProcessor<T> i() {
        return new PublishProcessor<>();
    }

    boolean a(PublishSubscription<T> publishSubscription) {
        PublishSubscription<T>[] publishSubscriptionArr;
        PublishSubscription<T>[] publishSubscriptionArr2;
        do {
            publishSubscriptionArr = this.f22762d.get();
            if (publishSubscriptionArr == f22760b) {
                return false;
            }
            int length = publishSubscriptionArr.length;
            publishSubscriptionArr2 = new PublishSubscription[length + 1];
            System.arraycopy(publishSubscriptionArr, 0, publishSubscriptionArr2, 0, length);
            publishSubscriptionArr2[length] = publishSubscription;
        } while (!this.f22762d.compareAndSet(publishSubscriptionArr, publishSubscriptionArr2));
        return true;
    }

    @Override // io.reactivex.e
    protected void b(c<? super T> cVar) {
        PublishSubscription<T> publishSubscription = new PublishSubscription<>(cVar, this);
        cVar.onSubscribe(publishSubscription);
        if (a((PublishSubscription) publishSubscription)) {
            if (publishSubscription.isCancelled()) {
                b(publishSubscription);
            }
        } else {
            Throwable th = this.f22763e;
            if (th != null) {
                cVar.onError(th);
            } else {
                cVar.onComplete();
            }
        }
    }

    @Override // f.b.c
    public void onComplete() {
        PublishSubscription<T>[] publishSubscriptionArr = this.f22762d.get();
        PublishSubscription<T>[] publishSubscriptionArr2 = f22760b;
        if (publishSubscriptionArr == publishSubscriptionArr2) {
            return;
        }
        for (PublishSubscription<T> publishSubscription : this.f22762d.getAndSet(publishSubscriptionArr2)) {
            publishSubscription.onComplete();
        }
    }

    @Override // f.b.c
    public void onError(Throwable th) {
        io.reactivex.internal.functions.a.a(th, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        PublishSubscription<T>[] publishSubscriptionArr = this.f22762d.get();
        PublishSubscription<T>[] publishSubscriptionArr2 = f22760b;
        if (publishSubscriptionArr == publishSubscriptionArr2) {
            io.reactivex.e.a.b(th);
            return;
        }
        this.f22763e = th;
        for (PublishSubscription<T> publishSubscription : this.f22762d.getAndSet(publishSubscriptionArr2)) {
            publishSubscription.onError(th);
        }
    }

    @Override // f.b.c
    public void onNext(T t) {
        io.reactivex.internal.functions.a.a((Object) t, "onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
        for (PublishSubscription<T> publishSubscription : this.f22762d.get()) {
            publishSubscription.onNext(t);
        }
    }

    @Override // f.b.c
    public void onSubscribe(d dVar) {
        if (this.f22762d.get() == f22760b) {
            dVar.cancel();
        } else {
            dVar.request(Long.MAX_VALUE);
        }
    }

    void b(PublishSubscription<T> publishSubscription) {
        PublishSubscription<T>[] publishSubscriptionArr;
        PublishSubscription<T>[] publishSubscriptionArr2;
        do {
            publishSubscriptionArr = this.f22762d.get();
            if (publishSubscriptionArr == f22760b || publishSubscriptionArr == f22761c) {
                return;
            }
            int length = publishSubscriptionArr.length;
            int i = -1;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    break;
                }
                if (publishSubscriptionArr[i2] == publishSubscription) {
                    i = i2;
                    break;
                }
                i2++;
            }
            if (i < 0) {
                return;
            }
            if (length == 1) {
                publishSubscriptionArr2 = f22761c;
            } else {
                PublishSubscription<T>[] publishSubscriptionArr3 = new PublishSubscription[length - 1];
                System.arraycopy(publishSubscriptionArr, 0, publishSubscriptionArr3, 0, i);
                System.arraycopy(publishSubscriptionArr, i + 1, publishSubscriptionArr3, i, (length - i) - 1);
                publishSubscriptionArr2 = publishSubscriptionArr3;
            }
        } while (!this.f22762d.compareAndSet(publishSubscriptionArr, publishSubscriptionArr2));
    }
}
