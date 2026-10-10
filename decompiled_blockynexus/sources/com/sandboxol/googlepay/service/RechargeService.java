package com.sandboxol.googlepay.service;

import android.content.Context;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.sandboxol.center.entity.BuyVipEntity;
import com.sandboxol.center.entity.RechargeEntity;
import com.sandboxol.center.router.moduleApi.IRechargeService;
import com.sandboxol.center.router.moduleApi.a;
import com.sandboxol.center.router.moduleInfo.pay.BuyParam;
import com.sandboxol.center.router.path.RouterServicePath;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.googlepay.view.fragment.recharge.t;

/* JADX INFO: loaded from: classes3.dex */
@Route(path = RouterServicePath.EventRecharge.RECHARGE_SERVICE)
public class RechargeService implements IRechargeService {
    @Override // com.sandboxol.center.router.moduleApi.IRechargeService
    public void buySubs(Context context, BuyParam buyParam, OnResponseListener<BuyVipEntity> onResponseListener) {
        new t().a(context, buyParam, onResponseListener);
    }

    @Override // com.sandboxol.center.router.moduleApi.IRechargeService
    public void buyVip(Context context, BuyParam buyParam, OnResponseListener<BuyVipEntity> onResponseListener) {
        new t().b(context, buyParam, onResponseListener);
    }

    @Override // com.sandboxol.center.router.moduleApi.IRechargeService
    public void buyVipExtend(Context context, BuyParam buyParam, OnResponseListener<BuyVipEntity> onResponseListener) {
        new t().c(context, buyParam, onResponseListener);
    }

    @Override // com.sandboxol.center.router.moduleApi.IBaseService, com.alibaba.android.arouter.facade.template.IProvider
    public /* synthetic */ void init(Context context) {
        a.a(this, context);
    }

    @Override // com.sandboxol.center.router.moduleApi.IRechargeService
    public void recharge(Context context, BuyParam buyParam, OnResponseListener<RechargeEntity> onResponseListener) {
        new t().d(context, buyParam, onResponseListener);
    }
}
