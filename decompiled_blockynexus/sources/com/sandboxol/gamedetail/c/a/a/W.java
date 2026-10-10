package com.sandboxol.gamedetail.c.a.a;

import android.content.Context;
import com.sandboxol.center.entity.AdsTurntableInfo;
import com.sandboxol.center.view.dialog.adsturntable.AdsTurntableDialog;
import com.sandboxol.center.web.error.GameOnError;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.listener.OnViewClickListener;
import com.sandboxol.common.web.error.ServerOnError;
import java.util.List;

/* JADX INFO: compiled from: GameDetailModel.java */
/* JADX INFO: loaded from: classes3.dex */
class W extends OnResponseListener<List<AdsTurntableInfo>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Context f17955a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ String f17956b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ Z f17957c;

    W(Z z, Context context, String str) {
        this.f17957c = z;
        this.f17955a = context;
        this.f17956b = str;
    }

    public /* synthetic */ void a(String str) {
        this.f17957c.a(str, true);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onError(int i, String str) {
        GameOnError.showErrorTip(this.f17955a, i);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onServerError(int i) {
        ServerOnError.showOnServerError(this.f17955a, i);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onSuccess(List<AdsTurntableInfo> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        AdsTurntableDialog adsTurntableDialog = new AdsTurntableDialog(this.f17955a, list, this.f17956b);
        final String str = this.f17956b;
        adsTurntableDialog.setRewardListener(new OnViewClickListener() { // from class: com.sandboxol.gamedetail.c.a.a.i
            @Override // com.sandboxol.common.listener.OnViewClickListener
            public final void onClick() {
                this.f17991a.a(str);
            }
        }).show();
    }
}
