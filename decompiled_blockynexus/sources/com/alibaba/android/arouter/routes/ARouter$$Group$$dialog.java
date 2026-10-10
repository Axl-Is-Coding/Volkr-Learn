package com.alibaba.android.arouter.routes;

import com.alibaba.android.arouter.facade.enums.RouteType;
import com.alibaba.android.arouter.facade.model.RouteMeta;
import com.alibaba.android.arouter.facade.template.IRouteGroup;
import com.disabngo.blockynexus.service.DialogService;
import com.sandboxol.center.router.path.RouterServicePath;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class ARouter$$Group$$dialog implements IRouteGroup {
    @Override // com.alibaba.android.arouter.facade.template.IRouteGroup
    public void loadInto(Map<String, RouteMeta> map) {
        map.put(RouterServicePath.EventDialog.DIALOG_SERVICE, RouteMeta.build(RouteType.PROVIDER, DialogService.class, RouterServicePath.EventDialog.DIALOG_SERVICE, "dialog", null, -1, Integer.MIN_VALUE));
    }
}
