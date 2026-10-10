package com.facebook.ads.redexgen.X;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.SystemClock;
import java.util.HashMap;
import java.util.List;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Uv, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1994Uv extends C6P {
    public static PackageManager A00;
    public static String[] A01;

    static {
        A04();
    }

    public static void A04() {
        A01 = new String[]{"mMUsySdK", "G1dnExSQKLbMoTCo5d1h1U5A6G7ndhFt", "GiJYkTHpyeTaf3ywPcthUoX2rTVjWFCb", "0A5FUJ9kDHtL7zu8WVVZPRsd6iFGNBV", "Uxf0Oizk", "zpV62zjrrTP1cgdKU18BbBXv", "Pb6NlhKASELFsFyHLiNoj4ENeXMrfTQa", "RrSFtRYH4qZAbHiyxnUErsMfABxwLq"};
    }

    public C1994Uv(Context context, C13815p c13815p) {
        super(context, c13815p);
        A00 = context.getPackageManager();
    }

    public static /* synthetic */ PackageManager A01() {
        PackageManager packageManager = A00;
        if (A01[1].charAt(22) == 'k') {
            throw new RuntimeException();
        }
        String[] strArr = A01;
        strArr[7] = "gjUVtXXuXbvsWPZLBaiwFqVTuNtnGy";
        strArr[3] = "aaBFOo2Y3N72goZoHRvUb35kO6Lzp1W";
        return packageManager;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"Nullable Dereference"})
    public AbstractC14046n A03(HashMap<String, C1993Uu> map) {
        return new WS(SystemClock.elapsedRealtime(), A03(), map, EnumC14036m.A0C);
    }

    public final C6Y A0H(List<C6X> list) {
        return new C1992Ut(this, list);
    }
}
