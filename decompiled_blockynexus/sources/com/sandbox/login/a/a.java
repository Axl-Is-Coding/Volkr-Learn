package com.sandbox.login.a;

import com.sandbox.login.entity.UserRecord;
import com.sandboxol.common.base.dao.OnDaoResponseListener;
import java.util.List;
import rx.functions.Action1;

/* JADX INFO: compiled from: UserCacheManager.java */
/* JADX INFO: loaded from: classes2.dex */
class a extends OnDaoResponseListener<List<UserRecord>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Action1 f15593a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ b f15594b;

    a(b bVar, Action1 action1) {
        this.f15594b = bVar;
        this.f15593a = action1;
    }

    @Override // com.sandboxol.common.base.dao.OnDaoResponseListener
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onSuccess(List<UserRecord> list) {
        this.f15594b.f15596b.clear();
        this.f15594b.f15596b.addAll(list);
        Action1 action1 = this.f15593a;
        if (action1 != null) {
            action1.call(this.f15594b.f15596b);
        }
    }

    @Override // com.sandboxol.common.base.dao.OnDaoResponseListener
    public void onError(int i, String str) {
    }
}
