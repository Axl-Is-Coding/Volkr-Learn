package com.facebook.ads.redexgen.X;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Eh, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1578Eh extends AbstractC2123Zx<C1904Rh> {
    public static String[] A00;

    static {
        A00();
    }

    public static void A00() {
        A00 = new String[]{"ByMq6MLqhjUJsdWB3RBIp", "zuOr3", "msyHKBX3wHVeYE5obxbctQprcgEzI02t", "I3sOgeRwcNYGF4oixOV5Q17", "dcB", "ibtCqc8qysdz0E5AMIDmPhuL1XZA", "mNtKCg4kzaH6sXUtb2oDuqx2", "ObFvkEusatMYzjWaq72f4FkWXHrQjerH"};
    }

    public C1578Eh(C1904Rh c1904Rh) {
        super(c1904Rh);
    }

    @Override // com.facebook.ads.redexgen.X.KT
    public final void A07() {
        C1904Rh c1904RhA08 = A08();
        if (c1904RhA08 == null) {
            return;
        }
        C2026Wb c2026Wb = c1904RhA08.A08;
        String[] strArr = A00;
        if (strArr[3].length() == strArr[4].length()) {
            throw new RuntimeException();
        }
        String[] strArr2 = A00;
        strArr2[5] = "SiVLKh";
        strArr2[5] = "SiVLKh";
        if (C1756Lo.A02(c2026Wb)) {
            c1904RhA08.A08();
        } else {
            c1904RhA08.A05.postDelayed(c1904RhA08.A0C, 5000L);
        }
    }
}
