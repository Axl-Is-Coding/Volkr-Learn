package com.sandboxol.oversea.a;

import android.content.Context;
import android.util.Log;
import com.android.billingclient.api.Purchase;
import com.sandboxol.center.config.EventConstant;
import com.sandboxol.center.entity.AccountCenter;
import com.sandboxol.center.entity.RechargeEntity;
import com.sandboxol.center.router.manager.BillingManager;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.interfaces.ReportDataAdapter;

/* JADX INFO: compiled from: GoogleInventoryUtil.java */
/* JADX INFO: loaded from: classes4.dex */
class a extends OnResponseListener<RechargeEntity> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Purchase f18817a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ Context f18818b;

    a(Purchase purchase, Context context) {
        this.f18817a = purchase;
        this.f18818b = context;
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onError(int i, String str) {
        if (i == 5003) {
            BillingManager.getInstance().consumeAsync(this.f18817a, false);
        }
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onServerError(int i) {
        Log.e("recharge", String.valueOf(i));
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onSuccess(RechargeEntity rechargeEntity) {
        BillingManager.getInstance().consumeAsync(this.f18817a, false);
        if (rechargeEntity != null) {
            AccountCenter.newInstance().golds.set(Long.valueOf(rechargeEntity.getGolds()));
            AccountCenter.newInstance().diamonds.set(Long.valueOf(rechargeEntity.getDiamonds()));
            AccountCenter.newInstance().gDiamonds.set(Long.valueOf(rechargeEntity.getgDiamonds()));
            AccountCenter.putAccountInfo();
            ReportDataAdapter.onEvent(this.f18818b, EventConstant.TOPUP_DIA_CONSUME_SUC, this.f18817a.getSku());
        }
    }
}
