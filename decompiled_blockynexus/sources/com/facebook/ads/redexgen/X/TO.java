package com.facebook.ads.redexgen.X;

import android.annotation.SuppressLint;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.HashMap;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class TO implements AnonymousClass60 {
    public static String[] A02;
    public final TQ A00;
    public final C2027Wc A01;

    static {
        A00();
    }

    public static void A00() {
        A02 = new String[]{"iWDBF2OKl3jtj3mE0UZLtkhUaVvUxXqs", "ms2LCEwCyzsqM8QDDj0PRev1P1CSm3w7", "hMtVrOKQMF9h", "gi6PEiuAAOhVuZEccjIoIAk9XYc1uF", "R32JKWcbl7Qu2cyp2LhmQehQDOktlipk", "kBJUlLOX6LAUVPMDIzawXbz3hNZwTKWy", "5r9f7V6KCkM3IvysTdnytDlDBRDUQAcw", "vGzO7SO4CN32udhBb2qyIGFDHHv1hOkX"};
    }

    public TO(C2027Wc c2027Wc) {
        this.A01 = c2027Wc;
        this.A00 = new TQ(c2027Wc);
    }

    public final TQ A01() {
        return this.A00;
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass60
    @SuppressLint({"BadMethodUse-java.lang.String.length"})
    public final void ACn(Throwable th) {
        if (th == null || C13785m.A00(this.A01) >= Math.random()) {
            return;
        }
        StringWriter stringWriter = new StringWriter();
        th.printStackTrace(new PrintWriter(stringWriter));
        String string = stringWriter.toString();
        TQ tq = this.A00;
        String strA03 = EnumC13875v.A04.A03();
        String strA02 = EnumC13885w.A06.A02();
        HashMap map = new HashMap();
        String message = th.getMessage();
        if (string != null) {
            int length = string.length();
            if (A02[1].charAt(16) != 'D') {
                throw new RuntimeException();
            }
            String[] strArr = A02;
            strArr[5] = "Ct83iaSYEVOHUGfDQtOJkAbKybUxEBTx";
            strArr[5] = "Ct83iaSYEVOHUGfDQtOJkAbKybUxEBTx";
            if (length > 500) {
                string = string.substring(0, 500);
            }
        }
        tq.A8R(strA03, strA02, map, null, message, string, th.getClass().getSimpleName());
    }
}
