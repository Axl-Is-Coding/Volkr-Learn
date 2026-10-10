package rx.internal.operators;

import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicBoolean;
import rx.Single;
import rx.SingleSubscriber;
import rx.plugins.RxJavaHooks;

/* JADX INFO: loaded from: classes5.dex */
public final class SingleTakeUntilSingle<T, U> implements Single.OnSubscribe<T> {
    final Single<? extends U> other;
    final Single.OnSubscribe<T> source;

    static final class TakeUntilSourceSubscriber<T, U> extends SingleSubscriber<T> {
        final SingleSubscriber<? super T> actual;
        final AtomicBoolean once = new AtomicBoolean();
        final SingleSubscriber<U> other = new OtherSubscriber();

        final class OtherSubscriber extends SingleSubscriber<U> {
            OtherSubscriber() {
            }

            @Override // rx.SingleSubscriber
            public void onError(Throwable th) {
                TakeUntilSourceSubscriber.this.onError(th);
            }

            @Override // rx.SingleSubscriber
            public void onSuccess(U u) {
                onError(new CancellationException("Single::takeUntil(Single) - Stream was canceled before emitting a terminal event."));
            }
        }

        TakeUntilSourceSubscriber(SingleSubscriber<? super T> singleSubscriber) {
            this.actual = singleSubscriber;
            add(this.other);
        }

        @Override // rx.SingleSubscriber
        public void onError(Throwable th) {
            if (!this.once.compareAndSet(false, true)) {
                RxJavaHooks.onError(th);
            } else {
                unsubscribe();
                this.actual.onError(th);
            }
        }

        @Override // rx.SingleSubscriber
        public void onSuccess(T t) {
            if (this.once.compareAndSet(false, true)) {
                unsubscribe();
                this.actual.onSuccess(t);
            }
        }
    }

    public SingleTakeUntilSingle(Single.OnSubscribe<T> onSubscribe, Single<? extends U> single) {
        this.source = onSubscribe;
        this.other = single;
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // rx.functions.Action1
    public void call(SingleSubscriber<? super T> singleSubscriber) {
        TakeUntilSourceSubscriber takeUntilSourceSubscriber = new TakeUntilSourceSubscriber(singleSubscriber);
        singleSubscriber.add(takeUntilSourceSubscriber);
        this.other.subscribe((SingleSubscriber<? super Object>) takeUntilSourceSubscriber.other);
        this.source.call(takeUntilSourceSubscriber);
    }
}
