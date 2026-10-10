package com.ironsource.mediationsdk;

import android.text.TextUtils;
import android.util.Log;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.internal.ServerProtocol;
import com.ironsource.mediationsdk.AbstractSmash;
import com.ironsource.mediationsdk.logger.IronSourceLogger;
import com.sandboxol.center.web.http.HttpCode;
import java.util.Date;
import java.util.Map;
import java.util.Timer;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class ProgRvSmash extends AbstractC2373ua implements com.ironsource.mediationsdk.sdk.X {
    private final Object A;
    private final Object B;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private SMASH_STATE f14719f;
    private InterfaceC2345sa g;
    private Timer h;
    private int i;
    private String j;
    private String k;
    private String l;
    private boolean m;
    private boolean n;
    private boolean o;
    private com.ironsource.mediationsdk.model.l p;
    private int q;
    private long r;
    private String s;
    private String t;
    private int u;
    private String v;
    private int w;
    private int x;
    private String y;
    private String z;

    protected enum SMASH_STATE {
        NO_INIT,
        INIT_IN_PROGRESS,
        NOT_LOADED,
        LOAD_IN_PROGRESS,
        LOADED,
        SHOW_IN_PROGRESS
    }

    public ProgRvSmash(String str, String str2, com.ironsource.mediationsdk.model.p pVar, InterfaceC2345sa interfaceC2345sa, int i, AbstractC2311b abstractC2311b) {
        super(new com.ironsource.mediationsdk.model.a(pVar, pVar.k()), abstractC2311b);
        this.A = new Object();
        this.B = new Object();
        this.f14719f = SMASH_STATE.NO_INIT;
        this.j = str;
        this.k = str2;
        this.g = interfaceC2345sa;
        this.h = null;
        this.i = i;
        this.f15008a.addRewardedVideoListener(this);
        this.m = false;
        this.n = false;
        this.o = false;
        this.p = null;
        this.s = "";
        this.q = 1;
        H();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long G() {
        return new Date().getTime() - this.r;
    }

    private void H() {
        this.t = "";
        this.w = -1;
        this.z = "";
        this.l = "";
        this.x = this.q;
        this.y = "";
    }

    private void I() {
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
            b("setCustomParams() " + e2.getMessage());
        }
    }

    private void J() {
        synchronized (this.A) {
            K();
            this.h = new Timer();
            this.h.schedule(new C2371ta(this), this.i * 1000);
        }
    }

    private void K() {
        synchronized (this.A) {
            if (this.h != null) {
                this.h.cancel();
                this.h = null;
            }
        }
    }

    private boolean c(int i) {
        return i == 1001 || i == 1002 || i == 1200 || i == 1005 || i == 1203 || i == 1201 || i == 1202 || i == 1006 || i == 1010;
    }

    private void logAdapterCallback(String str) {
        com.ironsource.mediationsdk.logger.c.c().b(IronSourceLogger.IronSourceTag.ADAPTER_CALLBACK, "ProgRvSmash " + r() + " : " + str, 0);
    }

    public void A() {
        b("initForBidding()");
        a(SMASH_STATE.INIT_IN_PROGRESS);
        I();
        try {
            this.f15008a.initRewardedVideoForBidding(this.j, this.k, this.f15011d, this);
        } catch (Throwable th) {
            c("initForBidding exception: " + th.getLocalizedMessage());
            th.printStackTrace();
            f(new com.ironsource.mediationsdk.logger.b(1040, th.getLocalizedMessage()));
        }
    }

    public boolean B() {
        SMASH_STATE smash_state = this.f14719f;
        return smash_state == SMASH_STATE.INIT_IN_PROGRESS || smash_state == SMASH_STATE.LOAD_IN_PROGRESS;
    }

    public boolean C() {
        try {
            return y() ? this.o && this.f14719f == SMASH_STATE.LOADED && D() : D();
        } catch (Throwable th) {
            c("isReadyToShow exception: " + th.getLocalizedMessage());
            th.printStackTrace();
            a(81316, new Object[][]{new Object[]{"errorCode", 5002}, new Object[]{"reason", th.getLocalizedMessage()}});
            return false;
        }
    }

    public boolean D() {
        return this.f15008a.isRewardedVideoAvailable(this.f15011d);
    }

    public void E() {
        this.f15008a.setMediationState(AbstractSmash.MEDIATION_STATE.CAPPED_PER_SESSION, "rewardedvideo");
        a(1401);
    }

    public void F() {
        if (y()) {
            this.o = false;
        }
    }

    @Override // com.ironsource.mediationsdk.sdk.X
    public void f(com.ironsource.mediationsdk.logger.b bVar) {
        logAdapterCallback("onRewardedVideoInitFailed error=" + bVar.b());
        K();
        a(1200, new Object[][]{new Object[]{"errorCode", 1033}, new Object[]{"duration", Long.valueOf(G())}});
        a(1212, new Object[][]{new Object[]{"errorCode", Integer.valueOf(bVar.a())}, new Object[]{"reason", bVar.b()}, new Object[]{"duration", Long.valueOf(G())}});
        synchronized (this.B) {
            if (this.f14719f == SMASH_STATE.INIT_IN_PROGRESS) {
                a(SMASH_STATE.NO_INIT);
                this.g.b(this, this.s);
            } else {
                a(81316, new Object[][]{new Object[]{"errorCode", 5008}, new Object[]{"reason", "initFailed: " + this.f14719f}});
            }
        }
    }

    @Override // com.ironsource.mediationsdk.sdk.X
    public void g() {
        logAdapterCallback("onRewardedVideoAdStarted");
        this.g.d(this);
        b(1204);
    }

    @Override // com.ironsource.mediationsdk.sdk.X
    public void i() {
        logAdapterCallback("onRewardedVideoAdVisible");
        b(1206);
    }

    @Override // com.ironsource.mediationsdk.sdk.X
    public void k() {
        logAdapterCallback("onRewardedVideoAdClicked");
        this.g.b(this, this.p);
        b(HttpCode.PASSWORD_NOT_SET);
    }

    @Override // com.ironsource.mediationsdk.sdk.X
    public void l() {
        logAdapterCallback("onRewardedVideoAdRewarded");
        this.g.a(this, this.p);
        Map<String, Object> mapX = x();
        com.ironsource.mediationsdk.model.l lVar = this.p;
        if (lVar != null) {
            mapX.put("placement", lVar.c());
            mapX.put("rewardName", this.p.e());
            mapX.put("rewardAmount", Integer.valueOf(this.p.d()));
        }
        if (!TextUtils.isEmpty(U.e().d())) {
            mapX.put("dynamicUserId", U.e().d());
        }
        if (U.e().j() != null) {
            for (String str : U.e().j().keySet()) {
                mapX.put("custom_" + str, U.e().j().get(str));
            }
        }
        if (!TextUtils.isEmpty(this.s)) {
            mapX.put("auctionId", this.s);
        }
        if (c(1010)) {
            com.ironsource.mediationsdk.b.k.g().a(mapX, this.u, this.v);
        }
        mapX.put("sessionDepth", Integer.valueOf(this.q));
        b.f.b.b bVar = new b.f.b.b(1010, new JSONObject(mapX));
        bVar.a("transId", com.ironsource.mediationsdk.utils.j.b("" + Long.toString(bVar.d()) + this.j + r()));
        com.ironsource.mediationsdk.b.k.g().c(bVar);
    }

    @Override // com.ironsource.mediationsdk.sdk.X
    public void m() {
        logAdapterCallback("onRewardedVideoInitSuccess");
        synchronized (this.B) {
            if (this.f14719f == SMASH_STATE.INIT_IN_PROGRESS) {
                a(SMASH_STATE.NOT_LOADED);
                return;
            }
            a(81316, new Object[][]{new Object[]{"errorCode", 5007}, new Object[]{"reason", "initSuccess: " + this.f14719f}});
        }
    }

    @Override // com.ironsource.mediationsdk.sdk.X
    public void n() {
    }

    @Override // com.ironsource.mediationsdk.sdk.X
    public void onRewardedVideoAdClosed() {
        logAdapterCallback("onRewardedVideoAdClosed");
        synchronized (this.B) {
            if (this.f14719f != SMASH_STATE.SHOW_IN_PROGRESS) {
                b(1203);
                a(81316, new Object[][]{new Object[]{"errorCode", 5009}, new Object[]{"reason", "adClosed: " + this.f14719f}});
                return;
            }
            a(SMASH_STATE.NOT_LOADED);
            this.g.b(this);
            if (this.m) {
                b("onRewardedVideoAdClosed and mShouldLoadAfterClose is true - calling loadRewardedVideoForBidding");
                this.m = false;
                a(this.l, this.t, this.w, this.z, this.x, this.y);
                H();
            }
        }
    }

    @Override // com.ironsource.mediationsdk.sdk.X
    public void onRewardedVideoAdOpened() {
        logAdapterCallback("onRewardedVideoAdOpened");
        this.g.a(this);
        b(1005);
    }

    public Map<String, Object> z() {
        try {
            if (y()) {
                return this.f15008a.getRewardedVideoBiddingData(this.f15011d);
            }
            return null;
        } catch (Throwable th) {
            c("getBiddingData exception: " + th.getLocalizedMessage());
            th.printStackTrace();
            a(81316, new Object[][]{new Object[]{"errorCode", 5001}, new Object[]{"reason", th.getLocalizedMessage()}});
            return null;
        }
    }

    @Override // com.ironsource.mediationsdk.sdk.X
    public void b() {
        logAdapterCallback("onRewardedVideoAdEnded");
        this.g.c(this);
        b(1205);
    }

    @Override // com.ironsource.mediationsdk.sdk.X
    public void c(com.ironsource.mediationsdk.logger.b bVar) {
        logAdapterCallback("onRewardedVideoAdShowFailed error=" + bVar.b());
        b(1202, new Object[][]{new Object[]{"errorCode", Integer.valueOf(bVar.a())}, new Object[]{"reason", bVar.b()}});
        synchronized (this.B) {
            if (this.f14719f == SMASH_STATE.SHOW_IN_PROGRESS) {
                a(SMASH_STATE.NOT_LOADED);
                this.g.a(bVar, this);
            } else {
                a(81316, new Object[][]{new Object[]{"errorCode", 5006}, new Object[]{"reason", "showFailed: " + this.f14719f}});
            }
        }
    }

    @Override // com.ironsource.mediationsdk.sdk.X
    public void e(com.ironsource.mediationsdk.logger.b bVar) {
        a(1212, new Object[][]{new Object[]{"errorCode", Integer.valueOf(bVar.a())}, new Object[]{"reason", bVar.b()}, new Object[]{"duration", Long.valueOf(G())}});
    }

    public void a(String str, String str2, int i, String str3, int i2, String str4) {
        SMASH_STATE smash_state;
        b("loadVideo() auctionId: " + str2 + " state: " + this.f14719f);
        b(false);
        this.o = true;
        synchronized (this.B) {
            smash_state = this.f14719f;
            if (this.f14719f != SMASH_STATE.LOAD_IN_PROGRESS && this.f14719f != SMASH_STATE.SHOW_IN_PROGRESS) {
                a(SMASH_STATE.LOAD_IN_PROGRESS);
            }
        }
        if (smash_state == SMASH_STATE.LOAD_IN_PROGRESS) {
            a(81316, new Object[][]{new Object[]{"errorCode", 5003}, new Object[]{"reason", "load during load"}});
            this.n = true;
            b(str, str2, i, str3, i2, str4);
            this.g.b(this, str2);
            return;
        }
        if (smash_state == SMASH_STATE.SHOW_IN_PROGRESS) {
            a(81316, new Object[][]{new Object[]{"errorCode", 5004}, new Object[]{"reason", "load during show"}});
            this.m = true;
            b(str, str2, i, str3, i2, str4);
            return;
        }
        this.f15012e = str4;
        this.s = str2;
        this.u = i;
        this.v = str3;
        this.q = i2;
        J();
        this.r = new Date().getTime();
        a(1001);
        try {
            if (y()) {
                this.f15008a.loadRewardedVideoForBidding(this.f15011d, this, str);
            } else if (smash_state == SMASH_STATE.NO_INIT) {
                I();
                this.f15008a.initRewardedVideo(this.j, this.k, this.f15011d, this);
            } else {
                this.f15008a.fetchRewardedVideoForAutomaticLoad(this.f15011d, this);
            }
        } catch (Throwable th) {
            c("loadRewardedVideoForBidding exception: " + th.getLocalizedMessage());
            th.printStackTrace();
            a(81316, new Object[][]{new Object[]{"errorCode", 5005}, new Object[]{"reason", th.getLocalizedMessage()}});
        }
    }

    private void b(String str, String str2, int i, String str3, int i2, String str4) {
        this.t = str2;
        this.l = str;
        this.w = i;
        this.z = str3;
        this.x = i2;
        this.y = str4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str) {
        com.ironsource.mediationsdk.logger.c.c().b(IronSourceLogger.IronSourceTag.INTERNAL, "ProgRvSmash " + r() + " : " + str, 0);
    }

    private void c(String str) {
        com.ironsource.mediationsdk.logger.c.c().b(IronSourceLogger.IronSourceTag.INTERNAL, "ProgRvSmash " + r() + " : " + str, 3);
    }

    private void b(int i) {
        b(i, null);
    }

    public void b(int i, Object[][] objArr) {
        a(i, objArr, true);
    }

    public void a(boolean z, int i) {
        this.q = i;
        Object[][] objArr = new Object[1][];
        Object[] objArr2 = new Object[2];
        objArr2[0] = AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS;
        objArr2[1] = z ? ServerProtocol.DIALOG_RETURN_SCOPES_TRUE : "false";
        objArr[0] = objArr2;
        b(1209, objArr);
    }

    public void a(com.ironsource.mediationsdk.model.l lVar, int i) {
        K();
        b("showVideo()");
        this.p = lVar;
        this.q = i;
        a(SMASH_STATE.SHOW_IN_PROGRESS);
        b(1201);
        try {
            this.f15008a.showRewardedVideo(this.f15011d, this);
        } catch (Throwable th) {
            c("showVideo exception: " + th.getLocalizedMessage());
            th.printStackTrace();
            c(new com.ironsource.mediationsdk.logger.b(1038, th.getLocalizedMessage()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(SMASH_STATE smash_state) {
        b("current state=" + this.f14719f + ", new state=" + smash_state);
        synchronized (this.B) {
            this.f14719f = smash_state;
        }
    }

    @Override // com.ironsource.mediationsdk.sdk.X
    public void a(boolean z) {
        boolean z2;
        K();
        logAdapterCallback("onRewardedVideoAvailabilityChanged available=" + z + " state=" + this.f14719f.name());
        synchronized (this.B) {
            if (this.f14719f == SMASH_STATE.LOAD_IN_PROGRESS) {
                a(z ? SMASH_STATE.LOADED : SMASH_STATE.NOT_LOADED);
                z2 = false;
            } else {
                z2 = true;
            }
        }
        if (z2) {
            if (z) {
                a(1207, new Object[][]{new Object[]{"ext1", this.f14719f.name()}});
                return;
            } else {
                a(1208, new Object[][]{new Object[]{"errorCode", 1034}, new Object[]{"duration", Long.valueOf(G())}, new Object[]{"ext1", this.f14719f.name()}});
                return;
            }
        }
        a(z ? 1002 : 1200, new Object[][]{new Object[]{"duration", Long.valueOf(G())}});
        if (!this.n) {
            if (z) {
                this.g.a(this, this.s);
                return;
            } else {
                this.g.b(this, this.s);
                return;
            }
        }
        this.n = false;
        b("onRewardedVideoAvailabilityChanged to " + z + "and mShouldLoadAfterLoad is true - calling loadVideo");
        a(this.l, this.t, this.w, this.z, this.x, this.y);
        H();
    }

    private void a(int i) {
        a(i, null, false);
    }

    public void a(int i, Object[][] objArr) {
        a(i, objArr, false);
    }

    private void a(int i, Object[][] objArr, boolean z) {
        com.ironsource.mediationsdk.model.l lVar;
        Map<String, Object> mapX = x();
        if (!TextUtils.isEmpty(this.s)) {
            mapX.put("auctionId", this.s);
        }
        if (z && (lVar = this.p) != null && !TextUtils.isEmpty(lVar.c())) {
            mapX.put("placement", this.p.c());
        }
        if (c(i)) {
            com.ironsource.mediationsdk.b.k.g().a(mapX, this.u, this.v);
        }
        mapX.put("sessionDepth", Integer.valueOf(this.q));
        if (objArr != null) {
            try {
                for (Object[] objArr2 : objArr) {
                    mapX.put(objArr2[0].toString(), objArr2[1]);
                }
            } catch (Exception e2) {
                com.ironsource.mediationsdk.logger.c.c().b(IronSourceLogger.IronSourceTag.INTERNAL, r() + " smash: RV sendMediationEvent " + Log.getStackTraceString(e2), 3);
            }
        }
        com.ironsource.mediationsdk.b.k.g().c(new b.f.b.b(i, new JSONObject(mapX)));
        if (i == 1203) {
            com.ironsource.mediationsdk.utils.m.a().b(1);
        }
    }
}
