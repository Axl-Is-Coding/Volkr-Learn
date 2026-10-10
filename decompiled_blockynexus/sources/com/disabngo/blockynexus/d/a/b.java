package com.disabngo.blockynexus.d.a;

import android.util.Log;
import com.sandboxol.center.entity.DecorationResourcesResponse;
import com.sandboxol.center.utils.AppSharedUtils;
import com.sandboxol.common.base.web.OnResponseListener;

/* JADX INFO: compiled from: DressDownloadUtils.java */
/* JADX INFO: loaded from: classes2.dex */
class b extends OnResponseListener<DecorationResourcesResponse> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ com.disabngo.blockynexus.interfaces.a f7204a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ com.disabngo.blockynexus.interfaces.a f7205b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ long f7206c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ e f7207d;

    b(e eVar, com.disabngo.blockynexus.interfaces.a aVar, com.disabngo.blockynexus.interfaces.a aVar2, long j) {
        this.f7207d = eVar;
        this.f7204a = aVar;
        this.f7205b = aVar2;
        this.f7206c = j;
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onSuccess(DecorationResourcesResponse decorationResourcesResponse) {
        Log.d("DressDownload&Unzip", "check dress res success");
        com.disabngo.blockynexus.interfaces.a aVar = this.f7204a;
        if (aVar != null) {
            aVar.a();
        }
        if (!decorationResourcesResponse.isNeedUpdate()) {
            this.f7205b.a(this.f7206c);
            return;
        }
        e eVar = this.f7207d;
        eVar.a(eVar.f7214b, decorationResourcesResponse, this.f7204a == null, this.f7205b);
        AppSharedUtils.newInstance().putDecorationResourcesResponse(decorationResourcesResponse);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onError(int i, String str) {
        this.f7205b.a(0L);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onServerError(int i) {
        this.f7205b.a(0L);
    }
}
