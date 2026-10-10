package com.disabngo.blockynexus.e.b.na;

import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.web.error.TribeOnError;
import com.sandboxol.center.config.EventConstant;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.interfaces.ReportDataAdapter;
import com.sandboxol.common.utils.AppToastUtils;
import com.sandboxol.common.web.error.ServerOnError;

/* JADX INFO: compiled from: TribeInviteFriendViewModel.java */
/* JADX INFO: loaded from: classes2.dex */
class i extends OnResponseListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ j f9980a;

    i(j jVar) {
        this.f9980a = jVar;
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onError(int i, String str) {
        this.f9980a.f9983c.set(true);
        TribeOnError.showErrorTip(this.f9980a.f9981a, i);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onServerError(int i) {
        this.f9980a.f9983c.set(true);
        ServerOnError.showOnServerError(this.f9980a.f9981a, i);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onSuccess(Object obj) {
        this.f9980a.f9983c.set(true);
        AppToastUtils.showShortPositiveTipToast(this.f9980a.f9981a, R.string.tribe_invite_success);
        if (this.f9980a.f9982b && !this.f9980a.f9981a.isFinishing()) {
            this.f9980a.f9981a.finish();
        }
        ReportDataAdapter.onEvent(this.f9980a.f9981a, EventConstant.CLAN_INVITE_MEMBER_CLICK);
    }
}
