package com.bytedance.sdk.openadsdk.core.nativeexpress;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.core.p;
import com.bytedance.sdk.openadsdk.utils.ab;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: ExpressAdLoadManager.java */
/* JADX INFO: loaded from: classes.dex */
public class b {
    private static Set<b> j = Collections.synchronizedSet(new HashSet());

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private AdSlot f6294a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Context f6296c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private TTAdNative.NativeExpressAdListener f6297d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private List<com.bytedance.sdk.openadsdk.core.d.h> f6299f;
    private List<com.bytedance.sdk.openadsdk.core.d.h> g;
    private a h;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final AtomicBoolean f6298e = new AtomicBoolean(false);
    private int i = 5;
    private ScheduledFuture<?> k = null;
    private ScheduledFuture<?> l = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final p f6295b = o.f();

    /* JADX INFO: compiled from: ExpressAdLoadManager.java */
    public interface a {
        void a();

        void a(List<com.bytedance.sdk.openadsdk.core.d.h> list);
    }

    private b(Context context) {
        if (context != null) {
            this.f6296c = context.getApplicationContext();
        } else {
            this.f6296c = o.a();
        }
        j.add(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        List<com.bytedance.sdk.openadsdk.core.d.h> list = this.f6299f;
        if (list != null) {
            list.clear();
        }
        List<com.bytedance.sdk.openadsdk.core.d.h> list2 = this.g;
        if (list2 != null) {
            list2.clear();
        }
        a(true);
        b(true);
        d();
    }

    private void d() {
        j.remove(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        if (this.f6298e.getAndSet(false)) {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.b.2
                @Override // java.lang.Runnable
                public void run() {
                    if (b.this.g == null || b.this.g.size() <= 0) {
                        if (b.this.f6297d != null) {
                            b.this.f6297d.onError(108, com.bytedance.sdk.openadsdk.core.g.a(108));
                            b.this.a(108);
                        }
                        if (b.this.h != null) {
                            b.this.h.a();
                        }
                    } else {
                        if (b.this.f6297d != null) {
                            ArrayList arrayList = new ArrayList(b.this.g.size());
                            Iterator it = b.this.g.iterator();
                            while (it.hasNext()) {
                                arrayList.add(b.this.a((com.bytedance.sdk.openadsdk.core.d.h) it.next()));
                            }
                            if (arrayList.isEmpty()) {
                                b.this.f6297d.onError(103, com.bytedance.sdk.openadsdk.core.g.a(103));
                                b.this.a(103);
                            } else {
                                b.this.f6297d.onNativeExpressAdLoad(arrayList);
                            }
                        }
                        if (b.this.h != null) {
                            b.this.h.a(b.this.g);
                        }
                    }
                    b.this.c();
                }
            });
        }
    }

    public static b a(Context context) {
        return new b(context);
    }

    private void b(boolean z) {
        try {
            if (this.l == null || this.l.isCancelled()) {
                return;
            }
            com.bytedance.sdk.openadsdk.utils.o.b("ExpressAdLoadManager", "CheckValidDoneFutureTask-->cancel.....success=" + this.l.cancel(z));
        } catch (Throwable unused) {
        }
    }

    public void a(AdSlot adSlot, int i, TTAdNative.NativeExpressAdListener nativeExpressAdListener, int i2) {
        a(adSlot, i, nativeExpressAdListener, null, i2);
    }

    public void a(AdSlot adSlot, int i, TTAdNative.NativeExpressAdListener nativeExpressAdListener, a aVar, int i2) {
        if (this.f6298e.get()) {
            com.bytedance.sdk.openadsdk.utils.o.e("ExpressAdLoadManager", "express ad is loading...");
            return;
        }
        this.i = i;
        this.f6298e.set(true);
        this.f6294a = adSlot;
        this.f6297d = nativeExpressAdListener;
        this.h = aVar;
        a(this.f6294a, this.f6297d);
    }

