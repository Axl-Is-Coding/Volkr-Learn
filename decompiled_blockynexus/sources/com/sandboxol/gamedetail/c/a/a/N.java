package com.sandboxol.gamedetail.c.a.a;

import com.sandboxol.center.router.manager.BillingManager;
import com.sandboxol.center.utils.IntentUtils;
import com.sandboxol.common.base.app.BaseFragment;

/* JADX INFO: compiled from: GameDetailFragment.java */
/* JADX INFO: loaded from: classes3.dex */
class N implements com.sandboxol.greendao.a.c<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ O f17926a;

    N(O o) {
        this.f17926a = o;
    }

    @Override // com.sandboxol.greendao.a.c
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onSuccess(Boolean bool) {
        if (bool.booleanValue()) {
            IntentUtils.startPasswordSettingDialog(((BaseFragment) this.f17926a.f17929c).context, true);
        } else {
            BillingManager.getInstance().updateUserMoney(((BaseFragment) this.f17926a.f17929c).context, this.f17926a.f17928b);
        }
    }

    @Override // com.sandboxol.greendao.a.c
    public void onError(int i, String str) {
    }
}
