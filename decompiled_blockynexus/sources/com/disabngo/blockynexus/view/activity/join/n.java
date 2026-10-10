package com.disabngo.blockynexus.view.activity.join;

import com.disabngo.blockynexus.R;
import com.sandboxol.center.config.EventConstant;
import com.sandboxol.center.utils.ReportUtils;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.utils.HttpUtils;
import com.sandboxol.greendao.entity.MiniGameToken;

/* JADX INFO: compiled from: EnterGameViewModel.java */
/* JADX INFO: loaded from: classes2.dex */
class n extends OnResponseListener<MiniGameToken> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ long f10725a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ s f10726b;

    n(s sVar, long j) {
        this.f10726b = sVar;
        this.f10725a = j;
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onError(int i, String str) {
        s sVar = this.f10726b;
        sVar.b(HttpUtils.getHttpErrorMsg(sVar.f10737a, i));
        com.disabngo.blockynexus.d.n.a(this.f10726b.f10737a, HttpUtils.getHttpErrorMsg(this.f10726b.f10737a, i));
        ReportUtils.resDownloadReport(this.f10726b.f10737a, this.f10726b.f10738b.getGameId(), EventConstant.ENTER_GAME_AUTH_FAILED, String.valueOf(i));
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onServerError(int i) {
        s sVar = this.f10726b;
        sVar.b(sVar.f10737a.getResources().getString(R.string.checking_map_res_failed));
        com.disabngo.blockynexus.d.n.a(this.f10726b.f10737a, this.f10726b.f10737a.getResources().getString(R.string.checking_map_res_failed));
        ReportUtils.resDownloadReport(this.f10726b.f10737a, this.f10726b.f10738b.getGameId(), EventConstant.ENTER_GAME_AUTH_FAILED, String.valueOf(i));
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onSuccess(MiniGameToken miniGameToken) {
        this.f10726b.a(miniGameToken, this.f10725a);
    }
}
