package com.disabngo.blockynexus.view.activity.main;

import com.sandboxol.center.config.EventConstant;
import com.sandboxol.center.router.manager.BillingManager;
import com.sandboxol.common.interfaces.ReportDataAdapter;

/* JADX INFO: renamed from: com.disabngo.blockynexus.view.activity.main.wb, reason: case insensitive filesystem */
/* JADX INFO: compiled from: MainActivity.java */
/* JADX INFO: loaded from: classes2.dex */
class C1064wb implements com.sandboxol.messager.a.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ MainActivity f10981a;

    C1064wb(MainActivity mainActivity) {
        this.f10981a = mainActivity;
    }

    @Override // com.sandboxol.messager.a.a
    public void onCall() {
        ReportDataAdapter.onEvent(this.f10981a, EventConstant.BUY_ACT_SUCCESS);
        BillingManager.getInstance().updateUserMoney(this.f10981a);
    }
}
