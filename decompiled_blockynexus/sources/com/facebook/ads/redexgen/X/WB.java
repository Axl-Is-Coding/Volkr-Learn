package com.facebook.ads.redexgen.X;

import android.icu.util.TimeZone;
import android.os.Build;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class WB implements C6Y {
    public static String[] A01;
    public final /* synthetic */ WC A00;

    static {
        A00();
    }

    public static void A00() {
        A01 = new String[]{"smnl8goxbtEXy2ari0oo94M5wBAsJ", "4jdGfKjJVtKongVqtnlXz1qpag9QmJcO", "6HhyQoH63eZiDTc8tIM8lg1a8XmlaMXL", "TRovmJ8dsKeWsGtAEtnO1NLs5DkGdItv", "EJDQOjfPW", "Fvhxx1JOY2tpNVIZJk2UFnorm88CMjoG", "Hr", "QB67UPOvQOrUPNaLWc8iYWX5dhIe7kRi"};
    }

    public WB(WC wc) {
        this.A00 = wc;
    }

    @Override // com.facebook.ads.redexgen.X.C6Y
    public final AbstractC14046n A58() {
        if (Build.VERSION.SDK_INT < 24) {
            AbstractC14046n abstractC14046nA08 = this.A00.A08(EnumC14006j.A05);
            String[] strArr = A01;
            if (strArr[5].charAt(2) != strArr[2].charAt(2)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A01;
            strArr2[0] = "zHpdef4a8sETM0qy6DqDlJHNwIYZi";
            strArr2[0] = "zHpdef4a8sETM0qy6DqDlJHNwIYZi";
            return abstractC14046nA08;
        }
        return this.A00.A09(TimeZone.getDefault().getDisplayName());
    }
}
