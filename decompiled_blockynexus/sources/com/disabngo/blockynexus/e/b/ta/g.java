package com.disabngo.blockynexus.e.b.ta;

import android.app.Activity;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.view.fragment.tribehas.Q;
import com.disabngo.blockynexus.web.error.TribeOnError;
import com.sandboxol.center.router.moduleInfo.pay.BroadcastType;
import com.sandboxol.center.view.dialog.TwoButtonDialog;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.messenger.Messenger;
import com.sandboxol.common.utils.AppToastUtils;
import com.sandboxol.common.web.error.ServerOnError;
import com.sandboxol.messager.MessagerClient;

/* JADX INFO: compiled from: TribeShopCarViewModel.java */
/* JADX INFO: loaded from: classes2.dex */
class g extends OnResponseListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ h f10189a;

    g(h hVar) {
        this.f10189a = hVar;
    }

    public /* synthetic */ void a() {
        ((Activity) this.f10189a.f10190a).finish();
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onError(int i, String str) {
        if (i == 5006) {
            AppToastUtils.showShortNegativeTipToast(this.f10189a.f10190a, R.string.tribe_not_enough_golds);
        } else {
            TribeOnError.showErrorTip(this.f10189a.f10190a, i);
        }
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onServerError(int i) {
        ServerOnError.showOnServerError(this.f10189a.f10190a, i);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onSuccess(Object obj) {
        MessagerClient.getIns().sendMsg0(BroadcastType.BROADCAST_REFRESH_TRIBE_SHOP_LIST);
        new TwoButtonDialog(this.f10189a.f10190a).setDetailText(this.f10189a.f10190a.getString(R.string.good_buy_success)).setLeftButtonText(R.string.base_back).setLeftListener(new TwoButtonDialog.OnTwoButtonDialogLeftClickListener() { // from class: com.disabngo.blockynexus.e.b.ta.a
            @Override // com.sandboxol.center.view.dialog.TwoButtonDialog.OnTwoButtonDialogLeftClickListener
            public final void onLeftClick() {
                this.f10185a.a();
            }
        }).setRightButtonText(R.string.good_goto_dress).setListener(new TwoButtonDialog.OnTwoButtonDialogClickListener() { // from class: com.disabngo.blockynexus.e.b.ta.b
            @Override // com.sandboxol.center.view.dialog.TwoButtonDialog.OnTwoButtonDialogClickListener
            public final void onClick() {
                Messenger.getDefault().sendNoMsg("token.open.dress.fragment");
            }
        }).show();
        Q.a(this.f10189a.f10190a);
    }
}
