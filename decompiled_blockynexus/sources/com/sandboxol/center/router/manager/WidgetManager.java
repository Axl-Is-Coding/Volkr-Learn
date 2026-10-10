package com.sandboxol.center.router.manager;

import com.sandboxol.center.router.RouteServiceManager;
import com.sandboxol.center.router.moduleApi.IWidgetService;
import com.sandboxol.center.router.path.RouterServicePath;
import com.sandboxol.greendao.entity.BannerEntity;
import com.youth.banner.Banner;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class WidgetManager {
    private static IWidgetService iWidgetService = (IWidgetService) RouteServiceManager.provide(RouterServicePath.EventWidget.WIDGET_SERVICE);

    public static void bannerEntities(Banner banner, List<BannerEntity> list) {
        IWidgetService iWidgetService2 = iWidgetService;
        if (iWidgetService2 != null) {
            iWidgetService2.bannerEntities(banner, list);
        }
    }
}
