package com.sandbox.login.d;

import com.sandbox.login.entity.UserRecord;
import rx.Observable;
import rx.Subscriber;

/* JADX INFO: compiled from: UserRecordHelper.java */
/* JADX INFO: loaded from: classes2.dex */
class l implements Observable.OnSubscribe<UserRecord> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f15723a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ t f15724b;

    l(t tVar, String str) {
        this.f15724b = tVar;
        this.f15723a = str;
    }

    @Override // rx.functions.Action1
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void call(Subscriber<? super UserRecord> subscriber) {
        UserRecord userRecordB = this.f15724b.b(this.f15723a);
        if (userRecordB != null && userRecordB.getPassword() != null) {
            userRecordB.setPassword(new String(com.sandbox.login.e.c.a(userRecordB.getPassword())));
        }
        subscriber.onNext(userRecordB);
        subscriber.onCompleted();
    }
}
