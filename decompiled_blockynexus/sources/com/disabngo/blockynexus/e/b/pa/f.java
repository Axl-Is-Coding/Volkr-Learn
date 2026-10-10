package com.disabngo.blockynexus.e.b.pa;

import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.web.error.TribeOnError;
import com.sandboxol.center.config.MessageToken;
import com.sandboxol.common.base.viewmodel.ListItemViewModel;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.messenger.Messenger;
import com.sandboxol.common.utils.AppToastUtils;
import com.sandboxol.common.web.error.ServerOnError;
import com.sandboxol.common.widget.rv.msg.RefreshMsg;

/* JADX INFO: compiled from: TribeMessageItemViewModel.java */
/* JADX INFO: loaded from: classes2.dex */
class f extends OnResponseListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ i f10054a;

    f(i iVar) {
        this.f10054a = iVar;
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onError(int i, String str) {
        this.f10054a.f10059c.set(true);
        TribeOnError.showErrorTip(((ListItemViewModel) this.f10054a).context, i);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onServerError(int i) {
        this.f10054a.f10059c.set(true);
        ServerOnError.showOnServerError(((ListItemViewModel) this.f10054a).context, i);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onSuccess(Object obj) {
        this.f10054a.k();
        Messenger.getDefault().send(RefreshMsg.create(), MessageToken.TOKEN_TRIBE_MEMBER);
        AppToastUtils.showShortPositiveTipToast(((ListItemViewModel) this.f10054a).context, R.string.tribe_join_success);
    }
}
