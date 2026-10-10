package com.disabngo.blockynexus.service;

import android.content.Context;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.disabngo.blockynexus.binding.adapter.BannerBindAdapters;
import com.sandboxol.center.router.moduleApi.IWidgetService;
import com.sandboxol.center.router.path.RouterServicePath;
import com.sandboxol.greendao.entity.BannerEntity;
import com.youth.banner.Banner;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@Route(path = RouterServicePath.EventWidget.WIDGET_SERVICE)
public class WidgetService implements IWidgetService {
    @Override // com.sandboxol.center.router.moduleApi.IWidgetService
    public void bannerEntities(Banner banner, List<BannerEntity> list) {
        BannerBindAdapters.a(banner, list);
    }

    @Override // com.sandboxol.center.router.moduleApi.IBaseService, com.alibaba.android.arouter.facade.template.IProvider
    public /* synthetic */ void init(Context context) {
        com.sandboxol.center.router.moduleApi.a.a(this, context);
    }
}
