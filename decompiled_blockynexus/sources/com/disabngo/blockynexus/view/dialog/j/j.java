package com.disabngo.blockynexus.view.dialog.j;

import android.content.Context;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.interfaces.OnViewClickListener;
import com.disabngo.blockynexus.view.dialog.DialogC1111pa;
import com.sandboxol.center.config.EventConstant;
import com.sandboxol.center.config.MessageToken;
import com.sandboxol.center.entity.DailySignInfo;
import com.sandboxol.center.router.manager.BillingManager;
import com.sandboxol.center.router.moduleInfo.pay.BroadcastType;
import com.sandboxol.center.view.dialog.CampaignGetIntegralRewardDialog;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.interfaces.ReportDataAdapter;
import com.sandboxol.common.messenger.Messenger;
import com.sandboxol.common.utils.AppToastUtils;
import com.sandboxol.messager.MessagerClient;

/* JADX INFO: compiled from: WeekSignModel.java */
/* JADX INFO: loaded from: classes2.dex */
class j extends OnResponseListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Context f11624a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ DailySignInfo f11625b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ String f11626c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ String f11627d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final /* synthetic */ long f11628e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ k f11629f;

    j(k kVar, Context context, DailySignInfo dailySignInfo, String str, String str2, long j) {
        this.f11629f = kVar;
        this.f11624a = context;
        this.f11625b = dailySignInfo;
        this.f11626c = str;
        this.f11627d = str2;
        this.f11628e = j;
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onError(int i, String str) {
        Context context = this.f11624a;
        AppToastUtils.showShortNegativeTipToast(context, context.getString(R.string.week_sign_in_failed));
        MessagerClient.getIns().sendMsg0(BroadcastType.BROADCAST_CLOSE_LOADING_DIALOG);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onServerError(int i) {
        Context context = this.f11624a;
        AppToastUtils.showShortNegativeTipToast(context, context.getString(R.string.week_sign_in_failed));
        MessagerClient.getIns().sendMsg0(BroadcastType.BROADCAST_CLOSE_LOADING_DIALOG);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onSuccess(Object obj) {
        DialogC1111pa dialogC1111pa = new DialogC1111pa(this.f11624a, this.f11625b);
        final Context context = this.f11624a;
        final String str = this.f11626c;
        final String str2 = this.f11627d;
        dialogC1111pa.a(new OnViewClickListener() { // from class: com.disabngo.blockynexus.view.dialog.j.c
            @Override // com.disabngo.blockynexus.interfaces.OnViewClickListener
            public final void onClick() {
                new CampaignGetIntegralRewardDialog(context).setStringData(str, str2).show();
            }
        });
        dialogC1111pa.show();
        Messenger.getDefault().sendNoMsg(MessageToken.TOKEN_CLOSE_WEEK_DIALOG);
        BillingManager.getInstance().updateUserMoney(this.f11624a);
        MessagerClient.getIns().sendMsg0(BroadcastType.BROADCAST_CLOSE_LOADING_DIALOG);
        ReportDataAdapter.onEvent(this.f11624a, EventConstant.SIGN_IN_SUCCESS, String.valueOf(this.f11628e));
    }
}
