package com.alibaba.android.arouter.routes;

import com.alibaba.android.arouter.facade.enums.RouteType;
import com.alibaba.android.arouter.facade.model.RouteMeta;
import com.alibaba.android.arouter.facade.template.IProviderGroup;
import com.sandboxol.center.router.path.RouterServicePath;
import com.sandboxol.feedback.FeedBackServcie;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class ARouter$$Providers$$feedback implements IProviderGroup {
    @Override // com.alibaba.android.arouter.facade.template.IProviderGroup
    public void loadInto(Map<String, RouteMeta> map) {
        map.put("com.sandboxol.center.router.moduleApi.IFeedbackService", RouteMeta.build(RouteType.PROVIDER, FeedBackServcie.class, RouterServicePath.EventFeedBackPay.FEED_BACK_SERVICE, "feedback", null, -1, Integer.MIN_VALUE));
    }
}
