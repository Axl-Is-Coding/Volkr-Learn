package com.sandbox.login.a;

import com.sandbox.login.d.t;
import com.sandbox.login.entity.UserRecord;
import java.util.List;
import java.util.Vector;
import rx.functions.Action1;

/* JADX INFO: compiled from: UserCacheManager.java */
/* JADX INFO: loaded from: classes2.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static b f15595a = new b();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Vector<UserRecord> f15596b = new Vector<>();

    public List<UserRecord> b() {
        return this.f15596b;
    }

    public static b a() {
        return f15595a;
    }

    public void a(Action1<List<UserRecord>> action1) {
        t.a().a(new a(this, action1));
    }

    public void a(UserRecord userRecord) {
        this.f15596b.remove(userRecord);
        t.a().a(userRecord);
    }
}
