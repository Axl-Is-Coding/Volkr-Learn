package com.facebook.ads.redexgen.X;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class ZF implements InterfaceC1737Kv {
    public static String[] A01;
    public final /* synthetic */ Y5 A00;

    public static void A00() {
        A01 = new String[]{"XQ6pDaA1rZEM", "XoeGOYiSv0w2M1U1qXC2kK0WxpTFbq6C", "goNPtYs5sZFfNSJyOgs171oDuCl7t69H", "IBRmsKraW8ihcuaNuynFKjmRlH", "udOMyB", "k9bLdXox5SSCuqwZoRmzAy5kJm", "rLCACxpviKCtWgunDsmekf59Ef0kXw8R", "IiDilnQTvcIperbA6lCpmy3utrrmGEhT"};
    }

    static {
        A00();
    }

    public ZF(Y5 y5) {
        this.A00 = y5;
    }

    public /* synthetic */ ZF(Y5 y5, ZS zs) {
        this(y5);
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1737Kv
    public final void A9V() {
        this.A00.A0H();
        if (this.A00.A0N && this.A00.A0W()) {
            this.A00.A0P.setToolbarActionMode(1);
        } else {
            this.A00.A0P.setToolbarActionMode(0);
        }
        boolean z = this.A00.A0O;
        if (A01[4].length() != 6) {
            throw new RuntimeException();
        }
        String[] strArr = A01;
        strArr[4] = "RNuzR8";
        strArr[4] = "RNuzR8";
        if (!z) {
            LX.A0Y(this.A00, 500);
            if (this.A00.A05 != null) {
                LX.A0Q(this.A00.A05, 0);
            }
        }
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1737Kv
    public final void AAv(float f2) {
        this.A00.A0P.setProgress(100.0f * (1.0f - (f2 / this.A00.A0A.A08())));
        this.A00.A0O((int) f2);
    }
}
