package com.trello.rxlifecycle;

import rx.Observable;
import rx.functions.Func1;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: compiled from: RxLifecycle.java */
/* JADX INFO: loaded from: classes5.dex */
class f<T> implements Observable.Transformer<T, T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Observable f20089a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ Func1 f20090b;

    f(Observable observable, Func1 func1) {
        this.f20089a = observable;
        this.f20090b = func1;
    }

    @Override // rx.functions.Func1
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public Observable<T> call(Observable<T> observable) {
        return observable.takeUntil(Observable.combineLatest(this.f20089a.take(1).map(this.f20090b), this.f20089a.skip(1), new e(this)).onErrorReturn(l.f20093a).takeFirst(l.f20094b));
    }
}
