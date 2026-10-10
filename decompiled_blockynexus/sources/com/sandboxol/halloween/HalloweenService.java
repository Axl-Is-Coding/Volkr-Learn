package com.sandboxol.halloween;

import android.content.Context;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.sandboxol.center.router.moduleApi.IHalloweenService;
import com.sandboxol.center.router.path.RouterServicePath;
import com.sandboxol.halloween.web.g;

/* JADX INFO: loaded from: classes4.dex */
@Route(path = RouterServicePath.EventHalloween.HALLOWEEN_SERVICE)
public class HalloweenService implements IHalloweenService {
    @Override // com.sandboxol.center.router.moduleApi.IHalloweenService
    public void enterActivity(Context context) {
        g.a(context, new d(this, context));
    }

    @Override // com.sandboxol.center.router.moduleApi.IBaseService, com.alibaba.android.arouter.facade.template.IProvider
    public void init(Context context) {
    }

    @Override // com.sandboxol.center.router.moduleApi.IHalloweenService
    public void openActivity(Context context) {
        g.a(context, new c(this, context));
    }
}
