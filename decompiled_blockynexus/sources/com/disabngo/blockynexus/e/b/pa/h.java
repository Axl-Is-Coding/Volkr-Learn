package com.disabngo.blockynexus.e.b.pa;

import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.d.y;
import com.disabngo.blockynexus.web.error.TribeOnError;
import com.sandboxol.common.base.viewmodel.ListItemViewModel;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.messenger.Messenger;
import com.sandboxol.common.utils.AppToastUtils;
import com.sandboxol.common.web.error.ServerOnError;
import com.sandboxol.imchat.config.ChatMessageToken;

/* JADX INFO: compiled from: TribeMessageItemViewModel.java */
/* JADX INFO: loaded from: classes2.dex */
class h extends OnResponseListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ i f10056a;

    h(i iVar) {
        this.f10056a = iVar;
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onError(int i, String str) {
        this.f10056a.f10059c.set(true);
        y.b().b(false);
        TribeOnError.showErrorTip(((ListItemViewModel) this.f10056a).context, i);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onServerError(int i) {
        this.f10056a.f10059c.set(true);
        y.b().b(false);
        ServerOnError.showOnServerError(((ListItemViewModel) this.f10056a).context, i);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onSuccess(Object obj) {
        this.f10056a.k();
        Messenger.getDefault().send(true, ChatMessageToken.TOKEN_TRIBE_JOIN_OR_EXIT);
        AppToastUtils.showShortPositiveTipToast(((ListItemViewModel) this.f10056a).context, R.string.tribe_join_success);
    }
}
