package com.sandboxol.center.router.manager;

import android.content.Context;
import com.sandboxol.center.router.RouteServiceManager;
import com.sandboxol.center.router.moduleApi.IVipService;
import com.sandboxol.center.router.moduleInfo.pay.VipProductEntity;
import com.sandboxol.center.router.path.RouterServicePath;

/* JADX INFO: loaded from: classes3.dex */
public class VipManager {
    private static IVipService iVipService = (IVipService) RouteServiceManager.provide(RouterServicePath.EventVip.VIP_SERVICE);

    public static void buyVip(Context context, int i, String str) {
        IVipService iVipService2 = iVipService;
        if (iVipService2 != null) {
            iVipService2.buyVip(context, i, str);
        }
    }

    public static void enterVipFragment(Context context) {
        IVipService iVipService2 = iVipService;
        if (iVipService2 != null) {
            iVipService2.enterVipFragment(context);
        }
    }

    public static VipProductEntity getProductEntityByVipType(boolean z, int i) {
        IVipService iVipService2 = iVipService;
        if (iVipService2 != null) {
            return iVipService2.getProductEntityByVipType(z, i);
        }
        return null;
    }

    public static boolean getSubscribeStatus(int i) {
        IVipService iVipService2 = iVipService;
        if (iVipService2 != null) {
            return iVipService2.getSubscribeStatus(i);
        }
        return false;
    }

    public static int getVipSubsDiamond(int i) {
        IVipService iVipService2 = iVipService;
        if (iVipService2 != null) {
            return iVipService2.getVipSubsDiamond(i);
        }
        return 0;
    }

    public static String getVipSubsFree(int i) {
        IVipService iVipService2 = iVipService;
        return iVipService2 != null ? iVipService2.getVipSubsFree(i) : "";
    }

    public static void reportAlreadyOwnedVipSub(Context context) {
        IVipService iVipService2 = iVipService;
        if (iVipService2 != null) {
            iVipService2.reportAlreadyOwnedVipSub(context);
        }
    }

    public static void reportHomeVipClick(Context context) {
        IVipService iVipService2 = iVipService;
        if (iVipService2 != null) {
            iVipService2.reportHomeVipClick(context);
        }
    }

    public static void reportRechargePageVipClick(Context context, String str) {
        IVipService iVipService2 = iVipService;
        if (iVipService2 != null) {
            iVipService2.reportRechargePageVipClick(context, str);
        }
    }

    public static void reportVipSubWin(Context context) {
        IVipService iVipService2 = iVipService;
        if (iVipService2 != null) {
            iVipService2.reportVipSubWin(context);
        }
    }

    public static void reportVipSubscribeFail(Context context, String str) {
        IVipService iVipService2 = iVipService;
        if (iVipService2 != null) {
            iVipService2.reportVipSubscribeFail(context, str);
        }
    }

    public static void reportVipSubscribeSuccess(Context context, String str) {
        IVipService iVipService2 = iVipService;
        if (iVipService2 != null) {
            iVipService2.reportVipSubscribeSuccess(context, str);
        }
    }

    public static void resetVipInfo() {
        IVipService iVipService2 = iVipService;
        if (iVipService2 != null) {
            iVipService2.resetVipInfo();
        }
    }

    public static void showSubscribeDialog(Context context) {
        IVipService iVipService2 = iVipService;
        if (iVipService2 != null) {
            iVipService2.showSubscribeDialog(context);
        }
    }
}
