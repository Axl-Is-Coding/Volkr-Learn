package com.disabngo.blockynexus.view.activity.main;

import android.content.Context;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.web.error.ServerOnError;
import com.sandboxol.decorate.entity.DressExpireInfo;
import java.util.List;

/* JADX INFO: compiled from: MainModel.java */
/* JADX INFO: loaded from: classes2.dex */
class Pb extends OnResponseListener<List<DressExpireInfo>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Context f10819a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ bc f10820b;

    Pb(bc bcVar, Context context) {
        this.f10820b = bcVar;
        this.f10819a = context;
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onError(int i, String str) {
        com.sandboxol.decorate.web.u.a(this.f10819a, i);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onServerError(int i) {
        ServerOnError.showOnServerError(this.f10819a, i);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onSuccess(List<DressExpireInfo> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        new com.sandboxol.decorate.view.dialog.b.c(this.f10819a, list).show();
    }
}
