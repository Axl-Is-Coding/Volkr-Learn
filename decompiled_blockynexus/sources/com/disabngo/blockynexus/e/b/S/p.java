package com.disabngo.blockynexus.e.b.S;

import android.content.Context;
import com.sandboxol.center.entity.PartyCreateGameConfig;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.interfaces.OnDataListener;
import com.sandboxol.common.web.error.ServerOnError;

/* JADX INFO: compiled from: PartyCreateModel.java */
/* JADX INFO: loaded from: classes2.dex */
class p extends OnResponseListener<PartyCreateGameConfig> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ OnDataListener f9424a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ Context f9425b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ t f9426c;

    p(t tVar, OnDataListener onDataListener, Context context) {
        this.f9426c = tVar;
        this.f9424a = onDataListener;
        this.f9425b = context;
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onSuccess(PartyCreateGameConfig partyCreateGameConfig) {
        this.f9424a.onSuccess(partyCreateGameConfig);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onError(int i, String str) {
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onServerError(int i) {
        ServerOnError.showOnServerError(this.f9425b, i);
    }
}
