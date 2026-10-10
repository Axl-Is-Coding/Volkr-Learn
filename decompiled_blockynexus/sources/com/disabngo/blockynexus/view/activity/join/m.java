package com.disabngo.blockynexus.view.activity.join;

import com.disabngo.blockynexus.R;
import com.sandboxol.center.config.EventConstant;
import com.sandboxol.center.utils.ReportUtils;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.utils.HttpUtils;
import com.sandboxol.greendao.entity.MiniGameToken;

/* JADX INFO: compiled from: EnterGameViewModel.java */
/* JADX INFO: loaded from: classes2.dex */
class m extends OnResponseListener<MiniGameToken> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ s f10724a;

    m(s sVar) {
        this.f10724a = sVar;
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onError(int i, String str) {
        s sVar = this.f10724a;
        sVar.b(HttpUtils.getHttpErrorMsg(sVar.f10737a, i));
        ReportUtils.resDownloadReport(this.f10724a.f10737a, this.f10724a.f10738b.getGameId(), EventConstant.ENTER_GAME_AUTH_FAILED, String.valueOf(i));
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onServerError(int i) {
        s sVar = this.f10724a;
        sVar.b(sVar.f10737a.getResources().getString(R.string.checking_map_res_failed));
        ReportUtils.resDownloadReport(this.f10724a.f10737a, this.f10724a.f10738b.getGameId(), EventConstant.ENTER_GAME_AUTH_FAILED, String.valueOf(i));
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onSuccess(MiniGameToken miniGameToken) {
        this.f10724a.a(miniGameToken, 0L);
    }
}
