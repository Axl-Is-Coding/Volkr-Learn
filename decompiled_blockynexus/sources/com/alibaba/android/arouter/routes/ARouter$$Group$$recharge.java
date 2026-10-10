package com.alibaba.android.arouter.routes;

import com.alibaba.android.arouter.facade.enums.RouteType;
import com.alibaba.android.arouter.facade.model.RouteMeta;
import com.alibaba.android.arouter.facade.template.IRouteGroup;
import com.sandboxol.center.router.path.RouterFragmentPath;
import com.sandboxol.center.router.path.RouterServicePath;
import com.sandboxol.googlepay.service.RechargeService;
import com.sandboxol.googlepay.view.fragment.recharge.k;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class ARouter$$Group$$recharge implements IRouteGroup {
    @Override // com.alibaba.android.arouter.facade.template.IRouteGroup
    public void loadInto(Map<String, RouteMeta> map) {
        map.put(RouterFragmentPath.RechargeModule.PAGER_RECHARGE, RouteMeta.build(RouteType.FRAGMENT, k.class, RouterFragmentPath.RechargeModule.PAGER_RECHARGE, "recharge", null, -1, Integer.MIN_VALUE));
        map.put(RouterServicePath.EventRecharge.RECHARGE_SERVICE, RouteMeta.build(RouteType.PROVIDER, RechargeService.class, RouterServicePath.EventRecharge.RECHARGE_SERVICE, "recharge", null, -1, Integer.MIN_VALUE));
    }
}
