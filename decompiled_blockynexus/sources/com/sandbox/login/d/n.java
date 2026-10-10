package com.sandbox.login.d;

import com.sandbox.login.entity.UserRecord;
import rx.Observable;
import rx.Subscriber;

/* JADX INFO: compiled from: UserRecordHelper.java */
/* JADX INFO: loaded from: classes2.dex */
class n implements Observable.OnSubscribe<String> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f15726a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ String f15727b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ t f15728c;

    n(t tVar, String str, String str2) {
        this.f15728c = tVar;
        this.f15726a = str;
        this.f15727b = str2;
    }

    @Override // rx.functions.Action1
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void call(Subscriber<? super String> subscriber) {
        synchronized (t.class) {
            UserRecord userRecordB = this.f15728c.b(this.f15726a);
            if (userRecordB != null && this.f15727b != null) {
                userRecordB.setAccount(this.f15727b);
                userRecordB.setLoginType(UserRecord.LOGIN_TYPE_ACCOUNT);
                this.f15728c.f15740d.insertOrReplace(userRecordB);
            }
            subscriber.onCompleted();
        }
    }
}
