package com.bytedance.sdk.openadsdk.component.banner;

import android.content.Context;
import android.graphics.Bitmap;
import com.bytedance.sdk.adnet.b.d;
import com.bytedance.sdk.adnet.core.m;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.core.d.h;
import com.bytedance.sdk.openadsdk.core.g;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.core.p;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: BannerAdManager.java */
/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile b f5819a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private WeakReference<Context> f5820b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final p f5821c = o.f();

    /* JADX INFO: compiled from: BannerAdManager.java */
    public interface a {
        void a();

        void a(com.bytedance.sdk.openadsdk.component.banner.a aVar);
    }

    private b(Context context) {
        this.f5820b = new WeakReference<>(context);
    }

    private void b(Context context) {
        this.f5820b = new WeakReference<>(context);
    }

    public static b a(Context context) {
        if (f5819a == null) {
            synchronized (b.class) {
                if (f5819a == null) {
                    f5819a = new b(context);
                }
            }
        } else {
            f5819a.b(context);
        }
        return f5819a;
    }

    void a(AdSlot adSlot, final a aVar) {
        this.f5821c.a(adSlot, null, 1, new p.a() { // from class: com.bytedance.sdk.openadsdk.component.banner.b.1
            @Override // com.bytedance.sdk.openadsdk.core.p.a
            public void a(int i, String str) {
                com.bytedance.sdk.openadsdk.utils.o.b("BannerAdManager", str + "  " + i);
                a aVar2 = aVar;
                if (aVar2 != null) {
                    aVar2.a();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.p.a
            public void a(com.bytedance.sdk.openadsdk.core.d.a aVar2) {
                if (aVar2.c() == null || aVar2.c().isEmpty()) {
                    return;
                }
                h hVar = aVar2.c().get(0);
                if (hVar.W()) {
                    b.this.a(hVar, aVar);
                    return;
                }
                com.bytedance.sdk.openadsdk.utils.o.b("BannerAdManager", "Banner广告解析失败/广告为空");
                a aVar3 = aVar;
                if (aVar3 != null) {
                    aVar3.a();
                }
            }
        });
    }

    public void a(final AdSlot adSlot, final TTAdNative.BannerAdListener bannerAdListener) {
        this.f5821c.a(adSlot, null, 1, new p.a() { // from class: com.bytedance.sdk.openadsdk.component.banner.b.2
            @Override // com.bytedance.sdk.openadsdk.core.p.a
            public void a(int i, String str) {
                bannerAdListener.onError(i, str);
                com.bytedance.sdk.openadsdk.utils.o.b("BannerAdManager", str + " " + i);
            }

            @Override // com.bytedance.sdk.openadsdk.core.p.a
            public void a(com.bytedance.sdk.openadsdk.core.d.a aVar) {
                if (aVar.c() != null && !aVar.c().isEmpty()) {
                    h hVar = aVar.c().get(0);
                    if (hVar.W()) {
                        b.this.a(hVar, new a() { // from class: com.bytedance.sdk.openadsdk.component.banner.b.2.1
                            @Override // com.bytedance.sdk.openadsdk.component.banner.b.a
                            public void a(com.bytedance.sdk.openadsdk.component.banner.a aVar2) {
                                if (b.this.f5820b.get() != null) {
                                    bannerAdListener.onBannerAdLoad(new e((Context) b.this.f5820b.get(), aVar2, adSlot));
                                }
                            }

                            @Override // com.bytedance.sdk.openadsdk.component.banner.b.a
                            public void a() {
                                bannerAdListener.onError(-5, g.a(-5));
                            }
                        });
                        return;
                    } else {
                        com.bytedance.sdk.openadsdk.utils.o.b("BannerAdManager", "Banner广告解析失败");
                        bannerAdListener.onError(-4, g.a(-4));
                        return;
                    }
                }
                com.bytedance.sdk.openadsdk.utils.o.b("BannerAdManager", "Banner广告解析失败/广告为空");
                bannerAdListener.onError(-4, g.a(-4));
            }
        });
    }

    private Context a() {
        WeakReference<Context> weakReference = this.f5820b;
        return (weakReference == null || weakReference.get() == null) ? o.a() : this.f5820b.get();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final h hVar, final a aVar) {
        com.bytedance.sdk.openadsdk.g.d.a(a()).g().a(hVar.B().get(0).a(), new d.InterfaceC0070d() { // from class: com.bytedance.sdk.openadsdk.component.banner.b.3
            @Override // com.bytedance.sdk.adnet.b.d.InterfaceC0070d
            public void a() {
            }

            @Override // com.bytedance.sdk.adnet.b.d.InterfaceC0070d
            public void a(d.c cVar, boolean z) {
                if (cVar == null || cVar.a() == null) {
                    a aVar2 = aVar;
                    if (aVar2 != null) {
                        aVar2.a();
                        return;
                    }
                    return;
                }
                a aVar3 = aVar;
                if (aVar3 != null) {
                    aVar3.a(new com.bytedance.sdk.openadsdk.component.banner.a(cVar.a(), hVar));
                }
            }

            @Override // com.bytedance.sdk.adnet.core.m.a
            public void a(m<Bitmap> mVar) {
            }

            @Override // com.bytedance.sdk.adnet.b.d.InterfaceC0070d
            public void b() {
            }

            @Override // com.bytedance.sdk.adnet.core.m.a
            public void b(m<Bitmap> mVar) {
                a aVar2 = aVar;
                if (aVar2 != null) {
                    aVar2.a();
                }
            }
        });
    }
}
