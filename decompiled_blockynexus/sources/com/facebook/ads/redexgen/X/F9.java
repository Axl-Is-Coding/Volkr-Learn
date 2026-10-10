package com.facebook.ads.redexgen.X;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class F9 implements Runnable {
    public static String[] A02;
    public final /* synthetic */ FJ A00;
    public final /* synthetic */ FM A01;

    static {
        A00();
    }

    public static void A00() {
        A02 = new String[]{"WoRssMEMKAHHv5eOYWv6bcyCNlOXOf", "pA2", "3fT7OOiQOTO0YPgLHZKt2Q997Hb2Xix9", "WvgPUzUWGb7Do3xsV3", "Ec3vTQmgAcMNirmUvkhwoL1JefVS29Et", "cLkVqjW9ihOrHUtkcRLXNZqcrrO72e", "NZCcSFELY0AlwKVNvcWKAmZ3Ywu7Rk3n", "YvU"};
    }

    public F9(FJ fj, FM fm) {
        this.A00 = fj;
        this.A01 = fm;
    }

    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        if (KL.A02(this)) {
            return;
        }
        try {
            this.A01.AAT(this.A00.A00, this.A00.A01);
        } catch (Throwable th) {
            KL.A00(th, this);
            if (A02[4].charAt(31) != 't') {
                throw new RuntimeException();
            }
            String[] strArr = A02;
            strArr[7] = "YLN";
            strArr[1] = "t0z";
        }
    }
}
