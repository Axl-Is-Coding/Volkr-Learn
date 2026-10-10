package com.disabngo.blockynexus.view.activity.main;

import com.sandboxol.center.router.manager.BillingManager;
import com.sandboxol.center.utils.IntentUtils;

/* JADX INFO: compiled from: MainViewModel.java */
/* JADX INFO: loaded from: classes2.dex */
class ic implements com.sandboxol.greendao.a.c<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ jc f10913a;

    ic(jc jcVar) {
        this.f10913a = jcVar;
    }

    @Override // com.sandboxol.greendao.a.c
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onSuccess(Boolean bool) {
        if (bool.booleanValue()) {
            IntentUtils.startPasswordSettingDialog(this.f10913a.f10919c.f10939c, true);
        } else {
            BillingManager.getInstance().updateUserMoney(this.f10913a.f10919c.f10939c, this.f10913a.f10918b);
        }
    }

    @Override // com.sandboxol.greendao.a.c
    public void onError(int i, String str) {
    }
}
