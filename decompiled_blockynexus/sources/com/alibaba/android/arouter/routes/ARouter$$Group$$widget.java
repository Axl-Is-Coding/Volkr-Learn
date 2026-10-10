package com.alibaba.android.arouter.routes;

import com.alibaba.android.arouter.facade.enums.RouteType;
import com.alibaba.android.arouter.facade.model.RouteMeta;
import com.alibaba.android.arouter.facade.template.IRouteGroup;
import com.disabngo.blockynexus.service.WidgetService;
import com.sandboxol.center.router.path.RouterServicePath;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class ARouter$$Group$$widget implements IRouteGroup {
    @Override // com.alibaba.android.arouter.facade.template.IRouteGroup
    public void loadInto(Map<String, RouteMeta> map) {
        map.put(RouterServicePath.EventWidget.WIDGET_SERVICE, RouteMeta.build(RouteType.PROVIDER, WidgetService.class, RouterServicePath.EventWidget.WIDGET_SERVICE, "widget", null, -1, Integer.MIN_VALUE));
    }
}
