package com.disabngo.blockynexus.view.activity.main;

import com.sandboxol.center.config.EventConstant;
import com.sandboxol.common.interfaces.ReportDataAdapter;
import com.sandboxol.common.utils.FirebaseUtils;

/* JADX INFO: compiled from: MainViewModel.java */
/* JADX INFO: loaded from: classes2.dex */
class mc implements com.sandboxol.messager.a.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ nc f10931a;

    mc(nc ncVar) {
        this.f10931a = ncVar;
    }

    @Override // com.sandboxol.messager.a.a
    public void onCall() {
        ReportDataAdapter.onEvent(this.f10931a.f10939c, EventConstant.ENTER_RECHARGE_PAGE_GAME);
        FirebaseUtils.onEvent(this.f10931a.f10939c, EventConstant.ENTER_RECHARGE_PAGE_GAME);
    }
}
