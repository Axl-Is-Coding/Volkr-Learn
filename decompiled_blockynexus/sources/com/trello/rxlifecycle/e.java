package com.trello.rxlifecycle;

import rx.functions.Func2;

/* JADX INFO: Add missing generic type declarations: [R] */
/* JADX INFO: compiled from: RxLifecycle.java */
/* JADX INFO: loaded from: classes5.dex */
class e<R> implements Func2<R, R, Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ f f20088a;

    e(f fVar) {
        this.f20088a = fVar;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // rx.functions.Func2
    public Boolean call(R r, R r2) {
        return Boolean.valueOf(r2.equals(r));
    }
}
