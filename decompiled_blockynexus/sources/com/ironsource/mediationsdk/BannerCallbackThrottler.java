package com.ironsource.mediationsdk;

import android.os.Handler;
import android.os.Looper;

/* JADX INFO: loaded from: classes2.dex */
public class BannerCallbackThrottler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static BannerCallbackThrottler f14615a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f14616b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f14617c = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f14618d;

    private BannerCallbackThrottler() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void invokeCallback(IronSourceBannerLayout ironSourceBannerLayout, com.ironsource.mediationsdk.logger.b bVar) {
        this.f14616b = System.currentTimeMillis();
        this.f14617c = false;
        ironSourceBannerLayout.sendBannerAdLoadFailed(bVar);
    }

    public boolean b() {
        boolean z;
        synchronized (this) {
            z = this.f14617c;
        }
        return z;
    }

    public static synchronized BannerCallbackThrottler a() {
        if (f14615a == null) {
            f14615a = new BannerCallbackThrottler();
        }
        return f14615a;
    }

    public void a(IronSourceBannerLayout ironSourceBannerLayout, com.ironsource.mediationsdk.logger.b bVar) {
        synchronized (this) {
            if (this.f14617c) {
                return;
            }
            long jCurrentTimeMillis = System.currentTimeMillis() - this.f14616b;
            if (jCurrentTimeMillis > this.f14618d * 1000) {
                invokeCallback(ironSourceBannerLayout, bVar);
                return;
            }
            this.f14617c = true;
            new Handler(Looper.getMainLooper()).postDelayed(new RunnableC2327j(this, ironSourceBannerLayout, bVar), ((long) (this.f14618d * 1000)) - jCurrentTimeMillis);
        }
    }

    public void a(int i) {
        this.f14618d = i;
    }
}
