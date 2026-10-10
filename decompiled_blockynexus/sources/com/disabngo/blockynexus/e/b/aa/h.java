package com.disabngo.blockynexus.e.b.aa;

import com.sandboxol.center.entity.ReportRequest;
import com.sandboxol.center.router.moduleInfo.pay.BroadcastType;
import com.sandboxol.center.web.UserOnError;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.web.error.ServerOnError;
import com.sandboxol.messager.MessagerClient;
import java.util.ArrayList;

/* JADX INFO: compiled from: ReportDetailViewModel.java */
/* JADX INFO: loaded from: classes2.dex */
class h extends OnResponseListener<String> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ ArrayList f9636a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ ArrayList f9637b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ g f9638c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ long f9639d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final /* synthetic */ String f9640e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ int[] f9641f;
    final /* synthetic */ i g;

    h(i iVar, ArrayList arrayList, ArrayList arrayList2, g gVar, long j, String str, int[] iArr) {
        this.g = iVar;
        this.f9636a = arrayList;
        this.f9637b = arrayList2;
        this.f9638c = gVar;
        this.f9639d = j;
        this.f9640e = str;
        this.f9641f = iArr;
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onError(int i, String str) {
        MessagerClient.getIns().sendMsg0(BroadcastType.BROADCAST_CLOSE_LOADING_DIALOG);
        if (this.f9641f[0] != i) {
            UserOnError.showErrorTip(this.g.f9642a, i);
            this.f9641f[0] = i;
        }
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onServerError(int i) {
        MessagerClient.getIns().sendMsg0(BroadcastType.BROADCAST_CLOSE_LOADING_DIALOG);
        ServerOnError.showOnServerError(this.g.f9642a, i);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onSuccess(String str) {
        this.f9636a.add(str);
        if (this.f9636a.size() == this.f9637b.size()) {
            this.f9638c.a(this.g.f9642a, new ReportRequest(this.f9639d, this.g.f9643b, this.f9640e, this.f9636a));
        }
    }
}
