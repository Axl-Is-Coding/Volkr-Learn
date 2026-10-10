package com.disabngo.blockynexus.view.activity.searchfriend;

import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.greendao.entity.Friend;
import java.util.ArrayList;

/* JADX INFO: compiled from: SearchFriendPageListModel.java */
/* JADX INFO: loaded from: classes2.dex */
class o extends OnResponseListener<Friend> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ OnResponseListener f11083a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ p f11084b;

    o(p pVar, OnResponseListener onResponseListener) {
        this.f11084b = pVar;
        this.f11083a = onResponseListener;
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onError(int i, String str) {
        this.f11083a.onSuccess(this.f11084b.f11087c);
        this.f11084b.f11086b.set(true);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onServerError(int i) {
        this.f11083a.onSuccess(this.f11084b.f11087c);
        this.f11084b.f11086b.set(true);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onSuccess(Friend friend) {
        ArrayList arrayList = new ArrayList();
        if (friend != null) {
            friend.setIsSearchById(true);
            arrayList.add(friend);
        }
        if (this.f11084b.f11087c.getData().size() > 0) {
            arrayList.addAll(this.f11084b.f11087c.getData());
        }
        this.f11084b.f11087c.setData(arrayList);
        this.f11083a.onSuccess(this.f11084b.f11087c);
        this.f11084b.f11086b.set(true);
    }
}
