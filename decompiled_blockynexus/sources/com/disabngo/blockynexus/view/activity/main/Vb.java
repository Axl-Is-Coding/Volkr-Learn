package com.disabngo.blockynexus.view.activity.main;

import android.content.Context;
import com.disabngo.blockynexus.view.activity.main.bc;
import com.sandboxol.center.entity.LatestVersion;
import com.sandboxol.common.base.web.OnResponseListener;

/* JADX INFO: compiled from: MainModel.java */
/* JADX INFO: loaded from: classes2.dex */
class Vb extends OnResponseListener<LatestVersion> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ bc.a f10850a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ Context f10851b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ bc f10852c;

    Vb(bc bcVar, bc.a aVar, Context context) {
        this.f10852c = bcVar;
        this.f10850a = aVar;
        this.f10851b = context;
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onSuccess(LatestVersion latestVersion) {
        if (latestVersion.getStatus() == 0 || latestVersion.getStatus() == 1 || latestVersion.getStatus() == 2) {
            this.f10852c.a(this.f10851b, latestVersion, false);
        } else {
            this.f10850a.a();
        }
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onError(int i, String str) {
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onServerError(int i) {
    }
}
