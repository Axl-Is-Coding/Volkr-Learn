package com.ironsource.mediationsdk;

import android.text.TextUtils;
import com.alibaba.android.arouter.utils.Consts;
import com.ironsource.mediationsdk.logger.IronSourceLogger;
import com.ironsource.mediationsdk.sdk.InterfaceC2356k;
import com.ironsource.mediationsdk.sdk.InterfaceC2357l;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.ironsource.mediationsdk.fa, reason: case insensitive filesystem */
/* JADX INFO: compiled from: OfferwallManager.java */
/* JADX INFO: loaded from: classes2.dex */
class C2320fa implements InterfaceC2356k, InterfaceC2357l {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private com.ironsource.mediationsdk.sdk.O f14820b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private InterfaceC2357l f14821c;
    private com.ironsource.mediationsdk.utils.k g;
    private com.ironsource.mediationsdk.model.p h;
    private String i;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f14819a = C2320fa.class.getName();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private AtomicBoolean f14823e = new AtomicBoolean(true);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private AtomicBoolean f14824f = new AtomicBoolean(false);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private com.ironsource.mediationsdk.logger.c f14822d = com.ironsource.mediationsdk.logger.c.c();

    C2320fa() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public synchronized void a(String str, String str2) {
        this.f14822d.b(IronSourceLogger.IronSourceTag.NATIVE, this.f14819a + ":initOfferwall(appKey: " + str + ", userId: " + str2 + ")", 1);
        this.g = U.e().c();
        if (this.g == null) {
            a(com.ironsource.mediationsdk.utils.g.a("Please check configurations for Offerwall adapters", "Offerwall"));
            return;
        }
        this.h = this.g.d().b("SupersonicAds");
        if (this.h == null) {
            a(com.ironsource.mediationsdk.utils.g.a("Please check configurations for Offerwall adapters", "Offerwall"));
            return;
        }
        AbstractC2311b abstractC2311bA = a();
        if (abstractC2311bA == 0) {
            a(com.ironsource.mediationsdk.utils.g.a("Please check configurations for Offerwall adapters", "Offerwall"));
            return;
        }
        a(abstractC2311bA);
        abstractC2311bA.setLogListener(this.f14822d);
        this.f14820b = (com.ironsource.mediationsdk.sdk.O) abstractC2311bA;
        this.f14820b.setInternalOfferwallListener(this);
        this.f14820b.initOfferwall(str, str2, this.h.k());
    }

    @Override // com.ironsource.mediationsdk.sdk.Q
    public void b(boolean z) {
        a(z, (com.ironsource.mediationsdk.logger.b) null);
    }

    @Override // com.ironsource.mediationsdk.sdk.Q
    public void d(com.ironsource.mediationsdk.logger.b bVar) {
        this.f14822d.b(IronSourceLogger.IronSourceTag.ADAPTER_CALLBACK, "onGetOfferwallCreditsFailed(" + bVar + ")", 1);
        InterfaceC2357l interfaceC2357l = this.f14821c;
        if (interfaceC2357l != null) {
            interfaceC2357l.d(bVar);
        }
    }

    @Override // com.ironsource.mediationsdk.sdk.Q
    public void e(com.ironsource.mediationsdk.logger.b bVar) {
        this.f14822d.b(IronSourceLogger.IronSourceTag.ADAPTER_CALLBACK, "onOfferwallShowFailed(" + bVar + ")", 1);
        InterfaceC2357l interfaceC2357l = this.f14821c;
        if (interfaceC2357l != null) {
            interfaceC2357l.e(bVar);
        }
    }

