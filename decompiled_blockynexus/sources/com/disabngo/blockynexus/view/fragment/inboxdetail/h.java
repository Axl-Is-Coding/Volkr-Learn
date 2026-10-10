package com.disabngo.blockynexus.view.fragment.inboxdetail;

import com.disabngo.blockynexus.R;
import com.sandboxol.center.config.MessageToken;
import com.sandboxol.center.router.manager.BillingManager;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.messenger.Messenger;
import com.sandboxol.common.utils.AppToastUtils;
import com.sandboxol.common.widget.rv.msg.RefreshMsg;

/* JADX INFO: compiled from: InboxDetailViewModel.java */
/* JADX INFO: loaded from: classes2.dex */
class h extends OnResponseListener<String> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ k f11745a;

    h(k kVar) {
        this.f11745a = kVar;
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onError(int i, String str) {
        this.f11745a.j.set(true);
        if (i == 10) {
            AppToastUtils.showLongNegativeTipToast(this.f11745a.f11748a, R.string.email_attachment_has_received);
            this.f11745a.h.set(2);
            k kVar = this.f11745a;
            kVar.i.set(kVar.f11748a.getString(R.string.delete));
        } else {
            AppToastUtils.showLongNegativeTipToast(this.f11745a.f11748a, R.string.email_attachment_received_failed);
        }
        Messenger.getDefault().send(RefreshMsg.create(), MessageToken.TOKEN_REFRESH_INBOX);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onServerError(int i) {
        this.f11745a.j.set(true);
        AppToastUtils.showLongNegativeTipToast(this.f11745a.f11748a, R.string.email_attachment_received_failed);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onSuccess(String str) {
        this.f11745a.j.set(true);
        this.f11745a.m();
        this.f11745a.h.set(2);
        k kVar = this.f11745a;
        kVar.i.set(kVar.f11748a.getString(R.string.delete));
        Messenger.getDefault().send(RefreshMsg.create(), MessageToken.TOKEN_REFRESH_INBOX);
        BillingManager.getInstance().updateUserMoney(this.f11745a.f11748a);
    }
}
