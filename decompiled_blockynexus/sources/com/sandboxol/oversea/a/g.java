package com.sandboxol.oversea.a;

import android.content.Context;
import com.android.billingclient.api.Purchase;
import com.sandboxol.center.config.MessageToken;
import com.sandboxol.center.entity.BuyVipEntity;
import com.sandboxol.center.router.manager.BillingManager;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.messenger.Messenger;
import com.sandboxol.common.utils.AppToastUtils;
import com.sandboxol.common.utils.HttpUtils;
import com.sandboxol.oversea.R;

/* JADX INFO: compiled from: GoogleInventoryUtil.java */
/* JADX INFO: loaded from: classes4.dex */
class g extends OnResponseListener<BuyVipEntity> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Purchase f18832a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ boolean f18833b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ Context f18834c;

    g(Purchase purchase, boolean z, Context context) {
        this.f18832a = purchase;
        this.f18833b = z;
        this.f18834c = context;
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onSuccess(BuyVipEntity buyVipEntity) {
        BillingManager.getInstance().consumeAsync(this.f18832a, true);
        Messenger.getDefault().send(this.f18832a.getSku(), MessageToken.TOKEN_DRAGON_BALL_RECHARGE_SUCCESS);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onError(int i, String str) {
        if (this.f18833b) {
            if (i == 5003) {
                BillingManager.getInstance().consumeAsync(this.f18832a, true);
            }
        } else if (i == 5001) {
            AppToastUtils.showShortNegativeTipToast(this.f18834c, R.string.recharge_invalid_order);
        } else if (i == 5002) {
            AppToastUtils.showShortNegativeTipToast(this.f18834c, R.string.good_invalid_good_id);
        } else if (i == 5003) {
            BillingManager.getInstance().consumeAsync(this.f18832a, true);
        }
        Messenger.getDefault().sendNoMsg(MessageToken.TOKEN_ACTIVITY_RECHARGE_FAILED);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onServerError(int i) {
        if (!this.f18833b) {
            Context context = this.f18834c;
            AppToastUtils.showShortNegativeTipToast(context, HttpUtils.getHttpErrorMsg(context, i));
        }
        Messenger.getDefault().sendNoMsg(MessageToken.TOKEN_ACTIVITY_RECHARGE_FAILED);
    }
}
