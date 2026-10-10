package com.sandbox.login.d;

import com.sandbox.login.entity.UserRecord;
import rx.Observable;
import rx.Subscriber;

/* JADX INFO: compiled from: UserRecordHelper.java */
/* JADX INFO: loaded from: classes2.dex */
class j implements Observable.OnSubscribe<Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ UserRecord f15719a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ t f15720b;

    j(t tVar, UserRecord userRecord) {
        this.f15720b = tVar;
        this.f15719a = userRecord;
    }

    @Override // rx.functions.Action1
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void call(Subscriber<? super Object> subscriber) {
        synchronized (t.class) {
            try {
                this.f15720b.f15740d.delete(this.f15719a);
                subscriber.onCompleted();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
}
