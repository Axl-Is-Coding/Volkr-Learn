package com.alibaba.android.arouter.routes;

import com.alibaba.android.arouter.facade.enums.RouteType;
import com.alibaba.android.arouter.facade.model.RouteMeta;
import com.alibaba.android.arouter.facade.template.IRouteGroup;
import com.sandboxol.center.router.path.RouterServicePath;
import com.sandboxol.oversea.service.AdsService;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class ARouter$$Group$$ads implements IRouteGroup {
    @Override // com.alibaba.android.arouter.facade.template.IRouteGroup
    public void loadInto(Map<String, RouteMeta> map) {
        map.put(RouterServicePath.EventAds.ADS_SERVICE, RouteMeta.build(RouteType.PROVIDER, AdsService.class, RouterServicePath.EventAds.ADS_SERVICE, "ads", null, -1, Integer.MIN_VALUE));
    }
}
