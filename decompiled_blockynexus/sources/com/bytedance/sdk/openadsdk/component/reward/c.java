package com.bytedance.sdk.openadsdk.component.reward;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import cn.qqtheme.framework.widget.WheelView;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.component.reward.a;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.core.p;
import com.bytedance.sdk.openadsdk.core.video.c.a;
import com.bytedance.sdk.openadsdk.utils.ab;
import com.bytedance.sdk.openadsdk.utils.q;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: FullScreenVideoLoadManager.java */
/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SuppressLint({"StaticFieldLeak"})
    private static volatile c f5881a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Context f5882b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private AtomicBoolean f5884d = new AtomicBoolean(false);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private List<a> f5885e = Collections.synchronizedList(new ArrayList());

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final BroadcastReceiver f5886f = new BroadcastReceiver() { // from class: com.bytedance.sdk.openadsdk.component.reward.c.3
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (!"android.net.conn.CONNECTIVITY_CHANGE".equals(intent.getAction()) || q.c(c.this.f5882b) == 0) {
                return;
            }
            Iterator it = c.this.f5885e.iterator();
            while (it.hasNext()) {
                com.bytedance.sdk.openadsdk.i.a.a().b((Runnable) it.next(), 1);
                it.remove();
            }
        }
    };

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final p f5883c = o.f();

    /* JADX INFO: compiled from: FullScreenVideoLoadManager.java */
    private class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        com.bytedance.sdk.openadsdk.core.d.h f5900a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        AdSlot f5901b;

        a(com.bytedance.sdk.openadsdk.core.d.h hVar, AdSlot adSlot) {
            this.f5900a = hVar;
            this.f5901b = adSlot;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.bytedance.sdk.openadsdk.component.reward.a.a(c.this.f5882b).a(this.f5900a, new a.InterfaceC0076a<Object>() { // from class: com.bytedance.sdk.openadsdk.component.reward.c.a.1
                @Override // com.bytedance.sdk.openadsdk.component.reward.a.InterfaceC0076a
                public void a(boolean z, Object obj) {
                    if (z) {
                        com.bytedance.sdk.openadsdk.component.reward.a aVarA = com.bytedance.sdk.openadsdk.component.reward.a.a(c.this.f5882b);
                        a aVar = a.this;
                        aVarA.a(aVar.f5901b, aVar.f5900a);
                    }
                }
            });
        }
    }

    private c(Context context) {
        this.f5882b = context == null ? o.a() : context.getApplicationContext();
        c();
    }

    private void c() {
        if (this.f5884d.get()) {
            return;
        }
        this.f5884d.set(true);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        try {
            this.f5882b.registerReceiver(this.f5886f, intentFilter);
        } catch (Exception unused) {
        }
    }

    private void d() {
        if (this.f5884d.get()) {
            this.f5884d.set(false);
            try {
                this.f5882b.unregisterReceiver(this.f5886f);
            } catch (Exception unused) {
            }
        }
    }

    protected void finalize() throws Throwable {
        super.finalize();
        d();
    }

    public void b() {
        AdSlot adSlotB = com.bytedance.sdk.openadsdk.component.reward.a.a(this.f5882b).b();
        if (adSlotB == null || TextUtils.isEmpty(adSlotB.getCodeId()) || com.bytedance.sdk.openadsdk.component.reward.a.a(this.f5882b).c(adSlotB.getCodeId()) != null) {
            return;
        }
        b(adSlotB);
    }

    public static c a(Context context) {
        if (f5881a == null) {
            synchronized (c.class) {
                if (f5881a == null) {
                    f5881a = new c(context);
                }
            }
        }
        return f5881a;
    }

    public void b(AdSlot adSlot) {
        com.bytedance.sdk.openadsdk.utils.o.b("FullScreenVideoLoadManager", "preload full screen video: " + String.valueOf(adSlot));
        a(adSlot, true, null);
    }

    private void b(final AdSlot adSlot, final boolean z, final TTAdNative.FullScreenVideoAdListener fullScreenVideoAdListener) {
        com.bytedance.sdk.openadsdk.core.d.i iVar = new com.bytedance.sdk.openadsdk.core.d.i();
        iVar.f6117c = z ? 2 : 1;
        if (o.h().i(adSlot.getCodeId()) || adSlot.getExpressViewAcceptedWidth() > WheelView.DividerConfig.FILL || adSlot.isExpressAd()) {
            iVar.f6119e = 2;
        }
        this.f5883c.a(adSlot, iVar, 8, new p.a() { // from class: com.bytedance.sdk.openadsdk.component.reward.c.2
            @Override // com.bytedance.sdk.openadsdk.core.p.a
            public void a(int i, String str) {
                TTAdNative.FullScreenVideoAdListener fullScreenVideoAdListener2;
                if (z || (fullScreenVideoAdListener2 = fullScreenVideoAdListener) == null) {
                    return;
                }
                fullScreenVideoAdListener2.onError(i, str);
            }

            @Override // com.bytedance.sdk.openadsdk.core.p.a
            public void a(com.bytedance.sdk.openadsdk.core.d.a aVar) {
                TTAdNative.FullScreenVideoAdListener fullScreenVideoAdListener2;
                TTAdNative.FullScreenVideoAdListener fullScreenVideoAdListener3;
                TTAdNative.FullScreenVideoAdListener fullScreenVideoAdListener4;
                if (aVar.c() != null && !aVar.c().isEmpty()) {
                    com.bytedance.sdk.openadsdk.utils.o.b("FullScreenVideoLoadManager", "get material data success isPreload=" + z);
                    final com.bytedance.sdk.openadsdk.core.d.h hVar = aVar.c().get(0);
                    try {
                        if (hVar.y() != null && !TextUtils.isEmpty(hVar.y().a())) {
                            String strA = hVar.y().a();
                            com.bytedance.sdk.openadsdk.g.b bVar = new com.bytedance.sdk.openadsdk.g.b(true);
                            bVar.a(adSlot.getCodeId());
                            bVar.a(8);
                            bVar.c(hVar.J());
                            bVar.d(hVar.M());
                            bVar.b(ab.h(hVar.M()));
                            com.bytedance.sdk.openadsdk.g.d.a(c.this.f5882b).g().a(strA, bVar);
                        }
                    } catch (Throwable unused) {
                    }
                    final i iVar2 = new i(c.this.f5882b, hVar, adSlot);
                    if (!z && (fullScreenVideoAdListener4 = fullScreenVideoAdListener) != null) {
                        fullScreenVideoAdListener4.onFullScreenVideoAdLoad(iVar2);
                    }
                    com.bytedance.sdk.openadsdk.core.video.c.a.a().a(hVar, new a.InterfaceC0081a() { // from class: com.bytedance.sdk.openadsdk.component.reward.c.2.1
                        @Override // com.bytedance.sdk.openadsdk.core.video.c.a.InterfaceC0081a
                        public void a(boolean z2) {
                            com.bytedance.sdk.openadsdk.core.d.h hVar2;
                            AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                            if (z || fullScreenVideoAdListener == null || (hVar2 = hVar) == null || !hVar2.s()) {
                                return;
                            }
                            fullScreenVideoAdListener.onFullScreenVideoCached();
                        }
                    });
                    if (hVar.W()) {
                        if (z && !hVar.s() && o.h().r(adSlot.getCodeId()).f6187d == 1) {
                            if (q.d(c.this.f5882b)) {
                                return;
                            }
                            c cVar = c.this;
                            cVar.a(cVar.new a(hVar, adSlot));
                            return;
                        }
                        if (!hVar.s()) {
                            com.bytedance.sdk.openadsdk.component.reward.a.a(c.this.f5882b).a(hVar, new a.InterfaceC0076a<Object>() { // from class: com.bytedance.sdk.openadsdk.component.reward.c.2.2
                                @Override // com.bytedance.sdk.openadsdk.component.reward.a.InterfaceC0076a
                                public void a(boolean z2, Object obj) {
                                    TTAdNative.FullScreenVideoAdListener fullScreenVideoAdListener5;
                                    com.bytedance.sdk.openadsdk.utils.o.b("FullScreenVideoLoadManager", "download video file: " + z2 + ", preload: " + z);
                                    if (z2) {
                                        iVar2.a(com.bytedance.sdk.openadsdk.component.reward.a.a(c.this.f5882b).a(hVar));
                                    }
                                    AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                                    if (z) {
                                        if (z2) {
                                            com.bytedance.sdk.openadsdk.component.reward.a.a(c.this.f5882b).a(adSlot, hVar);
                                        }
                                    } else {
                                        com.bytedance.sdk.openadsdk.c.d.a(hVar);
                                        if (!z2 || (fullScreenVideoAdListener5 = fullScreenVideoAdListener) == null) {
                                            return;
                                        }
                                        fullScreenVideoAdListener5.onFullScreenVideoCached();
                                    }
                                }
                            });
                            return;
                        } else {
                            com.bytedance.sdk.openadsdk.component.reward.a.a(c.this.f5882b).a(adSlot, hVar);
                            return;
                        }
                    }
                    if (z || (fullScreenVideoAdListener3 = fullScreenVideoAdListener) == null) {
                        return;
                    }
                    fullScreenVideoAdListener3.onError(-4, com.bytedance.sdk.openadsdk.core.g.a(-4));
                    return;
                }
                if (z || (fullScreenVideoAdListener2 = fullScreenVideoAdListener) == null) {
                    return;
                }
                fullScreenVideoAdListener2.onError(-3, com.bytedance.sdk.openadsdk.core.g.a(-3));
            }
        });
    }

    public void a() {
        try {
            com.bytedance.sdk.openadsdk.component.reward.a.a(this.f5882b).a();
        } catch (Throwable unused) {
        }
    }

    public void a(AdSlot adSlot) {
        com.bytedance.sdk.openadsdk.component.reward.a.a(this.f5882b).b(adSlot);
    }

    public void a(AdSlot adSlot, TTAdNative.FullScreenVideoAdListener fullScreenVideoAdListener) {
        com.bytedance.sdk.openadsdk.utils.o.b("FullScreenVideoLoadManager", "load full screen video: " + String.valueOf(adSlot));
        com.bytedance.sdk.openadsdk.component.reward.a.a(this.f5882b).a(adSlot);
        a(adSlot, false, fullScreenVideoAdListener);
    }

    private void a(AdSlot adSlot, boolean z, final TTAdNative.FullScreenVideoAdListener fullScreenVideoAdListener) {
        if (z) {
            b(adSlot, true, fullScreenVideoAdListener);
            return;
        }
        final com.bytedance.sdk.openadsdk.core.d.h hVarC = com.bytedance.sdk.openadsdk.component.reward.a.a(this.f5882b).c(adSlot.getCodeId());
        if (hVarC != null) {
            i iVar = new i(this.f5882b, hVarC, adSlot);
            if (!hVarC.s()) {
                iVar.a(com.bytedance.sdk.openadsdk.component.reward.a.a(this.f5882b).a(hVarC));
            }
            com.bytedance.sdk.openadsdk.c.d.a(hVarC);
            if (fullScreenVideoAdListener != null) {
                fullScreenVideoAdListener.onFullScreenVideoAdLoad(iVar);
                if (!hVarC.s()) {
                    fullScreenVideoAdListener.onFullScreenVideoCached();
                }
            }
            com.bytedance.sdk.openadsdk.core.video.c.a.a().a(hVarC, new a.InterfaceC0081a() { // from class: com.bytedance.sdk.openadsdk.component.reward.c.1
                @Override // com.bytedance.sdk.openadsdk.core.video.c.a.InterfaceC0081a
                public void a(boolean z2) {
                    if (fullScreenVideoAdListener == null || !hVarC.s()) {
                        return;
                    }
                    fullScreenVideoAdListener.onFullScreenVideoCached();
                }
            });
            com.bytedance.sdk.openadsdk.utils.o.b("FullScreenVideoLoadManager", "get cache data success");
            return;
        }
        b(adSlot, false, fullScreenVideoAdListener);
    }

    public AdSlot b(String str) {
        return com.bytedance.sdk.openadsdk.component.reward.a.a(this.f5882b).b(str);
    }

    public void a(String str) {
        com.bytedance.sdk.openadsdk.component.reward.a.a(this.f5882b).a(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(a aVar) {
        if (aVar == null) {
            return;
        }
        if (this.f5885e.size() >= 1) {
            this.f5885e.remove(0);
        }
        this.f5885e.add(aVar);
    }
}
