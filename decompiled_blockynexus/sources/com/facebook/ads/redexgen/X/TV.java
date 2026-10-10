package com.facebook.ads.redexgen.X;

import android.app.ActivityManager;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class TV implements C6Y {
    public static String[] A01;
    public final /* synthetic */ C1953Tg A00;

    static {
        A00();
    }

    public static void A00() {
        A01 = new String[]{"ks6FgoJovve7iHM2pZkl", "wha53u", "49wSJ7V8XkDKZTUcjMDnpoSn", "1JQ5I5ad77Yrp3ewkirQ0oRutiEmvr6i", "jAt3ZHaaMbDXz0fIQiir7V", "EKdcAjdCbYFTR4bnYqi4SV", "MwtlcC", "w1RouBmka6J1zGDRhikmrfItH78owLWg"};
    }

    public TV(C1953Tg c1953Tg) {
        this.A00 = c1953Tg;
    }

    @Override // com.facebook.ads.redexgen.X.C6Y
    public final AbstractC14046n A58() {
        if (this.A00.A02 != null) {
            return this.A00.A0G(ActivityManager.isUserAMonkey());
        }
        C1953Tg c1953Tg = this.A00;
        EnumC14006j enumC14006j = EnumC14006j.A07;
        if (A01[2].length() == 23) {
            throw new RuntimeException();
        }
        String[] strArr = A01;
        strArr[3] = "MHidzBjnmsHNQkooJipxy3AaWgleVPOv";
        strArr[7] = "EW2Ra62KpqEXQLSIkiFDqiivYFqdEGvM";
        return c1953Tg.A08(enumC14006j);
    }
}
