package com.disabngo.blockynexus.view.activity.friends;

import android.content.Context;
import android.text.TextUtils;
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
class z extends OnResponseListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Context f10696a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ String f10697b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ Friend f10698c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ FriendActivityIntentInfo f10699d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final /* synthetic */ F f10700e;

    z(F f2, Context context, String str, Friend friend, FriendActivityIntentInfo friendActivityIntentInfo) {
        this.f10700e = f2;
        this.f10696a = context;
        this.f10697b = str;
        this.f10698c = friend;
        this.f10699d = friendActivityIntentInfo;
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onError(int i, String str) {
        AppToastUtils.showShortNegativeTipToast(this.f10696a, R.string.friend_add_note_failed);
        FriendOnError.showErrorTip(this.f10696a, i);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onServerError(int i) {
        AppToastUtils.showShortNegativeTipToast(this.f10696a, R.string.friend_add_note_failed);
        ServerOnError.showOnServerError(this.f10696a, i);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onSuccess(Object obj) {
        AppToastUtils.showLongPositiveTipToast(this.f10696a, R.string.friend_add_note_success);
        com.sandboxol.messager.a.f fVar = new com.sandboxol.messager.a.f();
        if (!TextUtils.isEmpty(this.f10697b)) {
            this.f10698c.setAlias(this.f10697b);
            fVar.b("friend.alias", this.f10697b);
            fVar.b("friend.id", this.f10699d.getFriendId());
            fVar.b("friend.type", 1);
        }
        MessagerClient.getIns().sendMsg1(BroadcastType.BROADCAST_REFRESH_FRIEND_LIST, fVar);
        ReportDataAdapter.onEvent(this.f10696a, EventConstant.CHAT_REMARK);
    }
}
