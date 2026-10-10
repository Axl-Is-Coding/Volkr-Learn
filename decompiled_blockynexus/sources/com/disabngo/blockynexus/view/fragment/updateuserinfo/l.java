package com.disabngo.blockynexus.view.fragment.updateuserinfo;

import com.sandboxol.center.config.EventConstant;
import com.sandboxol.center.web.UserOnError;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.interfaces.ReportDataAdapter;
import com.sandboxol.common.web.error.ServerOnError;

/* JADX INFO: compiled from: UpdateUserInfoViewModel.java */
/* JADX INFO: loaded from: classes2.dex */
class l extends OnResponseListener<String> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ UpdateUserInfoViewModel f12066a;

    l(UpdateUserInfoViewModel updateUserInfoViewModel) {
        this.f12066a = updateUserInfoViewModel;
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onError(int i, String str) {
        UserOnError.showErrorTip(this.f12066a.f12048a, i);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onServerError(int i) {
        ServerOnError.showOnServerError(this.f12066a.f12048a, i);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onSuccess(String str) {
        this.f12066a.f12050c.setPicUrl(str);
        this.f12066a.f();
        ReportDataAdapter.onEvent(this.f12066a.f12048a, EventConstant.MORE_HEAD_SUC);
    }
}
