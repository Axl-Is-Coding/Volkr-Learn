package com.disabngo.blockynexus.e.b.x;

import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.web.error.FriendOnError;
import com.sandboxol.center.config.EventConstant;
import com.sandboxol.center.router.moduleInfo.pay.BroadcastType;
import com.sandboxol.common.base.viewmodel.ListItemViewModel;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.interfaces.ReportDataAdapter;
import com.sandboxol.common.utils.AppToastUtils;
import com.sandboxol.common.web.error.ServerOnError;
import com.sandboxol.greendao.entity.Friend;
import com.sandboxol.messager.MessagerClient;

/* JADX INFO: compiled from: FriendItemViewModel.java */
/* JADX INFO: loaded from: classes2.dex */
class y extends OnResponseListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ C0934B f10321a;

    y(C0934B c0934b) {
        this.f10321a = c0934b;
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onError(int i, String str) {
        AppToastUtils.showShortNegativeTipToast(((ListItemViewModel) this.f10321a).context, R.string.friend_add_note_failed);
        FriendOnError.showErrorTip(((ListItemViewModel) this.f10321a).context, i);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onServerError(int i) {
        AppToastUtils.showShortNegativeTipToast(((ListItemViewModel) this.f10321a).context, R.string.friend_add_note_failed);
        ServerOnError.showOnServerError(((ListItemViewModel) this.f10321a).context, i);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onSuccess(Object obj) {
        AppToastUtils.showLongPositiveTipToast(((ListItemViewModel) this.f10321a).context, R.string.friend_add_note_success);
        com.sandboxol.messager.a.f fVar = new com.sandboxol.messager.a.f();
        ((Friend) ((ListItemViewModel) this.f10321a).item).setAlias("");
        fVar.b("friend.alias", "");
        fVar.b("friend.id", ((Friend) ((ListItemViewModel) this.f10321a).item).getUserId());
        fVar.b("friend.type", 2);
        MessagerClient.getIns().sendMsg1(BroadcastType.BROADCAST_REFRESH_FRIEND_LIST, fVar);
        ReportDataAdapter.onEvent(((ListItemViewModel) this.f10321a).context, EventConstant.CHAT_REMARK);
    }
}
