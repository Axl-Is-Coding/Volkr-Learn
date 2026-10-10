package com.sandboxol.gamedetail.c.a.d;

import com.sandboxol.center.config.EventConstant;
import com.sandboxol.center.config.MessageToken;
import com.sandboxol.center.entity.GameDetailShop;
import com.sandboxol.center.router.manager.BillingManager;
import com.sandboxol.center.router.manager.DressManager;
import com.sandboxol.center.router.moduleInfo.pay.BroadcastType;
import com.sandboxol.center.view.dialog.CampaignGetIntegralRewardDialog;
import com.sandboxol.common.base.viewmodel.ListItemViewModel;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.interfaces.ReportDataAdapter;
import com.sandboxol.common.listener.OnViewClickListener;
import com.sandboxol.common.messenger.Messenger;
import com.sandboxol.common.web.error.ServerOnError;
import com.sandboxol.common.widget.rv.msg.RefreshMsg;
import com.sandboxol.messager.MessagerClient;

/* JADX INFO: compiled from: GameDetailShopItemViewModel.java */
/* JADX INFO: loaded from: classes3.dex */
class g extends OnResponseListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ h f18104a;

    g(h hVar) {
        this.f18104a = hVar;
    }

    public /* synthetic */ void a() {
        BillingManager.getInstance().updateUserMoney(((ListItemViewModel) this.f18104a).context, true);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onError(int i, String str) {
        DressManager.showShopErrorTip(((ListItemViewModel) this.f18104a).context, i);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onServerError(int i) {
        ServerOnError.showOnServerError(((ListItemViewModel) this.f18104a).context, i);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onSuccess(Object obj) {
        MessagerClient.getIns().sendMsg0(BroadcastType.BROADCAST_CLOSE_LOADING_DIALOG);
        new CampaignGetIntegralRewardDialog(((ListItemViewModel) this.f18104a).context).setStringData(((GameDetailShop) ((ListItemViewModel) this.f18104a).item).getIconUrl(), ((GameDetailShop) ((ListItemViewModel) this.f18104a).item).getName()).setOnViewClick(new OnViewClickListener() { // from class: com.sandboxol.gamedetail.c.a.d.a
            @Override // com.sandboxol.common.listener.OnViewClickListener
            public final void onClick() {
                this.f18100a.a();
            }
        }).show();
        Messenger.getDefault().send(RefreshMsg.create(), MessageToken.TOKEN_REFRESH_GAME_DETAIL_SHOP);
        ReportDataAdapter.onEvent(((ListItemViewModel) this.f18104a).context, EventConstant.BUY_SUCCESS);
    }
}
