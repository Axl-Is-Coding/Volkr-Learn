package com.facebook.ads.redexgen.X;

import android.content.pm.ActivityInfo;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Vc, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C2001Vc implements C6Y {
    public static String[] A01;
    public final /* synthetic */ C2003Ve A00;

    static {
        A00();
    }

    public static void A00() {
        A01 = new String[]{"BjEOBj6HSQS8i4DRK2qoJX27hoC0R4DA", "kauKwe7CVPrqe4cOgSIwGmxqelbhToEk", "XZC7QZo7Jtp8ceyvJGPCObnucv7Agiw", "JUan8YMmX5ogxlB6aq0dkHVlKOHTqFeF", "IuTolVrjy7qRtOK6QcTLTodgNQuY61bU", "4L2hIP4Kb6m", "Yg6y90VIZ7Ah3ybSxqXW6wOi2HMwnGfT", "hl8KcVIJUlPiTEXEjbalUYczznSZgz62"};
    }

    public C2001Vc(C2003Ve c2003Ve) {
        this.A00 = c2003Ve;
    }

    @Override // com.facebook.ads.redexgen.X.C6Y
    public final AbstractC14046n A58() {
        if (this.A00.A04 != null) {
            C2003Ve c2003Ve = this.A00;
            ActivityInfo[] activityInfoArr = c2003Ve.A04;
            if (A01[3].charAt(20) != 'k') {
                throw new RuntimeException();
            }
            String[] strArr = A01;
            strArr[4] = "ZFJR0DMAu8l3jjK6mMcKAcH3eLfgQnHb";
            strArr[4] = "ZFJR0DMAu8l3jjK6mMcKAcH3eLfgQnHb";
            return c2003Ve.A05(activityInfoArr.length);
        }
        return this.A00.A08(EnumC14006j.A07);
    }
}
