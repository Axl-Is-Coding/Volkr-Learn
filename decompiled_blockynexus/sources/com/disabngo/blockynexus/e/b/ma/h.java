package com.disabngo.blockynexus.e.b.ma;

import android.content.Context;
import com.sandboxol.center.config.MessageToken;
import com.sandboxol.center.entity.TribeDetail;
import com.sandboxol.center.router.moduleInfo.pay.BroadcastType;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.messenger.Messenger;
import com.sandboxol.common.web.error.ServerOnError;
import com.sandboxol.common.widget.rv.msg.RefreshMsg;
import com.sandboxol.messager.MessagerClient;

/* JADX INFO: compiled from: TribeDetailViewModel.java */
/* JADX INFO: loaded from: classes2.dex */
class h extends OnResponseListener<TribeDetail> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Context f9943a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ m f9944b;

    h(m mVar, Context context) {
        this.f9944b = mVar;
        this.f9943a = context;
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onSuccess(TribeDetail tribeDetail) {
        this.f9944b.f9954f.set(tribeDetail);
        this.f9944b.f9953e.addAll(tribeDetail.getTags());
        m mVar = this.f9944b;
        mVar.g.setData(mVar.f9953e);
        m mVar2 = this.f9944b;
        mVar2.h.set(mVar2.f());
        this.f9944b.j.a(tribeDetail.getClanMembers());
        Messenger.getDefault().send(RefreshMsg.create(), MessageToken.TOKEN_REFRESH_TRIBE_INFO_MEMBERS);
        MessagerClient.getIns().sendMsg0(BroadcastType.BROADCAST_CLOSE_LOADING_DIALOG);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onError(int i, String str) {
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onServerError(int i) {
        ServerOnError.showOnServerError(this.f9943a, i);
    }
}
