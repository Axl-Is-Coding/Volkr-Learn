package b.f.d.a;

import com.facebook.ads.AdError;

/* JADX INFO: compiled from: SDK5Events.java */
/* JADX INFO: loaded from: classes2.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static a f2634a = new a(2001, a("initsdk"));

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static a f2635b = new a(2002, a("createcontrollerweb"));

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static a f2636c = new a(AdError.INTERNAL_ERROR_2003, a("createcontrollernative"));

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static a f2637d = new a(AdError.INTERNAL_ERROR_2004, a("controllerstageready"));

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static a f2638e = new a(2005, a("loadad"));

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static a f2639f = new a(AdError.INTERNAL_ERROR_2006, a("loadadfailed"));
    public static a g = new a(2007, a("initproduct"));
    public static a h = new a(AdError.REMOTE_ADS_SERVICE_ERROR, a("initproductfailed"));
    public static a i = new a(AdError.INTERSTITIAL_AD_TIMEOUT, a("loadproduct"));
    public static a j = new a(2010, a("parseadmfailed"));
    public static a k = new a(2011, a("loadadsuccess"));
    public static a l = new a(2013, a("controllerfailed"));
    public static a m = new a(2014, a("extractinstalledpackagesfailed"));
    public static a n = new a(2015, a("appendnativefeaturesdatafailed"));
    public static a o = new a(2016, a("adunitcouldnotloadtowebview"));
    public static a p = new a(2017, a("webviewcleanupfailed"));
    public static a q = new a(2018, a("removewebviewfailed"));
    public static a r = new a(2019, a("adunitcouldnotloadtowebviewbanners"));

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX INFO: compiled from: SDK5Events.java */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        String f2640a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f2641b;

        a(int i, String str) {
            this.f2641b = i;
            this.f2640a = str;
        }
    }

    static String a(String str) {
        return "n_" + str;
    }
}
