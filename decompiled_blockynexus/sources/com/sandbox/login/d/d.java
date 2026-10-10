package com.sandbox.login.d;

import com.sandbox.login.entity.UserRecord;
import rx.Observable;
import rx.Subscriber;

/* JADX INFO: compiled from: UserRecordHelper.java */
/* JADX INFO: loaded from: classes2.dex */
class d implements Observable.OnSubscribe<String> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f15708a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ t f15709b;

    d(t tVar, String str) {
        this.f15709b = tVar;
        this.f15708a = str;
    }

    @Override // rx.functions.Action1
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void call(Subscriber<? super String> subscriber) {
        synchronized (t.class) {
            UserRecord userRecordB = this.f15709b.b(this.f15708a);
            if (userRecordB != null) {
                userRecordB.setPassword("");
                this.f15709b.f15740d.insertOrReplace(userRecordB);
                userRecordB.setLoginTime(System.currentTimeMillis());
            }
            subscriber.onNext("");
            subscriber.onCompleted();
        }
    }
}
