package com.disabngo.blockynexus.message.provider;

import android.view.View;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.message.provider.ScrapHelpProvider;
import com.disabngo.blockynexus.view.dialog.Fa;
import com.sandboxol.center.config.EventConstant;
import com.sandboxol.center.config.MessageToken;
import com.sandboxol.center.router.manager.VipManager;
import com.sandboxol.center.utils.ScrapStatusHelper;
import com.sandboxol.center.view.dialog.TwoButtonDialog;
import com.sandboxol.center.web.error.ScrapOnError;
import com.sandboxol.common.base.app.BaseApplication;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.interfaces.ReportDataAdapter;
import com.sandboxol.common.messenger.Messenger;
import com.sandboxol.common.utils.SharedUtils;
import com.sandboxol.common.web.error.ServerOnError;

/* JADX INFO: compiled from: ScrapHelpProvider.java */
/* JADX INFO: loaded from: classes2.dex */
class m extends OnResponseListener<Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ View f10480a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ ScrapHelpProvider.AnonymousClass1 f10481b;

    m(ScrapHelpProvider.AnonymousClass1 anonymousClass1, View view) {
        this.f10481b = anonymousClass1;
        this.f10480a = view;
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onError(int i, String str) {
        if (i == 10109) {
            ScrapStatusHelper.getInstance().updateCacheData(this.f10480a.getContext(), this.f10481b.f10430a.getUuid(), ((System.currentTimeMillis() - SharedUtils.getLong(BaseApplication.getContext(), this.f10481b.f10430a.getUuid(), System.currentTimeMillis())) > 1800000L ? 1 : ((System.currentTimeMillis() - SharedUtils.getLong(BaseApplication.getContext(), this.f10481b.f10430a.getUuid(), System.currentTimeMillis())) == 1800000L ? 0 : -1)) > 0 ? 2 : 1);
            ScrapHelpProvider.AnonymousClass1 anonymousClass1 = this.f10481b;
            ScrapHelpProvider.this.a(anonymousClass1.f10431b, anonymousClass1.f10432c, anonymousClass1.f10430a, anonymousClass1.f10433d);
            return;
        }
        if (i != 10113) {
            ScrapOnError.showErrorTip(this.f10480a.getContext(), i);
            return;
        }
        TwoButtonDialog rightButtonText = new TwoButtonDialog(this.f10480a.getContext()).setDetailText(R.string.base_scrap_not_vip_can_t_receive).setRightButtonText(R.string.base_vip_open);
        final View view = this.f10480a;
        rightButtonText.setListener(new TwoButtonDialog.OnTwoButtonDialogClickListener() { // from class: com.disabngo.blockynexus.message.provider.c
            @Override // com.sandboxol.center.view.dialog.TwoButtonDialog.OnTwoButtonDialogClickListener
            public final void onClick() {
                VipManager.showSubscribeDialog(view.getContext());
            }
        }).show();
        VipManager.reportVipSubWin(this.f10480a.getContext());
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onServerError(int i) {
        ServerOnError.showOnServerError(this.f10480a.getContext(), i);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onSuccess(Object obj) {
        ReportDataAdapter.onEvent(this.f10480a.getContext(), EventConstant.GET_FRIEND_PART_SUC);
        Messenger.getDefault().sendNoMsg(MessageToken.TOKEN_REFRESH_SCRAP_RED_POINT_NUM);
        new Fa(this.f10480a.getContext(), this.f10481b.f10430a, new l(this)).show();
    }
}
