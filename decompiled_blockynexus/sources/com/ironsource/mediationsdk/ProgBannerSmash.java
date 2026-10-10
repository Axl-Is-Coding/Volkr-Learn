package com.ironsource.mediationsdk;

import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import com.google.android.gms.auth.api.proxy.AuthApiStatusCodes;
import com.ironsource.mediationsdk.g.d;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.sdk.InterfaceC2349d;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class ProgBannerSmash extends AbstractC2373ua implements d.a, InterfaceC2349d {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private C2329k f14707f;
    private com.ironsource.mediationsdk.g.d g;
    private BannerSmashState h;
    private InterfaceC2330ka i;
    private IronSourceBannerLayout j;
    private String k;
    private int l;
    private String m;
    private com.ironsource.mediationsdk.model.f n;
    private int o;
    private final Object p;

    protected enum BannerSmashState {
        NONE,
        INIT_IN_PROGRESS,
        READY_TO_LOAD,
        LOADING,
        LOADED,
        LOAD_FAILED,
        DESTROYED
    }

    ProgBannerSmash(C2329k c2329k, InterfaceC2330ka interfaceC2330ka, com.ironsource.mediationsdk.model.p pVar, AbstractC2311b abstractC2311b, int i) {
        this(c2329k, interfaceC2330ka, pVar, abstractC2311b, i, "", 0, "");
    }

    private void D() {
        IronLog.INTERNAL.verbose(B() + "isBidder = " + y());
        a(BannerSmashState.INIT_IN_PROGRESS);
        F();
        try {
            if (y()) {
                this.f15008a.initBannerForBidding(this.f14707f.a(), this.f14707f.g(), this.f15011d, this);
            } else {
                this.f15008a.initBanners(this.f14707f.a(), this.f14707f.g(), this.f15011d, this);
            }
        } catch (Throwable th) {
            IronLog.INTERNAL.error("exception = " + th.getLocalizedMessage());
            h(new com.ironsource.mediationsdk.logger.b(612, th.getLocalizedMessage()));
        }
    }

    private boolean E() {
        IronSourceBannerLayout ironSourceBannerLayout = this.j;
        return ironSourceBannerLayout == null || ironSourceBannerLayout.isDestroyed();
    }

    private void F() {
        if (this.f15008a == null) {
            return;
        }
        try {
            String strH = U.e().h();
            if (!TextUtils.isEmpty(strH)) {
                this.f15008a.setMediationSegment(strH);
            }
            String strC = com.ironsource.mediationsdk.a.a.a().c();
            if (TextUtils.isEmpty(strC)) {
                return;
            }
            this.f15008a.setPluginData(strC, com.ironsource.mediationsdk.a.a.a().b());
        } catch (Exception e2) {
            IronLog.INTERNAL.verbose("exception - " + e2.toString());
        }
    }

    private void b(String str) {
        IronLog.INTERNAL.verbose(A());
        if (a(BannerSmashState.READY_TO_LOAD, BannerSmashState.LOADING)) {
            a(AuthApiStatusCodes.AUTH_API_CLIENT_ERROR);
            if (y()) {
                this.f15008a.loadBannerForBidding(this.j, this.f15011d, this, str);
                return;
            } else {
                this.f15008a.loadBanner(this.j, this.f15011d, this);
                return;
            }
        }
        IronLog.INTERNAL.error("wrong state - state = " + this.h);
    }

    private boolean b(int i) {
        return i == 3005 || i == 3002 || i == 3008 || i == 3305 || i == 3300 || i == 3302 || i == 3303 || i == 3304;
    }

    private void i(com.ironsource.mediationsdk.logger.b bVar) {
        boolean z = bVar.a() == 606;
        Object[][] objArr = {new Object[]{"errorCode", Integer.valueOf(bVar.a())}};
        int i = z ? 3306 : 3300;
        if (z) {
            objArr = null;
        }
        a(i, objArr);
        InterfaceC2330ka interfaceC2330ka = this.i;
        if (interfaceC2330ka != null) {
            interfaceC2330ka.a(bVar, this, z);
        }
    }

    public String A() {
        return String.format("%s %s", C(), Integer.valueOf(hashCode()));
    }

    public String B() {
        return String.format("%s - ", A());
    }

    public String C() {
        return this.f15009b.g().m() ? this.f15009b.g().i() : this.f15009b.g().h();
    }

    public void a(IronSourceBannerLayout ironSourceBannerLayout, com.ironsource.mediationsdk.model.f fVar, String str) {
        IronLog.INTERNAL.verbose(A());
        this.n = fVar;
        if (!C2335n.a(ironSourceBannerLayout)) {
            String str2 = ironSourceBannerLayout == null ? "banner is null" : "banner is destroyed";
            IronLog.INTERNAL.verbose(str2);
            this.i.a(new com.ironsource.mediationsdk.logger.b(610, str2), this, false);
            return;
        }
        if (this.f15008a == null) {
            IronLog.INTERNAL.verbose("mAdapter is null");
            this.i.a(new com.ironsource.mediationsdk.logger.b(611, "mAdapter is null"), this, false);
            return;
        }
        this.j = ironSourceBannerLayout;
        this.g.a((d.a) this);
        try {
            if (y()) {
                b(str);
            } else {
                D();
            }
        } catch (Throwable th) {
            IronLog.INTERNAL.error("exception = " + th.getLocalizedMessage());
            th.printStackTrace();
        }
    }

    @Override // com.ironsource.mediationsdk.sdk.InterfaceC2349d
    public void d(com.ironsource.mediationsdk.logger.b bVar) {
        IronLog.INTERNAL.verbose(B() + "error = " + bVar);
        this.g.d();
        if (a(BannerSmashState.LOADING, BannerSmashState.LOAD_FAILED)) {
            i(bVar);
        }
    }

    @Override // com.ironsource.mediationsdk.sdk.InterfaceC2349d
    public void h(com.ironsource.mediationsdk.logger.b bVar) {
        IronLog.INTERNAL.verbose(B() + "error = " + bVar);
        this.g.d();
        if (a(BannerSmashState.INIT_IN_PROGRESS, BannerSmashState.NONE)) {
            InterfaceC2330ka interfaceC2330ka = this.i;
            if (interfaceC2330ka != null) {
                interfaceC2330ka.a(new com.ironsource.mediationsdk.logger.b(612, "Banner init failed"), this, false);
                return;
            }
            return;
        }
        IronLog.INTERNAL.warning("wrong state - mState = " + this.h);
    }

    @Override // com.ironsource.mediationsdk.sdk.InterfaceC2349d
    public void j() {
        IronLog.INTERNAL.verbose(A());
        a(3304);
        InterfaceC2330ka interfaceC2330ka = this.i;
        if (interfaceC2330ka != null) {
            interfaceC2330ka.d(this);
        }
    }

    @Override // com.ironsource.mediationsdk.sdk.InterfaceC2349d
    public void o() {
        IronLog.INTERNAL.verbose(A());
        a(3008);
        InterfaceC2330ka interfaceC2330ka = this.i;
        if (interfaceC2330ka != null) {
            interfaceC2330ka.b(this);
        }
    }

    @Override // com.ironsource.mediationsdk.sdk.InterfaceC2349d
    public void onBannerInitSuccess() {
        IronLog.INTERNAL.verbose(A());
        if (!a(BannerSmashState.INIT_IN_PROGRESS, BannerSmashState.READY_TO_LOAD) || y()) {
            return;
        }
        if (C2335n.a(this.j)) {
            b((String) null);
        } else {
            this.i.a(new com.ironsource.mediationsdk.logger.b(605, this.j == null ? "banner is null" : "banner is destroyed"), this, false);
        }
    }

    @Override // com.ironsource.mediationsdk.g.d.a
    public void onTimeout() {
        com.ironsource.mediationsdk.logger.b bVar;
        IronLog.INTERNAL.verbose(A());
        if (a(BannerSmashState.INIT_IN_PROGRESS, BannerSmashState.LOAD_FAILED)) {
            IronLog.INTERNAL.verbose("init timed out");
            bVar = new com.ironsource.mediationsdk.logger.b(607, "Timed out");
        } else {
            if (!a(BannerSmashState.LOADING, BannerSmashState.LOAD_FAILED)) {
                IronLog.INTERNAL.error("unexpected state - " + this.h);
                return;
            }
            IronLog.INTERNAL.verbose("load timed out");
            bVar = new com.ironsource.mediationsdk.logger.b(608, "Timed out");
        }
        i(bVar);
    }

    @Override // com.ironsource.mediationsdk.sdk.InterfaceC2349d
    public void p() {
        IronLog.INTERNAL.verbose(A());
        a(3303);
        InterfaceC2330ka interfaceC2330ka = this.i;
        if (interfaceC2330ka != null) {
            interfaceC2330ka.a(this);
        }
    }

    @Override // com.ironsource.mediationsdk.sdk.InterfaceC2349d
    public void q() {
        IronLog.INTERNAL.verbose(A());
        a(3302);
        InterfaceC2330ka interfaceC2330ka = this.i;
        if (interfaceC2330ka != null) {
            interfaceC2330ka.c(this);
        }
    }

    public Map<String, Object> z() {
        try {
            if (y()) {
                return this.f15008a.getBannerBiddingData(this.f15011d);
            }
            return null;
        } catch (Throwable th) {
            IronLog.INTERNAL.error("getBiddingData exception: " + th.getLocalizedMessage());
            th.printStackTrace();
            return null;
        }
    }

    ProgBannerSmash(C2329k c2329k, InterfaceC2330ka interfaceC2330ka, com.ironsource.mediationsdk.model.p pVar, AbstractC2311b abstractC2311b, int i, String str, int i2, String str2) {
        super(new com.ironsource.mediationsdk.model.a(pVar, pVar.d()), abstractC2311b);
        this.p = new Object();
        this.h = BannerSmashState.NONE;
        this.f14707f = c2329k;
        this.g = new com.ironsource.mediationsdk.g.d(c2329k.d());
        this.i = interfaceC2330ka;
        this.o = i;
        this.k = str;
        this.l = i2;
        this.m = str2;
        this.f15008a.addBannerListener(this);
        if (y()) {
            D();
        }
    }

    private boolean a(BannerSmashState bannerSmashState, BannerSmashState bannerSmashState2) {
        boolean z;
        synchronized (this.p) {
            if (this.h == bannerSmashState) {
                IronLog.INTERNAL.verbose(B() + "set state from '" + this.h + "' to '" + bannerSmashState2 + "'");
                z = true;
                this.h = bannerSmashState2;
            } else {
                z = false;
            }
        }
        return z;
    }

    private void a(BannerSmashState bannerSmashState) {
        IronLog.INTERNAL.verbose(B() + "state = " + bannerSmashState.name());
        synchronized (this.p) {
            this.h = bannerSmashState;
        }
    }

    @Override // com.ironsource.mediationsdk.sdk.InterfaceC2349d
    public void a(View view, FrameLayout.LayoutParams layoutParams) {
        IronLog.INTERNAL.verbose(A());
        this.g.d();
        if (a(BannerSmashState.LOADING, BannerSmashState.LOADED)) {
            a(AuthApiStatusCodes.AUTH_URL_RESOLUTION);
            InterfaceC2330ka interfaceC2330ka = this.i;
            if (interfaceC2330ka != null) {
                interfaceC2330ka.a(this, view, layoutParams);
            }
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private void a(Map<String, Object> map, C2374v c2374v) {
        try {
            String strA = c2374v.a();
            byte b2 = -1;
            switch (strA.hashCode()) {
                case -387072689:
                    if (strA.equals("RECTANGLE")) {
                        b2 = 2;
                    }
                    break;
                case 72205083:
                    if (strA.equals("LARGE")) {
                        b2 = 1;
                    }
                    break;
                case 79011241:
                    if (strA.equals("SMART")) {
                        b2 = 3;
                    }
                    break;
                case 1951953708:
                    if (strA.equals("BANNER")) {
                        b2 = 0;
                    }
                    break;
                case 1999208305:
                    if (strA.equals("CUSTOM")) {
                        b2 = 4;
                    }
                    break;
            }
            if (b2 == 0) {
                map.put("bannerAdSize", 1);
                return;
            }
            if (b2 == 1) {
                map.put("bannerAdSize", 2);
                return;
            }
            if (b2 == 2) {
                map.put("bannerAdSize", 3);
                return;
            }
            if (b2 == 3) {
                map.put("bannerAdSize", 5);
                return;
            }
            if (b2 != 4) {
                return;
            }
            map.put("bannerAdSize", 6);
            map.put("custom_banner_size", c2374v.c() + "x" + c2374v.b());
        } catch (Exception e2) {
            IronLog.INTERNAL.error(Log.getStackTraceString(e2));
        }
    }

    public void a(int i) {
        a(i, (Object[][]) null);
    }

    private void a(int i, Object[][] objArr) {
        Map<String, Object> mapX = x();
        if (E()) {
            mapX.put("reason", "banner is destroyed");
        } else {
            a(mapX, this.j.getSize());
        }
        if (!TextUtils.isEmpty(this.k)) {
            mapX.put("auctionId", this.k);
        }
        com.ironsource.mediationsdk.model.f fVar = this.n;
        if (fVar != null) {
            mapX.put("placement", fVar.c());
        }
        if (b(i)) {
            com.ironsource.mediationsdk.b.h.g().a(mapX, this.l, this.m);
        }
        mapX.put("sessionDepth", Integer.valueOf(this.o));
        if (objArr != null) {
            try {
                for (Object[] objArr2 : objArr) {
                    mapX.put(objArr2[0].toString(), objArr2[1]);
                }
            } catch (Exception e2) {
                IronLog.INTERNAL.error(r() + " smash: BN sendMediationEvent " + Log.getStackTraceString(e2));
            }
        }
        com.ironsource.mediationsdk.b.h.g().c(new b.f.b.b(i, new JSONObject(mapX)));
    }
}
