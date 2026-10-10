package com.disabngo.blockynexus.e.b.qa;

import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.web.error.TribeOnError;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.utils.AppToastUtils;
import com.sandboxol.common.utils.SharedUtils;
import com.sandboxol.common.web.error.ServerOnError;

/* JADX INFO: compiled from: TribeNoticeViewModel.java */
/* JADX INFO: loaded from: classes2.dex */
class c extends OnResponseListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ d f10096a;

    c(d dVar) {
        this.f10096a = dVar;
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onError(int i, String str) {
        TribeOnError.showErrorTip(this.f10096a.f10097a, i);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onServerError(int i) {
        ServerOnError.showOnServerError(this.f10096a.f10097a, i);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onSuccess(Object obj) {
        SharedUtils.putString(this.f10096a.f10097a, "tribe.notice.content", this.f10096a.f10098b.get());
        AppToastUtils.showShortPositiveTipToast(this.f10096a.f10097a, R.string.tribe_modify_success);
        if (this.f10096a.f10097a.isFinishing()) {
            return;
        }
        this.f10096a.f10097a.finish();
    }
}
