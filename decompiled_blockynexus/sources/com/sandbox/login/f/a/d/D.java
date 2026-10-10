package com.sandbox.login.f.a.d;

import rx.Observer;

/* JADX INFO: compiled from: MakeRoleViewModel.java */
/* JADX INFO: loaded from: classes2.dex */
class D implements Observer<Long> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f15801a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ E f15802b;

    D(E e2, String str) {
        this.f15802b = e2;
        this.f15801a = str;
    }

    @Override // rx.Observer
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onNext(Long l) {
        String strA = v.a(this.f15802b.f15806d, this.f15801a);
        if (strA == null) {
            this.f15802b.b(this.f15801a);
        } else {
            this.f15802b.d(strA);
            this.f15802b.h = true;
        }
    }

    @Override // rx.Observer
    public void onCompleted() {
    }

    @Override // rx.Observer
    public void onError(Throwable th) {
    }
}
