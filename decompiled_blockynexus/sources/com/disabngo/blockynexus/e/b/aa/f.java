package com.disabngo.blockynexus.e.b.aa;

import android.app.Activity;
import android.content.Context;
import com.disabngo.blockynexus.R;
import com.sandboxol.center.router.moduleInfo.pay.BroadcastType;
import com.sandboxol.center.web.UserOnError;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.utils.AppToastUtils;
import com.sandboxol.common.web.error.ServerOnError;
import com.sandboxol.messager.MessagerClient;

/* JADX INFO: compiled from: ReportDetailModel.java */
/* JADX INFO: loaded from: classes2.dex */
class f extends OnResponseListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Context f9634a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ g f9635b;

    f(g gVar, Context context) {
        this.f9635b = gVar;
        this.f9634a = context;
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onError(int i, String str) {
        MessagerClient.getIns().sendMsg0(BroadcastType.BROADCAST_CLOSE_LOADING_DIALOG);
        UserOnError.showErrorTip(this.f9634a, i);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onServerError(int i) {
        MessagerClient.getIns().sendMsg0(BroadcastType.BROADCAST_CLOSE_LOADING_DIALOG);
        ServerOnError.showOnServerError(this.f9634a, i);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onSuccess(Object obj) {
        MessagerClient.getIns().sendMsg0(BroadcastType.BROADCAST_CLOSE_LOADING_DIALOG);
        Context context = this.f9634a;
        AppToastUtils.showShortPositiveTipToast(context, context.getString(R.string.report_success));
        Context context2 = this.f9634a;
        if (!(context2 instanceof Activity) || ((Activity) context2).isFinishing()) {
            return;
        }
        ((Activity) this.f9634a).finish();
    }
}
