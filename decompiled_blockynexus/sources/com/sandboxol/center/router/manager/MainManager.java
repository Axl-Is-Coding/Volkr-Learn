package com.sandboxol.center.router.manager;

import com.sandboxol.center.router.RouteServiceManager;
import com.sandboxol.center.router.moduleApi.IMainService;
import com.sandboxol.center.router.path.RouterServicePath;

/* JADX INFO: loaded from: classes3.dex */
public class MainManager {
    private static IMainService iMainService = (IMainService) RouteServiceManager.provide(RouterServicePath.EventMain.MAIN_SERVICE);

    public static int getPageAnimDirection() {
        IMainService iMainService2 = iMainService;
        if (iMainService2 != null) {
            return iMainService2.getPageAnimDirection();
        }
        return 1;
    }

    public static void setPageIndex(boolean z, int i) {
        IMainService iMainService2 = iMainService;
        if (iMainService2 != null) {
            iMainService2.setPageIndex(z, i);
        }
    }
}
