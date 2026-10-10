package com.disabngo.blockynexus.e.b.F;

import com.disabngo.blockynexus.entity.GroupMember;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.greendao.entity.Friend;
import java.util.List;

/* JADX INFO: compiled from: GroupMemberListModel.java */
/* JADX INFO: loaded from: classes2.dex */
class j implements com.sandboxol.greendao.a.c<List<Friend>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ OnResponseListener f9255a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ n f9256b;

    j(n nVar, OnResponseListener onResponseListener) {
        this.f9256b = nVar;
        this.f9255a = onResponseListener;
    }

    @Override // com.sandboxol.greendao.a.c
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onSuccess(List<Friend> list) {
        if (list != null) {
            List listA = this.f9256b.a((List<Friend>) list);
            if (listA.size() > 0) {
                listA.add(new GroupMember(-1L));
            }
            this.f9255a.onSuccess(listA);
        }
    }

    @Override // com.sandboxol.greendao.a.c
    public void onError(int i, String str) {
    }
}
