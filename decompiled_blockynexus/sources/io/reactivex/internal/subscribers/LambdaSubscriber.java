package io.reactivex.internal.subscribers;

import f.b.d;
import io.reactivex.b.g;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.h;
import io.reactivex.internal.functions.Functions;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes5.dex */
public final class LambdaSubscriber<T> extends AtomicReference<d> implements h<T>, d, io.reactivex.disposables.b, io.reactivex.observers.d {
    private static final long serialVersionUID = -7251123623727029452L;
    final io.reactivex.b.a onComplete;
    final g<? super Throwable> onError;
    final g<? super T> onNext;
    final g<? super d> onSubscribe;

    public LambdaSubscriber(g<? super T> gVar, g<? super Throwable> gVar2, io.reactivex.b.a aVar, g<? super d> gVar3) {
        this.onNext = gVar;
        this.onError = gVar2;
        this.onComplete = aVar;
        this.onSubscribe = gVar3;
    }

    @Override // f.b.d
    public void cancel() {
        SubscriptionHelper.cancel(this);
    }

    @Override // io.reactivex.disposables.b
    public void dispose() {
        cancel();
    }

    public boolean hasCustomOnError() {
        return this.onError != Functions.f21807f;
    }

    @Override // io.reactivex.disposables.b
    public boolean isDisposed() {
        return get() == SubscriptionHelper.CANCELLED;
    }

    @Override // f.b.c
    public void onComplete() {
        d dVar = get();
        SubscriptionHelper subscriptionHelper = SubscriptionHelper.CANCELLED;
        if (dVar != subscriptionHelper) {
            lazySet(subscriptionHelper);
            try {
                this.onComplete.run();
            } catch (Throwable th) {
                io.reactivex.exceptions.a.b(th);
                io.reactivex.e.a.b(th);
            }
        }
    }

    @Override // f.b.c
    public void onError(Throwable th) {
        d dVar = get();
        SubscriptionHelper subscriptionHelper = SubscriptionHelper.CANCELLED;
        if (dVar == subscriptionHelper) {
            io.reactivex.e.a.b(th);
            return;
        }
        lazySet(subscriptionHelper);
        try {
            this.onError.accept(th);
        } catch (Throwable th2) {
            io.reactivex.exceptions.a.b(th2);
            io.reactivex.e.a.b(new CompositeException(th, th2));
        }
    }

    @Override // f.b.c
    public void onNext(T t) {
        if (isDisposed()) {
            return;
        }
        try {
            this.onNext.accept(t);
        } catch (Throwable th) {
            io.reactivex.exceptions.a.b(th);
            get().cancel();
            onError(th);
        }
    }

    @Override // io.reactivex.h, f.b.c
    public void onSubscribe(d dVar) {
        if (SubscriptionHelper.setOnce(this, dVar)) {
            try {
                this.onSubscribe.accept(this);
            } catch (Throwable th) {
                io.reactivex.exceptions.a.b(th);
                dVar.cancel();
                onError(th);
            }
        }
    }

    @Override // f.b.d
    public void request(long j) {
        get().request(j);
    }
}
