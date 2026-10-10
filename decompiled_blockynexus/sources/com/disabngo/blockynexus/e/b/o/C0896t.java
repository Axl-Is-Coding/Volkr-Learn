package com.disabngo.blockynexus.e.b.o;

import android.content.Context;
import com.disabngo.blockynexus.entity.GroupInfo;
import com.disabngo.blockynexus.web.error.GroupOnError;
import com.sandboxol.center.config.EventConstant;
import com.sandboxol.center.entity.AccountCenter;
import com.sandboxol.center.entity.TribeCenter;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.interfaces.ReportDataAdapter;
import com.sandboxol.common.utils.GroupUtilsProxy;
import com.sandboxol.common.widget.rv.pagerv.PageData;

/* JADX INFO: renamed from: com.disabngo.blockynexus.e.b.o.t, reason: case insensitive filesystem */
/* JADX INFO: compiled from: ChatModel.java */
/* JADX INFO: loaded from: classes2.dex */
class C0896t extends OnResponseListener<PageData<GroupInfo>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Context f10014a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ v f10015b;

    C0896t(v vVar, Context context) {
        this.f10015b = vVar;
        this.f10014a = context;
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onError(int i, String str) {
        GroupOnError.showErrorTip(this.f10014a, i);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onServerError(int i) {
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onSuccess(PageData<GroupInfo> pageData) {
        if (pageData != null && pageData.getData() != null && pageData.getData().size() != 0 && !String.valueOf(pageData.getData().size()).equals("0")) {
            ReportDataAdapter.onEvent(this.f10014a, EventConstant.GROUP_HAS_GROUP, String.valueOf(pageData.getData().size()));
        }
        GroupUtilsProxy.getInstance().setTribeId(TribeCenter.newInstance().tribeClanId.get().longValue());
        GroupUtilsProxy.getInstance().setUserId(AccountCenter.newInstance().userId.get().longValue());
    }
}
