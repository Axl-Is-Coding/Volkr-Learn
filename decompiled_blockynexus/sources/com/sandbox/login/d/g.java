package com.sandbox.login.d;

import com.sandbox.login.entity.UserRecord;
import com.sandboxol.common.base.dao.OnDaoResponseListener;
import java.util.List;
import rx.Observer;

/* JADX INFO: compiled from: UserRecordHelper.java */
/* JADX INFO: loaded from: classes2.dex */
class g implements Observer<List<UserRecord>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ OnDaoResponseListener f15715a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ t f15716b;

    g(t tVar, OnDaoResponseListener onDaoResponseListener) {
        this.f15716b = tVar;
        this.f15715a = onDaoResponseListener;
    }

    @Override // rx.Observer
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onNext(List<UserRecord> list) {
        OnDaoResponseListener onDaoResponseListener = this.f15715a;
        if (onDaoResponseListener != null) {
            onDaoResponseListener.onSuccess(list);
        }
    }

    @Override // rx.Observer
    public void onCompleted() {
    }

    @Override // rx.Observer
    public void onError(Throwable th) {
        OnDaoResponseListener onDaoResponseListener = this.f15715a;
        if (onDaoResponseListener != null) {
            onDaoResponseListener.onError(-1, th.getMessage());
        }
    }
}
