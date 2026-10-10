package com.disabngo.blockynexus.e.b.x;

import android.text.TextUtils;
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
class x extends OnResponseListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f10319a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ C0934B f10320b;

    x(C0934B c0934b, String str) {
        this.f10320b = c0934b;
        this.f10319a = str;
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onError(int i, String str) {
        AppToastUtils.showShortNegativeTipToast(((ListItemViewModel) this.f10320b).context, R.string.friend_add_note_failed);
        FriendOnError.showErrorTip(((ListItemViewModel) this.f10320b).context, i);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onServerError(int i) {
        AppToastUtils.showShortNegativeTipToast(((ListItemViewModel) this.f10320b).context, R.string.friend_add_note_failed);
        ServerOnError.showOnServerError(((ListItemViewModel) this.f10320b).context, i);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onSuccess(Object obj) {
        AppToastUtils.showLongPositiveTipToast(((ListItemViewModel) this.f10320b).context, R.string.friend_add_note_success);
        com.sandboxol.messager.a.f fVar = new com.sandboxol.messager.a.f();
        if (!TextUtils.isEmpty(this.f10319a)) {
            fVar.b("friend.alias", this.f10319a);
            fVar.b("friend.id", ((Friend) ((ListItemViewModel) this.f10320b).item).getUserId());
            fVar.b("friend.type", 1);
        }
        MessagerClient.getIns().sendMsg1(BroadcastType.BROADCAST_REFRESH_FRIEND_LIST, fVar);
        ReportDataAdapter.onEvent(((ListItemViewModel) this.f10320b).context, EventConstant.CHAT_REMARK);
    }
}
