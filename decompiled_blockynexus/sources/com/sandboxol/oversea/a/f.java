package com.sandboxol.oversea.a;

import android.content.Context;
import com.android.billingclient.api.Purchase;
import com.sandboxol.center.config.EventConstant;
import com.sandboxol.center.config.MessageToken;
import com.sandboxol.center.entity.BuyVipEntity;
import com.sandboxol.center.router.manager.BillingManager;
import com.sandboxol.center.router.moduleInfo.pay.BuyParam;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.interfaces.ReportDataAdapter;
import com.sandboxol.common.messenger.Messenger;
import com.sandboxol.common.utils.AppToastUtils;
import com.sandboxol.common.utils.HttpUtils;
import com.sandboxol.oversea.R;

/* JADX INFO: compiled from: GoogleInventoryUtil.java */
/* JADX INFO: loaded from: classes4.dex */
class f extends OnResponseListener<BuyVipEntity> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Purchase f18828a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ Context f18829b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ BuyParam f18830c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ boolean f18831d;

    f(Purchase purchase, Context context, BuyParam buyParam, boolean z) {
        this.f18828a = purchase;
        this.f18829b = context;
        this.f18830c = buyParam;
        this.f18831d = z;
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onSuccess(BuyVipEntity buyVipEntity) {
        BillingManager.getInstance().consumeAsync(this.f18828a, true);
        Messenger.getDefault().sendNoMsg(MessageToken.TOKEN_CHRISTMAS_BUY_GIF_SUCCESS);
        ReportDataAdapter.onEvent(this.f18829b, EventConstant.GIF_BUY_SUCCESS, this.f18830c.getSku());
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onError(int i, String str) {
        if (this.f18831d) {
            if (i == 5003) {
                BillingManager.getInstance().consumeAsync(this.f18828a, true);
            }
        } else if (i == 5001) {
            AppToastUtils.showShortNegativeTipToast(this.f18829b, R.string.recharge_invalid_order);
        } else if (i == 5002) {
            AppToastUtils.showShortNegativeTipToast(this.f18829b, R.string.good_invalid_good_id);
        } else if (i == 5003) {
            BillingManager.getInstance().consumeAsync(this.f18828a, true);
        }
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onServerError(int i) {
        if (this.f18831d) {
            return;
        }
        Context context = this.f18829b;
        AppToastUtils.showShortNegativeTipToast(context, HttpUtils.getHttpErrorMsg(context, i));
    }
}
