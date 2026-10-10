package com.disabngo.blockynexus.e.b.da;

import com.sandboxol.center.config.EventConstant;
import com.sandboxol.center.config.StringConstant;
import com.sandboxol.center.entity.AccountCenter;
import com.sandboxol.center.entity.ScrapRewardInfo;
import com.sandboxol.center.web.error.ScrapOnError;
import com.sandboxol.common.base.model.DefaultListModel;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.interfaces.ReportDataAdapter;
import com.sandboxol.common.utils.SharedUtils;
import com.sandboxol.common.web.error.ServerOnError;
import com.sandboxol.common.widget.rv.pagerv.PageData;
import java.util.Iterator;

/* JADX INFO: compiled from: ScrapMainListModel.java */
/* JADX INFO: loaded from: classes2.dex */
class k extends OnResponseListener<PageData<ScrapRewardInfo>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ OnResponseListener f9706a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ l f9707b;

    k(l lVar, OnResponseListener onResponseListener) {
        this.f9707b = lVar;
        this.f9706a = onResponseListener;
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onError(int i, String str) {
        ScrapOnError.showErrorTip(((DefaultListModel) this.f9707b).context, i);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onServerError(int i) {
        ServerOnError.showOnServerError(((DefaultListModel) this.f9707b).context, i);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onSuccess(PageData<ScrapRewardInfo> pageData) {
        if (pageData == null || pageData.getData() == null) {
            return;
        }
        this.f9706a.onSuccess(pageData);
        Iterator<ScrapRewardInfo> it = pageData.getData().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            ScrapRewardInfo next = it.next();
            if (this.f9707b.f9709b == 0 && !this.f9707b.f9711d && next.getStatus() == 1) {
                ReportDataAdapter.onEvent(((DefaultListModel) this.f9707b).context, EventConstant.HAVE_AVAILABLE_ITEM);
                this.f9707b.f9711d = true;
                break;
            }
        }
        if (SharedUtils.getBoolean(((DefaultListModel) this.f9707b).context, AccountCenter.newInstance().userId.get() + StringConstant.KEY_HAS_SHOW_SCRAP_LIST_GUIDE, false)) {
            return;
        }
        this.f9707b.f9708a.set(true);
    }
}
