package b.f.d.c;

import android.app.Activity;
import android.app.Application;
import android.content.MutableContextWrapper;
import android.text.TextUtils;
import com.ironsource.sdk.ISNAdView.ISNAdView;
import com.ironsource.sdk.controller.A;
import com.ironsource.sdk.controller.E;
import com.ironsource.sdk.controller.H;
import com.ironsource.sdk.data.SSAEnums$ProductType;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: IronSourceAdsPublisherAgent.java */
/* JADX INFO: loaded from: classes2.dex */
public final class p implements q, b.f.d.e, b.f.d.g.a.a, b.f.d.g.a.b, b.f.d.g.a.c, b.f.d.g.a.d, b.f.d.i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static p f2717a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static MutableContextWrapper f2718b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private A f2720d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f2721e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f2722f;
    private long g;
    private E h;
    private com.ironsource.sdk.service.g i;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f2719c = "SupersonicAds";
    private boolean j = false;

    private p(Activity activity, int i) {
        e(activity);
    }

    private void e(Activity activity) {
        try {
            com.ironsource.sdk.utils.d.a(activity);
            this.i = d(activity);
            this.h = new E();
            this.f2720d = new A(activity, this.i, this.h);
            com.ironsource.sdk.utils.f.a(H.b().a());
            com.ironsource.sdk.utils.f.c("IronSourceAdsPublisherAgent", "C'tor");
            f2718b = new MutableContextWrapper(activity);
            a(activity.getApplication(), com.ironsource.sdk.utils.i.g());
            this.g = 0L;
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void f(b.f.d.b bVar, Map<String, String> map) {
        com.ironsource.sdk.utils.f.a("IronSourceAdsPublisherAgent", "loadOnNewInstance " + bVar.c());
        this.f2720d.a(new g(this, bVar, map));
    }

    @Override // b.f.d.i
    public void getOfferWallCredits(String str, String str2, b.f.d.g.e eVar) {
        this.f2721e = str;
        this.f2722f = str2;
        this.f2720d.a(new m(this, str, str2, eVar));
    }

    @Override // b.f.d.i
    public void initOfferWall(String str, String str2, Map<String, String> map, b.f.d.g.e eVar) {
        this.f2721e = str;
        this.f2722f = str2;
        this.f2720d.a(new k(this, str, str2, map, eVar));
    }

    @Override // b.f.d.i
    public boolean isInterstitialAdAvailable(String str) {
        return this.f2720d.b(str);
    }

    @Override // b.f.d.g.a.c
    public void onInterstitialAdRewarded(String str, int i) {
        com.ironsource.sdk.data.d dVarD = d(SSAEnums$ProductType.Interstitial, str);
        b.f.d.g.d dVarB = b(dVarD);
        if (dVarD == null || dVarB == null) {
            return;
        }
        dVarB.onInterstitialAdRewarded(str, i);
    }

    @Override // b.f.d.e, b.f.d.i
    public void onPause(Activity activity) {
        if (this.j) {
            return;
        }
        b(activity);
    }

    @Override // b.f.d.e, b.f.d.i
    public void onResume(Activity activity) {
        if (this.j) {
            return;
        }
        a(activity);
    }

    @Override // b.f.d.i
    public void showOfferWall(Map<String, String> map) {
        this.f2720d.a(new l(this, map));
    }

    @Override // b.f.d.e, b.f.d.i
    public void updateConsentInfo(JSONObject jSONObject) {
        e(jSONObject);
        this.f2720d.a(new e(this, jSONObject));
    }

    public static b.f.d.e a(Activity activity, String str, String str2) {
        return a(str, str2, activity);
    }

    private b.f.d.g.d b(com.ironsource.sdk.data.d dVar) {
        if (dVar == null) {
            return null;
        }
        return (b.f.d.g.d) dVar.g();
    }

    public static synchronized p c(Activity activity) throws Exception {
        return a(activity, 0);
    }

    private com.ironsource.sdk.service.g d(Activity activity) {
        com.ironsource.sdk.service.g gVarD = com.ironsource.sdk.service.g.d();
        gVarD.c();
        gVarD.a(activity, this.f2721e, this.f2722f);
        return gVarD;
    }

    public static synchronized b.f.d.e a(String str, String str2, Activity activity) {
        if (f2717a == null) {
            b.f.d.a.e.a(b.f.d.a.g.f2634a);
            f2717a = new p(str, str2, activity);
        } else {
            f2718b.setBaseContext(activity);
            com.ironsource.sdk.service.g.d().a(str);
            com.ironsource.sdk.service.g.d().b(str2);
        }
        return f2717a;
    }

    private b.f.d.g.f c(com.ironsource.sdk.data.d dVar) {
        if (dVar == null) {
            return null;
        }
        return (b.f.d.g.f) dVar.g();
    }

    @Override // b.f.d.i
    public void b(JSONObject jSONObject) {
        this.f2720d.a(new b(this, jSONObject));
    }

    @Override // b.f.d.g.a.d
    public void b(String str) {
        b.f.d.g.f fVarC;
        com.ironsource.sdk.data.d dVarD = d(SSAEnums$ProductType.RewardedVideo, str);
        if (dVarD == null || (fVarC = c(dVarD)) == null) {
            return;
        }
        fVarC.onRVNoMoreOffers();
    }

    @Override // b.f.d.i
    public void c(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        String strOptString = jSONObject.optString("demandSourceName");
        if (TextUtils.isEmpty(strOptString)) {
            return;
        }
        this.f2720d.a(new o(this, strOptString));
    }

    p(String str, String str2, Activity activity) {
        this.f2721e = str;
        this.f2722f = str2;
        e(activity);
    }

    @Override // b.f.d.i
    public void d(JSONObject jSONObject) {
        this.f2720d.a(new j(this, jSONObject));
    }

    @Override // b.f.d.g.a.d
    public void d(String str, String str2) {
        b.f.d.g.f fVarC;
        com.ironsource.sdk.data.d dVarD = d(SSAEnums$ProductType.RewardedVideo, str);
        if (dVarD == null || (fVarC = c(dVarD)) == null) {
            return;
        }
        fVarC.onRVShowFail(str2);
    }

    @Override // b.f.d.g.a.a
    public void b(SSAEnums$ProductType sSAEnums$ProductType, String str) {
        b.f.d.g.d dVarB;
        com.ironsource.sdk.data.d dVarD = d(sSAEnums$ProductType, str);
        if (dVarD != null) {
            if (sSAEnums$ProductType == SSAEnums$ProductType.RewardedVideo) {
                b.f.d.g.f fVarC = c(dVarD);
                if (fVarC != null) {
                    fVarC.onRVAdClosed();
                    return;
                }
                return;
            }
            if (sSAEnums$ProductType != SSAEnums$ProductType.Interstitial || (dVarB = b(dVarD)) == null) {
                return;
            }
            dVarB.onInterstitialClose();
        }
    }

    @Override // b.f.d.g.a.a
    public void c(SSAEnums$ProductType sSAEnums$ProductType, String str) {
        b.f.d.g.b bVarA;
        com.ironsource.sdk.data.d dVarD = d(sSAEnums$ProductType, str);
        if (dVarD != null) {
            if (sSAEnums$ProductType == SSAEnums$ProductType.RewardedVideo) {
                b.f.d.g.f fVarC = c(dVarD);
                if (fVarC != null) {
                    fVarC.onRVAdClicked();
                    return;
                }
                return;
            }
            if (sSAEnums$ProductType == SSAEnums$ProductType.Interstitial) {
                b.f.d.g.d dVarB = b(dVarD);
                if (dVarB != null) {
                    dVarB.onInterstitialClick();
                    return;
                }
                return;
            }
            if (sSAEnums$ProductType != SSAEnums$ProductType.Banner || (bVarA = a(dVarD)) == null) {
                return;
            }
            bVarA.onBannerClick();
        }
    }

    @Override // b.f.d.g.a.c
    public void d(String str) {
        b.f.d.g.d dVarB;
        com.ironsource.sdk.data.d dVarD = d(SSAEnums$ProductType.Interstitial, str);
        if (dVarD == null || (dVarB = b(dVarD)) == null) {
            return;
        }
        dVarB.onInterstitialShowSuccess();
    }

    public static synchronized p a(Activity activity, int i) throws Exception {
        com.ironsource.sdk.utils.f.c("IronSourceAdsPublisherAgent", "getInstance()");
        if (f2717a == null) {
            f2717a = new p(activity, i);
        } else {
            f2718b.setBaseContext(activity);
        }
        return f2717a;
    }

    private com.ironsource.sdk.data.d d(SSAEnums$ProductType sSAEnums$ProductType, String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.h.a(sSAEnums$ProductType, str);
    }

    private void e(JSONObject jSONObject) {
        if (jSONObject == null || !jSONObject.has("gdprConsentStatus")) {
            return;
        }
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("consent", Boolean.valueOf(jSONObject.getString("gdprConsentStatus")).booleanValue());
            this.i.a(jSONObject2);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    private void d(b.f.d.b bVar, Map<String, String> map) {
        com.ironsource.sdk.utils.f.a("IronSourceAdsPublisherAgent", "loadOnInitializedInstance " + bVar.c());
        this.f2720d.a(new f(this, bVar, map));
    }

    @Override // b.f.d.g.a.c
    public void b(String str, String str2) {
        com.ironsource.sdk.data.d dVarD = d(SSAEnums$ProductType.Interstitial, str);
        b.f.d.a.a aVar = new b.f.d.a.a();
        aVar.a("callfailreason", str2);
        aVar.a("demandsourcename", str);
        if (dVarD != null) {
            aVar.a("producttype", b.f.d.a.f.a(dVarD, SSAEnums$ProductType.Interstitial));
            aVar.a("generalmessage", dVarD.c() == 2 ? b.f.d.e.b.f2735a : b.f.d.e.b.f2736b);
            aVar.a("isbiddinginstance", Boolean.valueOf(b.f.d.a.f.a(dVarD)));
            b.f.d.g.d dVarB = b(dVarD);
            if (dVarB != null) {
                dVarB.onInterstitialLoadFailed(str2);
            }
        }
        b.f.d.a.e.a(b.f.d.a.g.f2639f, aVar.a());
    }

    public A a() {
        return this.f2720d;
    }

    private b.f.d.g.b a(com.ironsource.sdk.data.d dVar) {
        if (dVar == null) {
            return null;
        }
        return (b.f.d.g.b) dVar.g();
    }

    @Override // b.f.d.i
    public void a(String str, String str2, String str3, Map<String, String> map, b.f.d.g.f fVar) {
        this.f2721e = str;
        this.f2722f = str2;
        this.f2720d.a(new i(this, str, str2, this.h.a(SSAEnums$ProductType.RewardedVideo, str3, map, fVar)));
    }

    @Override // b.f.d.g.a.c
    public void c(String str) {
        com.ironsource.sdk.data.d dVarD = d(SSAEnums$ProductType.Interstitial, str);
        b.f.d.a.a aVar = new b.f.d.a.a();
        aVar.a("demandsourcename", str);
        if (dVarD != null) {
            aVar.a("producttype", b.f.d.a.f.a(dVarD, SSAEnums$ProductType.Interstitial));
            aVar.a("isbiddinginstance", Boolean.valueOf(b.f.d.a.f.a(dVarD)));
            b.f.d.g.d dVarB = b(dVarD);
            if (dVarB != null) {
                dVarB.onInterstitialLoadSuccess();
            }
        }
        b.f.d.a.e.a(b.f.d.a.g.k, aVar.a());
    }

    private void e(b.f.d.b bVar, Map<String, String> map) {
        if (bVar.f()) {
            d(bVar, map);
        } else {
            f(bVar, map);
        }
    }

    @Override // b.f.d.i
    public void a(String str, String str2, String str3, Map<String, String> map, b.f.d.g.d dVar) {
        this.f2721e = str;
        this.f2722f = str2;
        this.f2720d.a(new n(this, str, str2, this.h.a(SSAEnums$ProductType.Interstitial, str3, map, dVar)));
    }

    @Override // b.f.d.g
    public void b(b.f.d.b bVar, Map<String, String> map) {
        b.f.d.a.a aVar = new b.f.d.a.a();
        aVar.a("isbiddinginstance", Boolean.valueOf(bVar.e()));
        aVar.a("demandsourcename", bVar.d());
        aVar.a("producttype", bVar.g() ? SSAEnums$ProductType.RewardedVideo : SSAEnums$ProductType.Interstitial);
        b.f.d.a.e.a(b.f.d.a.g.f2638e, aVar.a());
        com.ironsource.sdk.utils.f.a("IronSourceAdsPublisherAgent", "loadAd " + bVar.c());
        if (bVar.e()) {
            c(bVar, map);
        } else {
            e(bVar, map);
        }
    }

    @Override // b.f.d.g.a.b
    public void c(String str, String str2) {
        b.f.d.g.b bVarA;
        com.ironsource.sdk.data.d dVarD = d(SSAEnums$ProductType.Banner, str);
        if (dVarD == null || (bVarA = a(dVarD)) == null) {
            return;
        }
        bVarA.onBannerLoadFail(str2);
    }

    @Override // b.f.d.i
    public void a(String str, String str2, String str3, Map<String, String> map, b.f.d.g.b bVar) {
        this.f2721e = str;
        this.f2722f = str2;
        this.f2720d.a(new c(this, str, str2, this.h.a(SSAEnums$ProductType.Banner, str3, map, bVar)));
    }

    private void c(b.f.d.b bVar, Map<String, String> map) {
        try {
            a(map);
        } catch (Exception e2) {
            b.f.d.a.a aVar = new b.f.d.a.a();
            aVar.a("callfailreason", e2.getMessage());
            aVar.a("generalmessage", bVar.f() ? b.f.d.e.b.f2735a : b.f.d.e.b.f2736b);
            aVar.a("isbiddinginstance", Boolean.valueOf(bVar.e()));
            aVar.a("demandsourcename", bVar.d());
            aVar.a("producttype", bVar.g() ? SSAEnums$ProductType.RewardedVideo : SSAEnums$ProductType.Interstitial);
            b.f.d.a.e.a(b.f.d.a.g.j, aVar.a());
            e2.printStackTrace();
            com.ironsource.sdk.utils.f.a("IronSourceAdsPublisherAgent", "loadInAppBiddingAd failed decoding ADM " + e2.getMessage());
        }
        e(bVar, map);
    }

    @Override // b.f.d.g, b.f.d.i
    public void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.f2720d.a(new d(this, jSONObject));
        }
    }

    @Override // b.f.d.g.a.a
    public void a(SSAEnums$ProductType sSAEnums$ProductType, String str, com.ironsource.sdk.data.a aVar) {
        b.f.d.g.b bVarA;
        com.ironsource.sdk.data.d dVarD = d(sSAEnums$ProductType, str);
        if (dVarD != null) {
            dVarD.b(2);
            if (sSAEnums$ProductType == SSAEnums$ProductType.RewardedVideo) {
                b.f.d.g.f fVarC = c(dVarD);
                if (fVarC != null) {
                    fVarC.onRVInitSuccess(aVar);
                    return;
                }
                return;
            }
            if (sSAEnums$ProductType == SSAEnums$ProductType.Interstitial) {
                b.f.d.g.d dVarB = b(dVarD);
                if (dVarB != null) {
                    dVarB.onInterstitialInitSuccess();
                    return;
                }
                return;
            }
            if (sSAEnums$ProductType != SSAEnums$ProductType.Banner || (bVarA = a(dVarD)) == null) {
                return;
            }
            bVarA.onBannerInitSuccess();
        }
    }

    @Override // b.f.d.c.q
    public void b(Activity activity) {
        try {
            this.f2720d.d();
            this.f2720d.b(activity);
        } catch (Exception e2) {
            e2.printStackTrace();
            new com.ironsource.sdk.utils.b().execute("https://www.supersonicads.com/mobile/sdk5/log?method=" + e2.getStackTrace()[0].getMethodName());
        }
    }

    @Override // b.f.d.g.a.a
    public void a(SSAEnums$ProductType sSAEnums$ProductType, String str, String str2) {
        b.f.d.g.b bVarA;
        com.ironsource.sdk.data.d dVarD = d(sSAEnums$ProductType, str);
        b.f.d.a.a aVar = new b.f.d.a.a();
        aVar.a("demandsourcename", str);
        aVar.a("producttype", sSAEnums$ProductType);
        aVar.a("callfailreason", str2);
        if (dVarD != null) {
            aVar.a("isbiddinginstance", Boolean.valueOf(b.f.d.a.f.a(dVarD)));
            dVarD.b(3);
            if (sSAEnums$ProductType == SSAEnums$ProductType.RewardedVideo) {
                b.f.d.g.f fVarC = c(dVarD);
                if (fVarC != null) {
                    fVarC.onRVInitFail(str2);
                }
            } else if (sSAEnums$ProductType == SSAEnums$ProductType.Interstitial) {
                b.f.d.g.d dVarB = b(dVarD);
                if (dVarB != null) {
                    dVarB.onInterstitialInitFailed(str2);
                }
            } else if (sSAEnums$ProductType == SSAEnums$ProductType.Banner && (bVarA = a(dVarD)) != null) {
                bVarA.onBannerInitFailed(str2);
            }
        }
        b.f.d.a.e.a(b.f.d.a.g.h, aVar.a());
    }

    @Override // b.f.d.g.a.d
    public void a(String str, int i) {
        b.f.d.g.f fVarC;
        com.ironsource.sdk.data.d dVarD = d(SSAEnums$ProductType.RewardedVideo, str);
        if (dVarD == null || (fVarC = c(dVarD)) == null) {
            return;
        }
        fVarC.onRVAdCredited(i);
    }

    @Override // b.f.d.g.a.a
    public void a(SSAEnums$ProductType sSAEnums$ProductType, String str, String str2, JSONObject jSONObject) {
        b.f.d.g.f fVarC;
        com.ironsource.sdk.data.d dVarD = d(sSAEnums$ProductType, str);
        if (dVarD != null) {
            try {
                if (sSAEnums$ProductType == SSAEnums$ProductType.Interstitial) {
                    b.f.d.g.d dVarB = b(dVarD);
                    if (dVarB != null) {
                        jSONObject.put("demandSourceName", str);
                        dVarB.onInterstitialEventNotificationReceived(str2, jSONObject);
                    }
                } else if (sSAEnums$ProductType == SSAEnums$ProductType.RewardedVideo && (fVarC = c(dVarD)) != null) {
                    jSONObject.put("demandSourceName", str);
                    fVarC.onRVEventNotificationReceived(str2, jSONObject);
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override // b.f.d.g.a.a
    public void a(SSAEnums$ProductType sSAEnums$ProductType, String str) {
        b.f.d.g.f fVarC;
        com.ironsource.sdk.data.d dVarD = d(sSAEnums$ProductType, str);
        if (dVarD != null) {
            if (sSAEnums$ProductType == SSAEnums$ProductType.Interstitial) {
                b.f.d.g.d dVarB = b(dVarD);
                if (dVarB != null) {
                    dVarB.onInterstitialOpen();
                    return;
                }
                return;
            }
            if (sSAEnums$ProductType != SSAEnums$ProductType.RewardedVideo || (fVarC = c(dVarD)) == null) {
                return;
            }
            fVarC.onRVAdOpened();
        }
    }

    @Override // b.f.d.g.a.c
    public void a(String str, String str2) {
        b.f.d.g.d dVarB;
        com.ironsource.sdk.data.d dVarD = d(SSAEnums$ProductType.Interstitial, str);
        if (dVarD == null || (dVarB = b(dVarD)) == null) {
            return;
        }
        dVarB.onInterstitialShowFailed(str2);
    }

    @Override // b.f.d.i
    public void a(String str, String str2, int i) {
        SSAEnums$ProductType sSAEnums$ProductTypeE;
        com.ironsource.sdk.data.d dVarA;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || (sSAEnums$ProductTypeE = com.ironsource.sdk.utils.i.e(str)) == null || (dVarA = this.h.a(sSAEnums$ProductTypeE, str2)) == null) {
            return;
        }
        dVarA.c(i);
    }

    @Override // b.f.d.i
    public ISNAdView a(Activity activity, b.f.d.a aVar) {
        String str = "SupersonicAds_" + this.g;
        this.g++;
        ISNAdView iSNAdView = new ISNAdView(activity, str, aVar);
        this.f2720d.a(iSNAdView);
        return iSNAdView;
    }

    @Override // b.f.d.g.a.b
    public void a(String str) {
        b.f.d.g.b bVarA;
        com.ironsource.sdk.data.d dVarD = d(SSAEnums$ProductType.Banner, str);
        if (dVarD == null || (bVarA = a(dVarD)) == null) {
            return;
        }
        bVarA.onBannerLoadSuccess();
    }

    private Map<String, String> a(Map<String, String> map) {
        map.put("adm", com.ironsource.sdk.utils.i.a(map.get("adm")));
        return map;
    }

    @Override // b.f.d.g
    public void a(b.f.d.b bVar, Map<String, String> map) {
        com.ironsource.sdk.utils.f.c("IronSourceAdsPublisherAgent", "showAd " + bVar.c());
        com.ironsource.sdk.data.d dVarA = this.h.a(SSAEnums$ProductType.Interstitial, bVar.c());
        if (dVarA == null) {
            return;
        }
        this.f2720d.a(new h(this, dVarA, map));
    }

    @Override // b.f.d.g
    public boolean a(b.f.d.b bVar) {
        com.ironsource.sdk.utils.f.a("IronSourceAdsPublisherAgent", "isAdAvailable " + bVar.c());
        com.ironsource.sdk.data.d dVarA = this.h.a(SSAEnums$ProductType.Interstitial, bVar.c());
        if (dVarA == null) {
            return false;
        }
        return dVarA.b();
    }

    public void a(Application application, JSONObject jSONObject) {
        this.j = jSONObject.optBoolean("enableLifeCycleListeners", false);
        if (this.j) {
            application.registerActivityLifecycleCallbacks(new a(this));
        }
    }

    @Override // b.f.d.c.q
    public void a(Activity activity) {
        f2718b.setBaseContext(activity);
        this.f2720d.e();
        this.f2720d.a(activity);
    }
}
