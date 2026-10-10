package com.disabngo.blockynexus.view.dialog.g;

import android.content.Context;
import android.text.TextUtils;
import com.disabngo.blockynexus.utils.logic.N;
import com.sandboxol.center.config.EventConstant;
import com.sandboxol.center.entity.AccountCenter;
import com.sandboxol.center.web.error.ScrapOnError;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.dialog.FullScreenDialog;
import com.sandboxol.common.interfaces.ReportDataAdapter;
import com.sandboxol.common.web.error.ServerOnError;
import com.sandboxol.imchat.message.entity.ScrapAskHelpMessage;

/* JADX INFO: compiled from: ScrapRequestDialog.java */
/* JADX INFO: loaded from: classes2.dex */
class d extends OnResponseListener<Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ e f11568a;

    d(e eVar) {
        this.f11568a = eVar;
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onError(int i, String str) {
        ScrapOnError.showErrorTip(((FullScreenDialog) this.f11568a).context, i);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onServerError(int i) {
        ServerOnError.showOnServerError(((FullScreenDialog) this.f11568a).context, i);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onSuccess(Object obj) {
        ReportDataAdapter.onEvent(((FullScreenDialog) this.f11568a).context, EventConstant.SEND_PART_HELP_SUC);
        N.a(((FullScreenDialog) this.f11568a).context, String.valueOf(this.f11568a.i.get()), this.f11568a.h.get());
        if (TextUtils.isEmpty(this.f11568a.f11569a.getScrapId())) {
            ReportDataAdapter.onEvent(((FullScreenDialog) this.f11568a).context, "askScrap");
        }
        Context context = ((FullScreenDialog) this.f11568a).context;
        String scrapId = this.f11568a.f11569a.getScrapId();
        String scrapName = this.f11568a.f11569a.getScrapName();
        String str = AccountCenter.newInstance().nickName.get();
        long jLongValue = AccountCenter.newInstance().userId.get().longValue();
        e eVar = this.f11568a;
        int i = eVar.f11571c;
        String scrapPic = eVar.f11569a.getScrapPic();
        e eVar2 = this.f11568a;
        N.a(context, new ScrapAskHelpMessage(scrapId, scrapName, str, jLongValue, i, scrapPic, eVar2.f11570b, eVar2.f11572d, this.f11568a.f11569a.getScrapValue()), String.valueOf(this.f11568a.i.get()));
    }
}
