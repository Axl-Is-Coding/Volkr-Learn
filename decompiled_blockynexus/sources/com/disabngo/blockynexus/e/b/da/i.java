package com.disabngo.blockynexus.e.b.da;

import com.disabngo.blockynexus.view.dialog.Pa;
import com.sandboxol.center.entity.ScrapRewardDetails;
import com.sandboxol.center.entity.ScrapRewardInfo;
import com.sandboxol.center.router.moduleInfo.pay.BroadcastType;
import com.sandboxol.center.web.error.ScrapOnError;
import com.sandboxol.common.base.viewmodel.ListItemViewModel;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.web.error.ServerOnError;
import com.sandboxol.messager.MessagerClient;

/* JADX INFO: compiled from: ScrapMainItemViewModel.java */
/* JADX INFO: loaded from: classes2.dex */
class i extends OnResponseListener<ScrapRewardDetails> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ j f9701a;

    i(j jVar) {
        this.f9701a = jVar;
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onSuccess(ScrapRewardDetails scrapRewardDetails) {
        MessagerClient.getIns().sendMsg0(BroadcastType.BROADCAST_CLOSE_LOADING_DIALOG);
        new Pa(((ListItemViewModel) this.f9701a).context, scrapRewardDetails, ((ScrapRewardInfo) ((ListItemViewModel) this.f9701a).item).getCardId(), ((ScrapRewardInfo) ((ListItemViewModel) this.f9701a).item).getCardQuality(), ((ScrapRewardInfo) ((ListItemViewModel) this.f9701a).item).getStatus(), ((ScrapRewardInfo) ((ListItemViewModel) this.f9701a).item).getCardRewardType()).show();
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onError(int i, String str) {
        MessagerClient.getIns().sendMsg0(BroadcastType.BROADCAST_CLOSE_LOADING_DIALOG);
        ScrapOnError.showErrorTip(((ListItemViewModel) this.f9701a).context, i);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onServerError(int i) {
        MessagerClient.getIns().sendMsg0(BroadcastType.BROADCAST_CLOSE_LOADING_DIALOG);
        ServerOnError.showOnServerError(((ListItemViewModel) this.f9701a).context, i);
    }
}
