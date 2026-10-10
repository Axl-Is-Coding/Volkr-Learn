package com.trello.rxlifecycle;

import rx.exceptions.Exceptions;
import rx.functions.Func1;

/* JADX INFO: compiled from: RxLifecycle.java */
/* JADX INFO: loaded from: classes5.dex */
class g implements Func1<Throwable, Boolean> {
    g() {
    }

    @Override // rx.functions.Func1
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public Boolean call(Throwable th) {
        if (th instanceof OutsideLifecycleException) {
            return true;
        }
        Exceptions.propagate(th);
        throw null;
    }
}
