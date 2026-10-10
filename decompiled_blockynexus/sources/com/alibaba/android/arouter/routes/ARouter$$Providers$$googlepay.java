package com.alibaba.android.arouter.routes;

import com.alibaba.android.arouter.facade.enums.RouteType;
import com.alibaba.android.arouter.facade.model.RouteMeta;
import com.alibaba.android.arouter.facade.template.IProviderGroup;
import com.sandboxol.center.router.path.RouterServicePath;
import com.sandboxol.googlepay.billing.GooglePlayPayService;
import com.sandboxol.googlepay.service.RechargeService;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class ARouter$$Providers$$googlepay implements IProviderGroup {
    @Override // com.alibaba.android.arouter.facade.template.IProviderGroup
    public void loadInto(Map<String, RouteMeta> map) {
        map.put("com.sandboxol.center.router.moduleApi.IRechargeService", RouteMeta.build(RouteType.PROVIDER, RechargeService.class, RouterServicePath.EventRecharge.RECHARGE_SERVICE, "recharge", null, -1, Integer.MIN_VALUE));
        map.put("com.sandboxol.center.router.moduleApi.IGooglePlayPayService", RouteMeta.build(RouteType.PROVIDER, GooglePlayPayService.class, RouterServicePath.EventGooglePlayPay.PAY_SERVICE, "pay", null, -1, Integer.MIN_VALUE));
    }
}
