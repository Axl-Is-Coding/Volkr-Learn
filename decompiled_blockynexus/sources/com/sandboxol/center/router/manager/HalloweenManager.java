package com.sandboxol.center.router.manager;

import android.content.Context;
import com.sandboxol.center.router.RouteServiceManager;
import com.sandboxol.center.router.moduleApi.IHalloweenService;
import com.sandboxol.center.router.path.RouterServicePath;

/* JADX INFO: loaded from: classes3.dex */
public class HalloweenManager {
    private static IHalloweenService iHalloweenService = (IHalloweenService) RouteServiceManager.provide(RouterServicePath.EventHalloween.HALLOWEEN_SERVICE);

    public static void enterActivity(Context context) {
        IHalloweenService iHalloweenService2 = iHalloweenService;
        if (iHalloweenService2 != null) {
            iHalloweenService2.enterActivity(context);
        }
    }

    public static void openActivity(Context context) {
        IHalloweenService iHalloweenService2 = iHalloweenService;
        if (iHalloweenService2 != null) {
            iHalloweenService2.openActivity(context);
        }
    }
}
