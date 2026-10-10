package com.alibaba.android.arouter.routes;

import com.alibaba.android.arouter.facade.enums.RouteType;
import com.alibaba.android.arouter.facade.model.RouteMeta;
import com.alibaba.android.arouter.facade.template.IRouteGroup;
import com.sandboxol.center.config.ActivityType;
import com.sandboxol.center.router.path.RouterServicePath;
import com.sandboxol.halloween.HalloweenService;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class ARouter$$Group$$halloween implements IRouteGroup {
    @Override // com.alibaba.android.arouter.facade.template.IRouteGroup
    public void loadInto(Map<String, RouteMeta> map) {
        map.put(RouterServicePath.EventHalloween.HALLOWEEN_SERVICE, RouteMeta.build(RouteType.PROVIDER, HalloweenService.class, RouterServicePath.EventHalloween.HALLOWEEN_SERVICE, ActivityType.HALLOWEEN, null, -1, Integer.MIN_VALUE));
    }
}
