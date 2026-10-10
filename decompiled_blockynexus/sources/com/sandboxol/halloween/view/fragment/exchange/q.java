package com.sandboxol.halloween.view.fragment.exchange;

import android.content.Context;
import com.sandboxol.center.router.manager.BillingManager;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.web.error.ServerOnError;
import com.sandboxol.halloween.view.fragment.exchange.r;

/* JADX INFO: compiled from: ExchangeModel.java */
/* JADX INFO: loaded from: classes4.dex */
class q extends OnResponseListener<Integer> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ r.a f18730a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ Context f18731b;

    q(r.a aVar, Context context) {
        this.f18730a = aVar;
        this.f18731b = context;
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onError(int i, String str) {
        com.sandboxol.halloween.web.h.a(this.f18731b, i);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onServerError(int i) {
        ServerOnError.showOnServerError(this.f18731b, i);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onSuccess(Integer num) {
        if (this.f18730a == null || num == null) {
            return;
        }
        BillingManager.getInstance().updateUserMoney(this.f18731b);
        this.f18730a.a(num.intValue());
    }
}
