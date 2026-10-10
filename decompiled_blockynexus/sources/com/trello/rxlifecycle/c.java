package com.trello.rxlifecycle;

import rx.functions.Func1;

/* JADX INFO: Add missing generic type declarations: [R] */
/* JADX INFO: compiled from: RxLifecycle.java */
/* JADX INFO: loaded from: classes5.dex */
class c<R> implements Func1<R, Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ d f20080a;

    c(d dVar) {
        this.f20080a = dVar;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // rx.functions.Func1
    public Boolean call(R r) {
        return Boolean.valueOf(r.equals(this.f20080a.f20087b));
    }
}
