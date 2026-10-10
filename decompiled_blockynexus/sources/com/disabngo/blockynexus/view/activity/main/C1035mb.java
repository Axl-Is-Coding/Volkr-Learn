package com.disabngo.blockynexus.view.activity.main;

import com.sandboxol.center.router.manager.BillingManager;
import com.sandboxol.center.utils.IntentUtils;

/* JADX INFO: renamed from: com.disabngo.blockynexus.view.activity.main.mb, reason: case insensitive filesystem */
/* JADX INFO: compiled from: MainActivity.java */
/* JADX INFO: loaded from: classes2.dex */
class C1035mb implements com.sandboxol.greendao.a.c<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ C1038nb f10930a;

    C1035mb(C1038nb c1038nb) {
        this.f10930a = c1038nb;
    }

    @Override // com.sandboxol.greendao.a.c
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onSuccess(Boolean bool) {
        if (bool.booleanValue()) {
            IntentUtils.startPasswordSettingDialog(this.f10930a.f10936c, true);
            return;
        }
        BillingManager billingManager = BillingManager.getInstance();
        C1038nb c1038nb = this.f10930a;
        billingManager.updateUserMoney(c1038nb.f10936c, c1038nb.f10935b);
    }

    @Override // com.sandboxol.greendao.a.c
    public void onError(int i, String str) {
    }
}
