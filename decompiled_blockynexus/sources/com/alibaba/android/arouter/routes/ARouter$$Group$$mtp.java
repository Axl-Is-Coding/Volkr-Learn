package com.alibaba.android.arouter.routes;

import com.alibaba.android.arouter.facade.enums.RouteType;
import com.alibaba.android.arouter.facade.model.RouteMeta;
import com.alibaba.android.arouter.facade.template.IRouteGroup;
import com.sandboxol.center.router.path.RouterServicePath;
import com.sandboxol.mtp.MtpService;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class ARouter$$Group$$mtp implements IRouteGroup {
    @Override // com.alibaba.android.arouter.facade.template.IRouteGroup
    public void loadInto(Map<String, RouteMeta> map) {
        map.put(RouterServicePath.EventMtp.MTP_SERVICE, RouteMeta.build(RouteType.PROVIDER, MtpService.class, RouterServicePath.EventMtp.MTP_SERVICE, "mtp", null, -1, Integer.MIN_VALUE));
    }
}
