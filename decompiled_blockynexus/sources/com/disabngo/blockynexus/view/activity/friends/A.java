package com.disabngo.blockynexus.view.activity.friends;

import android.content.Context;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.entity.FriendActivityIntentInfo;
import com.disabngo.blockynexus.web.error.FriendOnError;
import com.sandboxol.center.config.EventConstant;
import com.sandboxol.center.router.moduleInfo.pay.BroadcastType;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.interfaces.ReportDataAdapter;
import com.sandboxol.common.utils.AppToastUtils;
import com.sandboxol.common.web.error.ServerOnError;
import com.sandboxol.greendao.entity.Friend;
import com.sandboxol.messager.MessagerClient;

/* JADX INFO: compiled from: FriendActivityModel.java */
/* JADX INFO: loaded from: classes2.dex */
class A extends OnResponseListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Context f10624a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ Friend f10625b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ FriendActivityIntentInfo f10626c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ F f10627d;

    A(F f2, Context context, Friend friend, FriendActivityIntentInfo friendActivityIntentInfo) {
        this.f10627d = f2;
        this.f10624a = context;
        this.f10625b = friend;
        this.f10626c = friendActivityIntentInfo;
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onError(int i, String str) {
        AppToastUtils.showShortNegativeTipToast(this.f10624a, R.string.friend_add_note_failed);
        FriendOnError.showErrorTip(this.f10624a, i);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onServerError(int i) {
        AppToastUtils.showShortNegativeTipToast(this.f10624a, R.string.friend_add_note_failed);
        ServerOnError.showOnServerError(this.f10624a, i);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onSuccess(Object obj) {
        AppToastUtils.showLongPositiveTipToast(this.f10624a, R.string.friend_add_note_success);
        com.sandboxol.messager.a.f fVar = new com.sandboxol.messager.a.f();
        this.f10625b.setAlias("");
        fVar.b("friend.alias", "");
        fVar.b("friend.id", this.f10626c.getFriendId());
        fVar.b("friend.type", 2);
        MessagerClient.getIns().sendMsg1(BroadcastType.BROADCAST_REFRESH_FRIEND_LIST, fVar);
        ReportDataAdapter.onEvent(this.f10624a, EventConstant.CHAT_REMARK);
    }
}
