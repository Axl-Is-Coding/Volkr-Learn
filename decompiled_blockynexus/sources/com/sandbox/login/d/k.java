package com.sandbox.login.d;

import com.sandbox.login.entity.UserRecord;
import com.sandboxol.common.base.dao.OnDaoResponseListener;
import rx.Observer;

/* JADX INFO: compiled from: UserRecordHelper.java */
/* JADX INFO: loaded from: classes2.dex */
class k implements Observer<UserRecord> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ OnDaoResponseListener f15721a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ t f15722b;

    k(t tVar, OnDaoResponseListener onDaoResponseListener) {
        this.f15722b = tVar;
        this.f15721a = onDaoResponseListener;
    }

    @Override // rx.Observer
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onNext(UserRecord userRecord) {
        OnDaoResponseListener onDaoResponseListener = this.f15721a;
        if (onDaoResponseListener != null) {
            onDaoResponseListener.onSuccess(userRecord);
        }
    }

    @Override // rx.Observer
    public void onCompleted() {
    }

    @Override // rx.Observer
    public void onError(Throwable th) {
        OnDaoResponseListener onDaoResponseListener = this.f15721a;
        if (onDaoResponseListener != null) {
            onDaoResponseListener.onError(-1, "");
        }
    }
}
