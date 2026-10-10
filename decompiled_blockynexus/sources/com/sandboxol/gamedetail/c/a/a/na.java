package com.sandboxol.gamedetail.c.a.a;

import com.sandboxol.center.config.SharedConstant;
import com.sandboxol.center.entity.AppEngineResourceUpdateResult;
import com.sandboxol.center.view.dialog.NotWifiDialog;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.utils.NetworkUtil;
import com.sandboxol.common.utils.SharedUtils;
import com.sandboxol.greendao.entity.Game;
import java.util.List;

/* JADX INFO: compiled from: GameResDownloadManager.java */
/* JADX INFO: loaded from: classes3.dex */
class na extends OnResponseListener<List<AppEngineResourceUpdateResult>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Game f18017a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ va f18018b;

    na(va vaVar, Game game) {
        this.f18018b = vaVar;
        this.f18017a = game;
    }

    public /* synthetic */ void a(Game game, List list) {
        this.f18018b.a(game, (List<AppEngineResourceUpdateResult>) list);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onError(int i, String str) {
        if (this.f18018b.f18043c != null) {
            this.f18018b.f18043c.a(false);
        }
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onServerError(int i) {
        if (this.f18018b.f18043c != null) {
            this.f18018b.f18043c.a(false);
        }
    }

    public /* synthetic */ void a() {
        if (this.f18018b.f18043c != null) {
            this.f18018b.f18043c.a(true);
        }
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onSuccess(final List<AppEngineResourceUpdateResult> list) {
        if (list == null) {
            if (this.f18018b.f18043c != null) {
                this.f18018b.f18043c.a(false);
            }
        } else {
            if (!this.f18018b.b((List<AppEngineResourceUpdateResult>) list)) {
                if (this.f18018b.f18043c != null) {
                    this.f18018b.d(this.f18017a);
                    this.f18018b.f18043c.a(true);
                    return;
                }
                return;
            }
            if (NetworkUtil.isWifi(this.f18018b.f18042b) || SharedUtils.getBoolean(this.f18018b.f18042b, SharedConstant.IS_SHOW_NO_WIFI)) {
                this.f18018b.a(this.f18017a, (List<AppEngineResourceUpdateResult>) list);
                return;
            }
            NotWifiDialog notWifiDialog = new NotWifiDialog(this.f18018b.f18042b);
            final Game game = this.f18017a;
            notWifiDialog.setListener(new NotWifiDialog.OnTwoButtonDialogClickListener() { // from class: com.sandboxol.gamedetail.c.a.a.z
                @Override // com.sandboxol.center.view.dialog.NotWifiDialog.OnTwoButtonDialogClickListener
                public final void onClick() {
                    this.f18050a.a(game, list);
                }
            }).setCancelListener(new NotWifiDialog.OnCancelClickListener() { // from class: com.sandboxol.gamedetail.c.a.a.A
                @Override // com.sandboxol.center.view.dialog.NotWifiDialog.OnCancelClickListener
                public final void onCancel() {
                    this.f17893a.a();
                }
            }).show();
        }
    }
}
