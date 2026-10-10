package com.alibaba.android.arouter.routes;

import com.alibaba.android.arouter.facade.enums.RouteType;
import com.alibaba.android.arouter.facade.model.RouteMeta;
import com.alibaba.android.arouter.facade.template.IRouteGroup;
import com.sandboxol.center.router.path.RouterActivityPath;
import com.sandboxol.videosubmit.view.activity.VideoSubmitActivity;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class ARouter$$Group$$video implements IRouteGroup {
    @Override // com.alibaba.android.arouter.facade.template.IRouteGroup
    public void loadInto(Map<String, RouteMeta> map) {
        map.put(RouterActivityPath.VideoSubmit.MAIN_ACTIVITY, RouteMeta.build(RouteType.ACTIVITY, VideoSubmitActivity.class, "/video/mainactivity", "video", null, -1, Integer.MIN_VALUE));
    }
}
