package com.sandboxol.vip.d.a.a;

import com.sandboxol.center.entity.VipSubInfo;
import com.sandboxol.center.utils.VipDataManager;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.dialog.FullScreenDialog;
import com.sandboxol.common.messenger.Messenger;
import com.sandboxol.common.web.error.ServerOnError;
import com.sandboxol.common.widget.rv.msg.RefreshMsg;

/* JADX INFO: compiled from: SubscribeBottomDialog.java */
/* JADX INFO: loaded from: classes4.dex */
class i extends OnResponseListener<VipSubInfo> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ j f19052a;

    i(j jVar) {
        this.f19052a = jVar;
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onSuccess(VipSubInfo vipSubInfo) {
        VipDataManager.getInstance().setVipSubInfo(vipSubInfo);
        if (this.f19052a.f19054b.get() != null) {
            int level = this.f19052a.f19054b.get().getLevel();
            this.f19052a.f19056d.set(Boolean.valueOf(com.sandboxol.vip.c.a.d(level)));
            j jVar = this.f19052a;
            jVar.f19054b.set(com.sandboxol.vip.c.a.a(jVar.f19056d.get().booleanValue(), level));
        }
        Messenger.getDefault().sendNoMsg("token.refresh.vip.info");
        Messenger.getDefault().send(RefreshMsg.create(), "token.refresh.subscribe.bottom.list");
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onError(int i, String str) {
        ServerOnError.showOnServerError(((FullScreenDialog) this.f19052a).context, i);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onServerError(int i) {
        ServerOnError.showOnServerError(((FullScreenDialog) this.f19052a).context, i);
    }
}
