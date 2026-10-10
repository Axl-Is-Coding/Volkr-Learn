package com.disabngo.blockynexus.view.fragment.partyhall;

import android.content.Context;
import androidx.databinding.ObservableField;
import com.sandboxol.center.entity.PartyAuthInfo;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.interfaces.OnDataListener;
import com.sandboxol.common.web.error.ServerOnError;

/* JADX INFO: compiled from: PartyHallModel.java */
/* JADX INFO: loaded from: classes2.dex */
class x extends OnResponseListener<PartyAuthInfo> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ OnDataListener f11951a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ ObservableField f11952b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ Context f11953c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ E f11954d;

    x(E e2, OnDataListener onDataListener, ObservableField observableField, Context context) {
        this.f11954d = e2;
        this.f11951a = onDataListener;
        this.f11952b = observableField;
        this.f11953c = context;
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onError(int i, String str) {
        this.f11952b.set(false);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onServerError(int i) {
        this.f11952b.set(false);
        ServerOnError.showOnServerError(this.f11953c, i);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onSuccess(PartyAuthInfo partyAuthInfo) {
        this.f11951a.onSuccess(partyAuthInfo);
    }
}
