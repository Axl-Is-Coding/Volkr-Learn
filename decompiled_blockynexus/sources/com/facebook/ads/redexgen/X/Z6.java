package com.facebook.ads.redexgen.X;

import android.util.SparseArray;
import android.util.SparseIntArray;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class Z6 implements DO {
    public static String[] A05;
    public final int A00;
    public final /* synthetic */ Z7 A04;
    public final IF A03 = new IF(new byte[5]);
    public final SparseArray<DV> A01 = new SparseArray<>();
    public final SparseIntArray A02 = new SparseIntArray();

    static {
        A01();
    }

    public static void A01() {
        A05 = new String[]{"RGyTh4SpGx69CnC3uYB0gmKqWWTNP", "iDg", "j2BD3qxwlCatqD2Ch8dsr4SydA7XKwXL", "m1LAn1cIXYa33UPzElI", "cPJKdoCFMTZnGOgvNAg6pI", "iUx5cAJ8Ufw2U1Fp6uB6P", "qd", "YeOgnvzSUR8"};
    }

    public Z6(Z7 z7, int i) {
        this.A04 = z7;
        this.A00 = i;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00a1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private com.facebook.ads.redexgen.X.DS A00(com.facebook.ads.redexgen.X.IG r13, int r14) {
        /*
            Method dump skipped, instruction units count: 249
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.Z6.A00(com.facebook.ads.redexgen.X.IG, int):com.facebook.ads.redexgen.X.DS");
    }

    @Override // com.facebook.ads.redexgen.X.DO
    public final void A48(IG ig) {
        IS is;
        DV dvA4O;
        if (ig.A0F() != 2) {
            return;
        }
        if (this.A04.A05 != 1 && this.A04.A05 != 2 && this.A04.A01 != 1) {
            is = new IS(((IS) this.A04.A0B.get(0)).A04());
            this.A04.A0B.add(is);
        } else {
            is = (IS) this.A04.A0B.get(0);
        }
        ig.A0a(2);
        int iA0J = ig.A0J();
        int i = 5;
        ig.A0a(5);
        ig.A0b(this.A03, 2);
        int i2 = 4;
        this.A03.A09(4);
        int i3 = 12;
        int programNumber = this.A03.A05(12);
        ig.A0a(programNumber);
        int programNumber2 = this.A04.A05;
        int programInfoLength = 21;
        if (programNumber2 == 2 && this.A04.A03 == null) {
            DS ds = new DS(21, null, null, new byte[0]);
            Z7 z7 = this.A04;
            z7.A03 = z7.A09.A4O(21, ds);
            this.A04.A03.A7g(is, this.A04.A02, new DU(iA0J, 21, 8192));
        }
        this.A01.clear();
        this.A02.clear();
        int iA05 = ig.A05();
        while (iA05 > 0) {
            ig.A0b(this.A03, i);
            int iA052 = this.A03.A05(8);
            this.A03.A09(3);
            int iA053 = this.A03.A05(13);
            this.A03.A09(i2);
            int iA054 = this.A03.A05(i3);
            DS dsA00 = A00(ig, iA054);
            if (iA052 == 6) {
                iA052 = dsA00.A00;
            }
            int esInfoLength = iA054 + 5;
            iA05 -= esInfoLength;
            int esInfoLength2 = this.A04.A05;
            int i4 = esInfoLength2 == 2 ? iA052 : iA053;
            if (!this.A04.A07.get(i4)) {
                int trackId = this.A04.A05;
                if (trackId != 2 || iA052 != programInfoLength) {
                    Z7 z72 = this.A04;
                    String[] strArr = A05;
                    String str = strArr[0];
                    String str2 = strArr[1];
                    int programInfoLength2 = str.length();
                    if (programInfoLength2 == str2.length()) {
                        throw new RuntimeException();
                    }
                    String[] strArr2 = A05;
                    strArr2[5] = "uMTX0BK3hwRt9LI9TXEhN";
                    strArr2[7] = "Q6yhhKO6s7v";
                    dvA4O = z72.A09.A4O(iA052, dsA00);
                } else {
                    dvA4O = this.A04.A03;
                }
                if (this.A04.A05 != 2 || iA053 < this.A02.get(i4, 8192)) {
                    SparseIntArray sparseIntArray = this.A02;
                    int programInfoLength3 = A05[4].length();
                    if (programInfoLength3 == 17) {
                        throw new RuntimeException();
                    }
                    String[] strArr3 = A05;
                    strArr3[3] = "hYuW2ZxScZvjOUyRYzD";
                    strArr3[3] = "hYuW2ZxScZvjOUyRYzD";
                    sparseIntArray.put(i4, iA053);
                    this.A01.put(i4, dvA4O);
                }
            }
            i = 5;
            i2 = 4;
            i3 = 12;
            programInfoLength = 21;
        }
        int size = this.A02.size();
        for (int i5 = 0; i5 < size; i5++) {
            int iKeyAt = this.A02.keyAt(i5);
            this.A04.A07.put(iKeyAt, true);
            DV dvValueAt = this.A01.valueAt(i5);
            if (dvValueAt != null) {
                if (dvValueAt != this.A04.A03) {
                    dvValueAt.A7g(is, this.A04.A02, new DU(iA0J, iKeyAt, 8192));
                }
                SparseArray sparseArray = this.A04.A06;
                int trackIdCount = this.A02.valueAt(i5);
                sparseArray.put(trackIdCount, dvValueAt);
            }
        }
        if (this.A04.A05 != 2) {
            int i6 = 0;
            SparseArray sparseArray2 = this.A04.A06;
            int programInfoLength4 = this.A00;
            sparseArray2.remove(programInfoLength4);
            Z7 z73 = this.A04;
            if (z73.A05 != 1) {
                i6 = this.A04.A01 - 1;
            }
            z73.A01 = i6;
            if (this.A04.A01 != 0) {
                return;
            }
            this.A04.A02.A54();
            this.A04.A04 = true;
            return;
        }
        if (this.A04.A04) {
            return;
        }
        this.A04.A02.A54();
        this.A04.A01 = 0;
        this.A04.A04 = true;
    }

    @Override // com.facebook.ads.redexgen.X.DO
    public final void A7g(IS is, CC cc, DU du) {
    }
}
