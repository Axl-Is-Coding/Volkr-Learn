package com.disabngo.blockynexus.view.fragment.tribehas;

import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.web.error.TribeOnError;
import com.sandboxol.center.config.MessageToken;
import com.sandboxol.common.base.viewmodel.ListItemViewModel;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.messenger.Messenger;
import com.sandboxol.common.utils.AppToastUtils;
import com.sandboxol.common.web.error.ServerOnError;
import com.sandboxol.common.widget.rv.msg.RefreshMsg;

/* JADX INFO: compiled from: TribeHasItemViewModel.java */
/* JADX INFO: loaded from: classes2.dex */
class I extends OnResponseListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ J f11972a;

    I(J j) {
        this.f11972a = j;
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onError(int i, String str) {
        TribeOnError.showErrorTip(((ListItemViewModel) this.f11972a).context, i);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onServerError(int i) {
        ServerOnError.showOnServerError(((ListItemViewModel) this.f11972a).context, i);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onSuccess(Object obj) {
        AppToastUtils.showShortPositiveTipToast(((ListItemViewModel) this.f11972a).context, R.string.tribe_remove_member_success);
        Messenger.getDefault().send(RefreshMsg.create(), MessageToken.TOKEN_TRIBE_MEMBER);
    }
}
