package com.disabngo.blockynexus.view.activity.main;

import android.os.Bundle;
import com.sandboxol.center.config.EventConstant;
import com.sandboxol.center.config.StringConstant;
import com.sandboxol.common.interfaces.ReportDataAdapter;
import com.sandboxol.common.utils.FirebaseUtils;

/* JADX INFO: compiled from: MainViewModel.java */
/* JADX INFO: loaded from: classes2.dex */
class cc implements com.sandboxol.messager.a.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ nc f10888a;

    cc(nc ncVar) {
        this.f10888a = ncVar;
    }

    @Override // com.sandboxol.messager.a.b
    public void onCall(com.sandboxol.messager.a.f fVar) {
        Bundle bundleA = fVar.a();
        if (bundleA != null) {
            String string = bundleA.getString(StringConstant.PRODUCT_ID);
            ReportDataAdapter.onEvent(this.f10888a.f10939c, EventConstant.TOP_UP_DIAMONDS_GAME, string);
            FirebaseUtils.onEvent(this.f10888a.f10939c, EventConstant.TOP_UP_DIAMONDS_GAME, string);
        }
    }
}
