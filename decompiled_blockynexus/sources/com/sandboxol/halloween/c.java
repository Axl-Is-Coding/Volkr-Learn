package com.sandboxol.halloween;

import android.content.Context;
import android.content.Intent;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.halloween.entity.HalloweenInfoResponse;
import com.sandboxol.halloween.view.activity.HalloweenHomeActivity;

/* JADX INFO: compiled from: HalloweenService.java */
/* JADX INFO: loaded from: classes4.dex */
class c extends OnResponseListener<HalloweenInfoResponse> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Context f18642a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ HalloweenService f18643b;

    c(HalloweenService halloweenService, Context context) {
        this.f18643b = halloweenService;
        this.f18642a = context;
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onSuccess(HalloweenInfoResponse halloweenInfoResponse) {
        if (halloweenInfoResponse == null || halloweenInfoResponse.getStatus() == 0 || halloweenInfoResponse.getStatus() == 3) {
            return;
        }
        com.sandboxol.halloween.c.b.b().a(halloweenInfoResponse);
        this.f18642a.startActivity(new Intent(this.f18642a, (Class<?>) HalloweenHomeActivity.class));
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onError(int i, String str) {
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onServerError(int i) {
    }
}
