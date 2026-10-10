package com.disabngo.blockynexus.e.b.F;

import com.disabngo.blockynexus.entity.GroupMember;
import com.sandboxol.common.base.web.OnResponseListener;
import java.util.List;

/* JADX INFO: compiled from: GroupMemberListModel.java */
/* JADX INFO: loaded from: classes2.dex */
class k implements com.sandboxol.greendao.a.c<List<GroupMember>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ OnResponseListener f9257a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ n f9258b;

    k(n nVar, OnResponseListener onResponseListener) {
        this.f9258b = nVar;
        this.f9257a = onResponseListener;
    }

    @Override // com.sandboxol.greendao.a.c
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onSuccess(List<GroupMember> list) {
        this.f9257a.onSuccess(list);
    }

    @Override // com.sandboxol.greendao.a.c
    public void onError(int i, String str) {
    }
}
