package com.disabngo.blockynexus.view.activity.friends;

import android.app.Activity;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.web.error.FriendOnError;
import com.sandboxol.center.config.EventConstant;
import com.sandboxol.center.config.MessageToken;
import com.sandboxol.center.config.StringConstant;
import com.sandboxol.center.router.moduleInfo.pay.BroadcastType;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.interfaces.ReportDataAdapter;
import com.sandboxol.common.messenger.Messenger;
import com.sandboxol.common.utils.AppToastUtils;
import com.sandboxol.common.web.error.ServerOnError;
import com.sandboxol.common.widget.rv.msg.RefreshMsg;
import com.sandboxol.messager.MessagerClient;

/* JADX INFO: compiled from: FriendActivityModel.java */
/* JADX INFO: loaded from: classes2.dex */
class x extends OnResponseListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ long f10689a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ Activity f10690b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ F f10691c;

    x(F f2, long j, Activity activity) {
        this.f10691c = f2;
        this.f10689a = j;
        this.f10690b = activity;
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onError(int i, String str) {
        AppToastUtils.showShortPositiveTipToast(this.f10690b, R.string.agree_add_friend_failed);
        FriendOnError.showErrorTip(this.f10690b, i);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onServerError(int i) {
        AppToastUtils.showShortPositiveTipToast(this.f10690b, R.string.agree_add_friend_failed);
        ServerOnError.showOnServerError(this.f10690b, i);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onSuccess(Object obj) {
        com.sandboxol.messager.a.f fVar = new com.sandboxol.messager.a.f();
        fVar.b(StringConstant.FRIEND_INFO_ACTIVITY_FRIEND_ID, this.f10689a);
        MessagerClient.getIns().sendMsg1(BroadcastType.BROADCAST_REFRESH_FRIEND_APPLY_LIST, fVar);
        com.disabngo.blockynexus.utils.logic.N.a(this.f10690b, this.f10689a);
        Messenger.getDefault().send(RefreshMsg.create(), MessageToken.TOKEN_REFRESH_FRIEND_APPLY_LIST);
        AppToastUtils.showLongPositiveTipToast(this.f10690b, R.string.pass_friend_verify_success);
        this.f10690b.finish();
        ReportDataAdapter.onEvent(this.f10690b, EventConstant.CHAT_ACCEPT, "APP");
    }
}
