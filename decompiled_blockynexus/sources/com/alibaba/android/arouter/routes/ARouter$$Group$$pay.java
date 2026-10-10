package com.alibaba.android.arouter.routes;

import com.alibaba.android.arouter.facade.enums.RouteType;
import com.alibaba.android.arouter.facade.model.RouteMeta;
import com.alibaba.android.arouter.facade.template.IRouteGroup;
import com.sandboxol.center.router.path.RouterServicePath;
import com.sandboxol.googlepay.billing.GooglePlayPayService;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class ARouter$$Group$$pay implements IRouteGroup {
    @Override // com.alibaba.android.arouter.facade.template.IRouteGroup
    public void loadInto(Map<String, RouteMeta> map) {
        map.put(RouterServicePath.EventGooglePlayPay.PAY_SERVICE, RouteMeta.build(RouteType.PROVIDER, GooglePlayPayService.class, RouterServicePath.EventGooglePlayPay.PAY_SERVICE, "pay", null, -1, Integer.MIN_VALUE));
    }
}
