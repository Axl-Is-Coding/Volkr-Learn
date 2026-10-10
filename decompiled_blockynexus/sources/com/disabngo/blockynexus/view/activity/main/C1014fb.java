package com.disabngo.blockynexus.view.activity.main;

import android.os.Bundle;
import com.sandboxol.center.config.EventConstant;
import com.sandboxol.center.config.MessageToken;
import com.sandboxol.center.config.StringConstant;
import com.sandboxol.center.entity.AccountCenter;
import com.sandboxol.center.utils.IntentUtils;
import com.sandboxol.common.interfaces.ReportDataAdapter;

/* JADX INFO: renamed from: com.disabngo.blockynexus.view.activity.main.fb, reason: case insensitive filesystem */
/* JADX INFO: compiled from: MainActivity.java */
/* JADX INFO: loaded from: classes2.dex */
class C1014fb implements com.sandboxol.messager.a.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ MainActivity f10899a;

    C1014fb(MainActivity mainActivity) {
        this.f10899a = mainActivity;
    }

    @Override // com.sandboxol.messager.a.b
    public void onCall(com.sandboxol.messager.a.f fVar) {
        Bundle bundleA = fVar.a();
        if (bundleA != null) {
            String string = bundleA.getString(StringConstant.PRODUCT_ID);
            String string2 = bundleA.getString(StringConstant.RECHARGE_PARAMS);
            if (string2 == null || "".equals(string2)) {
                IntentUtils.startGooglePayActivity(this.f10899a, string, MessageToken.TOKEN_RECHARGE_PAY, "userId=" + AccountCenter.newInstance().userId.get());
            } else if (string2.startsWith("userId")) {
                IntentUtils.startGooglePayActivity(this.f10899a, string, MessageToken.TOKEN_RECHARGE_PAY, "userId=" + AccountCenter.newInstance().userId.get(), string2);
            } else {
                IntentUtils.startGooglePayActivity(this.f10899a, string, MessageToken.TOKEN_RECHARGE_PAY, "userId=" + AccountCenter.newInstance().userId.get() + "&" + string2);
            }
            ReportDataAdapter.onEvent(this.f10899a, EventConstant.TOP_UP_GOOGLE_GAME, string);
        }
    }
}
