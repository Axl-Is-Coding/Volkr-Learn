package com.disabngo.blockynexus.view.activity.join;

import android.content.Intent;
import android.net.Uri;
import com.disabngo.blockynexus.R;
import com.sandboxol.center.config.EventConstant;
import com.sandboxol.center.config.UrlConstant;
import com.sandboxol.center.entity.GameResInfo;
import com.sandboxol.center.router.manager.LoginManager;
import com.sandboxol.center.utils.ReportUtils;
import com.sandboxol.center.view.dialog.TwoButtonDialog;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.utils.HttpUtils;
import com.sandboxol.greendao.entity.MiniGameToken;

/* JADX INFO: compiled from: EnterGameViewModel.java */
/* JADX INFO: loaded from: classes2.dex */
class o extends OnResponseListener<GameResInfo> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ MiniGameToken f10727a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ long f10728b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ s f10729c;

    o(s sVar, MiniGameToken miniGameToken, long j) {
        this.f10729c = sVar;
        this.f10727a = miniGameToken;
        this.f10728b = j;
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onSuccess(GameResInfo gameResInfo) {
        if (gameResInfo != null) {
            this.f10729c.a(this.f10727a, gameResInfo, this.f10728b);
        } else {
            s sVar = this.f10729c;
            sVar.b(sVar.f10737a.getString(R.string.check_resource_failed));
        }
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onError(int i, String str) {
        ReportUtils.resDownloadReport(this.f10729c.f10737a, this.f10729c.f10738b.getGameId(), EventConstant.CONNECT_DISPATCH_FAILED, String.valueOf(i));
        if (i == 2) {
            s sVar = this.f10729c;
            sVar.k.set(sVar.f10737a.getString(R.string.create_game));
        } else if (i == 7) {
            LoginManager.switchAccount(this.f10729c.f10737a);
        } else if (i == 2009) {
            new TwoButtonDialog(this.f10729c.f10737a).setRightButtonText(R.string.dialog_button_update).setListener(new TwoButtonDialog.OnTwoButtonDialogClickListener() { // from class: com.disabngo.blockynexus.view.activity.join.d
                @Override // com.sandboxol.center.view.dialog.TwoButtonDialog.OnTwoButtonDialogClickListener
                public final void onClick() {
                    this.f10707a.a();
                }
            }).setDetailText(R.string.play_game_after_update).show();
        } else {
            s sVar2 = this.f10729c;
            sVar2.b(HttpUtils.getHttpErrorMsg(sVar2.f10737a, i));
        }
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onServerError(int i) {
        s sVar = this.f10729c;
        sVar.b(sVar.f10737a.getResources().getString(R.string.game_allocation_failed));
        ReportUtils.resDownloadReport(this.f10729c.f10737a, this.f10729c.f10738b.getGameId(), EventConstant.CONNECT_DISPATCH_FAILED, String.valueOf(i));
    }

    public /* synthetic */ void a() {
        this.f10729c.f10737a.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(UrlConstant.PLAY_STORE_URL)));
    }
}
