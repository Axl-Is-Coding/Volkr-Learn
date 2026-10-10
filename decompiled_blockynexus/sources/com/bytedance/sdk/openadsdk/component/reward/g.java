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
import com.bytedance.sdk.openadsdk.component.reward.e;
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

/* JADX INFO: compiled from: RewardVideoLoadManager.java */
/* JADX INFO: loaded from: classes.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SuppressLint({"StaticFieldLeak"})
    private static volatile g f5916a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Context f5917b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private AtomicBoolean f5919d = new AtomicBoolean(false);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private List<a> f5920e = Collections.synchronizedList(new ArrayList());

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final BroadcastReceiver f5921f = new BroadcastReceiver() { // from class: com.bytedance.sdk.openadsdk.component.reward.g.3
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (!"android.net.conn.CONNECTIVITY_CHANGE".equals(intent.getAction()) || q.c(g.this.f5917b) == 0) {
                return;
            }
            Iterator it = g.this.f5920e.iterator();
            while (it.hasNext()) {
                com.bytedance.sdk.openadsdk.i.a.a().b((Runnable) it.next(), 1);
                it.remove();
            }
        }
    };

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final p f5918c = o.f();

    /* JADX INFO: compiled from: RewardVideoLoadManager.java */
    private class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        com.bytedance.sdk.openadsdk.core.d.h f5935a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        AdSlot f5936b;

        a(com.bytedance.sdk.openadsdk.core.d.h hVar, AdSlot adSlot) {
            this.f5935a = hVar;
            this.f5936b = adSlot;
        }

        @Override // java.lang.Runnable
        public void run() {
            e.a(g.this.f5917b).a(this.f5935a, new e.a<Object>() { // from class: com.bytedance.sdk.openadsdk.component.reward.g.a.1
                @Override // com.bytedance.sdk.openadsdk.component.reward.e.a
                public void a(boolean z, Object obj) {
                    if (z) {
                        e eVarA = e.a(g.this.f5917b);
                        a aVar = a.this;
                        eVarA.a(aVar.f5936b, aVar.f5935a);
                    }
                }
            });
        }
    }

    private g(Context context) {
        this.f5917b = context == null ? o.a() : context.getApplicationContext();
        c();
    }

    private void c() {
        if (this.f5919d.get()) {
            return;
        }
        this.f5919d.set(true);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        try {
            this.f5917b.registerReceiver(this.f5921f, intentFilter);
        } catch (Exception unused) {
        }
    }

    private void d() {
        if (this.f5919d.get()) {
            this.f5919d.set(false);
            try {
                this.f5917b.unregisterReceiver(this.f5921f);
            } catch (Exception unused) {
            }
        }
    }

    protected void finalize() throws Throwable {
        super.finalize();
        d();
    }

    public void b() {
        try {
            e.a(this.f5917b).a();
        } catch (Throwable unused) {
        }
    }

    public static g a(Context context) {
        if (f5916a == null) {
            synchronized (g.class) {
                if (f5916a == null) {
                    f5916a = new g(context);
                }
            }
        }
        return f5916a;
    }

    public void b(AdSlot adSlot) {
        com.bytedance.sdk.openadsdk.utils.o.b("RewardVideoLoadManager", "preload reward video: " + String.valueOf(adSlot));
        a(adSlot, true, null);
    }

    private void b(final AdSlot adSlot, final boolean z, final TTAdNative.RewardVideoAdListener rewardVideoAdListener) {
        com.bytedance.sdk.openadsdk.core.d.i iVar = new com.bytedance.sdk.openadsdk.core.d.i();
        iVar.f6116b = z ? 2 : 1;
        if (o.h().i(adSlot.getCodeId()) || adSlot.getExpressViewAcceptedWidth() > WheelView.DividerConfig.FILL || adSlot.isExpressAd()) {
            iVar.f6119e = 2;
        }
        this.f5918c.a(adSlot, iVar, 7, new p.a() { // from class: com.bytedance.sdk.openadsdk.component.reward.g.2
            @Override // com.bytedance.sdk.openadsdk.core.p.a
            public void a(int i, String str) {
                TTAdNative.RewardVideoAdListener rewardVideoAdListener2;
                if (z || (rewardVideoAdListener2 = rewardVideoAdListener) == null) {
                    return;
                }
                rewardVideoAdListener2.onError(i, str);
            }

            @Override // com.bytedance.sdk.openadsdk.core.p.a
            public void a(com.bytedance.sdk.openadsdk.core.d.a aVar) {
                TTAdNative.RewardVideoAdListener rewardVideoAdListener2;
                TTAdNative.RewardVideoAdListener rewardVideoAdListener3;
                TTAdNative.RewardVideoAdListener rewardVideoAdListener4;
                if (aVar.c() != null && !aVar.c().isEmpty()) {
                    com.bytedance.sdk.openadsdk.utils.o.b("RewardVideoLoadManager", "get material data success isPreload=" + z);
                    final com.bytedance.sdk.openadsdk.core.d.h hVar = aVar.c().get(0);
                    try {
                        if (hVar.y() != null && !TextUtils.isEmpty(hVar.y().a())) {
                            String strA = hVar.y().a();
                            com.bytedance.sdk.openadsdk.g.b bVar = new com.bytedance.sdk.openadsdk.g.b(true);
                            bVar.a(adSlot.getCodeId());
                            bVar.a(7);
                            bVar.c(hVar.J());
                            bVar.d(hVar.M());
                            bVar.b(ab.h(hVar.M()));
                            com.bytedance.sdk.openadsdk.g.d.a(g.this.f5917b).g().a(strA, bVar);
                        }
                    } catch (Throwable unused) {
                    }
                    final j jVar = new j(g.this.f5917b, hVar, adSlot);
                    if (!z && (rewardVideoAdListener4 = rewardVideoAdListener) != null) {
                        rewardVideoAdListener4.onRewardVideoAdLoad(jVar);
                    }
                    com.bytedance.sdk.openadsdk.core.video.c.a.a().a(hVar, new a.InterfaceC0081a() { // from class: com.bytedance.sdk.openadsdk.component.reward.g.2.1
                        @Override // com.bytedance.sdk.openadsdk.core.video.c.a.InterfaceC0081a
                        public void a(boolean z2) {
                            com.bytedance.sdk.openadsdk.core.d.h hVar2;
                            AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                            if (z || rewardVideoAdListener == null || (hVar2 = hVar) == null || !hVar2.s()) {
                                return;
                            }
                            rewardVideoAdListener.onRewardVideoCached();
                        }
                    });
                    if (hVar.W()) {
                        if (z && !hVar.s() && o.h().r(adSlot.getCodeId()).f6187d == 1) {
                            if (q.d(g.this.f5917b)) {
                                return;
                            }
                            g gVar = g.this;
                            gVar.a(gVar.new a(hVar, adSlot));
                            return;
                        }
                        if (!hVar.s()) {
                            e.a(g.this.f5917b).a(hVar, new e.a<Object>() { // from class: com.bytedance.sdk.openadsdk.component.reward.g.2.2
                                @Override // com.bytedance.sdk.openadsdk.component.reward.e.a
                                public void a(boolean z2, Object obj) {
                                    TTAdNative.RewardVideoAdListener rewardVideoAdListener5;
                                    com.bytedance.sdk.openadsdk.utils.o.b("RewardVideoLoadManager", "download video file: " + z2 + ", preload: " + z);
                                    if (z2) {
                                        jVar.a(e.a(g.this.f5917b).a(hVar));
                                    }
                                    AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                                    if (z) {
                                        if (z2) {
                                            e.a(g.this.f5917b).a(adSlot, hVar);
                                        }
                                    } else {
                                        com.bytedance.sdk.openadsdk.c.d.a(hVar);
                                        if (!z2 || (rewardVideoAdListener5 = rewardVideoAdListener) == null) {
                                            return;
                                        }
                                        rewardVideoAdListener5.onRewardVideoCached();
                                    }
                                }
                            });
                            return;
                        } else {
                            e.a(g.this.f5917b).a(adSlot, hVar);
                            return;
                        }
                    }
                    if (z || (rewardVideoAdListener3 = rewardVideoAdListener) == null) {
                        return;
                    }
                    rewardVideoAdListener3.onError(-4, com.bytedance.sdk.openadsdk.core.g.a(-4));
                    return;
                }
                if (z || (rewardVideoAdListener2 = rewardVideoAdListener) == null) {
                    return;
                }
                rewardVideoAdListener2.onError(-3, com.bytedance.sdk.openadsdk.core.g.a(-3));
            }
        });
    }

    public void a() {
        AdSlot adSlotB = e.a(this.f5917b).b();
        if (adSlotB == null || TextUtils.isEmpty(adSlotB.getCodeId()) || e.a(this.f5917b).c(adSlotB.getCodeId()) != null) {
            return;
        }
        b(adSlotB);
    }

    public AdSlot b(String str) {
        return e.a(this.f5917b).b(str);
    }

    public void a(AdSlot adSlot) {
        e.a(this.f5917b).b(adSlot);
    }

    public void a(AdSlot adSlot, TTAdNative.RewardVideoAdListener rewardVideoAdListener) {
        com.bytedance.sdk.openadsdk.utils.o.b("RewardVideoLoadManager", "load reward vide: " + String.valueOf(adSlot));
        e.a(this.f5917b).a(adSlot);
        a(adSlot, false, rewardVideoAdListener);
    }

    private void a(AdSlot adSlot, boolean z, final TTAdNative.RewardVideoAdListener rewardVideoAdListener) {
        if (z) {
            b(adSlot, true, rewardVideoAdListener);
            return;
        }
        final com.bytedance.sdk.openadsdk.core.d.h hVarC = e.a(this.f5917b).c(adSlot.getCodeId());
        if (hVarC != null) {
            j jVar = new j(this.f5917b, hVarC, adSlot);
            if (!hVarC.s()) {
                jVar.a(e.a(this.f5917b).a(hVarC));
            }
            com.bytedance.sdk.openadsdk.c.d.a(hVarC);
            if (rewardVideoAdListener != null) {
                rewardVideoAdListener.onRewardVideoAdLoad(jVar);
                if (!hVarC.s()) {
                    rewardVideoAdListener.onRewardVideoCached();
                }
            }
            com.bytedance.sdk.openadsdk.core.video.c.a.a().a(hVarC, new a.InterfaceC0081a() { // from class: com.bytedance.sdk.openadsdk.component.reward.g.1
                @Override // com.bytedance.sdk.openadsdk.core.video.c.a.InterfaceC0081a
                public void a(boolean z2) {
                    if (rewardVideoAdListener == null || !hVarC.s()) {
                        return;
                    }
                    rewardVideoAdListener.onRewardVideoCached();
                }
            });
            com.bytedance.sdk.openadsdk.utils.o.b("RewardVideoLoadManager", "get cache data success");
            return;
        }
        b(adSlot, false, rewardVideoAdListener);
    }

    public void a(String str) {
        e.a(this.f5917b).a(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(a aVar) {
        if (aVar == null) {
            return;
        }
        if (this.f5920e.size() >= 1) {
            this.f5920e.remove(0);
        }
        this.f5920e.add(aVar);
    }
}
