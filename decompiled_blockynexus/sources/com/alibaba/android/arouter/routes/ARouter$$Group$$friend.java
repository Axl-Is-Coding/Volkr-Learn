package com.alibaba.android.arouter.routes;

import com.alibaba.android.arouter.facade.enums.RouteType;
import com.alibaba.android.arouter.facade.model.RouteMeta;
import com.alibaba.android.arouter.facade.template.IRouteGroup;
import com.disabngo.blockynexus.service.FriendService;
import com.sandboxol.center.router.path.RouterServicePath;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class ARouter$$Group$$friend implements IRouteGroup {
    @Override // com.alibaba.android.arouter.facade.template.IRouteGroup
    public void loadInto(Map<String, RouteMeta> map) {
        map.put(RouterServicePath.EventFriend.FRIEND_SERVICE, RouteMeta.build(RouteType.PROVIDER, FriendService.class, RouterServicePath.EventFriend.FRIEND_SERVICE, "friend", null, -1, Integer.MIN_VALUE));
    }
}
