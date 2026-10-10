package com.ironsource.mediationsdk;

import com.ironsource.adapters.pangle.BuildConfig;
import com.ironsource.mediationsdk.logger.IronSourceLogger;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: renamed from: com.ironsource.mediationsdk.e, reason: case insensitive filesystem */
/* JADX INFO: compiled from: AdaptersCompatibilityHandler.java */
/* JADX INFO: loaded from: classes2.dex */
public class C2317e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final C2317e f14808a = new C2317e();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ConcurrentHashMap<String, String> f14809b = new ConcurrentHashMap<>();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ConcurrentHashMap<String, String> f14810c;

    private C2317e() {
        this.f14809b.put("adcolony", "4.1.6");
        this.f14809b.put("vungle", "4.1.5");
        this.f14809b.put("applovin", "4.3.3");
        this.f14809b.put("admob", "4.3.2");
        this.f14810c = new ConcurrentHashMap<>();
        this.f14810c.put("adcolony", "4.1.6");
        this.f14810c.put("admob", "4.3.2");
        this.f14810c.put("applovin", "4.3.3");
        this.f14810c.put("chartboost", "4.1.9");
        this.f14810c.put("fyber", "4.1.0");
        this.f14810c.put("hyprmx", "4.1.2");
        this.f14810c.put("inmobi", "4.3.1");
        this.f14810c.put("maio", "4.1.3");
        this.f14810c.put("tapjoy", "4.0.0");
        this.f14810c.put("unityads", BuildConfig.VERSION_NAME);
        this.f14810c.put("vungle", "4.1.5");
    }

    public static C2317e a() {
        return f14808a;
    }

    public boolean b(AbstractC2311b abstractC2311b) {
        return a(abstractC2311b, this.f14810c, "rewarded video");
    }

    public boolean c(AbstractC2311b abstractC2311b) {
        if (abstractC2311b == null) {
            return false;
        }
        String version = abstractC2311b.getVersion();
        boolean zA = a("4.3.0", version);
        if (!zA) {
            com.ironsource.mediationsdk.logger.c.c().b(IronSourceLogger.IronSourceTag.API, abstractC2311b.getProviderName() + " adapter " + version + " is incompatible with SDK version " + com.ironsource.mediationsdk.utils.j.c() + ", please update your adapter to the latest version", 3);
        }
        return zA;
    }

    public boolean a(AbstractC2311b abstractC2311b) {
        return a(abstractC2311b, this.f14809b, "interstitial");
    }

    private boolean a(AbstractC2311b abstractC2311b, Map<String, String> map, String str) {
        if (abstractC2311b == null) {
            return false;
        }
        String strA = com.ironsource.environment.c.a(abstractC2311b.getProviderName());
        if (!map.containsKey(strA)) {
            return true;
        }
        String str2 = map.get(strA);
        String version = abstractC2311b.getVersion();
        boolean zA = a(str2, version);
        if (!zA) {
            com.ironsource.mediationsdk.logger.c.c().b(IronSourceLogger.IronSourceTag.API, abstractC2311b.getProviderName() + " adapter " + version + " is incompatible with SDK version " + com.ironsource.mediationsdk.utils.j.c() + " for " + str + " ad unit, please update your adapter to the latest version", 3);
        }
        return zA;
    }

    private boolean a(String str, String str2) {
        if (str.equalsIgnoreCase(str2)) {
            return true;
        }
        String[] strArrSplit = str.split("\\.");
        String[] strArrSplit2 = str2.split("\\.");
        for (int i = 0; i < 3; i++) {
            int i2 = Integer.parseInt(strArrSplit[i]);
            int i3 = Integer.parseInt(strArrSplit2[i]);
            if (i3 < i2) {
                return false;
            }
            if (i3 > i2) {
                return true;
            }
        }
        return true;
    }
}
