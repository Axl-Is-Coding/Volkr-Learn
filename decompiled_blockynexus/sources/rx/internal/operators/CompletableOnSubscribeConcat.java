package rx.internal.operators;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import rx.Completable;
import rx.CompletableSubscriber;
import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.exceptions.MissingBackpressureException;
import rx.internal.subscriptions.SequentialSubscription;
import rx.internal.util.unsafe.SpscArrayQueue;
import rx.plugins.RxJavaHooks;

/* JADX INFO: loaded from: classes5.dex */
public final class CompletableOnSubscribeConcat implements Completable.OnSubscribe {
    final int prefetch;
    final Observable<Completable> sources;

    static final class CompletableConcatSubscriber extends Subscriber<Completable> {
        volatile boolean active;
        final CompletableSubscriber actual;
        volatile boolean done;
        final SpscArrayQueue<Completable> queue;
        final SequentialSubscription sr = new SequentialSubscription();
        final ConcatInnerSubscriber inner = new ConcatInnerSubscriber();
        final AtomicBoolean once = new AtomicBoolean();

        final class ConcatInnerSubscriber extends AtomicInteger implements CompletableSubscriber {
            private static final long serialVersionUID = 7233503139645205620L;

            ConcatInnerSubscriber() {
            }

            @Override // rx.CompletableSubscriber
            public void onCompleted() {
                CompletableConcatSubscriber.this.innerComplete();
            }

            @Override // rx.CompletableSubscriber
            public void onError(Throwable th) {
                CompletableConcatSubscriber.this.innerError(th);
            }

            @Override // rx.CompletableSubscriber
            public void onSubscribe(Subscription subscription) {
                CompletableConcatSubscriber.this.sr.set(subscription);
            }
        }

        public CompletableConcatSubscriber(CompletableSubscriber completableSubscriber, int i) {
            this.actual = completableSubscriber;
            this.queue = new SpscArrayQueue<>(i);
            add(this.sr);
            request(i);
        }

        void drain() {
            ConcatInnerSubscriber concatInnerSubscriber = this.inner;
            if (concatInnerSubscriber.getAndIncrement() != 0) {
                return;
            }
            while (!isUnsubscribed()) {
                if (!this.active) {
                    boolean z = this.done;
                    Completable completablePoll = this.queue.poll();
                    boolean z2 = completablePoll == null;
                    if (z && z2) {
                        this.actual.onCompleted();
                        return;
                    } else if (!z2) {
                        this.active = true;
                        completablePoll.subscribe(concatInnerSubscriber);
                        request(1L);
                    }
                }
                if (concatInnerSubscriber.decrementAndGet() == 0) {
                    return;
                }
            }
        }

        void innerComplete() {
            this.active = false;
            drain();
        }

        void innerError(Throwable th) {
            unsubscribe();
            onError(th);
        }

        @Override // rx.Observer
        public void onCompleted() {
            if (this.done) {
                return;
            }
            this.done = true;
            drain();
        }

        @Override // rx.Observer
        public void onError(Throwable th) {
            if (this.once.compareAndSet(false, true)) {
                this.actual.onError(th);
            } else {
                RxJavaHooks.onError(th);
            }
        }

        @Override // rx.Observer
        public void onNext(Completable completable) {
            if (this.queue.offer(completable)) {
                drain();
            } else {
                onError(new MissingBackpressureException());
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CompletableOnSubscribeConcat(Observable<? extends Completable> observable, int i) {
        this.sources = observable;
        this.prefetch = i;
    }

    @Override // rx.functions.Action1
    public void call(CompletableSubscriber completableSubscriber) {
        CompletableConcatSubscriber completableConcatSubscriber = new CompletableConcatSubscriber(completableSubscriber, this.prefetch);
        completableSubscriber.onSubscribe(completableConcatSubscriber);
        this.sources.unsafeSubscribe(completableConcatSubscriber);
    }
}
