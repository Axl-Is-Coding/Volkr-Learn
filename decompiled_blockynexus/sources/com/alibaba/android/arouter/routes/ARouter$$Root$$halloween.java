package com.alibaba.android.arouter.routes;

import com.alibaba.android.arouter.facade.template.IRouteGroup;
import com.alibaba.android.arouter.facade.template.IRouteRoot;
import com.sandboxol.center.config.ActivityType;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class ARouter$$Root$$halloween implements IRouteRoot {
    @Override // com.alibaba.android.arouter.facade.template.IRouteRoot
    public void loadInto(Map<String, Class<? extends IRouteGroup>> map) {
        map.put(ActivityType.HALLOWEEN, ARouter$$Group$$halloween.class);
    }
}
