package com.disabngo.blockynexus.view.dialog.h;

import com.sandboxol.center.web.error.ScrapOnError;
import com.sandboxol.common.base.model.DefaultListModel;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.web.error.ServerOnError;
import java.util.List;

/* JADX INFO: compiled from: ScrapRuleListModel.java */
/* JADX INFO: loaded from: classes2.dex */
class d extends OnResponseListener<List<String>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ OnResponseListener f11592a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ e f11593b;

    d(e eVar, OnResponseListener onResponseListener) {
        this.f11593b = eVar;
        this.f11592a = onResponseListener;
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onError(int i, String str) {
        ScrapOnError.showErrorTip(((DefaultListModel) this.f11593b).context, i);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onServerError(int i) {
        ServerOnError.showOnServerError(((DefaultListModel) this.f11593b).context, i);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onSuccess(List<String> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        this.f11592a.onSuccess(list);
    }
}
