package com.disabngo.blockynexus.view.activity.searchfriend;

import com.sandboxol.center.entity.AccountCenter;
import com.sandboxol.common.base.model.DefaultListModel;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.web.error.ServerOnError;
import com.sandboxol.common.widget.rv.pagerv.PageData;
import com.sandboxol.greendao.entity.Friend;
import java.util.Iterator;

/* JADX INFO: compiled from: SearchFriendPageListModel.java */
/* JADX INFO: loaded from: classes2.dex */
class n extends OnResponseListener<PageData<Friend>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ OnResponseListener f11081a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ p f11082b;

    n(p pVar, OnResponseListener onResponseListener) {
        this.f11082b = pVar;
        this.f11081a = onResponseListener;
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onError(int i, String str) {
        this.f11081a.onError(i, str);
        this.f11082b.f11086b.set(true);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onServerError(int i) {
        ServerOnError.showOnServerError(((DefaultListModel) this.f11082b).context, i);
        this.f11081a.onServerError(i);
        this.f11082b.f11086b.set(true);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onSuccess(PageData<Friend> pageData) {
        Iterator<Friend> it = pageData.getData().iterator();
        while (it.hasNext()) {
            if (AccountCenter.newInstance().userId.get().longValue() == it.next().getUserId()) {
                it.remove();
            }
        }
        if (this.f11082b.f11085a.matches("[0-9]+") && pageData.getPageNo() == 0) {
            this.f11082b.a((PageData<Friend>) pageData);
            this.f11082b.a((OnResponseListener<PageData<Friend>>) this.f11081a);
        } else {
            this.f11081a.onSuccess(pageData);
            this.f11082b.f11086b.set(true);
        }
    }
}
