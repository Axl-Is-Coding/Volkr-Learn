package com.trello.rxlifecycle;

import rx.Observable;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: compiled from: RxLifecycle.java */
/* JADX INFO: loaded from: classes5.dex */
class d<T> implements Observable.Transformer<T, T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Observable f20086a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ Object f20087b;

    d(Observable observable, Object obj) {
        this.f20086a = observable;
        this.f20087b = obj;
    }

    @Override // rx.functions.Func1
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public Observable<T> call(Observable<T> observable) {
        return observable.takeUntil(this.f20086a.takeFirst(new c(this)));
    }
}
