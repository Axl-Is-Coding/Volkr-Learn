package com.sandbox.login.d;

import com.sandbox.login.entity.UserRecord;
import java.io.UnsupportedEncodingException;
import rx.Observable;
import rx.Subscriber;

/* JADX INFO: compiled from: UserRecordHelper.java */
/* JADX INFO: loaded from: classes2.dex */
class p implements Observable.OnSubscribe<String> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f15730a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ String f15731b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ String f15732c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ t f15733d;

    p(t tVar, String str, String str2, String str3) {
        this.f15733d = tVar;
        this.f15730a = str;
        this.f15731b = str2;
        this.f15732c = str3;
    }

    @Override // rx.functions.Action1
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void call(Subscriber<? super String> subscriber) {
        synchronized (t.class) {
            UserRecord userRecordB = this.f15733d.b(this.f15730a);
            if (userRecordB == null) {
                userRecordB = this.f15733d.a(this.f15731b);
            }
            if (userRecordB == null || this.f15732c == null) {
                subscriber.onCompleted();
            } else {
                try {
                    userRecordB.setPassword(com.sandbox.login.e.c.a(this.f15732c.getBytes("utf-8")));
                    userRecordB.setHasPassword(true);
                    this.f15733d.f15740d.insertOrReplace(userRecordB);
                } catch (UnsupportedEncodingException e2) {
                    e2.printStackTrace();
                }
                subscriber.onCompleted();
            }
        }
    }
}
