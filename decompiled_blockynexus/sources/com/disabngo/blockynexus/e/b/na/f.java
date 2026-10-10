package com.disabngo.blockynexus.e.b.na;

import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.greendao.entity.Friend;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: TribeInviteFriendListModel.java */
/* JADX INFO: loaded from: classes2.dex */
class f extends OnResponseListener<List<Friend>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ OnResponseListener f9975a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ g f9976b;

    f(g gVar, OnResponseListener onResponseListener) {
        this.f9976b = gVar;
        this.f9975a = onResponseListener;
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onError(int i, String str) {
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onServerError(int i) {
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onSuccess(List<Friend> list) {
        if (list == null) {
            this.f9975a.onSuccess(new ArrayList());
            return;
        }
        Iterator<Friend> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Friend next = it.next();
            if (next.getUserId() == 32) {
                list.remove(next);
                break;
            }
        }
        this.f9975a.onSuccess(list);
    }
}
