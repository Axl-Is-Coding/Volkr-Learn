package com.disabngo.blockynexus.view.activity.main;

import android.content.Context;
import com.disabngo.blockynexus.R;
import com.sandboxol.center.config.EventConstant;
import com.sandboxol.center.entity.AppConfig;
import com.sandboxol.center.entity.AppInfoCenter;
import com.sandboxol.center.router.manager.MTPManager;
import com.sandboxol.center.router.manager.NewSandboxReportManager;
import com.sandboxol.center.router.manager.PingReportManager;
import com.sandboxol.center.router.manager.SandboxReportManager;
import com.sandboxol.center.view.dialog.OneButtonDialog;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.interfaces.ReportDataAdapter;
import rx.functions.Action0;

/* JADX INFO: compiled from: MainModel.java */
/* JADX INFO: loaded from: classes2.dex */
class Jb extends OnResponseListener<AppConfig> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Context f10789a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ Action0 f10790b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ bc f10791c;

    Jb(bc bcVar, Context context, Action0 action0) {
        this.f10791c = bcVar;
        this.f10789a = context;
        this.f10790b = action0;
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onSuccess(AppConfig appConfig) {
        if (appConfig == null) {
            ReportDataAdapter.onEvent(this.f10789a, EventConstant.NONETWORK_TIME, "LoadAppConfig Success but no data");
            OneButtonDialog detailText = new OneButtonDialog(this.f10789a).setButtonText(R.string.retry).setDetailText(R.string.connect_server_no_connect);
            final Context context = this.f10789a;
            final Action0 action0 = this.f10790b;
            detailText.setListener(new OneButtonDialog.OneButtonDialogListener() { // from class: com.disabngo.blockynexus.view.activity.main.r
                @Override // com.sandboxol.center.view.dialog.OneButtonDialog.OneButtonDialogListener
                public final void onClick() {
                    this.f10956a.c(context, action0);
                }
            }).show();
            return;
        }
        this.f10791c.b(this.f10789a, appConfig.isNeedStopServiceAnnouncement());
        MTPManager.setOpenMtp(appConfig.isOpenMTP());
        AppInfoCenter.newInstance().setAppConfig(appConfig);
        PingReportManager.setReportInternal(appConfig.getPingReportInterval());
        SandboxReportManager.setReportInternal(appConfig.getReportInterval());
        NewSandboxReportManager.setReportInternal(appConfig.getReportInterval());
        com.disabngo.blockynexus.e.a.a.h.c().a(appConfig.isClearCache());
        Action0 action02 = this.f10790b;
        if (action02 != null) {
            action02.call();
        }
    }

    public /* synthetic */ void b(Context context, Action0 action0) {
        this.f10791c.a(context, action0);
    }

    public /* synthetic */ void c(Context context, Action0 action0) {
        this.f10791c.a(context, action0);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onError(int i, String str) {
        ReportDataAdapter.onEvent(this.f10789a, EventConstant.NONETWORK_TIME, "LoadAppConfig onError");
        OneButtonDialog detailText = new OneButtonDialog(this.f10789a).setButtonText(R.string.retry).setDetailText(R.string.connect_server_no_connect);
        final Context context = this.f10789a;
        final Action0 action0 = this.f10790b;
        detailText.setListener(new OneButtonDialog.OneButtonDialogListener() { // from class: com.disabngo.blockynexus.view.activity.main.q
            @Override // com.sandboxol.center.view.dialog.OneButtonDialog.OneButtonDialogListener
            public final void onClick() {
                this.f10951a.a(context, action0);
            }
        }).show();
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onServerError(int i) {
        ReportDataAdapter.onEvent(this.f10789a, EventConstant.NONETWORK_TIME, "LoadAppConfig onServerError");
        OneButtonDialog detailText = new OneButtonDialog(this.f10789a).setButtonText(R.string.retry).setDetailText(R.string.connect_server_no_connect);
        final Context context = this.f10789a;
        final Action0 action0 = this.f10790b;
        detailText.setListener(new OneButtonDialog.OneButtonDialogListener() { // from class: com.disabngo.blockynexus.view.activity.main.p
            @Override // com.sandboxol.center.view.dialog.OneButtonDialog.OneButtonDialogListener
            public final void onClick() {
                this.f10946a.b(context, action0);
            }
        }).show();
    }

    public /* synthetic */ void a(Context context, Action0 action0) {
        this.f10791c.a(context, action0);
    }
}
