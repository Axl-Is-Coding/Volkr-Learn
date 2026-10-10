package com.facebook.ads.redexgen.X;

import android.content.Context;
import android.os.Build;
import android.provider.Settings;
import javax.annotation.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Vn, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C2012Vn implements InterfaceC13966f<String> {
    public static String[] A02;
    public final String A00;

    @Nullable
    public final String A01;

    static {
        A05();
    }

    public static void A05() {
        A02 = new String[]{"RYi9iRGIRLFgmHyLCTFL79e8HRjDnFrb", "vSh82J56btqitzV2K8vhhpmd8nuWc73Q", "zIHtrJzxIsbAX2RcAusdDGuQeAmEyx5S", "rSB1T329BncZ8PoGprLRF5BkUgeBLg1f", "Ia7f", "MvVPUyTuCHBxSL2xIpKuAgdBDgeXTXtl", "79Ouy72hXQ07YEkZUE4DpCR0vQs9qv4f", "z8weDZlyW5ITWcD9B316mWOXeL9UDLe6"};
    }

    public C2012Vn(Context context, String str, C6U c6u) {
        this.A00 = str;
        this.A01 = A03(context, str, c6u);
    }

    @Nullable
    public static String A00(Context context, String str) {
        if (Build.VERSION.SDK_INT < 17) {
            return null;
        }
        String string = Settings.Global.getString(context.getContentResolver(), str);
        if (A02[4].length() == 29) {
            throw new RuntimeException();
        }
        String[] strArr = A02;
        strArr[1] = "HfuCmMeEYPJ981gewRafdBFBSwX7gAX2";
        strArr[3] = "FHRlwpAt7jGi9NpBTepxh5ZgXrGMSq7S";
        return string;
    }

    @Nullable
    public static String A01(Context context, String str) {
        if (Build.VERSION.SDK_INT < 17) {
            return null;
        }
        return Settings.Secure.getString(context.getContentResolver(), str);
    }

    @Nullable
    public static String A02(Context context, String str) {
        if (Build.VERSION.SDK_INT < 17) {
            return null;
        }
        return Settings.System.getString(context.getContentResolver(), str);
    }

    @Nullable
    public static String A03(Context context, String str, C6U c6u) {
        int i = C6T.A00[c6u.ordinal()];
        if (i == 1) {
            return A00(context, str);
        }
        if (i == 2) {
            return A01(context, str);
        }
        if (i == 3) {
            return A02(context, str);
        }
        if (A02[5].charAt(13) != 'L') {
            throw new RuntimeException();
        }
        String[] strArr = A02;
        strArr[1] = "VMjILmm1VxijboR6qKsQ5ogEzhQ6S6Q6";
        strArr[3] = "9JH3tSpEeErHlVJFJtGetom3XKrYweEy";
        return "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.facebook.ads.redexgen.X.InterfaceC13966f
    /* JADX INFO: renamed from: A04, reason: merged with bridge method [inline-methods] */
    public final JSONObject ADp(String str, JSONObject jSONObject) throws JSONException {
        jSONObject.put(this.A00, this.A01);
        return jSONObject;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC13966f
    public final boolean A7o(Object obj) {
        String str;
        String str2;
        C2012Vn c2012Vn = (C2012Vn) obj;
        boolean zEquals = this.A00 == null && c2012Vn.A00 == null;
        boolean zEquals2 = this.A01 == null && c2012Vn.A01 == null;
        String str3 = this.A00;
        if (str3 != null && (str2 = c2012Vn.A00) != null) {
            zEquals = str3.equals(str2);
        }
        String str4 = this.A01;
        if (str4 != null && (str = c2012Vn.A01) != null) {
            zEquals2 = str4.equals(str);
        }
        return zEquals && zEquals2;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC13966f
    public final int ADV() {
        String str = this.A00;
        if (str != null && this.A01 != null) {
            return str.getBytes().length + this.A01.getBytes().length;
        }
        return 0;
    }
}
