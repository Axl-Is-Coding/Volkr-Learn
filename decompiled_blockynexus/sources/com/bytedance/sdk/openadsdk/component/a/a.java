package com.bytedance.sdk.openadsdk.component.a;

import android.content.Context;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.core.d.h;
import com.bytedance.sdk.openadsdk.core.g;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.core.p;
import com.bytedance.sdk.openadsdk.utils.ab;
import io.rong.imageloader.utils.IoUtils;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: FeedAdManager.java */
/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile a f5799a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final p f5800b = o.f();

    private a() {
    }

    public static a a() {
        if (f5799a == null) {
            synchronized (a.class) {
                if (f5799a == null) {
                    f5799a = new a();
                }
            }
        }
        return f5799a;
    }

    public void a(final Context context, final AdSlot adSlot, final TTAdNative.FeedAdListener feedAdListener) {
        this.f5800b.a(adSlot, null, 5, new p.a() { // from class: com.bytedance.sdk.openadsdk.component.a.a.1
            @Override // com.bytedance.sdk.openadsdk.core.p.a
            public void a(int i, String str) {
                feedAdListener.onError(i, str);
            }

            @Override // com.bytedance.sdk.openadsdk.core.p.a
            public void a(com.bytedance.sdk.openadsdk.core.d.a aVar) {
                if (aVar.c() == null || aVar.c().isEmpty()) {
                    feedAdListener.onError(-3, g.a(-3));
                    return;
                }
                List<h> listC = aVar.c();
                ArrayList arrayList = new ArrayList(listC.size());
                for (h hVar : listC) {
                    if (hVar.W()) {
                        arrayList.add(new c(context, hVar, 5, adSlot));
                    }
                    int iN = hVar.N();
                    if (iN == 5 || iN == 15 || iN == 50) {
                        if (hVar.v() != null && hVar.v().h() != null) {
                            int iD = ab.d(hVar.M());
                            if (o.h().b(String.valueOf(iD)) && o.h().q(String.valueOf(iD))) {
                                com.bytedance.sdk.openadsdk.core.video.f.c.a(new com.bytedance.sdk.openadsdk.h.f.b().a(hVar.v().h()).a(204800).b(hVar.v().k()));
                            }
                        }
                    }
                }
                if (arrayList.isEmpty()) {
                    feedAdListener.onError(-4, g.a(-4));
                } else {
                    feedAdListener.onFeedAdLoad(arrayList);
                }
            }
        });
    }

    public void a(final Context context, AdSlot adSlot, final TTAdNative.DrawFeedAdListener drawFeedAdListener) {
        this.f5800b.a(adSlot, null, 9, new p.a() { // from class: com.bytedance.sdk.openadsdk.component.a.a.2
            @Override // com.bytedance.sdk.openadsdk.core.p.a
            public void a(int i, String str) {
                drawFeedAdListener.onError(i, str);
            }

            @Override // com.bytedance.sdk.openadsdk.core.p.a
            public void a(com.bytedance.sdk.openadsdk.core.d.a aVar) {
                if (aVar.c() == null || aVar.c().isEmpty()) {
                    drawFeedAdListener.onError(-3, g.a(-3));
                    return;
                }
                List<h> listC = aVar.c();
                ArrayList arrayList = new ArrayList(listC.size());
                for (h hVar : listC) {
                    if (hVar.W()) {
                        arrayList.add(new b(context, hVar, 9));
                    }
                    int iN = hVar.N();
                    if (iN == 5 || iN == 15 || iN == 50) {
                        if (hVar.v() != null && hVar.v().h() != null) {
                            int iD = ab.d(hVar.M());
                            if (o.h().b(String.valueOf(iD)) && o.h().q(String.valueOf(iD))) {
                                com.bytedance.sdk.openadsdk.core.video.f.c.a(new com.bytedance.sdk.openadsdk.h.f.b().a(hVar.v().h()).a(IoUtils.DEFAULT_IMAGE_TOTAL_SIZE).b(hVar.v().k()));
                            }
                        }
                    }
                }
                if (arrayList.isEmpty()) {
                    drawFeedAdListener.onError(-4, g.a(-4));
                } else {
                    drawFeedAdListener.onDrawFeedAdLoad(arrayList);
                }
            }
        });
    }
}
