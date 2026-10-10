package com.sandboxol.halloween;

import android.content.Context;
import android.content.Intent;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.utils.AppToastUtils;
import com.sandboxol.common.web.error.ServerOnError;
import com.sandboxol.halloween.entity.HalloweenInfoResponse;
import com.sandboxol.halloween.view.activity.HalloweenHomeActivity;
import com.sandboxol.halloween.web.h;

/* JADX INFO: compiled from: HalloweenService.java */
/* JADX INFO: loaded from: classes4.dex */
class d extends OnResponseListener<HalloweenInfoResponse> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Context f18647a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ HalloweenService f18648b;

    d(HalloweenService halloweenService, Context context) {
        this.f18648b = halloweenService;
        this.f18647a = context;
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onSuccess(HalloweenInfoResponse halloweenInfoResponse) {
        if (halloweenInfoResponse != null) {
            if (halloweenInfoResponse.getStatus() == 0) {
                AppToastUtils.showShortNegativeTipToast(this.f18647a, R.string.halloween_error_8007);
            } else {
                if (halloweenInfoResponse.getStatus() == 3) {
                    AppToastUtils.showShortNegativeTipToast(this.f18647a, R.string.halloween_error_8006);
                    return;
                }
                com.sandboxol.halloween.c.b.b().a(halloweenInfoResponse);
                this.f18647a.startActivity(new Intent(this.f18647a, (Class<?>) HalloweenHomeActivity.class));
            }
        }
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onError(int i, String str) {
        h.a(this.f18647a, i);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onServerError(int i) {
        ServerOnError.showOnServerError(this.f18647a, i);
    }
}
