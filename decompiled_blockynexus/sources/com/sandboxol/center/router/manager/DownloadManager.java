package com.sandboxol.center.router.manager;

import android.content.Context;
import com.sandboxol.center.router.RouteServiceManager;
import com.sandboxol.center.router.moduleApi.IDownloadService;
import com.sandboxol.center.router.path.RouterServicePath;

/* JADX INFO: loaded from: classes3.dex */
public class DownloadManager {
    private static IDownloadService iDownloadService = (IDownloadService) RouteServiceManager.provide(RouterServicePath.EventDownload.DOWNLOAD_SERVICE);

    public static void checkClothesResource(Context context) {
        IDownloadService iDownloadService2 = iDownloadService;
        if (iDownloadService2 != null) {
            iDownloadService2.checkClothesResource(context);
        }
    }
}
