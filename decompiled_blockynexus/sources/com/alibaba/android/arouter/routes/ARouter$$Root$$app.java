package com.alibaba.android.arouter.routes;

import com.alibaba.android.arouter.facade.template.IRouteGroup;
import com.alibaba.android.arouter.facade.template.IRouteRoot;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class ARouter$$Root$$app implements IRouteRoot {
    @Override // com.alibaba.android.arouter.facade.template.IRouteRoot
    public void loadInto(Map<String, Class<? extends IRouteGroup>> map) {
        map.put(FirebaseAnalytics.Param.CAMPAIGN, ARouter$$Group$$campaign.class);
        map.put("dialog", ARouter$$Group$$dialog.class);
        map.put("download", ARouter$$Group$$download.class);
        map.put("friend", ARouter$$Group$$friend.class);
        map.put("main", ARouter$$Group$$main.class);
        map.put("partydress", ARouter$$Group$$partydress.class);
        map.put("rong", ARouter$$Group$$rong.class);
        map.put("widget", ARouter$$Group$$widget.class);
    }
}
