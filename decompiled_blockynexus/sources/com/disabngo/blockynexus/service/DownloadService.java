package com.disabngo.blockynexus.service;

import android.content.Context;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.sandboxol.center.router.moduleApi.IDownloadService;
import com.sandboxol.center.router.path.RouterServicePath;

/* JADX INFO: loaded from: classes2.dex */
@Route(path = RouterServicePath.EventDownload.DOWNLOAD_SERVICE)
public class DownloadService implements IDownloadService {
    @Override // com.sandboxol.center.router.moduleApi.IDownloadService
    public void checkClothesResource(Context context) {
        com.disabngo.blockynexus.d.a.e eVarB = com.disabngo.blockynexus.d.a.e.b();
        eVarB.a(context);
        eVarB.a();
    }

    @Override // com.sandboxol.center.router.moduleApi.IBaseService, com.alibaba.android.arouter.facade.template.IProvider
    public /* synthetic */ void init(Context context) {
        com.sandboxol.center.router.moduleApi.a.a(this, context);
    }
}
