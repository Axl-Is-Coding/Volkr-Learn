package com.alibaba.android.arouter.routes;

import com.alibaba.android.arouter.facade.template.IRouteGroup;
import com.alibaba.android.arouter.facade.template.IRouteRoot;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class ARouter$$Root$$login implements IRouteRoot {
    @Override // com.alibaba.android.arouter.facade.template.IRouteRoot
    public void loadInto(Map<String, Class<? extends IRouteGroup>> map) {
        map.put(FirebaseAnalytics.Event.LOGIN, ARouter$$Group$$login.class);
    }
}
