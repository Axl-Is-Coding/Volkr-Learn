package com.disabngo.blockynexus.e.b.x;

import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.web.error.FriendOnError;
import com.sandboxol.center.config.EventConstant;
import com.sandboxol.center.config.MessageToken;
import com.sandboxol.center.router.moduleInfo.pay.BroadcastType;
import com.sandboxol.common.base.viewmodel.ListItemViewModel;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.interfaces.ReportDataAdapter;
import com.sandboxol.common.messenger.Messenger;
import com.sandboxol.common.utils.AppToastUtils;
import com.sandboxol.common.web.error.ServerOnError;
import com.sandboxol.greendao.entity.Friend;
import com.sandboxol.messager.MessagerClient;

/* JADX INFO: compiled from: FriendItemViewModel.java */
/* JADX INFO: loaded from: classes2.dex */
class z extends OnResponseListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ C0934B f10322a;

    z(C0934B c0934b) {
        this.f10322a = c0934b;
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onError(int i, String str) {
        AppToastUtils.showLongNegativeTipToast(((ListItemViewModel) this.f10322a).context, R.string.delete_friend_failed);
        FriendOnError.showErrorTip(((ListItemViewModel) this.f10322a).context, i);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onServerError(int i) {
        AppToastUtils.showLongNegativeTipToast(((ListItemViewModel) this.f10322a).context, R.string.delete_friend_failed);
        ServerOnError.showOnServerError(((ListItemViewModel) this.f10322a).context, i);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onSuccess(Object obj) {
        com.sandboxol.messager.a.f fVar = new com.sandboxol.messager.a.f();
        fVar.b("friend.type", 3);
        fVar.b("friend.alias", ((Friend) ((ListItemViewModel) this.f10322a).item).getAlias());
        fVar.b("friend.id", ((Friend) ((ListItemViewModel) this.f10322a).item).getUserId());
        MessagerClient.getIns().sendMsg1(BroadcastType.BROADCAST_REFRESH_FRIEND_LIST, fVar);
        Messenger.getDefault().sendNoMsg(MessageToken.TOKEN_REFRESH_FOLLOW_FRIENDS_LIST);
        ReportDataAdapter.onEvent(((ListItemViewModel) this.f10322a).context, EventConstant.CHAT_DELETE_FRIEND);
    }
}
