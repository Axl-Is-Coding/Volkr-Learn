package com.disabngo.blockynexus.view.dialog;

import com.disabngo.blockynexus.view.dialog.DialogC1122va;
import com.google.android.gms.ads.formats.NativeContentAd;
import com.sandboxol.center.entity.AppInfoCenter;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.greendao.entity.Dispatch;
import com.sandboxol.greendao.entity.MiniGameToken;

/* JADX INFO: renamed from: com.disabngo.blockynexus.view.dialog.ya, reason: case insensitive filesystem */
/* JADX INFO: compiled from: EnterMiniGameDialog.java */
/* JADX INFO: loaded from: classes2.dex */
class C1128ya extends OnResponseListener<MiniGameToken> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ DialogC1122va.b f11715a;

    C1128ya(DialogC1122va.b bVar) {
        this.f11715a = bVar;
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onError(int i, String str) {
        DialogC1122va.this.c();
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onServerError(int i) {
        DialogC1122va.this.c();
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onSuccess(MiniGameToken miniGameToken) {
        AppInfoCenter.newInstance().setLatelyRegion(miniGameToken.getRegion() == 0 ? NativeContentAd.ASSET_HEADLINE : String.valueOf(miniGameToken.getRegion()));
        Dispatch dispatch = new Dispatch();
        dispatch.signature = miniGameToken.getSignature();
        dispatch.timestamp = miniGameToken.getTimestamp();
        this.f11715a.a(dispatch, false);
    }
}
