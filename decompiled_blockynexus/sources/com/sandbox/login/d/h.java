package com.sandbox.login.d;

import com.sandbox.login.entity.UserRecord;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import rx.Observable;
import rx.Subscriber;

/* JADX INFO: compiled from: UserRecordHelper.java */
/* JADX INFO: loaded from: classes2.dex */
class h implements Observable.OnSubscribe<List<UserRecord>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ t f15717a;

    h(t tVar) {
        this.f15717a = tVar;
    }

    @Override // rx.functions.Action1
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void call(Subscriber<? super List<UserRecord>> subscriber) {
        synchronized (t.class) {
            List<UserRecord> listLoadAll = this.f15717a.f15740d.loadAll();
            Collections.sort(listLoadAll, new com.sandbox.login.e.a());
            ArrayList arrayList = new ArrayList();
            Iterator<UserRecord> it = listLoadAll.iterator();
            while (it.hasNext()) {
                UserRecord userRecordM81clone = it.next().m81clone();
                if (userRecordM81clone.getPassword() != null) {
                    userRecordM81clone.setPassword(new String(com.sandbox.login.e.c.a(userRecordM81clone.getPassword())));
                }
                arrayList.add(userRecordM81clone);
            }
            subscriber.onNext(arrayList);
            subscriber.onCompleted();
        }
    }
}
