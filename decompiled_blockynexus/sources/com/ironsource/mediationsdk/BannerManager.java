package com.ironsource.mediationsdk;

import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import com.google.android.gms.auth.api.proxy.AuthApiStatusCodes;
import com.ironsource.mediationsdk.logger.IronSourceLogger;
import com.ironsource.mediationsdk.sdk.InterfaceC2348c;
import com.ironsource.mediationsdk.utils.CappingManager;
import java.util.Iterator;
import java.util.List;
import java.util.Timer;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class BannerManager implements InterfaceC2348c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private BannerSmash f14619a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private IronSourceBannerLayout f14620b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private com.ironsource.mediationsdk.model.f f14621c;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f14624f;
    private String g;
    private long i;
    private Timer j;
    private final CopyOnWriteArrayList<BannerSmash> h = new CopyOnWriteArrayList<>();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private com.ironsource.mediationsdk.logger.c f14623e = com.ironsource.mediationsdk.logger.c.c();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private BANNER_STATE f14622d = BANNER_STATE.NOT_INITIATED;
    private Boolean k = true;
    AtomicBoolean m = new AtomicBoolean();
    AtomicBoolean l = new AtomicBoolean();

    private enum BANNER_STATE {
        NOT_INITIATED,
        READY_TO_LOAD,
        FIRST_LOAD_IN_PROGRESS,
        LOAD_IN_PROGRESS,
        RELOAD_IN_PROGRESS
    }

    public BannerManager(List<com.ironsource.mediationsdk.model.p> list, String str, String str2, long j, int i, int i2) {
        this.f14624f = str;
        this.g = str2;
        this.i = i;
        BannerCallbackThrottler.a().a(i2);
        for (int i3 = 0; i3 < list.size(); i3++) {
            com.ironsource.mediationsdk.model.p pVar = list.get(i3);
            AbstractC2311b abstractC2311bA = C2313c.a().a(pVar, pVar.d());
            if (abstractC2311bA == null || !C2317e.a().c(abstractC2311bA)) {
                a(pVar.g() + " can't load adapter or wrong version");
            } else {
                this.h.add(new BannerSmash(this, pVar, abstractC2311bA, j, i3 + 1));
            }
        }
        this.f14621c = null;
        a(BANNER_STATE.READY_TO_LOAD);
    }

    private void b(BannerSmash bannerSmash, View view, FrameLayout.LayoutParams layoutParams) {
        this.f14619a = bannerSmash;
        this.f14620b.addViewWithFrameLayoutParams(view, layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        if (this.f14622d != BANNER_STATE.RELOAD_IN_PROGRESS) {
            a("onReloadTimer wrong state=" + this.f14622d.name());
            return;
        }
        if (!this.k.booleanValue()) {
            a(3200, new Object[][]{new Object[]{"errorCode", 614}});
            g();
        } else {
            a(3011);
            a(3012, this.f14619a);
            this.f14619a.g();
        }
    }

    private void f() {
        Iterator<BannerSmash> it = this.h.iterator();
        while (it.hasNext()) {
            it.next().a(true);
        }
    }

    private void g() {
        try {
            h();
            if (this.i > 0) {
                this.j = new Timer();
                this.j.schedule(new C2331l(this), this.i * 1000);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void h() {
        Timer timer = this.j;
        if (timer != null) {
            timer.cancel();
            this.j = null;
        }
    }

    @Override // com.ironsource.mediationsdk.sdk.InterfaceC2348c
    public void c(BannerSmash bannerSmash) {
        Object[][] objArr;
        a("onBannerAdScreenDismissed", bannerSmash);
        if (c()) {
            this.f14620b.sendBannerAdScreenDismissed();
            objArr = null;
        } else {
            objArr = new Object[][]{new Object[]{"reason", "banner is destroyed"}};
        }
        a(3114, objArr);
        a(3303, bannerSmash, objArr);
    }

    @Override // com.ironsource.mediationsdk.sdk.InterfaceC2348c
    public void d(BannerSmash bannerSmash) {
        Object[][] objArr;
        a("onBannerAdClicked", bannerSmash);
        if (c()) {
            this.f14620b.sendBannerAdClicked();
            objArr = null;
        } else {
            objArr = new Object[][]{new Object[]{"reason", "banner is destroyed"}};
        }
        a(3112, objArr);
        a(3008, bannerSmash, objArr);
    }

    public synchronized void a(IronSourceBannerLayout ironSourceBannerLayout, com.ironsource.mediationsdk.model.f fVar) {
        if (ironSourceBannerLayout != null) {
            try {
            } catch (Exception e2) {
                BannerCallbackThrottler.a().a(ironSourceBannerLayout, new com.ironsource.mediationsdk.logger.b(605, "loadBanner() failed " + e2.getMessage()));
                a(3111, new Object[][]{new Object[]{"errorCode", 605}, new Object[]{"reason", e2.getMessage()}});
                a(BANNER_STATE.READY_TO_LOAD);
            }
            if (!ironSourceBannerLayout.isDestroyed()) {
                if (fVar != null && !TextUtils.isEmpty(fVar.c())) {
                    if (this.f14622d == BANNER_STATE.READY_TO_LOAD && !BannerCallbackThrottler.a().b()) {
                        a(BANNER_STATE.FIRST_LOAD_IN_PROGRESS);
                        this.f14620b = ironSourceBannerLayout;
                        this.f14621c = fVar;
                        a(3001);
                        if (!CappingManager.d(com.ironsource.mediationsdk.utils.c.c().b(), fVar.c())) {
                            Iterator<BannerSmash> it = this.h.iterator();
                            while (it.hasNext()) {
                                it.next().a(true);
                            }
                            BannerSmash bannerSmash = this.h.get(0);
                            a(AuthApiStatusCodes.AUTH_API_CLIENT_ERROR, bannerSmash);
                            bannerSmash.a(ironSourceBannerLayout, this.f14624f, this.g);
                            return;
                        }
                        BannerCallbackThrottler.a().a(ironSourceBannerLayout, new com.ironsource.mediationsdk.logger.b(604, "placement " + fVar.c() + " is capped"));
                        a(3111, new Object[][]{new Object[]{"errorCode", 604}});
                        a(BANNER_STATE.READY_TO_LOAD);
                        return;
                    }
                    this.f14623e.b(IronSourceLogger.IronSourceTag.API, "A banner is already loaded", 3);
                    return;
                }
                Object[] objArr = new Object[1];
                objArr[0] = fVar == null ? "placement is null" : "placement name is empty";
                this.f14623e.b(IronSourceLogger.IronSourceTag.API, String.format("can't load banner - %s", objArr), 3);
                return;
            }
        }
        Object[] objArr2 = new Object[1];
        objArr2[0] = ironSourceBannerLayout == null ? "banner is null" : "banner is destroyed";
        this.f14623e.b(IronSourceLogger.IronSourceTag.API, String.format("can't load banner - %s", objArr2), 3);
    }

    @Override // com.ironsource.mediationsdk.sdk.InterfaceC2348c
    public void b(com.ironsource.mediationsdk.logger.b bVar, BannerSmash bannerSmash, boolean z) {
        a("onBannerAdReloadFailed " + bVar.b(), bannerSmash);
        if (this.f14622d != BANNER_STATE.RELOAD_IN_PROGRESS) {
            a("onBannerAdReloadFailed " + bannerSmash.c() + " wrong state=" + this.f14622d.name());
            return;
        }
        if (z) {
            a(3307, bannerSmash);
        } else {
            a(3301, bannerSmash, new Object[][]{new Object[]{"errorCode", Integer.valueOf(bVar.a())}});
        }
        if (this.h.size() == 1) {
            a(3201);
            g();
        } else {
            a(BANNER_STATE.LOAD_IN_PROGRESS);
            f();
            d();
        }
    }

    private boolean c() {
        IronSourceBannerLayout ironSourceBannerLayout = this.f14620b;
        return (ironSourceBannerLayout == null || ironSourceBannerLayout.isDestroyed()) ? false : true;
    }

    private boolean d() {
        for (BannerSmash bannerSmash : this.h) {
            if (bannerSmash.f() && this.f14619a != bannerSmash) {
                if (this.f14622d == BANNER_STATE.FIRST_LOAD_IN_PROGRESS) {
                    a(AuthApiStatusCodes.AUTH_API_CLIENT_ERROR, bannerSmash);
                } else {
                    a(3012, bannerSmash);
                }
                bannerSmash.a(this.f14620b, this.f14624f, this.g);
                return true;
            }
        }
        return false;
    }

    @Override // com.ironsource.mediationsdk.sdk.InterfaceC2348c
    public void b(BannerSmash bannerSmash) {
        Object[][] objArr;
        a("onBannerAdScreenPresented", bannerSmash);
        if (c()) {
            this.f14620b.sendBannerAdScreenPresented();
            objArr = null;
        } else {
            objArr = new Object[][]{new Object[]{"reason", "banner is destroyed"}};
        }
        a(3113, objArr);
        a(3302, bannerSmash, objArr);
    }

    public void b() {
        this.k = true;
    }

    private void a(String str) {
        this.f14623e.b(IronSourceLogger.IronSourceTag.INTERNAL, "BannerManager " + str, 0);
    }

    private void a(BANNER_STATE banner_state) {
        this.f14622d = banner_state;
        a("state=" + banner_state.name());
    }

    private void a(String str, BannerSmash bannerSmash) {
        this.f14623e.b(IronSourceLogger.IronSourceTag.ADAPTER_CALLBACK, "BannerManager " + str + " " + bannerSmash.c(), 0);
    }

    @Override // com.ironsource.mediationsdk.sdk.InterfaceC2348c
    public void a(BannerSmash bannerSmash, View view, FrameLayout.LayoutParams layoutParams) {
        a("onBannerAdLoaded", bannerSmash);
        BANNER_STATE banner_state = this.f14622d;
        if (banner_state == BANNER_STATE.FIRST_LOAD_IN_PROGRESS) {
            a(AuthApiStatusCodes.AUTH_URL_RESOLUTION, bannerSmash);
            b(bannerSmash, view, layoutParams);
            com.ironsource.mediationsdk.model.f fVar = this.f14621c;
            String strC = fVar != null ? fVar.c() : "";
            CappingManager.a(com.ironsource.mediationsdk.utils.c.c().b(), strC);
            if (CappingManager.d(com.ironsource.mediationsdk.utils.c.c().b(), strC)) {
                a(3400);
            }
            this.f14620b.sendBannerAdLoaded(bannerSmash.c());
            a(3110);
            a(BANNER_STATE.RELOAD_IN_PROGRESS);
            g();
            return;
        }
        if (banner_state == BANNER_STATE.LOAD_IN_PROGRESS) {
            a(3015, bannerSmash);
            b(bannerSmash, view, layoutParams);
            a(BANNER_STATE.RELOAD_IN_PROGRESS);
            g();
        }
    }

    @Override // com.ironsource.mediationsdk.sdk.InterfaceC2348c
    public void a(com.ironsource.mediationsdk.logger.b bVar, BannerSmash bannerSmash, boolean z) {
        a("onBannerAdLoadFailed " + bVar.b(), bannerSmash);
        BANNER_STATE banner_state = this.f14622d;
        if (banner_state != BANNER_STATE.FIRST_LOAD_IN_PROGRESS && banner_state != BANNER_STATE.LOAD_IN_PROGRESS) {
            a("onBannerAdLoadFailed " + bannerSmash.c() + " wrong state=" + this.f14622d.name());
            return;
        }
        if (z) {
            a(3306, bannerSmash);
        } else {
            a(3300, bannerSmash, new Object[][]{new Object[]{"errorCode", Integer.valueOf(bVar.a())}});
        }
        if (d()) {
            return;
        }
        if (this.f14622d == BANNER_STATE.FIRST_LOAD_IN_PROGRESS) {
            BannerCallbackThrottler.a().a(this.f14620b, new com.ironsource.mediationsdk.logger.b(606, "No ads to show"));
            a(3111, new Object[][]{new Object[]{"errorCode", 606}});
            a(BANNER_STATE.READY_TO_LOAD);
        } else {
            a(3201);
            a(BANNER_STATE.RELOAD_IN_PROGRESS);
            g();
        }
    }

    @Override // com.ironsource.mediationsdk.sdk.InterfaceC2348c
    public void a(BannerSmash bannerSmash, View view, FrameLayout.LayoutParams layoutParams, boolean z) {
        a("onBannerAdReloaded", bannerSmash);
        if (this.f14622d != BANNER_STATE.RELOAD_IN_PROGRESS) {
            a("onBannerAdReloaded " + bannerSmash.c() + " wrong state=" + this.f14622d.name());
            return;
        }
        com.ironsource.mediationsdk.utils.j.c("bannerReloadSucceeded");
        a(3015, bannerSmash);
        a("bindView = " + z, bannerSmash);
        if (z) {
            b(bannerSmash, view, layoutParams);
        }
        g();
    }

    @Override // com.ironsource.mediationsdk.sdk.InterfaceC2348c
    public void a(BannerSmash bannerSmash) {
        Object[][] objArr;
        a("onBannerAdLeftApplication", bannerSmash);
        if (c()) {
            this.f14620b.sendBannerAdLeftApplication();
            objArr = null;
        } else {
            objArr = new Object[][]{new Object[]{"reason", "banner is destroyed"}};
        }
        a(3115, objArr);
        a(3304, bannerSmash, objArr);
    }

    private void a(int i) {
        a(i, (Object[][]) null);
    }

    private void a(int i, Object[][] objArr) {
        JSONObject jSONObjectB = com.ironsource.mediationsdk.utils.j.b(false);
        try {
            if (this.f14620b != null) {
                a(jSONObjectB, this.f14620b.getSize());
            }
            if (this.f14621c != null) {
                jSONObjectB.put("placement", this.f14621c.c());
            }
            if (objArr != null) {
                for (Object[] objArr2 : objArr) {
                    jSONObjectB.put(objArr2[0].toString(), objArr2[1]);
                }
            }
        } catch (Exception e2) {
            this.f14623e.b(IronSourceLogger.IronSourceTag.INTERNAL, "sendMediationEvent " + Log.getStackTraceString(e2), 3);
        }
        com.ironsource.mediationsdk.b.h.g().c(new b.f.b.b(i, jSONObjectB));
    }

    private void a(int i, BannerSmash bannerSmash) {
        a(i, bannerSmash, (Object[][]) null);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0043  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void a(org.json.JSONObject r8, com.ironsource.mediationsdk.C2374v r9) {
        /*
            r7 = this;
            r0 = 3
            java.lang.String r1 = r9.a()     // Catch: java.lang.Exception -> L88
            r2 = -1
            int r3 = r1.hashCode()     // Catch: java.lang.Exception -> L88
            r4 = 4
            r5 = 2
            r6 = 1
            switch(r3) {
                case -387072689: goto L39;
                case 72205083: goto L2f;
                case 79011241: goto L25;
                case 1951953708: goto L1b;
                case 1999208305: goto L11;
                default: goto L10;
            }     // Catch: java.lang.Exception -> L88
        L10:
            goto L43
        L11:
            java.lang.String r3 = "CUSTOM"
            boolean r1 = r1.equals(r3)     // Catch: java.lang.Exception -> L88
            if (r1 == 0) goto L43
            r1 = 4
            goto L44
        L1b:
            java.lang.String r3 = "BANNER"
            boolean r1 = r1.equals(r3)     // Catch: java.lang.Exception -> L88
            if (r1 == 0) goto L43
            r1 = 0
            goto L44
        L25:
            java.lang.String r3 = "SMART"
            boolean r1 = r1.equals(r3)     // Catch: java.lang.Exception -> L88
            if (r1 == 0) goto L43
            r1 = 3
            goto L44
        L2f:
            java.lang.String r3 = "LARGE"
            boolean r1 = r1.equals(r3)     // Catch: java.lang.Exception -> L88
            if (r1 == 0) goto L43
            r1 = 1
            goto L44
        L39:
            java.lang.String r3 = "RECTANGLE"
            boolean r1 = r1.equals(r3)     // Catch: java.lang.Exception -> L88
            if (r1 == 0) goto L43
            r1 = 2
            goto L44
        L43:
            r1 = -1
        L44:
            java.lang.String r2 = "bannerAdSize"
            if (r1 == 0) goto L84
            if (r1 == r6) goto L80
            if (r1 == r5) goto L7c
            if (r1 == r0) goto L77
            if (r1 == r4) goto L51
            goto La5
        L51:
            r1 = 6
            r8.put(r2, r1)     // Catch: java.lang.Exception -> L88
            java.lang.String r1 = "custom_banner_size"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L88
            r2.<init>()     // Catch: java.lang.Exception -> L88
            int r3 = r9.c()     // Catch: java.lang.Exception -> L88
            r2.append(r3)     // Catch: java.lang.Exception -> L88
            java.lang.String r3 = "x"
            r2.append(r3)     // Catch: java.lang.Exception -> L88
            int r9 = r9.b()     // Catch: java.lang.Exception -> L88
            r2.append(r9)     // Catch: java.lang.Exception -> L88
            java.lang.String r9 = r2.toString()     // Catch: java.lang.Exception -> L88
            r8.put(r1, r9)     // Catch: java.lang.Exception -> L88
            goto La5
        L77:
            r9 = 5
            r8.put(r2, r9)     // Catch: java.lang.Exception -> L88
            goto La5
        L7c:
            r8.put(r2, r0)     // Catch: java.lang.Exception -> L88
            goto La5
        L80:
            r8.put(r2, r5)     // Catch: java.lang.Exception -> L88
            goto La5
        L84:
            r8.put(r2, r6)     // Catch: java.lang.Exception -> L88
            goto La5
        L88:
            r8 = move-exception
            com.ironsource.mediationsdk.logger.c r9 = r7.f14623e
            com.ironsource.mediationsdk.logger.IronSourceLogger$IronSourceTag r1 = com.ironsource.mediationsdk.logger.IronSourceLogger.IronSourceTag.INTERNAL
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "sendProviderEvent "
            r2.append(r3)
            java.lang.String r8 = android.util.Log.getStackTraceString(r8)
            r2.append(r8)
            java.lang.String r8 = r2.toString()
            r9.b(r1, r8, r0)
        La5:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.mediationsdk.BannerManager.a(org.json.JSONObject, com.ironsource.mediationsdk.v):void");
    }

    private void a(int i, BannerSmash bannerSmash, Object[][] objArr) {
        JSONObject jSONObjectA = com.ironsource.mediationsdk.utils.j.a(bannerSmash);
        try {
            if (this.f14620b != null) {
                a(jSONObjectA, this.f14620b.getSize());
            }
            if (this.f14621c != null) {
                jSONObjectA.put("placement", this.f14621c.c());
            }
            if (objArr != null) {
                for (Object[] objArr2 : objArr) {
                    jSONObjectA.put(objArr2[0].toString(), objArr2[1]);
                }
            }
        } catch (Exception e2) {
            this.f14623e.b(IronSourceLogger.IronSourceTag.INTERNAL, "sendProviderEvent " + Log.getStackTraceString(e2), 3);
        }
        com.ironsource.mediationsdk.b.h.g().c(new b.f.b.b(i, jSONObjectA));
    }

    public void a() {
        this.k = false;
    }
}
