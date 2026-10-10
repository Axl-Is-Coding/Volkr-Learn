package com.facebook.ads.redexgen.X;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class MR implements Q2 {
    public static String[] A01;
    public final /* synthetic */ C1820Ob A00;

    static {
        A00();
    }

    public static void A00() {
        A01 = new String[]{"uB1RC", "E7rLPB8klTW5J9FjuULp7NzB4AWE19Zm", "BGfRoGqubHgomR1aknLAm7BQoVqY9Rjo", "2aqRDajB7mkFiu8JUeuEjEkcXKsGj4gd", "YPIu8FWl8tmTV", "O2dNNTCX3dr0fdBVB7HhwqWACslxe6aK", "WKmspm9NaQlidgYEldSczPSkp8W1cJlS", "CDbKVWoo3Luj5aOlcVCk0HC1kDrFWNgV"};
    }

    public MR(C1820Ob c1820Ob) {
        this.A00 = c1820Ob;
    }

    @Override // com.facebook.ads.redexgen.X.Q2
    public final void AC7() {
        if (this.A00.A02 != null) {
            C1820Ob c1820Ob = this.A00;
            if (A01[3].charAt(8) == 'm') {
                throw new RuntimeException();
            }
            String[] strArr = A01;
            strArr[3] = "G62o5XZ8JRlbj2NUyH9KkdSeUCUXeXTA";
            strArr[3] = "G62o5XZ8JRlbj2NUyH9KkdSeUCUXeXTA";
            c1820Ob.A02.A3s(this.A00.A03.A72());
        }
    }

    @Override // com.facebook.ads.redexgen.X.Q2
    public final void AC9(Q4 q4) {
        if (this.A00.A02 == null) {
            return;
        }
        if (q4 == null || !q4.A00()) {
            this.A00.A02.A3s(this.A00.A03.A72());
            return;
        }
        InterfaceC1767Lz interfaceC1767Lz = this.A00.A02;
        C1820Ob c1820Ob = this.A00;
        if (A01[5].length() == 14) {
            throw new RuntimeException();
        }
        String[] strArr = A01;
        strArr[1] = "MYgqySdSEunU6EGhIZ8lv2VKjJmAUpiH";
        strArr[1] = "MYgqySdSEunU6EGhIZ8lv2VKjJmAUpiH";
        interfaceC1767Lz.A3s(c1820Ob.A03.A73());
    }
}
