package com.disabngo.blockynexus.utils.logic;

import android.content.Context;
import com.disabngo.blockynexus.R;
import com.sandboxol.center.config.EventConstant;
import com.sandboxol.center.router.moduleInfo.pay.BroadcastType;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.interfaces.ReportDataAdapter;
import com.sandboxol.common.utils.AppToastUtils;
import com.sandboxol.messager.MessagerClient;
import io.rong.imkit.model.UIConversation;

/* JADX INFO: compiled from: RongIMLogic.java */
/* JADX INFO: loaded from: classes2.dex */
class G extends OnResponseListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ UIConversation f10524a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ long f10525b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ Context f10526c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ I f10527d;

    G(I i, UIConversation uIConversation, long j, Context context) {
        this.f10527d = i;
        this.f10524a = uIConversation;
        this.f10525b = j;
        this.f10526c = context;
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onError(int i, String str) {
        AppToastUtils.showShortNegativeTipToast(this.f10526c, R.string.add_blacklist_fail);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onServerError(int i) {
        AppToastUtils.showShortNegativeTipToast(this.f10526c, R.string.add_blacklist_fail);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onSuccess(Object obj) {
        com.sandboxol.messager.a.f fVar = new com.sandboxol.messager.a.f();
        fVar.b("friend.type", 4);
        fVar.b("friend.alias", this.f10524a.getUIConversationTitle());
        fVar.b("friend.id", this.f10525b);
        MessagerClient.getIns().sendMsg1(BroadcastType.BROADCAST_REFRESH_FRIEND_LIST, fVar);
        AppToastUtils.showShortPositiveTipToast(this.f10526c, R.string.add_blacklist_success);
        ReportDataAdapter.onEvent(this.f10526c, EventConstant.CHAT_ADD_BLACKLIST);
    }
}
