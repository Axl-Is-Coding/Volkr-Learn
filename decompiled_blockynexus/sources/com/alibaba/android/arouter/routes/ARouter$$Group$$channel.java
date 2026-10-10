package com.alibaba.android.arouter.routes;

import com.alibaba.android.arouter.facade.enums.RouteType;
import com.alibaba.android.arouter.facade.model.RouteMeta;
import com.alibaba.android.arouter.facade.template.IRouteGroup;
import com.sandboxol.center.router.path.RouterServicePath;
import com.sandboxol.oversea.service.ChannelService;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class ARouter$$Group$$channel implements IRouteGroup {
    @Override // com.alibaba.android.arouter.facade.template.IRouteGroup
    public void loadInto(Map<String, RouteMeta> map) {
        map.put(RouterServicePath.EventChannel.CHANNEL_SERVICE, RouteMeta.build(RouteType.PROVIDER, ChannelService.class, RouterServicePath.EventChannel.CHANNEL_SERVICE, "channel", null, -1, Integer.MIN_VALUE));
    }
}
