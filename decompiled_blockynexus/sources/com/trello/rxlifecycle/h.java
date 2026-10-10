package com.trello.rxlifecycle;

import rx.functions.Func1;

/* JADX INFO: compiled from: RxLifecycle.java */
/* JADX INFO: loaded from: classes5.dex */
class h implements Func1<Boolean, Boolean> {
    h() {
    }

    public Boolean a(Boolean bool) {
        return bool;
    }

    @Override // rx.functions.Func1
    public /* bridge */ /* synthetic */ Boolean call(Boolean bool) {
        Boolean bool2 = bool;
        a(bool2);
        return bool2;
    }
}
