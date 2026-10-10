package com.alibaba.android.arouter.routes;

import com.alibaba.android.arouter.facade.enums.RouteType;
import com.alibaba.android.arouter.facade.model.RouteMeta;
import com.alibaba.android.arouter.facade.template.IRouteGroup;
import com.sandboxol.center.router.path.RouterFragmentPath;
import com.sandboxol.vip.view.fragment.main.n;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class ARouter$$Group$$privilege implements IRouteGroup {
    @Override // com.alibaba.android.arouter.facade.template.IRouteGroup
    public void loadInto(Map<String, RouteMeta> map) {
        map.put(RouterFragmentPath.PrivilegeModule.PAGER_MAIN, RouteMeta.build(RouteType.FRAGMENT, n.class, RouterFragmentPath.PrivilegeModule.PAGER_MAIN, "privilege", null, -1, Integer.MIN_VALUE));
    }
}
