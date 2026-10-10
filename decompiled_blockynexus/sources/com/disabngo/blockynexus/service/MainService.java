package com.disabngo.blockynexus.service;

import android.content.Context;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.disabngo.blockynexus.view.activity.main.nc;
import com.sandboxol.center.router.moduleApi.IMainService;
import com.sandboxol.center.router.path.RouterServicePath;

/* JADX INFO: loaded from: classes2.dex */
@Route(path = RouterServicePath.EventMain.MAIN_SERVICE)
public class MainService implements IMainService {
    @Override // com.sandboxol.center.router.moduleApi.IMainService
    public int getPageAnimDirection() {
        return nc.f10937a > nc.f10938b ? 1 : 2;
    }

    @Override // com.sandboxol.center.router.moduleApi.IBaseService, com.alibaba.android.arouter.facade.template.IProvider
    public void init(Context context) {
    }

    @Override // com.sandboxol.center.router.moduleApi.IMainService
    public void setPageIndex(boolean z, int i) {
        if (z) {
            nc.f10938b = i;
        }
    }
}
