package com.sandbox.login.d;

import com.sandbox.login.entity.UserRecord;
import com.sandboxol.greendao.entity.User;
import java.io.UnsupportedEncodingException;
import rx.Observable;
import rx.Subscriber;

/* JADX INFO: compiled from: UserRecordHelper.java */
/* JADX INFO: loaded from: classes2.dex */
class f implements Observable.OnSubscribe<String> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ User f15711a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ String f15712b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ String f15713c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ t f15714d;

    f(t tVar, User user, String str, String str2) {
        this.f15714d = tVar;
        this.f15711a = user;
        this.f15712b = str;
        this.f15713c = str2;
    }

    @Override // rx.functions.Action1
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void call(Subscriber<? super String> subscriber) {
        synchronized (t.class) {
            String str = "userId";
            if ("".equals(this.f15711a.getAccount()) || !this.f15712b.equals(this.f15711a.getAccount())) {
                if (!this.f15712b.equals(this.f15711a.getUserId() + "")) {
                    subscriber.onCompleted();
                    return;
                }
            } else {
                str = UserRecord.LOGIN_TYPE_ACCOUNT;
            }
            String str2 = str;
            UserRecord userRecordB = this.f15714d.b(this.f15711a.getUserId() + "");
            try {
                String strA = this.f15713c != null ? com.sandbox.login.e.c.a(this.f15713c.getBytes("utf-8")) : null;
                if (userRecordB != null) {
                    userRecordB.setLoginType(str2);
                    if (strA != null && !"".endsWith(strA)) {
                        userRecordB.setPassword(strA);
                    }
                    this.f15714d.a(userRecordB, this.f15711a, false);
                } else {
                    this.f15714d.a(new UserRecord(this.f15711a.getUserId() + "", this.f15711a.getAccount(), strA, this.f15711a.getPicUrl(), str2, this.f15711a.getNickName(), this.f15711a.getHasPassword(), System.currentTimeMillis()), this.f15711a, true);
                }
            } catch (UnsupportedEncodingException e2) {
                e2.printStackTrace();
            }
            subscriber.onCompleted();
        }
    }
}
