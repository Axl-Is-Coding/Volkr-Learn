package com.alibaba.android.arouter.routes;

import com.alibaba.android.arouter.facade.template.IRouteGroup;
import com.alibaba.android.arouter.facade.template.IRouteRoot;
import com.facebook.share.internal.MessengerShareContentUtility;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class ARouter$$Root$$libBaseRes implements IRouteRoot {
    @Override // com.alibaba.android.arouter.facade.template.IRouteRoot
    public void loadInto(Map<String, Class<? extends IRouteGroup>> map) {
        map.put(MessengerShareContentUtility.ATTACHMENT_TEMPLATE_TYPE, ARouter$$Group$$template.class);
    }
}
