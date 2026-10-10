package com.disabngo.blockynexus.e.b.Q;

import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.entity.FriendRequests;
import com.disabngo.blockynexus.utils.logic.N;
import com.disabngo.blockynexus.web.error.FriendOnError;
import com.sandboxol.center.config.EventConstant;
import com.sandboxol.center.utils.IntentUtils;
import com.sandboxol.common.base.viewmodel.ListItemViewModel;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.interfaces.ReportDataAdapter;
import com.sandboxol.common.messenger.Messenger;
import com.sandboxol.common.utils.AppToastUtils;
import com.sandboxol.common.web.error.ServerOnError;
import com.sandboxol.common.widget.rv.msg.RefreshMsg;
import com.sandboxol.imchat.config.ChatMessageToken;

/* JADX INFO: compiled from: NewFriendItemViewModel.java */
/* JADX INFO: loaded from: classes2.dex */
class f extends OnResponseListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ g f9399a;

    f(g gVar) {
        this.f9399a = gVar;
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onError(int i, String str) {
        AppToastUtils.showShortPositiveTipToast(((ListItemViewModel) this.f9399a).context, R.string.agree_add_friend_failed);
        FriendOnError.showErrorTip(((ListItemViewModel) this.f9399a).context, i);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onServerError(int i) {
        AppToastUtils.showShortPositiveTipToast(((ListItemViewModel) this.f9399a).context, R.string.agree_add_friend_failed);
        ServerOnError.showOnServerError(((ListItemViewModel) this.f9399a).context, i);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onSuccess(Object obj) {
        g gVar = this.f9399a;
        gVar.f9403d.set(((ListItemViewModel) gVar).context.getString(R.string.agree_add_friend));
        this.f9399a.f9404e.set(true);
        N.a(((ListItemViewModel) this.f9399a).context, ((FriendRequests) ((ListItemViewModel) this.f9399a).item).getUserId());
        Messenger.getDefault().send(RefreshMsg.create(), "token.refresh.friend.list");
        Messenger.getDefault().send(Long.valueOf(((FriendRequests) ((ListItemViewModel) this.f9399a).item).getUserId()), ChatMessageToken.TOKEN_CHAT_NEW_FRIEND_REMOVE);
        AppToastUtils.showShortPositiveTipToast(((ListItemViewModel) this.f9399a).context, R.string.agree_add_friend);
        ReportDataAdapter.onEvent(((ListItemViewModel) this.f9399a).context, EventConstant.CHAT_ACCEPT, "APP");
        IntentUtils.startPasswordSettingDialog(((ListItemViewModel) this.f9399a).context, false);
    }
}
