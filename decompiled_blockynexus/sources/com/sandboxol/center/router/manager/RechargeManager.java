package com.sandboxol.center.router.manager;

import android.content.Context;
import com.sandboxol.center.entity.BuyVipEntity;
import com.sandboxol.center.entity.RechargeEntity;
import com.sandboxol.center.router.RouteServiceManager;
import com.sandboxol.center.router.moduleApi.IRechargeService;
import com.sandboxol.center.router.moduleInfo.pay.BuyParam;
import com.sandboxol.center.router.path.RouterServicePath;
import com.sandboxol.common.base.web.OnResponseListener;

/* JADX INFO: loaded from: classes3.dex */
public class RechargeManager {
    private static IRechargeService iRechargeService = (IRechargeService) RouteServiceManager.provide(RouterServicePath.EventRecharge.RECHARGE_SERVICE);

    public static void buySubs(Context context, BuyParam buyParam, OnResponseListener<BuyVipEntity> onResponseListener) {
        IRechargeService iRechargeService2 = iRechargeService;
        if (iRechargeService2 != null) {
            iRechargeService2.buySubs(context, buyParam, onResponseListener);
        }
    }

    public static void buyVip(Context context, BuyParam buyParam, OnResponseListener<BuyVipEntity> onResponseListener) {
        IRechargeService iRechargeService2 = iRechargeService;
        if (iRechargeService2 != null) {
            iRechargeService2.buyVip(context, buyParam, onResponseListener);
        }
    }

    public static void buyVipExtend(Context context, BuyParam buyParam, OnResponseListener<BuyVipEntity> onResponseListener) {
        IRechargeService iRechargeService2 = iRechargeService;
        if (iRechargeService2 != null) {
            iRechargeService2.buyVipExtend(context, buyParam, onResponseListener);
        }
    }

    public static void recharge(Context context, BuyParam buyParam, OnResponseListener<RechargeEntity> onResponseListener) {
        IRechargeService iRechargeService2 = iRechargeService;
        if (iRechargeService2 != null) {
            iRechargeService2.recharge(context, buyParam, onResponseListener);
        }
    }
}
