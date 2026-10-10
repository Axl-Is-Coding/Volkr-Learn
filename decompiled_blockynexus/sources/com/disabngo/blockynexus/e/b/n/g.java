package com.disabngo.blockynexus.e.b.n;

import android.app.Activity;
import com.disabngo.blockynexus.R;
import com.sandboxol.center.entity.AccountCenter;
import com.sandboxol.center.entity.ModifyNameFreeResponse;
import com.sandboxol.center.router.manager.BillingManager;
import com.sandboxol.center.utils.TemplateUtils;
import com.sandboxol.center.view.dialog.TwoButtonDialog;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.utils.AppToastUtils;
import com.sandboxol.common.web.error.ServerOnError;
import com.sandboxol.googlepay.view.fragment.recharge.k;
import com.sandboxol.greendao.entity.User;

/* JADX INFO: compiled from: ChangeNameViewModel.java */
/* JADX INFO: loaded from: classes2.dex */
class g extends OnResponseListener<User> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ h f9963a;

    g(h hVar) {
        this.f9963a = hVar;
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onSuccess(User user) {
        AccountCenter.newInstance().nickName.set(user.getNickName());
        AccountCenter.putAccountInfo();
        AppToastUtils.showShortPositiveTipToast(this.f9963a.f9964a, R.string.change_name_success);
        BillingManager.getInstance().updateUserMoney(this.f9963a.f9964a, !((ModifyNameFreeResponse) this.f9963a.f9966c.get()).isFree());
        ((Activity) this.f9963a.f9964a).finish();
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onError(int i, String str) {
        if (i == 1003) {
            AppToastUtils.showShortNegativeTipToast(this.f9963a.f9964a, R.string.account_nickname_exist);
        } else if (i == 5006) {
            new TwoButtonDialog(this.f9963a.f9964a).setRightButtonText(R.string.good_goto_recharge).setDetailText(R.string.good_diamonds_not_enough).setListener(new TwoButtonDialog.OnTwoButtonDialogClickListener() { // from class: com.disabngo.blockynexus.e.b.n.a
                @Override // com.sandboxol.center.view.dialog.TwoButtonDialog.OnTwoButtonDialogClickListener
                public final void onClick() {
                    this.f9955a.a();
                }
            }).show();
        } else {
            ServerOnError.showOnServerError(this.f9963a.f9964a, i);
        }
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onServerError(int i) {
        ServerOnError.showOnServerError(this.f9963a.f9964a, i);
    }

    public /* synthetic */ void a() {
        TemplateUtils.startTemplate(this.f9963a.f9964a, k.class, this.f9963a.f9964a.getString(R.string.me_recharge), R.mipmap.ic_recharge_history);
    }
}
