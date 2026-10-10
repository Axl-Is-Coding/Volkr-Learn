package com.alibaba.android.arouter.routes;

import com.alibaba.android.arouter.facade.enums.RouteType;
import com.alibaba.android.arouter.facade.model.RouteMeta;
import com.alibaba.android.arouter.facade.template.IProviderGroup;
import com.sandboxol.center.router.path.RouterServicePath;
import com.sandboxol.oversea.service.AdsService;
import com.sandboxol.oversea.service.ChannelService;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class ARouter$$Providers$$oversea implements IProviderGroup {
    @Override // com.alibaba.android.arouter.facade.template.IProviderGroup
    public void loadInto(Map<String, RouteMeta> map) {
        map.put("com.sandboxol.center.router.moduleApi.IAdsService", RouteMeta.build(RouteType.PROVIDER, AdsService.class, RouterServicePath.EventAds.ADS_SERVICE, "ads", null, -1, Integer.MIN_VALUE));
        map.put("com.sandboxol.center.router.moduleApi.IChannelService", RouteMeta.build(RouteType.PROVIDER, ChannelService.class, RouterServicePath.EventChannel.CHANNEL_SERVICE, "channel", null, -1, Integer.MIN_VALUE));
    }
}
