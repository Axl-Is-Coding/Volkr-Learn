package com.sandboxol.center.router.moduleApi;

import com.sandboxol.greendao.entity.BannerEntity;
import com.youth.banner.Banner;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public interface IWidgetService extends IBaseService {
    void bannerEntities(Banner banner, List<BannerEntity> list);
}
