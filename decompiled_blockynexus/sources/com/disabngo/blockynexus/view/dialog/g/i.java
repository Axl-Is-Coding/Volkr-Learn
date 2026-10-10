package com.disabngo.blockynexus.view.dialog.g;

import com.disabngo.blockynexus.R;
import com.sandboxol.center.entity.ScrapRequestTargetInfo;
import com.sandboxol.center.web.error.ScrapOnError;
import com.sandboxol.common.base.model.DefaultListModel;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.web.error.ServerOnError;
import com.sandboxol.common.widget.rv.pagerv.PageData;

/* JADX INFO: compiled from: ScrapRequestListModel.java */
/* JADX INFO: loaded from: classes2.dex */
class i extends OnResponseListener<PageData<ScrapRequestTargetInfo>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ OnResponseListener f11579a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ j f11580b;

    i(j jVar, OnResponseListener onResponseListener) {
        this.f11580b = jVar;
        this.f11579a = onResponseListener;
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onError(int i, String str) {
        if (i == 10110) {
            this.f11580b.f11585e.set(1);
            j jVar = this.f11580b;
            jVar.f11586f.set(((DefaultListModel) jVar).context.getString(R.string.app_scrap_request_null_tips));
        } else {
            if (i != 10113) {
                ScrapOnError.showErrorTip(((DefaultListModel) this.f11580b).context, i);
                return;
            }
            this.f11580b.f11585e.set(3);
            j jVar2 = this.f11580b;
            jVar2.f11586f.set(((DefaultListModel) jVar2).context.getString(R.string.base_scrap_not_vip_can_t_seek_help));
        }
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onServerError(int i) {
        ServerOnError.showOnServerError(((DefaultListModel) this.f11580b).context, i);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onSuccess(PageData<ScrapRequestTargetInfo> pageData) {
        this.f11579a.onSuccess(pageData);
        if (pageData.getData().size() == 0) {
            this.f11580b.f11585e.set(2);
            j jVar = this.f11580b;
            jVar.f11586f.set(((DefaultListModel) jVar).context.getString(R.string.app_scrap_request_null_tips_2));
            return;
        }
        for (ScrapRequestTargetInfo scrapRequestTargetInfo : pageData.getData()) {
            if (scrapRequestTargetInfo.getHelpStatus() == 0 && scrapRequestTargetInfo.getScrapNum() > this.f11580b.f11582b) {
                this.f11580b.f11582b = scrapRequestTargetInfo.getScrapNum();
                this.f11580b.f11584d.set(Long.valueOf(scrapRequestTargetInfo.getFriendId()));
                this.f11580b.f11583c.set(scrapRequestTargetInfo.getFriendName());
                return;
            }
        }
    }
}
