package com.facebook.ads.redexgen.X;

import java.util.Collections;
import java.util.List;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.a8, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C2132a8 implements G6 {
    public static String[] A01;
    public final List<G5> A00;

    static {
        A00();
    }

    public static void A00() {
        A01 = new String[]{"uyzG6nZhYmNB4VufbjNeT4Wu24aJjB", "gpgsRAJrUCyLiJ0U4KQoajYft8d2IWSs", "V6tp6oNeuWY4Rz4wk", "QxLD6Qr0", "n2jYEAQ7ylPlmaGFo", "iuLvneSMbLfhzIa7Pvm7Ht11vKly078I", "9KvTRZ4e8scFY8IRtC8ize1aHWfIVCyu", "s0mDJJaIHWanY7Mz7gNVqOFT5NJr2uCg"};
    }

    public C2132a8(List<G5> list) {
        this.A00 = list;
    }

    @Override // com.facebook.ads.redexgen.X.G6
    public final List<G5> A5w(long j) {
        return j >= 0 ? this.A00 : Collections.emptyList();
    }

    @Override // com.facebook.ads.redexgen.X.G6
    public final long A6L(int i) {
        C1662Hr.A03(i == 0);
        String[] strArr = A01;
        if (strArr[6].charAt(12) != strArr[7].charAt(12)) {
            throw new RuntimeException();
        }
        String[] strArr2 = A01;
        strArr2[0] = "k5niKSSkUsmLECakjkbMaTYSf6uR41";
        strArr2[3] = "iDI18Hfk";
        return 0L;
    }

    @Override // com.facebook.ads.redexgen.X.G6
    public final int A6M() {
        return 1;
    }

    @Override // com.facebook.ads.redexgen.X.G6
    public final int A6f(long j) {
        return j < 0 ? 0 : -1;
    }
}
