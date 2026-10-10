package com.disabngo.blockynexus.view.activity.tribesearch;

import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.entity.TribeRecommendation;
import com.disabngo.blockynexus.web.error.TribeOnError;
import com.sandboxol.common.base.viewmodel.ListItemViewModel;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.messenger.Messenger;
import com.sandboxol.common.utils.AppToastUtils;
import com.sandboxol.common.web.error.ServerOnError;
import com.sandboxol.imchat.config.ChatMessageToken;

/* JADX INFO: compiled from: TribeSearchPageItemViewModel.java */
/* JADX INFO: loaded from: classes2.dex */
class g extends OnResponseListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ h f11133a;

    g(h hVar) {
        this.f11133a = hVar;
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onError(int i, String str) {
        TribeOnError.showErrorTip(((ListItemViewModel) this.f11133a).context, i);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onServerError(int i) {
        ServerOnError.showOnServerError(((ListItemViewModel) this.f11133a).context, i);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onSuccess(Object obj) {
        if (((TribeRecommendation) ((ListItemViewModel) this.f11133a).item).getFreeVerify() != 1) {
            AppToastUtils.showShortPositiveTipToast(((ListItemViewModel) this.f11133a).context, R.string.send_apply_for_friend_success);
        } else {
            Messenger.getDefault().send(true, ChatMessageToken.TOKEN_TRIBE_JOIN_OR_EXIT);
            AppToastUtils.showShortPositiveTipToast(((ListItemViewModel) this.f11133a).context, R.string.tribe_joined);
        }
    }
}
