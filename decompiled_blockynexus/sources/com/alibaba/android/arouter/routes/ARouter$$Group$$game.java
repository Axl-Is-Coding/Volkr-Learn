package com.alibaba.android.arouter.routes;

import com.alibaba.android.arouter.facade.enums.RouteType;
import com.alibaba.android.arouter.facade.model.RouteMeta;
import com.alibaba.android.arouter.facade.template.IRouteGroup;
import com.sandboxol.center.router.path.RouterFragmentPath;
import com.sandboxol.center.router.path.RouterServicePath;
import com.sandboxol.gamedetail.c.a.a.P;
import com.sandboxol.gamedetail.service.GameDetailService;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class ARouter$$Group$$game implements IRouteGroup {
    @Override // com.alibaba.android.arouter.facade.template.IRouteGroup
    public void loadInto(Map<String, RouteMeta> map) {
        map.put(RouterFragmentPath.GameDetailModule.PAGER_GAME_DETAIL, RouteMeta.build(RouteType.FRAGMENT, P.class, RouterFragmentPath.GameDetailModule.PAGER_GAME_DETAIL, "game", null, -1, Integer.MIN_VALUE));
        map.put(RouterServicePath.EventGameDetail.GAME_DETAIL_SERVICE, RouteMeta.build(RouteType.PROVIDER, GameDetailService.class, RouterServicePath.EventGameDetail.GAME_DETAIL_SERVICE, "game", null, -1, Integer.MIN_VALUE));
    }
}
