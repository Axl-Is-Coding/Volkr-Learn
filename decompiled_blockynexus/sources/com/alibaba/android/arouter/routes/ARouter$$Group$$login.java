package com.alibaba.android.arouter.routes;

import com.alibaba.android.arouter.facade.enums.RouteType;
import com.alibaba.android.arouter.facade.model.RouteMeta;
import com.alibaba.android.arouter.facade.template.IRouteGroup;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.sandbox.login.LoginService;
import com.sandboxol.center.router.path.RouterServicePath;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class ARouter$$Group$$login implements IRouteGroup {
    @Override // com.alibaba.android.arouter.facade.template.IRouteGroup
    public void loadInto(Map<String, RouteMeta> map) {
        map.put(RouterServicePath.EventLogin.LOGIN_SERVICE, RouteMeta.build(RouteType.PROVIDER, LoginService.class, RouterServicePath.EventLogin.LOGIN_SERVICE, FirebaseAnalytics.Event.LOGIN, null, -1, Integer.MIN_VALUE));
    }
}
