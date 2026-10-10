package com.bytedance.sdk.openadsdk.core;

import android.content.Context;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.core.p;
import com.bytedance.sdk.openadsdk.utils.z;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: TTAdNativeImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class u implements TTAdNative {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final p f6371a = o.f();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Context f6372b;

    public u(Context context) {
        this.f6372b = context;
    }

    private void b(AdSlot adSlot) {
        a(adSlot);
        com.bytedance.sdk.openadsdk.utils.r.a(adSlot.getNativeAdType() > 0, "必须设置请求原生广告的类型，目前支持TYPE_BANNER和TYPE_INTERACTION_AD");
    }

    private void c(AdSlot adSlot) {
        a(adSlot);
        com.bytedance.sdk.openadsdk.utils.r.a(adSlot.getNativeAdType() == 0, "请求非原生广告的类型，请勿调用setNativeAdType()方法");
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdNative
    public void loadBannerAd(AdSlot adSlot, TTAdNative.BannerAdListener bannerAdListener) {
        if (a(bannerAdListener)) {
            return;
        }
        c(adSlot);
        try {
            Method methodA = z.a("com.bytedance.sdk.openadsdk.TTC1Proxy", "load", Context.class, AdSlot.class, TTAdNative.BannerAdListener.class);
            if (methodA != null) {
                methodA.invoke(null, this.f6372b, adSlot, bannerAdListener);
            }
        } catch (Throwable th) {
            com.bytedance.sdk.openadsdk.utils.o.b("TTAdNativeImpl", "banner component maybe not exist, pls check", th);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdNative
    public void loadBannerExpressAd(AdSlot adSlot, TTAdNative.NativeExpressAdListener nativeExpressAdListener) {
        if (a(nativeExpressAdListener)) {
            return;
        }
        adSlot.setNativeAdType(1);
        com.bytedance.sdk.openadsdk.core.nativeexpress.b.a(this.f6372b).a(adSlot, 1, nativeExpressAdListener, 5000);
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdNative
    public void loadDrawFeedAd(AdSlot adSlot, TTAdNative.DrawFeedAdListener drawFeedAdListener) {
        if (a(drawFeedAdListener)) {
            return;
        }
        a(adSlot);
        try {
            Method methodA = z.a("com.bytedance.sdk.openadsdk.TTC5Proxy", "loadDraw", Context.class, AdSlot.class, TTAdNative.DrawFeedAdListener.class);
            if (methodA != null) {
                methodA.invoke(null, this.f6372b, adSlot, drawFeedAdListener);
            }
        } catch (Throwable th) {
            com.bytedance.sdk.openadsdk.utils.o.b("TTAdNativeImpl", "feed component maybe not exist, pls check2", th);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdNative
    public void loadExpressDrawFeedAd(AdSlot adSlot, TTAdNative.NativeExpressAdListener nativeExpressAdListener) {
        if (a(nativeExpressAdListener)) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.nativeexpress.b.a(this.f6372b).a(adSlot, 9, nativeExpressAdListener, 5000);
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdNative
    public void loadFeedAd(AdSlot adSlot, TTAdNative.FeedAdListener feedAdListener) {
        if (a(feedAdListener)) {
            return;
        }
        c(adSlot);
        try {
            Method methodA = z.a("com.bytedance.sdk.openadsdk.TTC5Proxy", "loadFeed", Context.class, AdSlot.class, TTAdNative.FeedAdListener.class);
            if (methodA != null) {
                methodA.invoke(null, this.f6372b, adSlot, feedAdListener);
            }
        } catch (Throwable th) {
            com.bytedance.sdk.openadsdk.utils.o.b("TTAdNativeImpl", "feed component maybe not exist, pls check1", th);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdNative
    public void loadFullScreenVideoAd(AdSlot adSlot, TTAdNative.FullScreenVideoAdListener fullScreenVideoAdListener) {
        if (a(fullScreenVideoAdListener)) {
            return;
        }
        try {
            Method methodA = z.a("com.bytedance.sdk.openadsdk.TTC3Proxy", "loadFull", Context.class, AdSlot.class, TTAdNative.FullScreenVideoAdListener.class);
            if (methodA != null) {
                methodA.invoke(null, this.f6372b, adSlot, fullScreenVideoAdListener);
            }
        } catch (Throwable th) {
            com.bytedance.sdk.openadsdk.utils.o.b("TTAdNativeImpl", "reward component maybe not exist, pls check2", th);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdNative
    public void loadInteractionAd(AdSlot adSlot, TTAdNative.InteractionAdListener interactionAdListener) {
        if (a(interactionAdListener)) {
            return;
        }
        c(adSlot);
        try {
            Method methodA = z.a("com.bytedance.sdk.openadsdk.TTC4Proxy", "load", Context.class, AdSlot.class, TTAdNative.InteractionAdListener.class);
            if (methodA != null) {
                methodA.invoke(null, this.f6372b, adSlot, interactionAdListener);
            }
        } catch (Throwable th) {
            com.bytedance.sdk.openadsdk.utils.o.b("TTAdNativeImpl", "interaction component maybe not exist, pls check", th);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdNative
    public void loadInteractionExpressAd(AdSlot adSlot, TTAdNative.NativeExpressAdListener nativeExpressAdListener) {
        if (a(nativeExpressAdListener)) {
            return;
        }
        adSlot.setNativeAdType(2);
        com.bytedance.sdk.openadsdk.core.nativeexpress.b.a(this.f6372b).a(adSlot, 2, nativeExpressAdListener, 5000);
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdNative
    public void loadNativeAd(final AdSlot adSlot, final TTAdNative.NativeAdListener nativeAdListener) {
        if (a(nativeAdListener)) {
            return;
        }
        b(adSlot);
        this.f6371a.a(adSlot, null, adSlot.getNativeAdType(), new p.a() { // from class: com.bytedance.sdk.openadsdk.core.u.1
            @Override // com.bytedance.sdk.openadsdk.core.p.a
            public void a(int i, String str) {
                nativeAdListener.onError(i, str);
            }

            @Override // com.bytedance.sdk.openadsdk.core.p.a
            public void a(com.bytedance.sdk.openadsdk.core.d.a aVar) {
                if (aVar.c() == null || aVar.c().isEmpty()) {
                    nativeAdListener.onError(-3, g.a(-3));
                    return;
                }
                List<com.bytedance.sdk.openadsdk.core.d.h> listC = aVar.c();
                ArrayList arrayList = new ArrayList(listC.size());
                for (com.bytedance.sdk.openadsdk.core.d.h hVar : listC) {
                    if (hVar.W()) {
                        arrayList.add(new com.bytedance.sdk.openadsdk.core.e.a(u.this.f6372b, hVar, adSlot.getNativeAdType()) { // from class: com.bytedance.sdk.openadsdk.core.u.1.1
                        });
                    }
                }
                if (arrayList.isEmpty()) {
                    nativeAdListener.onError(-4, g.a(-4));
                } else {
                    nativeAdListener.onNativeAdLoad(arrayList);
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdNative
    public void loadNativeExpressAd(AdSlot adSlot, TTAdNative.NativeExpressAdListener nativeExpressAdListener) {
        if (a(nativeExpressAdListener)) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.nativeexpress.b.a(this.f6372b).a(adSlot, 5, nativeExpressAdListener, 5000);
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdNative
    public void loadRewardVideoAd(AdSlot adSlot, TTAdNative.RewardVideoAdListener rewardVideoAdListener) {
        if (a(rewardVideoAdListener)) {
            return;
        }
        try {
            Method methodA = z.a("com.bytedance.sdk.openadsdk.TTC3Proxy", "loadReward", Context.class, AdSlot.class, TTAdNative.RewardVideoAdListener.class);
            if (methodA != null) {
                methodA.invoke(null, this.f6372b, adSlot, rewardVideoAdListener);
            }
        } catch (Throwable th) {
            com.bytedance.sdk.openadsdk.utils.o.b("TTAdNativeImpl", "reward component maybe not exist, pls check1", th);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdNative
    public void loadSplashAd(AdSlot adSlot, TTAdNative.SplashAdListener splashAdListener, int i) {
        if (a(splashAdListener)) {
            return;
        }
        c(adSlot);
        int iD = o.h().d(adSlot.getCodeId());
        if (iD != -1) {
            i = iD;
        }
        try {
            Method methodA = z.a("com.bytedance.sdk.openadsdk.TTC2Proxy", "load", Context.class, AdSlot.class, TTAdNative.SplashAdListener.class, Integer.TYPE);
            if (methodA != null) {
                methodA.invoke(null, this.f6372b, adSlot, splashAdListener, Integer.valueOf(i));
            }
        } catch (Throwable th) {
            com.bytedance.sdk.openadsdk.utils.o.b("TTAdNativeImpl", "splash component maybe not exist, pls check1", th);
        }
    }

    private void a(AdSlot adSlot) {
        com.bytedance.sdk.openadsdk.utils.r.a(adSlot.getImgAcceptedWidth() > 0, "必须设置图片素材尺寸");
        com.bytedance.sdk.openadsdk.utils.r.a(adSlot.getImgAcceptedHeight() > 0, "必须设置图片素材尺寸");
    }

    private boolean a(com.bytedance.sdk.openadsdk.a.b bVar) {
        if (com.bytedance.sdk.openadsdk.core.g.g.a()) {
            return false;
        }
        if (bVar == null) {
            return true;
        }
        bVar.onError(1000, "广告请求开关已关闭,请联系穿山甲管理员");
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdNative
    public void loadSplashAd(AdSlot adSlot, TTAdNative.SplashAdListener splashAdListener) {
        if (a(splashAdListener)) {
            return;
        }
        c(adSlot);
        try {
            Method methodA = z.a("com.bytedance.sdk.openadsdk.TTC2Proxy", "load", Context.class, AdSlot.class, TTAdNative.SplashAdListener.class, Integer.TYPE);
            if (methodA != null) {
                methodA.invoke(null, this.f6372b, adSlot, splashAdListener, 0);
            }
        } catch (Throwable th) {
            com.bytedance.sdk.openadsdk.utils.o.b("TTAdNativeImpl", "splash component maybe not exist, pls check2", th);
        }
    }
}
