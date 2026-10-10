package com.disabngo.blockynexus.e.b.x;

import com.disabngo.blockynexus.R;
import com.sandboxol.center.config.EventConstant;
import com.sandboxol.center.router.moduleInfo.pay.BroadcastType;
import com.sandboxol.common.base.viewmodel.ListItemViewModel;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.interfaces.ReportDataAdapter;
import com.sandboxol.common.utils.AppToastUtils;
import com.sandboxol.greendao.entity.Friend;
import com.sandboxol.messager.MessagerClient;

/* JADX INFO: renamed from: com.disabngo.blockynexus.e.b.x.A, reason: case insensitive filesystem */
/* JADX INFO: compiled from: FriendItemViewModel.java */
/* JADX INFO: loaded from: classes2.dex */
class C0933A extends OnResponseListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ C0934B f10274a;

    C0933A(C0934B c0934b) {
        this.f10274a = c0934b;
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onError(int i, String str) {
        AppToastUtils.showShortNegativeTipToast(((ListItemViewModel) this.f10274a).context, R.string.add_blacklist_fail);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onServerError(int i) {
        AppToastUtils.showShortNegativeTipToast(((ListItemViewModel) this.f10274a).context, R.string.add_blacklist_fail);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onSuccess(Object obj) {
        com.sandboxol.messager.a.f fVar = new com.sandboxol.messager.a.f();
        fVar.b("friend.type", 4);
        fVar.b("friend.alias", ((Friend) ((ListItemViewModel) this.f10274a).item).getAlias());
        fVar.b("friend.id", ((Friend) ((ListItemViewModel) this.f10274a).item).getUserId());
        MessagerClient.getIns().sendMsg1(BroadcastType.BROADCAST_REFRESH_FRIEND_LIST, fVar);
        ReportDataAdapter.onEvent(((ListItemViewModel) this.f10274a).context, EventConstant.CHAT_ADD_BLACKLIST);
        AppToastUtils.showShortPositiveTipToast(((ListItemViewModel) this.f10274a).context, R.string.add_blacklist_success);
    }
}
