package com.disabngo.blockynexus.e.b.B;

import com.disabngo.blockynexus.entity.GroupInfo;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.widget.rv.pagerv.PageData;
import java.util.List;

/* JADX INFO: compiled from: GroupChatListModel.java */
/* JADX INFO: loaded from: classes2.dex */
class g extends OnResponseListener<PageData<GroupInfo>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ OnResponseListener f9116a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ h f9117b;

    g(h hVar, OnResponseListener onResponseListener) {
        this.f9117b = hVar;
        this.f9116a = onResponseListener;
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onError(int i, String str) {
        this.f9116a.onError(i, str);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onServerError(int i) {
        this.f9116a.onServerError(i);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onSuccess(PageData<GroupInfo> pageData) {
        if (pageData != null) {
            if (pageData.getData().size() == 0 && pageData.getPageNo() == 0) {
                this.f9117b.f9118a.set(true);
            } else {
                this.f9117b.f9118a.set(false);
            }
            pageData.setData(this.f9117b.a((List<GroupInfo>) pageData.getData()));
            this.f9116a.onSuccess(pageData);
        }
    }
}
