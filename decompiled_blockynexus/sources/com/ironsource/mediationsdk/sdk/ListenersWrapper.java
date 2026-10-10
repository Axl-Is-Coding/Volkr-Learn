package com.ironsource.mediationsdk.sdk;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.facebook.internal.AnalyticsEvents;
import com.ironsource.mediationsdk.logger.IronSourceLogger;
import java.util.Date;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class ListenersWrapper implements U, Y, InterfaceC2357l, InterfaceC2360o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private U f14984a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private InterfaceC2360o f14985b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Q f14986c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Y f14987d;
    private long h;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private com.ironsource.mediationsdk.model.i f14989f = null;
    private String g = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private a f14988e = new a(this, null);

    private class a extends Thread {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Handler f14990a;

        private a() {
        }

        public Handler a() {
            return this.f14990a;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            Looper.prepare();
            this.f14990a = new Handler();
            Looper.loop();
        }

        /* synthetic */ a(ListenersWrapper listenersWrapper, D d2) {
            this();
        }
    }

    public ListenersWrapper() {
        this.f14988e.start();
        this.h = new Date().getTime();
    }

    private boolean canSendCallback(Object obj) {
        return (obj == null || this.f14988e == null) ? false : true;
    }

    private void sendCallback(Runnable runnable) {
        Handler handlerA;
        a aVar = this.f14988e;
        if (aVar == null || (handlerA = aVar.a()) == null) {
            return;
        }
        handlerA.post(runnable);
    }

    @Override // com.ironsource.mediationsdk.sdk.InterfaceC2360o
    public void e() {
        com.ironsource.mediationsdk.logger.c.c().b(IronSourceLogger.IronSourceTag.CALLBACK, "onInterstitialAdOpened()", 1);
        if (canSendCallback(this.f14985b)) {
            sendCallback(new RunnableC2366v(this));
        }
    }

    @Override // com.ironsource.mediationsdk.sdk.InterfaceC2360o
    public void f() {
        com.ironsource.mediationsdk.logger.c.c().b(IronSourceLogger.IronSourceTag.CALLBACK, "onInterstitialAdShowSucceeded()", 1);
        if (canSendCallback(this.f14985b)) {
            sendCallback(new RunnableC2367w(this));
        }
    }

    @Override // com.ironsource.mediationsdk.sdk.U
    public void g() {
        com.ironsource.mediationsdk.logger.c.c().b(IronSourceLogger.IronSourceTag.CALLBACK, "onRewardedVideoAdStarted()", 1);
        if (canSendCallback(this.f14984a)) {
            sendCallback(new J(this));
        }
    }

    @Override // com.ironsource.mediationsdk.sdk.Q
    public void h() {
        com.ironsource.mediationsdk.logger.c.c().b(IronSourceLogger.IronSourceTag.CALLBACK, "onOfferwallOpened()", 1);
        if (canSendCallback(this.f14986c)) {
            sendCallback(new A(this));
        }
    }

    @Override // com.ironsource.mediationsdk.sdk.Q
    public void i() {
        com.ironsource.mediationsdk.logger.c.c().b(IronSourceLogger.IronSourceTag.CALLBACK, "onOfferwallClosed()", 1);
        if (canSendCallback(this.f14986c)) {
            sendCallback(new E(this));
        }
    }

    @Override // com.ironsource.mediationsdk.sdk.U
    public void onRewardedVideoAdClosed() {
        com.ironsource.mediationsdk.logger.c.c().b(IronSourceLogger.IronSourceTag.CALLBACK, "onRewardedVideoAdClosed()", 1);
        if (canSendCallback(this.f14984a)) {
            sendCallback(new H(this));
        }
    }

    @Override // com.ironsource.mediationsdk.sdk.U
    public void onRewardedVideoAdOpened() {
        com.ironsource.mediationsdk.logger.c.c().b(IronSourceLogger.IronSourceTag.CALLBACK, "onRewardedVideoAdOpened()", 1);
        if (canSendCallback(this.f14984a)) {
            sendCallback(new G(this));
        }
    }

    public void a(com.ironsource.mediationsdk.model.i iVar) {
        this.f14989f = iVar;
    }

    public void b(String str) {
        this.g = str;
    }

    @Override // com.ironsource.mediationsdk.sdk.U
    public void c(com.ironsource.mediationsdk.logger.b bVar) {
        com.ironsource.mediationsdk.logger.c.c().b(IronSourceLogger.IronSourceTag.CALLBACK, "onRewardedVideoAdShowFailed(" + bVar.toString() + ")", 1);
        JSONObject jSONObjectB = com.ironsource.mediationsdk.utils.j.b(false);
        try {
            jSONObjectB.put("errorCode", bVar.a());
            jSONObjectB.put("reason", bVar.b());
            if (!TextUtils.isEmpty(this.g)) {
                jSONObjectB.put("placement", this.g);
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        com.ironsource.mediationsdk.b.k.g().c(new b.f.b.b(1113, jSONObjectB));
        if (canSendCallback(this.f14984a)) {
            sendCallback(new N(this, bVar));
        }
    }

    @Override // com.ironsource.mediationsdk.sdk.InterfaceC2360o
    public void d() {
        com.ironsource.mediationsdk.logger.c.c().b(IronSourceLogger.IronSourceTag.CALLBACK, "onInterstitialAdClicked()", 1);
        if (canSendCallback(this.f14985b)) {
            sendCallback(new RunnableC2369y(this));
        }
    }

    public void a(U u) {
        this.f14984a = u;
    }

    @Override // com.ironsource.mediationsdk.sdk.U
    public void b() {
        com.ironsource.mediationsdk.logger.c.c().b(IronSourceLogger.IronSourceTag.CALLBACK, "onRewardedVideoAdEnded()", 1);
        if (canSendCallback(this.f14984a)) {
            sendCallback(new K(this));
        }
    }

    public void a(InterfaceC2360o interfaceC2360o) {
        this.f14985b = interfaceC2360o;
    }

    @Override // com.ironsource.mediationsdk.sdk.Q
    public void e(com.ironsource.mediationsdk.logger.b bVar) {
        com.ironsource.mediationsdk.logger.c.c().b(IronSourceLogger.IronSourceTag.CALLBACK, "onOfferwallShowFailed(" + bVar + ")", 1);
        if (canSendCallback(this.f14986c)) {
            sendCallback(new B(this, bVar));
        }
    }

    @Override // com.ironsource.mediationsdk.sdk.Y
    public void a(String str) {
        com.ironsource.mediationsdk.logger.c.c().b(IronSourceLogger.IronSourceTag.CALLBACK, "onSegmentReceived(" + str + ")", 1);
        if (canSendCallback(this.f14987d)) {
            sendCallback(new D(this, str));
        }
    }

    @Override // com.ironsource.mediationsdk.sdk.Q
    public void d(com.ironsource.mediationsdk.logger.b bVar) {
        com.ironsource.mediationsdk.logger.c.c().b(IronSourceLogger.IronSourceTag.CALLBACK, "onGetOfferwallCreditsFailed(" + bVar + ")", 1);
        if (canSendCallback(this.f14986c)) {
            sendCallback(new C(this, bVar));
        }
    }

    @Override // com.ironsource.mediationsdk.sdk.U
    public void b(com.ironsource.mediationsdk.model.l lVar) {
        com.ironsource.mediationsdk.logger.c.c().b(IronSourceLogger.IronSourceTag.CALLBACK, "onRewardedVideoAdClicked(" + lVar.c() + ")", 1);
        if (canSendCallback(this.f14984a)) {
            sendCallback(new M(this, lVar));
        }
    }

    @Override // com.ironsource.mediationsdk.sdk.U
    public void a(boolean z) {
        com.ironsource.mediationsdk.logger.c.c().b(IronSourceLogger.IronSourceTag.CALLBACK, "onRewardedVideoAvailabilityChanged(available:" + z + ")", 1);
        long time = new Date().getTime() - this.h;
        this.h = new Date().getTime();
        JSONObject jSONObjectB = com.ironsource.mediationsdk.utils.j.b(false);
        try {
            jSONObjectB.put("duration", time);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        com.ironsource.mediationsdk.b.k.g().c(new b.f.b.b(z ? 1111 : 1112, jSONObjectB));
        if (canSendCallback(this.f14984a)) {
            sendCallback(new I(this, z));
        }
    }

    @Override // com.ironsource.mediationsdk.sdk.InterfaceC2360o
    public void b(com.ironsource.mediationsdk.logger.b bVar) {
        com.ironsource.mediationsdk.logger.c.c().b(IronSourceLogger.IronSourceTag.CALLBACK, "onInterstitialAdShowFailed(" + bVar + ")", 1);
        JSONObject jSONObjectB = com.ironsource.mediationsdk.utils.j.b(false);
        try {
            jSONObjectB.put("errorCode", bVar.a());
            if (this.f14989f != null && !TextUtils.isEmpty(this.f14989f.c())) {
                jSONObjectB.put("placement", this.f14989f.c());
            }
            if (bVar.b() != null) {
                jSONObjectB.put("reason", bVar.b());
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        com.ironsource.mediationsdk.b.h.g().c(new b.f.b.b(2111, jSONObjectB));
        if (canSendCallback(this.f14985b)) {
            sendCallback(new RunnableC2368x(this, bVar));
        }
    }

    @Override // com.ironsource.mediationsdk.sdk.InterfaceC2360o
    public void c() {
        com.ironsource.mediationsdk.logger.c.c().b(IronSourceLogger.IronSourceTag.CALLBACK, "onInterstitialAdClosed()", 1);
        if (canSendCallback(this.f14985b)) {
            sendCallback(new z(this));
        }
    }

    @Override // com.ironsource.mediationsdk.sdk.U
    public void a(com.ironsource.mediationsdk.model.l lVar) {
        com.ironsource.mediationsdk.logger.c.c().b(IronSourceLogger.IronSourceTag.CALLBACK, "onRewardedVideoAdRewarded(" + lVar.toString() + ")", 1);
        if (canSendCallback(this.f14984a)) {
            sendCallback(new L(this, lVar));
        }
    }

    @Override // com.ironsource.mediationsdk.sdk.InterfaceC2360o
    public void a() {
        com.ironsource.mediationsdk.logger.c.c().b(IronSourceLogger.IronSourceTag.CALLBACK, "onInterstitialAdReady()", 1);
        if (canSendCallback(this.f14985b)) {
            sendCallback(new RunnableC2364t(this));
        }
    }

    @Override // com.ironsource.mediationsdk.sdk.Q
    public void b(boolean z) {
        a(z, null);
    }

    @Override // com.ironsource.mediationsdk.sdk.InterfaceC2360o
    public void a(com.ironsource.mediationsdk.logger.b bVar) {
        com.ironsource.mediationsdk.logger.c.c().b(IronSourceLogger.IronSourceTag.CALLBACK, "onInterstitialAdLoadFailed(" + bVar + ")", 1);
        if (canSendCallback(this.f14985b)) {
            sendCallback(new RunnableC2365u(this, bVar));
        }
    }

    @Override // com.ironsource.mediationsdk.sdk.Q
    public boolean a(int i, int i2, boolean z) {
        Q q = this.f14986c;
        boolean zA = q != null ? q.a(i, i2, z) : false;
        com.ironsource.mediationsdk.logger.c.c().b(IronSourceLogger.IronSourceTag.CALLBACK, "onOfferwallAdCredited(credits:" + i + ", totalCredits:" + i2 + ", totalCreditsFlag:" + z + "):" + zA, 1);
        return zA;
    }

    @Override // com.ironsource.mediationsdk.sdk.InterfaceC2357l
    public void a(boolean z, com.ironsource.mediationsdk.logger.b bVar) {
        String str = "onOfferwallAvailable(isAvailable: " + z + ")";
        if (bVar != null) {
            str = str + ", error: " + bVar.b();
        }
        com.ironsource.mediationsdk.logger.c.c().b(IronSourceLogger.IronSourceTag.CALLBACK, str, 1);
        JSONObject jSONObjectB = com.ironsource.mediationsdk.utils.j.b(false);
        try {
            jSONObjectB.put(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS, String.valueOf(z));
            if (bVar != null) {
                jSONObjectB.put("errorCode", bVar.a());
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        com.ironsource.mediationsdk.b.k.g().c(new b.f.b.b(302, jSONObjectB));
        if (canSendCallback(this.f14986c)) {
            sendCallback(new F(this, z));
        }
    }
}
