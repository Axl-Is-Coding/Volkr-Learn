package com.facebook.ads.redexgen.X;

import android.util.Pair;
import androidx.annotation.Nullable;
import com.facebook.ads.internal.exoplayer2.Format;
import java.util.Arrays;
import java.util.Collections;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Yx, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C2100Yx implements DG {
    public static byte[] A0K;
    public static String[] A0L;
    public int A00;
    public int A01;
    public int A02;
    public int A03;
    public int A04;
    public int A05;
    public int A06;
    public int A07;
    public int A08;
    public long A09;
    public long A0A;
    public long A0B;
    public Format A0C;
    public CM A0D;
    public String A0E;
    public boolean A0F;
    public boolean A0G;
    public final String A0J;
    public final IG A0I = new IG(1024);
    public final IF A0H = new IF(this.A0I.A00);

    static {
        A05();
        A04();
    }

    public static String A03(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0K, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            int i5 = (bArrCopyOfRange[i4] - i3) - 35;
            String[] strArr = A0L;
            if (strArr[1].charAt(19) != strArr[0].charAt(19)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0L;
            strArr2[3] = "gooppkWHFs0OH8ZO7KHmI5JoYki0niEb";
            strArr2[4] = "gQ32BKgMXcn7uGYeyK4g8BO1uII782R4";
            bArrCopyOfRange[i4] = (byte) i5;
        }
        return new String(bArrCopyOfRange);
    }

    public static void A04() {
        A0K = new byte[]{-87, -67, -84, -79, -73, 119, -75, -72, 124, -87, 117, -76, -87, -68, -75};
    }

    public static void A05() {
        A0L = new String[]{"hgUALiBHRBx3rc9PT3qyJLJuKriNjQIA", "JcSPF8dLSzFIe8gapkYyYGiPDe1iVZ7T", "a8IrrF5hi8IFjeZ2lIy6xY1armnYmb5o", "dI536DedIqR9AIwKwKzHAZoNzdw0gd0o", "spoCU0rWYssiPe95xKAIpCDVtAt9VbvV", "ZT5oGWr6FGwuE", "k3I4LHvMKlhfRum43HVkkWOAjRBPWhRl", "GOwjxx90kdElmS0"};
    }

    public C2100Yx(@Nullable String str) {
        this.A0J = str;
    }

    private int A00(IF r4) throws AD {
        int iA02 = r4.A02();
        Pair<Integer, Integer> pairA02 = C1666Hv.A02(r4, true);
        this.A05 = ((Integer) pairA02.first).intValue();
        this.A02 = ((Integer) pairA02.second).intValue();
        return iA02 - r4.A02();
    }

    private int A01(IF r4) throws AD {
        int iA05;
        int i = 0;
        if (this.A03 == 0) {
            do {
                iA05 = r4.A05(8);
                i += iA05;
            } while (iA05 == 255);
            return i;
        }
        throw new AD();
    }

    public static long A02(IF r1) {
        return r1.A05((r1.A05(2) + 1) * 8);
    }

    private void A06(int i) {
        this.A0I.A0X(i);
        this.A0H.A0C(this.A0I.A00);
    }

    private void A07(IF r4) throws AD {
        if (!r4.A0G()) {
            this.A0G = true;
            A09(r4);
        } else if (!this.A0G) {
            return;
        }
        if (this.A00 == 0) {
            if (this.A04 == 0) {
                A0A(r4, A01(r4));
                if (this.A0F) {
                    r4.A09((int) this.A09);
                    return;
                }
                return;
            }
            throw new AD();
        }
        throw new AD();
    }

    private void A08(IF r7) {
        this.A03 = r7.A05(3);
        int i = this.A03;
        if (i == 0) {
            r7.A09(8);
            return;
        }
        if (i != 1) {
            if (i != 3 && i != 4 && i != 5) {
                if (i != 6) {
                    if (A0L[7].length() != 15) {
                        throw new RuntimeException();
                    }
                    String[] strArr = A0L;
                    strArr[1] = "QJhjenmrzPYVr6mrKS1ywIZfks2sEqmv";
                    strArr[0] = "rtM7Stfru76sVtn814uyI2mxrEEn9Ydu";
                    if (i != 7) {
                        return;
                    }
                }
                r7.A09(1);
                return;
            }
            r7.A09(6);
            return;
        }
        r7.A09(9);
    }

    private void A09(IF r20) throws AD {
        boolean zA0G;
        int numProgram = r20.A05(1);
        int bitsRead = numProgram == 1 ? r20.A05(1) : 0;
        this.A00 = bitsRead;
        if (this.A00 == 0) {
            if (numProgram == 1) {
                A02(r20);
            }
            if (r20.A0G()) {
                this.A04 = r20.A05(6);
                int iA05 = r20.A05(4);
                int iA052 = r20.A05(3);
                if (iA05 == 0 && iA052 == 0) {
                    if (numProgram == 0) {
                        int readBits = r20.A04();
                        int iA00 = A00(r20);
                        r20.A08(readBits);
                        int readBits2 = iA00 + 7;
                        byte[] initData = new byte[readBits2 / 8];
                        r20.A0E(initData, 0, iA00);
                        Format formatA07 = Format.A07(this.A0E, A03(0, 15, 37), null, -1, -1, this.A02, this.A05, Collections.singletonList(initData), null, 0, this.A0J);
                        if (!formatA07.equals(this.A0C)) {
                            this.A0C = formatA07;
                            this.A0A = 1024000000 / ((long) formatA07.A0C);
                            this.A0D.A5I(formatA07);
                        }
                    } else {
                        int iA02 = (int) A02(r20);
                        int bitsRead2 = A00(r20);
                        r20.A09(iA02 - bitsRead2);
                    }
                    A08(r20);
                    this.A0F = r20.A0G();
                    this.A09 = 0L;
                    if (this.A0F) {
                        if (numProgram == 1) {
                            this.A09 = A02(r20);
                        } else {
                            do {
                                zA0G = r20.A0G();
                                this.A09 = (this.A09 << 8) + ((long) r20.A05(8));
                            } while (zA0G);
                        }
                    }
                    if (r20.A0G()) {
                        r20.A09(8);
                        return;
                    }
                    return;
                }
                throw new AD();
            }
            throw new AD();
        }
        throw new AD();
    }

    private void A0A(IF r8, int i) {
        int iA04 = r8.A04();
        if ((iA04 & 7) == 0) {
            this.A0I.A0Z(iA04 >> 3);
        } else {
            r8.A0E(this.A0I.A00, 0, i * 8);
            this.A0I.A0Z(0);
        }
        this.A0D.ACx(this.A0I, i);
        this.A0D.ACy(this.A0B, 1, i, 0, null);
        this.A0B += this.A0A;
    }

    @Override // com.facebook.ads.redexgen.X.DG
    public final void A48(IG ig) throws AD {
        while (ig.A05() > 0) {
            int i = this.A08;
            if (i != 0) {
                if (i == 1) {
                    int iA0F = ig.A0F();
                    if ((iA0F & 224) == 224) {
                        this.A07 = iA0F;
                        this.A08 = 2;
                    } else if (iA0F != 86) {
                        this.A08 = 0;
                    }
                } else {
                    if (A0L[7].length() != 15) {
                        throw new RuntimeException();
                    }
                    String[] strArr = A0L;
                    strArr[3] = "eXMY6UfuU8mptnxKZK3KjbCMiU1pAKNs";
                    strArr[4] = "BrFOrdIatggcu5HdAKqvOHyOVIidANWA";
                    if (i == 2) {
                        this.A06 = ((this.A07 & (-225)) << 8) | ig.A0F();
                        if (this.A06 > this.A0I.A00.length) {
                            A06(this.A06);
                        }
                        this.A01 = 0;
                        this.A08 = 3;
                    } else if (i == 3) {
                        int iMin = Math.min(ig.A05(), this.A06 - this.A01);
                        ig.A0d(this.A0H.A00, this.A01, iMin);
                        this.A01 += iMin;
                        if (this.A01 == this.A06) {
                            this.A0H.A08(0);
                            A07(this.A0H);
                            this.A08 = 0;
                        }
                    }
                }
            } else if (ig.A0F() == 86) {
                this.A08 = 1;
            }
        }
    }

    @Override // com.facebook.ads.redexgen.X.DG
    public final void A4U(CC cc, DU du) {
        du.A06();
        this.A0D = cc.ADr(du.A04(), 1);
        this.A0E = du.A05();
    }

    @Override // com.facebook.ads.redexgen.X.DG
    public final void ABo() {
    }

    @Override // com.facebook.ads.redexgen.X.DG
    public final void ABp(long j, boolean z) {
        this.A0B = j;
    }

    @Override // com.facebook.ads.redexgen.X.DG
    public final void AD1() {
        this.A08 = 0;
        this.A0G = false;
    }
}
