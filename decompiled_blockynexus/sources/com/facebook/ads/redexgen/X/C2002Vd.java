package com.facebook.ads.redexgen.X;

import java.util.Arrays;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Vd, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C2002Vd implements C6Y {
    public static byte[] A01;
    public final /* synthetic */ C2003Ve A00;

    static {
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A01, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 81);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{-128, -28, -29, -43, -68, -57};
    }

    public C2002Vd(C2003Ve c2003Ve) {
        this.A00 = c2003Ve;
    }

    /* JADX WARN: Incorrect condition in loop: B:6:0x0015 */
    @Override // com.facebook.ads.redexgen.X.C6Y
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.facebook.ads.redexgen.X.AbstractC14046n A58() throws java.security.NoSuchAlgorithmException, java.io.UnsupportedEncodingException {
        /*
            r5 = this;
            com.facebook.ads.redexgen.X.Ve r0 = r5.A00
            android.content.pm.ActivityInfo[] r0 = com.facebook.ads.redexgen.X.C2003Ve.A09(r0)
            if (r0 == 0) goto L5a
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r4 = 0
        Le:
            com.facebook.ads.redexgen.X.Ve r0 = r5.A00
            android.content.pm.ActivityInfo[] r0 = com.facebook.ads.redexgen.X.C2003Ve.A09(r0)
            int r0 = r0.length
            if (r4 >= r0) goto L3d
            com.facebook.ads.redexgen.X.Ve r0 = r5.A00
            android.content.pm.ActivityInfo[] r0 = com.facebook.ads.redexgen.X.C2003Ve.A09(r0)
            r0 = r0[r4]
            java.lang.String r0 = r0.name
            r3.append(r0)
            com.facebook.ads.redexgen.X.Ve r0 = r5.A00
            android.content.pm.ActivityInfo[] r0 = com.facebook.ads.redexgen.X.C2003Ve.A09(r0)
            int r0 = r0.length
            int r0 = r0 + (-1)
            if (r4 == r0) goto L3a
            r2 = 0
            r1 = 1
            r0 = 37
            java.lang.String r0 = A00(r2, r1, r0)
            r3.append(r0)
        L3a:
            int r4 = r4 + 1
            goto Le
        L3d:
            com.facebook.ads.redexgen.X.Ve r4 = r5.A00
            java.lang.String r3 = r3.toString()
            r2 = 1
            r1 = 5
            r0 = 62
            java.lang.String r0 = A00(r2, r1, r0)
            byte[] r1 = r3.getBytes(r0)
            com.facebook.ads.redexgen.X.6v r0 = com.facebook.ads.redexgen.X.EnumC14126v.A06
            java.lang.String r0 = com.facebook.ads.redexgen.X.C14136w.A08(r1, r0)
            com.facebook.ads.redexgen.X.6n r0 = r4.A09(r0)
            return r0
        L5a:
            com.facebook.ads.redexgen.X.Ve r1 = r5.A00
            com.facebook.ads.redexgen.X.6j r0 = com.facebook.ads.redexgen.X.EnumC14006j.A07
            com.facebook.ads.redexgen.X.6n r0 = r1.A08(r0)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C2002Vd.A58():com.facebook.ads.redexgen.X.6n");
    }
}
