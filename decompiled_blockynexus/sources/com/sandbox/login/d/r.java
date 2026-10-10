package com.sandbox.login.d;

import com.sandbox.login.entity.UserRecord;
import com.sandboxol.greendao.entity.User;
import rx.Observable;
import rx.Subscriber;

/* JADX INFO: compiled from: UserRecordHelper.java */
/* JADX INFO: loaded from: classes2.dex */
class r implements Observable.OnSubscribe<String> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ User f15735a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ t f15736b;

    r(t tVar, User user) {
        this.f15736b = tVar;
        this.f15735a = user;
    }

    @Override // rx.functions.Action1
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void call(Subscriber<? super String> subscriber) {
        synchronized (t.class) {
            UserRecord userRecordB = this.f15736b.b(this.f15735a.getUserId() + "");
            if (userRecordB == null) {
                userRecordB = this.f15736b.a(this.f15735a.getAccount());
            }
            if (userRecordB != null) {
                this.f15736b.a(userRecordB, this.f15735a, false);
            } else {
                this.f15736b.a(new UserRecord(this.f15735a.getUserId() + "", this.f15735a.getAccount(), "", this.f15735a.getPicUrl(), "userId", this.f15735a.getNickName(), this.f15735a.getHasPassword(), System.currentTimeMillis()), this.f15735a, true);
            }
            subscriber.onCompleted();
        }
    }
}
