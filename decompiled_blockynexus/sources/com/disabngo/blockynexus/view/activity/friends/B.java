package com.disabngo.blockynexus.view.activity.friends;

import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.web.error.FriendOnError;
import com.sandboxol.center.config.EventConstant;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.interfaces.ReportDataAdapter;
import com.sandboxol.common.utils.AppToastUtils;
import com.sandboxol.common.web.error.ServerOnError;

/* JADX INFO: compiled from: FriendActivityModel.java */
/* JADX INFO: loaded from: classes2.dex */
class B extends OnResponseListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ C f10628a;

    B(C c2) {
        this.f10628a = c2;
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onError(int i, String str) {
        FriendOnError.showErrorTip(this.f10628a.f10630b, i);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onServerError(int i) {
        ServerOnError.showOnServerError(this.f10628a.f10630b, i);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onSuccess(Object obj) {
        AppToastUtils.showLongPositiveTipToast(this.f10628a.f10630b, R.string.send_apply_for_friend_success);
        this.f10628a.f10630b.finish();
        ReportDataAdapter.onEvent(this.f10628a.f10630b, EventConstant.CHAT_ADD_FRIEND, "APP");
    }
}
