package com.sandboxol.oversea.a;

import android.content.Context;
import com.android.billingclient.api.Purchase;
import com.sandboxol.center.config.StringConstant;
import com.sandboxol.center.router.manager.RechargeManager;
import com.sandboxol.center.router.moduleInfo.pay.BuyParam;
import com.sandboxol.center.router.moduleInfo.pay.PayOrder;

/* JADX INFO: compiled from: GoogleInventoryUtil.java */
/* JADX INFO: loaded from: classes4.dex */
public class h {
    public static void a(Context context, PayOrder payOrder) {
        Purchase purchase = payOrder.purchase;
        if (purchase == null || payOrder.code != 1) {
            return;
        }
        if (purchase.getSku().contains(StringConstant.MONEY_TYPE_DIAMOND) || payOrder.purchase.getSku().contains("cube") || payOrder.purchase.getSku().contains("game")) {
            d(context, payOrder.purchase);
            return;
        }
        if (payOrder.purchase.getSku().contains("vip")) {
            if (payOrder.purchase.getSku().contains(StringConstant.VIP_SUBSCRIBE_TYPE)) {
                c(context, payOrder.purchase, false);
                return;
            } else {
                c(context, payOrder.purchase);
                return;
            }
        }
        if (payOrder.purchase.getSku().contains("gift") || payOrder.purchase.getSku().contains("pass")) {
            b(context, payOrder.purchase, true);
        }
    }

    public static void b(Context context, Purchase purchase) {
        BuyParam buyParam = new BuyParam();
        buyParam.setSignature(purchase.getSignature());
        buyParam.setPurchaseData(purchase.getOriginalJson());
        buyParam.setSku(purchase.getSku());
        RechargeManager.buyVipExtend(context, buyParam, new d(purchase, context));
    }

    private static void c(Context context, Purchase purchase) {
        BuyParam buyParam = new BuyParam();
        buyParam.setSignature(purchase.getSignature());
        buyParam.setPurchaseData(purchase.getOriginalJson());
        buyParam.setSku(purchase.getSku());
        RechargeManager.buyVipExtend(context, buyParam, new b(purchase, context));
    }

    private static void d(Context context, Purchase purchase) {
        BuyParam buyParam = new BuyParam();
        buyParam.setSignature(purchase.getSignature());
        buyParam.setPurchaseData(purchase.getOriginalJson());
        buyParam.setSku(purchase.getSku());
        RechargeManager.recharge(context, buyParam, new a(purchase, context));
    }

    public static void b(Context context, Purchase purchase, boolean z) {
        BuyParam buyParam = new BuyParam();
        buyParam.setSignature(purchase.getSignature());
        buyParam.setPurchaseData(purchase.getOriginalJson());
        buyParam.setSku(purchase.getSku());
        RechargeManager.buyVip(context, buyParam, new f(purchase, context, buyParam, z));
    }

    public static void c(Context context, Purchase purchase, boolean z) {
        BuyParam buyParam = new BuyParam();
        buyParam.setSignature(purchase.getSignature());
        buyParam.setPurchaseData(purchase.getOriginalJson());
        buyParam.setSku(purchase.getSku());
        buyParam.setSub(true);
        RechargeManager.buySubs(context, buyParam, new e(purchase, z, context));
    }

    public static void a(Context context, Purchase purchase) {
        BuyParam buyParam = new BuyParam();
        buyParam.setSignature(purchase.getSignature());
        buyParam.setPurchaseData(purchase.getOriginalJson());
        buyParam.setSku(purchase.getSku());
        RechargeManager.recharge(context, buyParam, new c(purchase, context));
    }

    public static void a(Context context, Purchase purchase, boolean z) {
        BuyParam buyParam = new BuyParam();
        buyParam.setSignature(purchase.getSignature());
        buyParam.setPurchaseData(purchase.getOriginalJson());
        buyParam.setSku(purchase.getSku());
        RechargeManager.buyVip(context, buyParam, new g(purchase, z, context));
    }
}
