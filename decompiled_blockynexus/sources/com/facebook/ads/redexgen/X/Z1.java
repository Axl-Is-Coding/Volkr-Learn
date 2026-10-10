package com.facebook.ads.redexgen.X;

import android.util.SparseArray;
import java.io.IOException;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class Z1 implements CA {
    public static String[] A08;
    public static final CD A09;
    public long A00;
    public CC A01;
    public boolean A02;
    public boolean A03;
    public boolean A04;
    public final SparseArray<DN> A05;
    public final IG A06;
    public final IS A07;

    public static void A00() {
        A08 = new String[]{"", "mExdGVP0maPlz", "mtU4GW9lJGPRgwi7WTtJ47xTDMOD9Jvz", "mnVK2jaR5CYO63Y95SEKprVffrLm5k0s", "WHnhbYArFQVibafDHBFVvoYN0aOa9WUH", "bzekXst0bt0AdcZvIiwJXkkJcIHRgIjU", "gyTL2jV1VgKAzlNybmW", "q"};
    }

    static {
        A00();
        A09 = new Z0();
    }

    public Z1() {
        this(new IS(0L));
    }

    public Z1(IS is) {
        this.A07 = is;
        this.A06 = new IG(4096);
        this.A05 = new SparseArray<>();
    }

    @Override // com.facebook.ads.redexgen.X.CA
    public final void A7e(CC cc) {
        this.A01 = cc;
        cc.AD3(new YB(-9223372036854775807L));
    }

    /* JADX WARN: Removed duplicated region for block: B:50:0x013a  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0141  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0162  */
    @Override // com.facebook.ads.redexgen.X.CA
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int ACG(com.facebook.ads.redexgen.X.CB r10, com.facebook.ads.redexgen.X.CH r11) throws java.lang.InterruptedException, java.io.IOException {
        /*
            Method dump skipped, instruction units count: 358
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.Z1.ACG(com.facebook.ads.redexgen.X.CB, com.facebook.ads.redexgen.X.CH):int");
    }

    @Override // com.facebook.ads.redexgen.X.CA
    public final void AD2(long j, long j2) {
        this.A07.A09();
        for (int i = 0; i < this.A05.size(); i++) {
            this.A05.valueAt(i).A02();
        }
    }

    @Override // com.facebook.ads.redexgen.X.CA
    public final boolean ADa(CB cb) throws InterruptedException, IOException {
        byte[] bArr = new byte[14];
        cb.ABs(bArr, 0, 14);
        if (442 != (((bArr[0] & 255) << 24) | ((bArr[1] & 255) << 16) | ((bArr[2] & 255) << 8) | (bArr[3] & 255)) || (bArr[4] & 196) != 68 || (bArr[6] & 4) != 4 || (bArr[8] & 4) != 4 || (bArr[9] & 1) != 1 || (bArr[12] & 3) != 3) {
            return false;
        }
        if (A08[7].length() == 3) {
            throw new RuntimeException();
        }
        String[] strArr = A08;
        strArr[4] = "dWjhqjXulz1hd3AtKzuGBSPNQhOMyT1H";
        strArr[4] = "dWjhqjXulz1hd3AtKzuGBSPNQhOMyT1H";
        cb.A3M(bArr[13] & 7);
        cb.ABs(bArr, 0, 3);
        return 1 == ((bArr[2] & 255) | (((bArr[0] & 255) << 16) | ((bArr[1] & 255) << 8)));
    }
}
