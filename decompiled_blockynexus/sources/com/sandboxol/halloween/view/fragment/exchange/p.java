package com.sandboxol.halloween.view.fragment.exchange;

import android.content.Context;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.web.error.ServerOnError;
import com.sandboxol.halloween.entity.ExchangeResponse;
import com.sandboxol.halloween.view.fragment.exchange.r;

/* JADX INFO: compiled from: ExchangeModel.java */
/* JADX INFO: loaded from: classes4.dex */
class p extends OnResponseListener<ExchangeResponse> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ r.b f18728a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ Context f18729b;

    p(r.b bVar, Context context) {
        this.f18728a = bVar;
        this.f18729b = context;
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onSuccess(ExchangeResponse exchangeResponse) {
        r.b bVar;
        if (exchangeResponse == null || (bVar = this.f18728a) == null) {
            return;
        }
        bVar.a(exchangeResponse);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onError(int i, String str) {
        com.sandboxol.halloween.web.h.a(this.f18729b, i);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onServerError(int i) {
        ServerOnError.showOnServerError(this.f18729b, i);
    }
}
