package com.disabngo.blockynexus.view.activity.join;

import android.content.Intent;
import android.net.Uri;
import com.disabngo.blockynexus.R;
import com.google.android.gms.ads.formats.NativeContentAd;
import com.sandboxol.center.config.EventConstant;
import com.sandboxol.center.config.UrlConstant;
import com.sandboxol.center.entity.AppInfoCenter;
import com.sandboxol.center.router.manager.LoginManager;
import com.sandboxol.center.router.manager.NewSandboxReportManager;
import com.sandboxol.center.router.manager.SandboxReportManager;
import com.sandboxol.center.router.moduleInfo.report.NewReportEventType;
import com.sandboxol.center.router.moduleInfo.report.ReportEventType;
import com.sandboxol.center.utils.ReportUtils;
import com.sandboxol.center.view.dialog.TwoButtonDialog;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.utils.HttpUtils;
import com.sandboxol.greendao.entity.Dispatch;

/* JADX INFO: compiled from: EnterGameViewModel.java */
/* JADX INFO: loaded from: classes2.dex */
class q extends OnResponseListener<Dispatch> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ s f10735a;

    q(s sVar) {
        this.f10735a = sVar;
    }

    public /* synthetic */ void a() {
        this.f10735a.f10737a.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(UrlConstant.PLAY_STORE_URL)));
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onError(int i, String str) {
        ReportUtils.resDownloadReport(this.f10735a.f10737a, this.f10735a.f10738b.getGameId(), EventConstant.CONNECT_DISPATCH_FAILED, String.valueOf(i));
        if (i == 2) {
            s sVar = this.f10735a;
            sVar.k.set(sVar.f10737a.getString(R.string.create_game));
        } else if (i == 7) {
            LoginManager.switchAccount(this.f10735a.f10737a);
        } else if (i == 2009) {
            new TwoButtonDialog(this.f10735a.f10737a).setRightButtonText(R.string.dialog_button_update).setListener(new TwoButtonDialog.OnTwoButtonDialogClickListener() { // from class: com.disabngo.blockynexus.view.activity.join.f
                @Override // com.sandboxol.center.view.dialog.TwoButtonDialog.OnTwoButtonDialogClickListener
                public final void onClick() {
                    this.f10712a.a();
                }
            }).setDetailText(R.string.play_game_after_update).show();
        } else {
            s sVar2 = this.f10735a;
            sVar2.b(HttpUtils.getHttpErrorMsg(sVar2.f10737a, i));
        }
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onServerError(int i) {
        s sVar = this.f10735a;
        sVar.b(sVar.f10737a.getResources().getString(R.string.game_allocation_failed));
        ReportUtils.resDownloadReport(this.f10735a.f10737a, this.f10735a.f10738b.getGameId(), EventConstant.CONNECT_DISPATCH_FAILED, String.valueOf(i));
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onSuccess(Dispatch dispatch) {
        String str;
        ReportUtils.resDownloadReport(this.f10735a.f10737a, this.f10735a.f10738b.getGameId(), EventConstant.CONNECT_DISPATCH_SUCCESS);
        SandboxReportManager.onEvent("new_connect_dispatch_success_" + this.f10735a.f10738b.getGameId(), this.f10735a.f10738b.getGameId() + ReportEventType.GAME_INTER_BASE, this.f10735a.f10738b.getGameId());
        SandboxReportManager.onEvent("new_connect_dispatch_success_" + this.f10735a.f10738b.getGameId(), ReportEventType.NEW_USER_BEHAVIOR, "app");
        NewSandboxReportManager.onGameEvent(NewReportEventType.FUNNEL_GAME_NUMBER, "new_connect_dispatch_success_" + this.f10735a.f10738b.getGameId(), this.f10735a.f10738b.getGameId());
        NewSandboxReportManager.onGameEvent(NewReportEventType.FUNNEL_GAME_FREQUENCY, "new_connect_dispatch_success_" + this.f10735a.f10738b.getGameId(), this.f10735a.f10738b.getGameId());
        AppInfoCenter appInfoCenterNewInstance = AppInfoCenter.newInstance();
        if ("".equals(dispatch.region) || (str = dispatch.region) == null) {
            str = NativeContentAd.ASSET_HEADLINE;
        }
        appInfoCenterNewInstance.setLatelyRegion(str);
        this.f10735a.a(dispatch, false);
    }
}
