package com.facebook.ads.redexgen.X;

import java.util.Comparator;
import java.util.TreeSet;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.9s, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C14769s implements InterfaceC2178as, Comparator<C1650Hf> {
    public static String[] A03;
    public long A00;
    public final long A01;
    public final TreeSet<C1650Hf> A02 = new TreeSet<>(this);

    static {
        A01();
    }

    public static void A01() {
        A03 = new String[]{"qrCZDebBZXOMsu5PI8FdamZv", "usPTrKdLrE7MLvxS6mJMRwkls4hZpcPz", "BDrpv9J1bckqz2zbQbGMwvdv", "cHdTuf55w1r5Lcr9n47avjSAGBdp9rLc", "v1mI", "NFtkBlX9Mz", "lz", "jBDMosIM65rjrOuIbY8WA7ZUxyDm84U3"};
    }

    public C14769s(long j) {
        this.A01 = j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // java.util.Comparator
    /* JADX INFO: renamed from: A00, reason: merged with bridge method [inline-methods] */
    public final int compare(C1650Hf c1650Hf, C1650Hf c1650Hf2) {
        if (c1650Hf.A00 - c1650Hf2.A00 == 0) {
            return c1650Hf.compareTo(c1650Hf2);
        }
        return c1650Hf.A00 < c1650Hf2.A00 ? -1 : 1;
    }

    private void A02(InterfaceC1646Hb interfaceC1646Hb, long j) {
        while (this.A00 + j > this.A01) {
            boolean zIsEmpty = this.A02.isEmpty();
            if (A03[4].length() == 25) {
                throw new RuntimeException();
            }
            String[] strArr = A03;
            strArr[0] = "3qXh8T5e4LOlD1IWJEc6SNWF";
            strArr[2] = "YJzC3pPkQPrTmiUzc4g95RWz";
            if (!zIsEmpty) {
                try {
                    interfaceC1646Hb.ACh(this.A02.first());
                } catch (HZ unused) {
                }
            } else {
                return;
            }
        }
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1645Ha
    public final void ABH(InterfaceC1646Hb interfaceC1646Hb, C1650Hf c1650Hf) {
        this.A02.add(c1650Hf);
        this.A00 += c1650Hf.A01;
        A02(interfaceC1646Hb, 0L);
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1645Ha
    public final void ABI(InterfaceC1646Hb interfaceC1646Hb, C1650Hf c1650Hf) {
        this.A02.remove(c1650Hf);
        this.A00 -= c1650Hf.A01;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1645Ha
    public final void ABJ(InterfaceC1646Hb interfaceC1646Hb, C1650Hf c1650Hf, C1650Hf c1650Hf2) {
        ABI(interfaceC1646Hb, c1650Hf);
        ABH(interfaceC1646Hb, c1650Hf2);
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC2178as
    public final void ABK(InterfaceC1646Hb interfaceC1646Hb, String str, long j, long j2) {
        A02(interfaceC1646Hb, j2);
    }
}
