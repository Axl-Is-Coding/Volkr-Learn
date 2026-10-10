package com.sandbox.login.d;

import com.sandboxol.common.base.dao.OnDaoResponseListener;
import rx.Observer;

/* JADX INFO: compiled from: UserRecordHelper.java */
/* JADX INFO: loaded from: classes2.dex */
class s implements Observer<String> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ OnDaoResponseListener f15737a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ t f15738b;

    s(t tVar, OnDaoResponseListener onDaoResponseListener) {
        this.f15738b = tVar;
        this.f15737a = onDaoResponseListener;
    }

    @Override // rx.Observer
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onNext(String str) {
        OnDaoResponseListener onDaoResponseListener = this.f15737a;
        if (onDaoResponseListener != null) {
            onDaoResponseListener.onSuccess(str);
        }
    }

    @Override // rx.Observer
    public void onCompleted() {
    }

    @Override // rx.Observer
    public void onError(Throwable th) {
    }
}
