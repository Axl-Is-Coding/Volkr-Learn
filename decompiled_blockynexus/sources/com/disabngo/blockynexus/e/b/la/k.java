package com.disabngo.blockynexus.e.b.la;

import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.entity.TribeClanRequest;
import com.disabngo.blockynexus.web.error.TribeOnError;
import com.sandboxol.center.config.MessageToken;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.messenger.Messenger;
import com.sandboxol.common.utils.AppToastUtils;
import com.sandboxol.common.web.error.ServerOnError;

/* JADX INFO: compiled from: TribeCreateModel.java */
/* JADX INFO: loaded from: classes2.dex */
class k extends OnResponseListener<TribeClanRequest> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ l f9916a;

    k(l lVar) {
        this.f9916a = lVar;
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onSuccess(TribeClanRequest tribeClanRequest) {
        this.f9916a.f9919c.set(true);
        AppToastUtils.showShortPositiveTipToast(this.f9916a.f9917a, R.string.tribe_modify_success);
        Messenger.getDefault().sendNoMsg(MessageToken.TOKEN_TRIBE_HAS);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onError(int i, String str) {
        this.f9916a.f9919c.set(true);
        TribeOnError.showErrorTip(this.f9916a.f9917a, i);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onServerError(int i) {
        this.f9916a.f9919c.set(true);
        ServerOnError.showOnServerError(this.f9916a.f9917a, i);
    }
}
