package com.disabngo.blockynexus.e.b.ma;

import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.web.error.TribeOnError;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.messenger.Messenger;
import com.sandboxol.common.utils.AppToastUtils;
import com.sandboxol.common.utils.SharedUtils;
import com.sandboxol.common.web.error.ServerOnError;
import com.sandboxol.imchat.config.ChatMessageToken;

/* JADX INFO: compiled from: TribeDetailViewModel.java */
/* JADX INFO: loaded from: classes2.dex */
class l extends OnResponseListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ m f9948a;

    l(m mVar) {
        this.f9948a = mVar;
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onError(int i, String str) {
        TribeOnError.showErrorTip(this.f9948a.f9949a, i);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onServerError(int i) {
        ServerOnError.showOnServerError(this.f9948a.f9949a, i);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onSuccess(Object obj) {
        AppToastUtils.showShortPositiveTipToast(this.f9948a.f9949a, R.string.tribe_removed_myself_success);
        SharedUtils.remove(this.f9948a.f9949a, "tribe.notice.content");
        Messenger.getDefault().send(false, ChatMessageToken.TOKEN_TRIBE_JOIN_OR_EXIT);
        if (this.f9948a.f9949a.isFinishing()) {
            return;
        }
        this.f9948a.f9949a.finish();
    }
}
