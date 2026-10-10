package com.facebook.ads.redexgen.X;

import android.os.Build;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class VT implements C6Y {
    public static String[] A01;
    public final /* synthetic */ C2003Ve A00;

    static {
        A00();
    }

    public static void A00() {
        A01 = new String[]{"eOUuWViEzFdpoMILAqmgKfGD", "kQ8zGky5wq3o9AT", "ncGQnuO4sM8XFQVxbr6Mt1Vf36DFujo3", "a4nYvm2BizGaG1Ug1SxTpBLIw0WxQ6vz", "jAlZY9MHNrHTDDv2DRP1sCieuZx8QBhv", "RCRcS7R4oQOTyLjlpIEX5API7Ni0gnf1", "stcG16G11KY1ooFu5mTwbs8KzP9kRkND", "k7goAJY4JhsqFIUQ56a5dCg3eq5QWQcp"};
    }

    public VT(C2003Ve c2003Ve) {
        this.A00 = c2003Ve;
    }

    @Override // com.facebook.ads.redexgen.X.C6Y
    public final AbstractC14046n A58() {
        if (Build.VERSION.SDK_INT < 26) {
            return this.A00.A08(EnumC14006j.A05);
        }
        if (this.A00.A02 != null && this.A00.A02.getPackageInstaller() != null && this.A00.A02.getPackageInstaller().getSessionInfo(0) != null) {
            C2003Ve c2003Ve = this.A00;
            return c2003Ve.A05(c2003Ve.A02.getPackageInstaller().getSessionInfo(0).getInstallReason());
        }
        C2003Ve c2003Ve2 = this.A00;
        EnumC14006j enumC14006j = EnumC14006j.A07;
        if (A01[4].charAt(16) != 'D') {
            throw new RuntimeException();
        }
        String[] strArr = A01;
        strArr[4] = "aumDgxyAyTkwYeibDzhpdrzSDvCJmfPb";
        strArr[4] = "aumDgxyAyTkwYeibDzhpdrzSDvCJmfPb";
        return c2003Ve2.A08(enumC14006j);
    }
}
