package com.bytedance.sdk.openadsdk;

import android.content.Context;
import com.bytedance.sdk.openadsdk.core.l;
import com.bytedance.sdk.openadsdk.g.d;
import com.bytedance.sdk.openadsdk.utils.k;
import com.bytedance.sdk.openadsdk.utils.o;
import com.bytedance.sdk.openadsdk.utils.r;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
public final class TTAdSdk {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static AtomicBoolean f5609a = new AtomicBoolean(false);

    private static void a(Context context, TTAdConfig tTAdConfig) {
        if (tTAdConfig.getHttpStack() != null) {
            d.a(tTAdConfig.getHttpStack());
        }
        l.f6243a = tTAdConfig.isAsyncInit();
        if (tTAdConfig.isDebug()) {
            o.b();
        }
        TTAdManager tTAdManagerFactory = TTAdManagerFactory.getInstance(context, tTAdConfig.isSupportMultiProcess());
        if (tTAdConfig.isDebug()) {
            tTAdManagerFactory.openDebugMode();
        }
        tTAdManagerFactory.setAppId(tTAdConfig.getAppId()).setCoppa(tTAdConfig.getCoppa()).setGdpr(tTAdConfig.getGDPR()).setName(tTAdConfig.getAppName()).setPaid(tTAdConfig.isPaid()).setKeywords(tTAdConfig.getKeywords()).setData(tTAdConfig.getData()).setTitleBarTheme(tTAdConfig.getTitleBarTheme()).setAllowShowNotifiFromSDK(tTAdConfig.isAllowShowNotify()).setAllowLandingPageShowWhenScreenLock(tTAdConfig.isAllowShowPageWhenScreenLock()).isUseTextureView(tTAdConfig.isUseTextureView()).setNeedClearTaskReset(tTAdConfig.getNeedClearTaskReset());
        try {
            k.a();
        } catch (Throwable unused) {
        }
    }

    public static TTAdManager getAdManager() {
        return TTAdManagerFactory.a();
    }

    public static TTAdManager init(Context context, TTAdConfig tTAdConfig) {
        r.a((Object) context, "Context is null, please check.");
        r.a(tTAdConfig, "TTAdConfig is null, please check.");
        if (!f5609a.get()) {
            a(context, tTAdConfig);
            f5609a.set(true);
        }
        return getAdManager();
    }
}