    private void a(AdSlot adSlot, TTAdNative.NativeExpressAdListener nativeExpressAdListener) {
        if (adSlot == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.d.i iVar = new com.bytedance.sdk.openadsdk.core.d.i();
        iVar.f6119e = 2;
        this.f6295b.a(adSlot, iVar, this.i, new p.a() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.b.1
            @Override // com.bytedance.sdk.openadsdk.core.p.a
            public void a(int i, String str) {
                b.this.a(i, str);
            }

            @Override // com.bytedance.sdk.openadsdk.core.p.a
            public void a(com.bytedance.sdk.openadsdk.core.d.a aVar) {
                if (aVar.c() == null || aVar.c().isEmpty()) {
                    b.this.a(-3, com.bytedance.sdk.openadsdk.core.g.a(-3));
                    return;
                }
                b.this.f6299f = aVar.c();
                b.this.g = aVar.c();
                b.this.a();
                b.this.b();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        List<com.bytedance.sdk.openadsdk.core.d.h> list = this.f6299f;
        if (list == null) {
            return;
        }
        for (com.bytedance.sdk.openadsdk.core.d.h hVar : list) {
            if (hVar.W() && hVar.B() != null && !hVar.B().isEmpty()) {
                for (com.bytedance.sdk.openadsdk.core.d.g gVar : hVar.B()) {
                    if (!TextUtils.isEmpty(gVar.a())) {
                        com.bytedance.sdk.openadsdk.g.d.a(this.f6296c).f().a(gVar.a(), com.bytedance.sdk.openadsdk.g.a.b.a(), gVar.b(), gVar.c());
                    }
                }
            }
            if (hVar.N() == 5 || hVar.N() == 15) {
                if (hVar.v() != null && hVar.v().h() != null) {
                    int iD = ab.d(hVar.M());
                    if (o.h().b(String.valueOf(iD)) && o.h().q(String.valueOf(iD))) {
                        com.bytedance.sdk.openadsdk.core.video.f.c.a(new com.bytedance.sdk.openadsdk.h.f.b().a(hVar.v().h()).a(204800).b(hVar.v().k()));
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i) {
        List<com.bytedance.sdk.openadsdk.core.d.h> list = this.f6299f;
        com.bytedance.sdk.openadsdk.f.a.c cVarE = com.bytedance.sdk.openadsdk.f.a.c.b().a(this.i).c(this.f6294a.getCodeId()).e((list == null || list.size() <= 0) ? "" : ab.h(this.f6299f.get(0).M()));
        cVarE.b(i).f(com.bytedance.sdk.openadsdk.core.g.a(i));
        com.bytedance.sdk.openadsdk.f.a.a().c(cVarE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, String str) {
        if (this.f6298e.getAndSet(false)) {
            TTAdNative.NativeExpressAdListener nativeExpressAdListener = this.f6297d;
            if (nativeExpressAdListener != null) {
                nativeExpressAdListener.onError(i, str);
            }
            a aVar = this.h;
            if (aVar != null) {
                aVar.a();
            }
            c();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TTNativeExpressAd a(com.bytedance.sdk.openadsdk.core.d.h hVar) {
        int i = this.i;
        if (i == 1) {
            return new com.bytedance.sdk.openadsdk.core.bannerexpress.b(this.f6296c, hVar, this.f6294a);
        }
        if (i == 2) {
            return new com.bytedance.sdk.openadsdk.core.c.b(this.f6296c, hVar, this.f6294a);
        }
        if (i != 5) {
            if (i != 9) {
                return null;
            }
            return new m(this.f6296c, hVar, this.f6294a);
        }
        if (hVar.v() != null) {
            return new n(this.f6296c, hVar, this.f6294a);
        }
        return new k(this.f6296c, hVar, this.f6294a);
    }

    private void a(boolean z) {
        try {
            if (this.k == null || this.k.isCancelled()) {
                return;
            }
            com.bytedance.sdk.openadsdk.utils.o.e("ExpressAdLoadManager", "CheckValidFutureTask-->cancel......success=" + this.k.cancel(z));
        } catch (Throwable unused) {
        }
    }
}
