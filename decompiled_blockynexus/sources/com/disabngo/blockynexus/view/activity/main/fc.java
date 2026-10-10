package com.disabngo.blockynexus.view.activity.main;

import android.text.TextUtils;
import com.sandboxol.center.entity.XScrapCardInfo;
import com.sandboxol.common.interfaces.ReportDataAdapter;
import com.sandboxol.imchat.message.entity.ScrapHelpMessage;
import rx.functions.Action1;

/* JADX INFO: compiled from: MainViewModel.java */
/* JADX INFO: loaded from: classes2.dex */
class fc implements Action1<XScrapCardInfo> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ nc f10900a;

    fc(nc ncVar) {
        this.f10900a = ncVar;
    }

    @Override // rx.functions.Action1
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void call(XScrapCardInfo xScrapCardInfo) {
        com.disabngo.blockynexus.utils.logic.N.a(this.f10900a.f10939c, ScrapHelpMessage.getInstanceFromXScrapCardInfo(xScrapCardInfo), xScrapCardInfo.getTargetId(), xScrapCardInfo.isPrivateFlag());
        if (TextUtils.isEmpty(xScrapCardInfo.getScrapId())) {
            ReportDataAdapter.onEvent(this.f10900a.f10939c, "TOKEN_SEND_SCRAP_CARD");
        }
    }
}
