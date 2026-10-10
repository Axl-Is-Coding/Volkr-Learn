package com.alibaba.android.arouter.routes;

import com.alibaba.android.arouter.facade.enums.RouteType;
import com.alibaba.android.arouter.facade.model.RouteMeta;
import com.alibaba.android.arouter.facade.template.IProviderGroup;
import com.sandboxol.center.router.path.RouterServicePath;
import com.sandboxol.gamedetail.service.GameDetailService;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class ARouter$$Providers$$gamedetail implements IProviderGroup {
    @Override // com.alibaba.android.arouter.facade.template.IProviderGroup
    public void loadInto(Map<String, RouteMeta> map) {
        map.put("com.sandboxol.center.router.moduleApi.IGameDetailService", RouteMeta.build(RouteType.PROVIDER, GameDetailService.class, RouterServicePath.EventGameDetail.GAME_DETAIL_SERVICE, "game", null, -1, Integer.MIN_VALUE));
    }
}
