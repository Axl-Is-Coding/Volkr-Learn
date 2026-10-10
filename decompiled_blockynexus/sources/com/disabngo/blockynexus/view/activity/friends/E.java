package com.disabngo.blockynexus.view.activity.friends;

import android.app.Activity;
import com.disabngo.blockynexus.R;
import com.sandboxol.center.config.EventConstant;
import com.sandboxol.center.router.moduleInfo.pay.BroadcastType;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.interfaces.ReportDataAdapter;
import com.sandboxol.common.utils.AppToastUtils;
import com.sandboxol.messager.MessagerClient;

/* JADX INFO: compiled from: FriendActivityModel.java */
/* JADX INFO: loaded from: classes2.dex */
class E extends OnResponseListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ long f10636a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ Activity f10637b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ F f10638c;

    E(F f2, long j, Activity activity) {
        this.f10638c = f2;
        this.f10636a = j;
        this.f10637b = activity;
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onError(int i, String str) {
        AppToastUtils.showShortNegativeTipToast(this.f10637b, R.string.add_blacklist_fail);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onServerError(int i) {
        AppToastUtils.showShortNegativeTipToast(this.f10637b, R.string.add_blacklist_fail);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onSuccess(Object obj) {
        com.sandboxol.messager.a.f fVar = new com.sandboxol.messager.a.f();
        fVar.b("friend.type", 4);
        fVar.b("friend.id", this.f10636a);
        fVar.b("friend.alias", "");
        MessagerClient.getIns().sendMsg1(BroadcastType.BROADCAST_REFRESH_FRIEND_LIST, fVar);
        AppToastUtils.showShortPositiveTipToast(this.f10637b, R.string.add_blacklist_success);
        if (!this.f10637b.isFinishing()) {
            this.f10637b.finish();
        }
        ReportDataAdapter.onEvent(this.f10637b, EventConstant.CHAT_ADD_BLACKLIST);
    }
}
