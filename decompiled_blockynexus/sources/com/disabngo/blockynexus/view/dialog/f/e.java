package com.disabngo.blockynexus.view.dialog.f;

import com.sandboxol.center.entity.ScrapHistoryInfo;
import com.sandboxol.center.web.error.ScrapOnError;
import com.sandboxol.common.base.model.DefaultListModel;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.web.error.ServerOnError;
import com.sandboxol.common.widget.rv.pagerv.PageData;
import java.util.List;

/* JADX INFO: compiled from: ScrapHistoryListModel.java */
/* JADX INFO: loaded from: classes2.dex */
class e extends OnResponseListener<PageData<ScrapHistoryInfo>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ int f11559a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ OnResponseListener f11560b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ f f11561c;

    e(f fVar, int i, OnResponseListener onResponseListener) {
        this.f11561c = fVar;
        this.f11559a = i;
        this.f11560b = onResponseListener;
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onError(int i, String str) {
        ScrapOnError.showErrorTip(((DefaultListModel) this.f11561c).context, i);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onServerError(int i) {
        ServerOnError.showOnServerError(((DefaultListModel) this.f11561c).context, i);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onSuccess(PageData<ScrapHistoryInfo> pageData) {
        List<ScrapHistoryInfo> data;
        if (pageData != null) {
            if (this.f11559a == 0 && (data = pageData.getData()) != null) {
                data.add(0, new ScrapHistoryInfo());
            }
            this.f11560b.onSuccess(pageData);
        }
    }
}
