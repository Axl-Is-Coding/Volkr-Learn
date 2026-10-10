package com.alibaba.android.arouter.routes;

import com.alibaba.android.arouter.facade.enums.RouteType;
import com.alibaba.android.arouter.facade.model.RouteMeta;
import com.alibaba.android.arouter.facade.template.IRouteGroup;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.sandboxol.center.router.path.RouterActivityPath;
import com.sandboxol.center.view.activity.TemplateActivity;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class ARouter$$Group$$template implements IRouteGroup {
    @Override // com.alibaba.android.arouter.facade.template.IRouteGroup
    public void loadInto(Map<String, RouteMeta> map) {
        map.put(RouterActivityPath.Template.TEMPLATE_ACTIVITY, RouteMeta.build(RouteType.ACTIVITY, TemplateActivity.class, "/template/templateactivity", MessengerShareContentUtility.ATTACHMENT_TEMPLATE_TYPE, null, -1, Integer.MIN_VALUE));
    }
}