    @Override // com.ironsource.mediationsdk.sdk.Q
    public void h() {
        this.f14822d.b(IronSourceLogger.IronSourceTag.ADAPTER_CALLBACK, "onOfferwallOpened()", 1);
        int iA = com.ironsource.mediationsdk.utils.m.a().a(0);
        JSONObject jSONObjectB = com.ironsource.mediationsdk.utils.j.b(false);
        try {
            if (!TextUtils.isEmpty(this.i)) {
                jSONObjectB.put("placement", this.i);
            }
            jSONObjectB.put("sessionDepth", iA);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        com.ironsource.mediationsdk.b.k.g().c(new b.f.b.b(305, jSONObjectB));
        com.ironsource.mediationsdk.utils.m.a().b(0);
        InterfaceC2357l interfaceC2357l = this.f14821c;
        if (interfaceC2357l != null) {
            interfaceC2357l.h();
        }
    }

    @Override // com.ironsource.mediationsdk.sdk.Q
    public void i() {
        this.f14822d.b(IronSourceLogger.IronSourceTag.ADAPTER_CALLBACK, "onOfferwallClosed()", 1);
        InterfaceC2357l interfaceC2357l = this.f14821c;
        if (interfaceC2357l != null) {
            interfaceC2357l.i();
        }
    }

    public void a(InterfaceC2357l interfaceC2357l) {
        this.f14821c = interfaceC2357l;
    }

    @Override // com.ironsource.mediationsdk.sdk.InterfaceC2357l
    public void a(boolean z, com.ironsource.mediationsdk.logger.b bVar) {
        this.f14822d.b(IronSourceLogger.IronSourceTag.ADAPTER_CALLBACK, "onOfferwallAvailable(isAvailable: " + z + ")", 1);
        if (z) {
            this.f14824f.set(true);
            InterfaceC2357l interfaceC2357l = this.f14821c;
            if (interfaceC2357l != null) {
                interfaceC2357l.b(true);
                return;
            }
            return;
        }
        a(bVar);
    }

    @Override // com.ironsource.mediationsdk.sdk.Q
    public boolean a(int i, int i2, boolean z) {
        this.f14822d.b(IronSourceLogger.IronSourceTag.ADAPTER_CALLBACK, "onOfferwallAdCredited()", 1);
        InterfaceC2357l interfaceC2357l = this.f14821c;
        if (interfaceC2357l != null) {
            return interfaceC2357l.a(i, i2, z);
        }
        return false;
    }

    private synchronized void a(com.ironsource.mediationsdk.logger.b bVar) {
        if (this.f14824f != null) {
            this.f14824f.set(false);
        }
        if (this.f14823e != null) {
            this.f14823e.set(true);
        }
        if (this.f14821c != null) {
            this.f14821c.a(false, bVar);
        }
    }

    private AbstractC2311b a() {
        try {
            U uE = U.e();
            AbstractC2311b abstractC2311bB = uE.b("SupersonicAds");
            if (abstractC2311bB == null) {
                Class<?> cls = Class.forName("com.ironsource.adapters." + com.ironsource.environment.c.a("SupersonicAds") + Consts.DOT + "SupersonicAdsAdapter");
                abstractC2311bB = (AbstractC2311b) cls.getMethod("startAdapter", String.class).invoke(cls, "SupersonicAds");
                if (abstractC2311bB == null) {
                    return null;
                }
            }
            uE.a(abstractC2311bB);
            return abstractC2311bB;
        } catch (Throwable th) {
            this.f14822d.b(IronSourceLogger.IronSourceTag.API, "SupersonicAds initialization failed - please verify that required dependencies are in you build path.", 2);
            this.f14822d.a(IronSourceLogger.IronSourceTag.API, this.f14819a + ":startOfferwallAdapter", th);
            return null;
        }
    }

    private void a(AbstractC2311b abstractC2311b) {
        try {
            String strH = U.e().h();
            if (strH != null) {
                abstractC2311b.setMediationSegment(strH);
            }
            Boolean boolB = U.e().b();
            if (boolB != null) {
                this.f14822d.b(IronSourceLogger.IronSourceTag.ADAPTER_API, "Offerwall | setConsent(consent:" + boolB + ")", 1);
                abstractC2311b.setConsent(boolB.booleanValue());
            }
        } catch (Exception e2) {
            this.f14822d.b(IronSourceLogger.IronSourceTag.INTERNAL, ":setCustomParams():" + e2.toString(), 3);
        }
    }
}
