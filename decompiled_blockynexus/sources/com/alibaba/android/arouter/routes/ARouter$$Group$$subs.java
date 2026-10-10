package com.alibaba.android.arouter.routes;

import com.alibaba.android.arouter.facade.enums.RouteType;
import com.alibaba.android.arouter.facade.model.RouteMeta;
import com.alibaba.android.arouter.facade.template.IRouteGroup;
import com.android.billingclient.api.BillingClient;
import com.sandboxol.center.router.path.RouterServicePath;
import com.sandboxol.vip.service.VipService;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class ARouter$$Group$$subs implements IRouteGroup {
    @Override // com.alibaba.android.arouter.facade.template.IRouteGroup
    public void loadInto(Map<String, RouteMeta> map) {
        map.put(RouterServicePath.EventVip.VIP_SERVICE, RouteMeta.build(RouteType.PROVIDER, VipService.class, RouterServicePath.EventVip.VIP_SERVICE, BillingClient.SkuType.SUBS, null, -1, Integer.MIN_VALUE));
    }
}
