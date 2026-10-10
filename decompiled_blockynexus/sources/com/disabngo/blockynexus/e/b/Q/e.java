package com.disabngo.blockynexus.e.b.Q;

import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.entity.FriendRequests;
import com.disabngo.blockynexus.web.error.FriendOnError;
import com.sandboxol.center.config.EventConstant;
import com.sandboxol.common.base.viewmodel.ListItemViewModel;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.interfaces.ReportDataAdapter;
import com.sandboxol.common.messenger.Messenger;
import com.sandboxol.common.utils.AppToastUtils;
import com.sandboxol.common.web.error.ServerOnError;
import com.sandboxol.imchat.config.ChatMessageToken;

/* JADX INFO: compiled from: NewFriendItemViewModel.java */
/* JADX INFO: loaded from: classes2.dex */
class e extends OnResponseListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ g f9398a;

    e(g gVar) {
        this.f9398a = gVar;
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onError(int i, String str) {
        AppToastUtils.showShortPositiveTipToast(((ListItemViewModel) this.f9398a).context, R.string.refuse_add_friend_failed);
        FriendOnError.showErrorTip(((ListItemViewModel) this.f9398a).context, i);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onServerError(int i) {
        AppToastUtils.showShortPositiveTipToast(((ListItemViewModel) this.f9398a).context, R.string.refuse_add_friend_failed);
        ServerOnError.showOnServerError(((ListItemViewModel) this.f9398a).context, i);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onSuccess(Object obj) {
        g gVar = this.f9398a;
        gVar.f9403d.set(((ListItemViewModel) gVar).context.getString(R.string.refuse_add_friend));
        this.f9398a.f9404e.set(true);
        Messenger.getDefault().send(Long.valueOf(((FriendRequests) ((ListItemViewModel) this.f9398a).item).getUserId()), ChatMessageToken.TOKEN_CHAT_NEW_FRIEND_REMOVE);
        AppToastUtils.showShortPositiveTipToast(((ListItemViewModel) this.f9398a).context, R.string.refuse_add_friend);
        ReportDataAdapter.onEvent(((ListItemViewModel) this.f9398a).context, EventConstant.CHAT_REFUSE);
    }
}
