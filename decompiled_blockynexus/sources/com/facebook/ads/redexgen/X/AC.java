package com.facebook.ads.redexgen.X;

import android.util.Pair;
import androidx.annotation.Nullable;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class AC {
    public static String[] A0C;
    public int A00;
    public int A01;
    public long A02;
    public long A03;
    public AA A04;
    public AA A05;
    public AA A06;
    public AZ A07;
    public Object A08;
    public boolean A09;
    public final AX A0A = new AX();
    public final AY A0B = new AY();

    static {
        A08();
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException: Index 22 out of bounds for length 22
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.startVar(DebugInfoParser.java:203)
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.process(DebugInfoParser.java:125)
    	at jadx.plugins.input.dex.sections.DexCodeReader.getDebugInfo(DexCodeReader.java:122)
    	at jadx.core.dex.nodes.MethodNode.getDebugInfo(MethodNode.java:645)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:38)
     */
    private AB A02(int i, long j, long j2) {
        F6 f6 = new F6(i, j2);
        this.A07.A0A(f6.A02, this.A0A);
        int iA04 = this.A0A.A04(j);
        long jA09 = iA04 == -1 ? Long.MIN_VALUE : this.A0A.A09(iA04);
        boolean zA0B = A0B(f6, jA09);
        return new AB(f6, j, jA09, -9223372036854775807L, jA09 == Long.MIN_VALUE ? this.A0A.A07() : jA09, zA0B, A0C(f6, zA0B));
    }

    public static void A08() {
        A0C = new String[]{"L0u3smBC6U6OaYtXppAd31iOC3v5Qhxz", "mD", "DMmTpdJrujAgbmCwwmXMokmpSOB8XVVu", "Fa0SCWKpXCwAFqaC3HE", "LFAAfAeIJjtENyizMXbJJCIXxkMYQ2BS", "EOXOixXcPNGoqbhwUMphXmxbz6TL9K", "ydRMenJrqCbsHYuDZ17G4nGASKkEf2si", "4zZeHgY0eMzISLpxtPc37pmrQXWGSxn"};
    }

    private long A00(int i) {
        int oldFrontPeriodIndex;
        Object obj = this.A07.A0B(i, this.A0A, true).A03;
        int i2 = this.A0A.A00;
        Object obj2 = this.A08;
        if (obj2 != null && (oldFrontPeriodIndex = this.A07.A05(obj2)) != -1) {
            int oldFrontWindowIndex = this.A07.A0A(oldFrontPeriodIndex, this.A0A).A00;
            if (oldFrontWindowIndex == i2) {
                return this.A03;
            }
        }
        for (AA aaA0F = A0F(); aaA0F != null; aaA0F = aaA0F.A01) {
            if (aaA0F.A09.equals(obj)) {
                return aaA0F.A02.A04.A03;
            }
        }
        for (AA aaA0F2 = A0F(); aaA0F2 != null; aaA0F2 = aaA0F2.A01) {
            int iA05 = this.A07.A05(aaA0F2.A09);
            if (iA05 != -1) {
                int holderWindowIndex = this.A07.A0A(iA05, this.A0A).A00;
                if (holderWindowIndex == i2) {
                    return aaA0F2.A02.A04.A03;
                }
            }
        }
        long j = this.A02;
        this.A02 = 1 + j;
        return j;
    }

    private AB A01(int i, int i2, int i3, long durationUs, long j) {
        long jA06;
        F6 f6 = new F6(i, i2, i3, j);
        boolean zA0B = A0B(f6, Long.MIN_VALUE);
        boolean zA0C = A0C(f6, zA0B);
        long jA0A = this.A07.A0A(f6.A02, this.A0A).A0A(f6.A00, f6.A01);
        if (i3 == this.A0A.A02(i2)) {
            jA06 = this.A0A.A06();
        } else {
            jA06 = 0;
        }
        return new AB(f6, jA06, Long.MIN_VALUE, durationUs, jA0A, zA0B, zA0C);
    }

    @Nullable
    private AB A03(AA aa, long j) {
        long jLongValue;
        AB ab = aa.A02;
        if (ab.A06) {
            int iA04 = this.A07.A04(ab.A04.A02, this.A0A, this.A0B, this.A01, this.A09);
            if (iA04 == -1) {
                return null;
            }
            int i = this.A07.A0B(iA04, this.A0A, true).A00;
            Object obj = this.A0A.A03;
            long j2 = ab.A04.A03;
            if (this.A07.A0C(i, this.A0B).A00 == iA04) {
                long windowSequenceNumber = aa.A08();
                Pair<Integer, Long> pairA09 = this.A07.A09(this.A0B, this.A0A, i, -9223372036854775807L, Math.max(0L, (windowSequenceNumber + ab.A01) - j));
                if (pairA09 == null) {
                    return null;
                }
                Object nextPeriodUid = pairA09.first;
                iA04 = ((Integer) nextPeriodUid).intValue();
                Object nextPeriodUid2 = pairA09.second;
                jLongValue = ((Long) nextPeriodUid2).longValue();
                Object nextPeriodUid3 = aa.A01;
                if (nextPeriodUid3 != null && aa.A01.A09.equals(obj)) {
                    j2 = aa.A01.A02.A04.A03;
                } else {
                    j2 = this.A02;
                    long startPositionUs = j2 + 1;
                    this.A02 = startPositionUs;
                }
            } else {
                jLongValue = 0;
            }
            return A06(A07(iA04, jLongValue, j2), jLongValue, jLongValue);
        }
        F6 currentPeriodId = ab.A04;
        this.A07.A0A(currentPeriodId.A02, this.A0A);
        if (currentPeriodId.A02()) {
            int adGroupIndex = currentPeriodId.A00;
            int iA01 = this.A0A.A01(adGroupIndex);
            if (iA01 == -1) {
                return null;
            }
            int adCountInCurrentAdGroup = this.A0A.A03(adGroupIndex, currentPeriodId.A01);
            if (adCountInCurrentAdGroup < iA01) {
                if (!this.A0A.A0E(adGroupIndex, adCountInCurrentAdGroup)) {
                    return null;
                }
                return A01(currentPeriodId.A02, adGroupIndex, adCountInCurrentAdGroup, ab.A00, currentPeriodId.A03);
            }
            return A02(currentPeriodId.A02, ab.A00, currentPeriodId.A03);
        }
        long j3 = ab.A02;
        if (A0C[6].charAt(23) != 'A') {
            throw new RuntimeException();
        }
        String[] strArr = A0C;
        strArr[1] = "6G";
        strArr[1] = "6G";
        if (j3 != Long.MIN_VALUE) {
            int iA05 = this.A0A.A05(ab.A02);
            if (iA05 == -1) {
                return A02(currentPeriodId.A02, ab.A02, currentPeriodId.A03);
            }
            int iA02 = this.A0A.A02(iA05);
            if (!this.A0A.A0E(iA05, iA02)) {
                return null;
            }
            return A01(currentPeriodId.A02, iA05, iA02, ab.A02, currentPeriodId.A03);
        }
        int iA00 = this.A0A.A00();
        if (iA00 == 0) {
            return null;
        }
        int i2 = iA00 - 1;
        if (this.A0A.A09(i2) != Long.MIN_VALUE || this.A0A.A0D(i2)) {
            return null;
        }
        int adGroupCount = this.A0A.A02(i2);
        if (!this.A0A.A0E(i2, adGroupCount)) {
            return null;
        }
        long jA07 = this.A0A.A07();
        int i3 = currentPeriodId.A02;
        long contentDurationUs = currentPeriodId.A03;
        return A01(i3, i2, adGroupCount, jA07, contentDurationUs);
    }

    private AB A04(AB ab, F6 f6) {
        long jA07;
        long j = ab.A03;
        long endPositionUs = ab.A02;
        boolean zA0B = A0B(f6, endPositionUs);
        boolean zA0C = A0C(f6, zA0B);
        this.A07.A0A(f6.A02, this.A0A);
        boolean isLastInPeriod = f6.A02();
        if (isLastInPeriod) {
            jA07 = this.A0A.A0A(f6.A00, f6.A01);
        } else {
            if (A0C[2].charAt(30) != 'V') {
                throw new RuntimeException();
            }
            String[] strArr = A0C;
            strArr[2] = "zTzAUiYM1BrQqeObFTyCKDEgqKKR2HVC";
            strArr[2] = "zTzAUiYM1BrQqeObFTyCKDEgqKKR2HVC";
            jA07 = endPositionUs == Long.MIN_VALUE ? this.A0A.A07() : endPositionUs;
        }
        return new AB(f6, j, endPositionUs, ab.A00, jA07, zA0B, zA0C);
    }

    private AB A05(AE ae) {
        return A06(ae.A04, ae.A01, ae.A02);
    }

    private AB A06(F6 f6, long j, long j2) {
        this.A07.A0A(f6.A02, this.A0A);
        if (f6.A02()) {
            if (!this.A0A.A0E(f6.A00, f6.A01)) {
                return null;
            }
            return A01(f6.A02, f6.A00, f6.A01, j, f6.A03);
        }
        return A02(f6.A02, j2, f6.A03);
    }

    private F6 A07(int i, long j, long j2) {
        this.A07.A0A(i, this.A0A);
        int iA05 = this.A0A.A05(j);
        if (iA05 == -1) {
            return new F6(i, j2);
        }
        return new F6(i, iA05, this.A0A.A02(iA05), j2);
    }

    private boolean A09() {
        AA aaA0F = A0F();
        if (aaA0F == null) {
            return true;
        }
        while (true) {
            int iA04 = this.A07.A04(aaA0F.A02.A04.A02, this.A0A, this.A0B, this.A01, this.A09);
            while (aaA0F.A01 != null && !aaA0F.A02.A06) {
                aaA0F = aaA0F.A01;
            }
            if (iA04 == -1 || aaA0F.A01 == null || aaA0F.A01.A02.A04.A02 != iA04) {
                break;
            }
            aaA0F = aaA0F.A01;
        }
        boolean zA0T = A0T(aaA0F);
        aaA0F.A02 = A04(aaA0F.A02, aaA0F.A02.A04);
        if (!zA0T) {
            return true;
        }
        boolean zA0Q = A0Q();
        if (A0C[7].length() != 31) {
            throw new RuntimeException();
        }
        String[] strArr = A0C;
        strArr[3] = "GuDKwHudSgXHMcEdzJg";
        strArr[5] = "TrxgVcYEVqGsLQMDNrMk5TDxlvQhmk";
        return !zA0Q;
    }

    private boolean A0A(AA aa, AB ab) {
        AB ab2 = aa.A02;
        return ab2.A03 == ab.A03 && ab2.A02 == ab.A02 && ab2.A04.equals(ab.A04);
    }

    private boolean A0B(F6 f6, long j) {
        int iA00 = this.A07.A0A(f6.A02, this.A0A).A00();
        if (iA00 == 0) {
            return true;
        }
        int i = iA00 - 1;
        boolean zA02 = f6.A02();
        if (this.A0A.A09(i) != Long.MIN_VALUE) {
            return !zA02 && j == Long.MIN_VALUE;
        }
        int postrollAdCount = this.A0A.A01(i);
        if (postrollAdCount == -1) {
            return false;
        }
        if (zA02 && f6.A00 == i && f6.A01 == postrollAdCount + (-1)) {
            return true;
        }
        return !zA02 && this.A0A.A02(i) == postrollAdCount;
    }

    private boolean A0C(F6 f6, boolean z) {
        return !this.A07.A0C(this.A07.A0A(f6.A02, this.A0A).A00, this.A0B).A08 && this.A07.A0G(f6.A02, this.A0A, this.A0B, this.A01, this.A09) && z;
    }

    public final AA A0D() {
        AA aa = this.A05;
        if (aa != null) {
            if (aa == this.A06) {
                this.A06 = aa.A01;
            }
            this.A05.A0E();
            this.A00--;
            if (this.A00 == 0) {
                this.A04 = null;
                this.A08 = this.A05.A09;
                this.A03 = this.A05.A02.A04.A03;
            }
            this.A05 = this.A05.A01;
        } else {
            AA aa2 = this.A04;
            this.A05 = aa2;
            this.A06 = aa2;
        }
        return this.A05;
    }

    public final AA A0E() {
        AA aa = this.A06;
        C1662Hr.A04((aa == null || aa.A01 == null) ? false : true);
        if (A0C[7].length() != 31) {
            throw new RuntimeException();
        }
        String[] strArr = A0C;
        strArr[4] = "7koWfuH1ta1EVLUWQFGgmnLKJoN2uwxl";
        strArr[0] = "1LlHzPavDhI1SmiN1gPMgWkfsuEkohyV";
        this.A06 = this.A06.A01;
        return this.A06;
    }

    public final AA A0F() {
        return A0Q() ? this.A05 : this.A04;
    }

    public final AA A0G() {
        return this.A04;
    }

    public final AA A0H() {
        return this.A05;
    }

    public final AA A0I() {
        return this.A06;
    }

    @Nullable
    public final AB A0J(long j, AE ae) {
        AA aa = this.A04;
        if (aa == null) {
            return A05(ae);
        }
        return A03(aa, j);
    }

    public final AB A0K(AB ab, int i) {
        return A04(ab, ab.A04.A01(i));
    }

    public final InterfaceC2114Zo A0L(AS[] asArr, H1 h1, H4 h4, F8 f8, Object obj, AB ab) {
        long jA08;
        AA aa = this.A04;
        if (aa != null) {
            jA08 = aa.A08() + this.A04.A02.A01;
        } else {
            jA08 = ab.A03;
        }
        AA aa2 = new AA(asArr, jA08, h1, h4, f8, obj, ab);
        if (this.A04 != null) {
            C1662Hr.A04(A0Q());
            this.A04.A01 = aa2;
        }
        this.A08 = null;
        this.A04 = aa2;
        this.A00++;
        return aa2.A08;
    }

    public final F6 A0M(int i, long j) {
        return A07(i, j, A00(i));
    }

    public final void A0N(long j) {
        AA aa = this.A04;
        if (aa != null) {
            aa.A0H(j);
        }
    }

    public final void A0O(AZ az) {
        this.A07 = az;
    }

    public final void A0P(boolean z) {
        AA aaA0F = A0F();
        if (aaA0F != null) {
            this.A08 = z ? aaA0F.A09 : null;
            this.A03 = aaA0F.A02.A04.A03;
            aaA0F.A0E();
            A0T(aaA0F);
        } else if (!z) {
            this.A08 = null;
        }
        this.A05 = null;
        this.A04 = null;
        this.A06 = null;
        this.A00 = 0;
    }

    public final boolean A0Q() {
        return this.A05 != null;
    }

    public final boolean A0R() {
        AA aa = this.A04;
        return aa == null || (!aa.A02.A05 && this.A04.A0I() && this.A04.A02.A01 != -9223372036854775807L && this.A00 < 100);
    }

    public final boolean A0S(int i) {
        this.A01 = i;
        return A09();
    }

    public final boolean A0T(AA aa) {
        C1662Hr.A04(aa != null);
        boolean z = false;
        this.A04 = aa;
        while (aa.A01 != null) {
            aa = aa.A01;
            if (aa == this.A06) {
                this.A06 = this.A05;
                z = true;
            }
            aa.A0E();
            this.A00--;
        }
        this.A04.A01 = null;
        return z;
    }

    public final boolean A0U(InterfaceC2114Zo interfaceC2114Zo) {
        AA aa = this.A04;
        return aa != null && aa.A08 == interfaceC2114Zo;
    }

    public final boolean A0V(F6 f6, long j) {
        int iA04 = f6.A02;
        AA aa = null;
        for (AA aaA0F = A0F(); aaA0F != null; aaA0F = aaA0F.A01) {
            if (aa == null) {
                aaA0F.A02 = A0K(aaA0F.A02, iA04);
            } else {
                if (iA04 != -1) {
                    Object obj = aaA0F.A09;
                    if (A0C[2].charAt(30) != 'V') {
                        throw new RuntimeException();
                    }
                    String[] strArr = A0C;
                    strArr[4] = "cRCq0i1JCmFgPvSHr0NI30IAvGtOkPUO";
                    strArr[0] = "aqPjT6JpLbsnsfh6iIpVbm4IivKwupA2";
                    if (obj.equals(this.A07.A0B(iA04, this.A0A, true).A03)) {
                        AB abA03 = A03(aa, j);
                        if (abA03 == null) {
                            return true ^ A0T(aa);
                        }
                        aaA0F.A02 = A0K(aaA0F.A02, iA04);
                        if (!A0A(aaA0F, abA03)) {
                            return true ^ A0T(aa);
                        }
                    }
                }
                return true ^ A0T(aa);
            }
            if (aaA0F.A02.A06) {
                iA04 = this.A07.A04(iA04, this.A0A, this.A0B, this.A01, this.A09);
            }
            aa = aaA0F;
        }
        return true;
    }

    public final boolean A0W(boolean z) {
        this.A09 = z;
        return A09();
    }
}
