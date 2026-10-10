package com.alibaba.android.arouter.routes;

import com.alibaba.android.arouter.facade.enums.RouteType;
import com.alibaba.android.arouter.facade.model.RouteMeta;
import com.alibaba.android.arouter.facade.template.IRouteGroup;
import com.disabngo.blockynexus.service.CampaignService;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.sandboxol.center.router.path.RouterServicePath;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class ARouter$$Group$$campaign implements IRouteGroup {
    @Override // com.alibaba.android.arouter.facade.template.IRouteGroup
    public void loadInto(Map<String, RouteMeta> map) {
        map.put(RouterServicePath.EventCampaign.CAMPAIGN_SERVICE, RouteMeta.build(RouteType.PROVIDER, CampaignService.class, RouterServicePath.EventCampaign.CAMPAIGN_SERVICE, FirebaseAnalytics.Param.CAMPAIGN, null, -1, Integer.MIN_VALUE));
    }
}
