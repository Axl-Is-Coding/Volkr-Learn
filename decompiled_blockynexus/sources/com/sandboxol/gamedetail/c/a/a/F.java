package com.sandboxol.gamedetail.c.a.a;

import com.sandboxol.center.config.EventConstant;
import com.sandboxol.center.config.MessageToken;
import com.sandboxol.center.config.SharedConstant;
import com.sandboxol.center.entity.AccountCenter;
import com.sandboxol.center.router.moduleInfo.game.EngineEnv;
import com.sandboxol.center.router.module_application.BaseModuleApp;
import com.sandboxol.center.utils.GameIdRemarkUtils;
import com.sandboxol.center.view.dialog.LoadingDialog;
import com.sandboxol.center.view.dialog.NotWifiDialog;
import com.sandboxol.center.view.dialog.TwoButtonDialog;
import com.sandboxol.common.interfaces.ReportDataAdapter;
import com.sandboxol.common.messenger.Messenger;
import com.sandboxol.common.utils.NetworkUtil;
import com.sandboxol.common.utils.SharedUtils;
import com.sandboxol.gamedetail.R;
import com.sandboxol.greendao.entity.Game;

/* JADX INFO: compiled from: GameDetailEnterGameLogic.java */
/* JADX INFO: loaded from: classes3.dex */
class F implements com.sandboxol.greendao.a.c<Game> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ boolean f17909a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ M f17910b;

    F(M m, boolean z) {
        this.f17910b = m;
        this.f17909a = z;
    }

    @Override // com.sandboxol.greendao.a.c
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onSuccess(Game game) {
        com.apkfuns.logutils.c.a("DressDownload&Unzip").d("Check db");
        if (this.f17910b.g.getIsNewEngine() != 0 && BaseModuleApp.getBaseModuleApp().getMetaDataIsPackNewEngineRes()) {
            this.f17910b.a();
            return;
        }
        boolean z = true;
        if (this.f17910b.g.getIsNewEngine() != 0 && this.f17910b.g.getLatestResVersions().getCresVersion() > EngineEnv.loadCommonResVersion(this.f17910b.f17920a, this.f17910b.g.getIsNewEngine(), this.f17910b.g.getIsUgc())) {
            z = false;
        }
        if (game != null && game.getLatestResVersions() != null && this.f17910b.g.getLatestResVersions() != null && game.getLatestResVersions().getGresVersion() == this.f17910b.g.getLatestResVersions().getGresVersion() && z) {
            com.apkfuns.logutils.c.a("DressDownload&Unzip").d("Enter Game");
            if (!this.f17909a) {
                this.f17910b.a();
                return;
            }
            new LoadingDialog(this.f17910b.f17920a).show();
            String strHallGameToSingleGame = GameIdRemarkUtils.hallGameToSingleGame(this.f17910b.g.getGameId());
            this.f17910b.f17923d.a(AccountCenter.newInstance().nickName.get() + this.f17910b.f17920a.getString(R.string.gamedetail_party_somebody), this.f17910b.g, strHallGameToSingleGame);
            return;
        }
        if (((Boolean) this.f17910b.o.get()).booleanValue() && (this.f17910b.h == null || this.f17910b.h.size() == 0)) {
            com.apkfuns.logutils.c.a("DressDownload&Unzip").d("upgradeResponse = null");
            Messenger.getDefault().sendNoMsg(MessageToken.UPGRADE_INTERFACE_IS_NOT_READY);
            return;
        }
        if (!this.f17910b.d()) {
            com.apkfuns.logutils.c.a("DressDownload&Unzip").d("Enter Game");
            if (this.f17909a) {
                new LoadingDialog(this.f17910b.f17920a).show();
                String strHallGameToSingleGame2 = GameIdRemarkUtils.hallGameToSingleGame(this.f17910b.g.getGameId());
                this.f17910b.f17923d.a(AccountCenter.newInstance().nickName.get() + this.f17910b.f17920a.getString(R.string.gamedetail_party_somebody), this.f17910b.g, this.f17910b.f17923d.a(this.f17910b.g, strHallGameToSingleGame2));
            } else {
                this.f17910b.a();
            }
            com.sandboxol.greendao.c.U.newInstance().a(this.f17910b.g);
            return;
        }
        if (this.f17909a) {
            new TwoButtonDialog(this.f17910b.f17920a).setDetailText(R.string.gamedetail_res_no_load).setRightButtonText(R.string.gamedetail_res_load).setListener(new TwoButtonDialog.OnTwoButtonDialogClickListener() { // from class: com.sandboxol.gamedetail.c.a.a.b
                @Override // com.sandboxol.center.view.dialog.TwoButtonDialog.OnTwoButtonDialogClickListener
                public final void onClick() {
                    this.f17965a.b();
                }
            }).show();
            ReportDataAdapter.onEvent(this.f17910b.f17920a, EventConstant.PARTY_DOWN_WIN);
        } else if (NetworkUtil.isWifi(this.f17910b.f17920a) || SharedUtils.getBoolean(this.f17910b.f17920a, SharedConstant.IS_SHOW_NO_WIFI)) {
            M m = this.f17910b;
            m.a(m.g);
            ReportDataAdapter.onEvent(this.f17910b.f17920a, EventConstant.CLICK_QUICK_ENTER);
        } else {
            com.apkfuns.logutils.c.a("DressDownload&Unzip").d("no wifi");
            new NotWifiDialog(this.f17910b.f17920a).setListener(new NotWifiDialog.OnTwoButtonDialogClickListener() { // from class: com.sandboxol.gamedetail.c.a.a.a
                @Override // com.sandboxol.center.view.dialog.NotWifiDialog.OnTwoButtonDialogClickListener
                public final void onClick() {
                    this.f17963a.c();
                }
            }).show();
            ReportDataAdapter.onEvent(this.f17910b.f17920a, EventConstant.NO_WIFI_WIN);
        }
    }

    public /* synthetic */ void b() {
        if (!NetworkUtil.isWifi(this.f17910b.f17920a) && !SharedUtils.getBoolean(this.f17910b.f17920a, SharedConstant.IS_SHOW_NO_WIFI)) {
            new NotWifiDialog(this.f17910b.f17920a).setListener(new NotWifiDialog.OnTwoButtonDialogClickListener() { // from class: com.sandboxol.gamedetail.c.a.a.c
                @Override // com.sandboxol.center.view.dialog.NotWifiDialog.OnTwoButtonDialogClickListener
                public final void onClick() {
                    this.f17972a.a();
                }
            }).show();
        } else {
            M m = this.f17910b;
            m.a(m.g);
        }
    }

    public /* synthetic */ void c() {
        M m = this.f17910b;
        m.a(m.g);
        ReportDataAdapter.onEvent(this.f17910b.f17920a, EventConstant.NO_WIFI_WIN_CONTINUE);
    }

    @Override // com.sandboxol.greendao.a.c
    public void onError(int i, String str) {
    }

    public /* synthetic */ void a() {
        M m = this.f17910b;
        m.a(m.g);
    }
}
