package com.disabngo.blockynexus.view.widget;

import com.disabngo.blockynexus.R;
import com.sandboxol.center.entity.AccountCenter;
import com.sandboxol.center.entity.RechargeEntity;
import com.sandboxol.center.router.manager.VipManager;
import com.sandboxol.center.view.dialog.TwoButtonDialog;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.web.error.ServerOnError;

/* JADX INFO: compiled from: SignInItemView.java */
/* JADX INFO: loaded from: classes.dex */
class t extends OnResponseListener<RechargeEntity> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ SignInItemView f12111a;

    t(SignInItemView signInItemView) {
        this.f12111a = signInItemView;
    }

    public /* synthetic */ void a() {
        VipManager.enterVipFragment(this.f12111a.context);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onError(int i, String str) {
        if (i == 9) {
            new TwoButtonDialog(this.f12111a.context).setRightButtonText(R.string.vip_pay_open_vip).setTitleText(R.string.sign_in_open_vip_title).setDetailText(R.string.sign_in_open_vip_desc).setListener(new TwoButtonDialog.OnTwoButtonDialogClickListener() { // from class: com.disabngo.blockynexus.view.widget.j
                @Override // com.sandboxol.center.view.dialog.TwoButtonDialog.OnTwoButtonDialogClickListener
                public final void onClick() {
                    this.f12102a.a();
                }
            }).show();
        } else {
            this.f12111a.setState(1);
        }
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onServerError(int i) {
        ServerOnError.showOnServerError(this.f12111a.context, i);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onSuccess(RechargeEntity rechargeEntity) {
        AccountCenter.newInstance().setDiamonds(rechargeEntity.getDiamonds());
        AccountCenter.newInstance().setGolds(rechargeEntity.getGolds());
        AccountCenter.newInstance().setGDiamonds(rechargeEntity.getgDiamonds());
        this.f12111a.setState(1);
    }
}
