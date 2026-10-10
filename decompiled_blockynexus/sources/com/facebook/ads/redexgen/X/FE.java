package com.facebook.ads.redexgen.X;

import java.io.IOException;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class FE implements Runnable {
    public static String[] A06;
    public final /* synthetic */ FJ A00;
    public final /* synthetic */ FK A01;
    public final /* synthetic */ FL A02;
    public final /* synthetic */ FM A03;
    public final /* synthetic */ IOException A04;
    public final /* synthetic */ boolean A05;

    static {
        A00();
    }

    public static void A00() {
        A06 = new String[]{"MFzmm2XpKtQDQZ1nrLFzIVLfypAdXqn0", "St6NP3oa8jPcs9ySqX58Qb7cq6M0Lslj", "FY6GSV0T1DmbxtheDZWAefy5bW4XMUrK", "e7zVVEHUrXPHmOTr9XrOqtCewhDOezV9", "rRe4XoYawEGGgKvf4FFgivRzu7z94IPy", "2sUcpRkbdiQEA9XQnsePPVJ2ZVsexJIi", "YygzZHUIY4dTUEusYM1qdSBaSuhDwAUc", "5Y8Iu0wedn9Jl3yvaaWMiUkpwoVz8Vqp"};
    }

    public FE(FJ fj, FM fm, FK fk, FL fl, IOException iOException, boolean z) {
        this.A00 = fj;
        this.A03 = fm;
        this.A01 = fk;
        this.A02 = fl;
        this.A04 = iOException;
        this.A05 = z;
    }

    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        if (KL.A02(this)) {
            return;
        }
        try {
            this.A03.AAK(this.A00.A00, this.A00.A01, this.A01, this.A02, this.A04, this.A05);
        } catch (Throwable th) {
            String[] strArr = A06;
            if (strArr[7].charAt(1) != strArr[2].charAt(1)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A06;
            strArr2[7] = "5YuzUPqIN2qUpgzcgBPCGBub3XZtkUQJ";
            strArr2[2] = "DYAXZKj6jF9OEHVnXiKZJEzpdMmcnACr";
            KL.A00(th, this);
        }
    }
}
