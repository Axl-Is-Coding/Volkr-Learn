package com.disabngo.blockynexus.e.b.ma;

import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.web.error.TribeOnError;
import com.sandboxol.center.config.EventConstant;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.interfaces.ReportDataAdapter;
import com.sandboxol.common.messenger.Messenger;
import com.sandboxol.common.utils.AppToastUtils;
import com.sandboxol.common.web.error.ServerOnError;
import com.sandboxol.imchat.config.ChatMessageToken;

/* JADX INFO: compiled from: TribeDetailViewModel.java */
/* JADX INFO: loaded from: classes2.dex */
class i extends OnResponseListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ j f9945a;

    i(j jVar) {
        this.f9945a = jVar;
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onError(int i, String str) {
        TribeOnError.showErrorTip(this.f9945a.f9946a.f9949a, i);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onServerError(int i) {
        ServerOnError.showOnServerError(this.f9945a.f9946a.f9949a, i);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onSuccess(Object obj) {
        if (this.f9945a.f9946a.f9954f.get().getFreeVerify() == 1) {
            Messenger.getDefault().send(true, ChatMessageToken.TOKEN_TRIBE_JOIN_OR_EXIT);
            AppToastUtils.showShortPositiveTipToast(this.f9945a.f9946a.f9949a, R.string.tribe_joined);
        } else {
            AppToastUtils.showShortPositiveTipToast(this.f9945a.f9946a.f9949a, R.string.tribe_request_join_success);
        }
        ReportDataAdapter.onEvent(this.f9945a.f9946a.f9949a, EventConstant.CLAN_DETAIL_PAGE_CLICK_ENTER_SUC, this.f9945a.f9946a.f9950b);
    }
}
