package com.ironsource.mediationsdk;

import android.app.Activity;
import android.content.Context;
import com.ironsource.mediationsdk.sdk.InterfaceC2360o;

/* JADX INFO: loaded from: classes2.dex */
public abstract class IronSource {

    public enum AD_UNIT {
        REWARDED_VIDEO("rewardedVideo"),
        INTERSTITIAL("interstitial"),
        OFFERWALL("offerwall"),
        BANNER("banner");

        private String mValue;

        AD_UNIT(String str) {
            this.mValue = str;
        }

        @Override // java.lang.Enum
        public String toString() {
            return this.mValue;
        }
    }

    public static void a(Activity activity, String str, AD_UNIT... ad_unitArr) {
        U.e().a(activity, str, false, ad_unitArr);
    }

    public static void b(Activity activity) {
        U.e().b(activity);
    }

    public static void c() {
        U.e().n();
    }

    public static void d() {
        U.e().o();
    }

    public static void e() {
        U.e().p();
    }

    public static void a(Activity activity) {
        U.e().a(activity);
    }

    public static void b(String str) {
        U.e().d(str);
    }

    public static void a(Context context, boolean z) {
        U.e().a(context, z);
    }

    public static boolean b() {
        return U.e().m();
    }

    public static void a(com.ironsource.mediationsdk.sdk.U u) {
        U.e().a(u);
    }

    public static void a(String str) {
        U.e().c(str);
    }

    public static boolean a() {
        return U.e().l();
    }

    public static void a(InterfaceC2360o interfaceC2360o) {
        U.e().a(interfaceC2360o);
    }
}
