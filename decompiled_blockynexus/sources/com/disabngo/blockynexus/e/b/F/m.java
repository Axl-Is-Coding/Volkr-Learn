package com.disabngo.blockynexus.e.b.F;

import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.greendao.entity.Friend;
import java.util.List;

/* JADX INFO: compiled from: GroupMemberListModel.java */
/* JADX INFO: loaded from: classes2.dex */
class m extends OnResponseListener<List<Friend>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ com.sandboxol.greendao.a.c f9262a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ n f9263b;

    m(n nVar, com.sandboxol.greendao.a.c cVar) {
        this.f9263b = nVar;
        this.f9262a = cVar;
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onError(int i, String str) {
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onServerError(int i) {
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onSuccess(List<Friend> list) {
        this.f9262a.onSuccess(list);
    }
}
