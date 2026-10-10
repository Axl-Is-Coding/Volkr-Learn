package com.disabngo.blockynexus.e.b.D;

import android.app.Activity;
import com.disabngo.blockynexus.entity.GroupInfo;
import com.disabngo.blockynexus.web.error.GroupOnError;
import com.sandboxol.center.config.EventConstant;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.interfaces.ReportDataAdapter;
import com.sandboxol.common.messenger.Messenger;
import com.sandboxol.common.web.error.ServerOnError;
import com.sandboxol.common.widget.rv.msg.RefreshMsg;
import com.sandboxol.common.widget.rv.pagerv.PageData;

/* JADX INFO: compiled from: GroupInfoViewModel.java */
/* JADX INFO: loaded from: classes2.dex */
class H extends OnResponseListener<PageData<GroupInfo>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ I f9167a;

    H(I i) {
        this.f9167a = i;
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onError(int i, String str) {
        GroupOnError.showErrorTip(this.f9167a.f9168a, i);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onServerError(int i) {
        ServerOnError.showOnServerError(this.f9167a.f9168a, i);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onSuccess(PageData<GroupInfo> pageData) {
        if (pageData != null) {
            Messenger.getDefault().send(RefreshMsg.create(), "token.refresh.group.list");
            com.disabngo.blockynexus.d.y.b().k(this.f9167a.f9170c);
            ReportDataAdapter.onEvent(this.f9167a.f9168a, EventConstant.GROUP_QUIT_SUCESS);
            ((Activity) this.f9167a.f9168a).finish();
        }
    }
}
