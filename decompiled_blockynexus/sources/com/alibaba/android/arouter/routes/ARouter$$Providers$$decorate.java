package com.alibaba.android.arouter.routes;

import com.alibaba.android.arouter.facade.enums.RouteType;
import com.alibaba.android.arouter.facade.model.RouteMeta;
import com.alibaba.android.arouter.facade.template.IProviderGroup;
import com.sandboxol.center.router.path.RouterServicePath;
import com.sandboxol.decorate.DressService;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class ARouter$$Providers$$decorate implements IProviderGroup {
    @Override // com.alibaba.android.arouter.facade.template.IProviderGroup
    public void loadInto(Map<String, RouteMeta> map) {
        map.put("com.sandboxol.center.router.moduleApi.IDressService", RouteMeta.build(RouteType.PROVIDER, DressService.class, RouterServicePath.EventDress.DRESS_SERVICE, "dress", null, -1, Integer.MIN_VALUE));
    }
}
