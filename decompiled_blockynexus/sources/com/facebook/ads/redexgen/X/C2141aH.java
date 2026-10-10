package com.facebook.ads.redexgen.X;

import android.text.SpannableStringBuilder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.aH, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C2141aH implements G6 {
    public static byte[] A04;
    public final int A00;
    public final List<C2140aG> A01;
    public final long[] A02;
    public final long[] A03;

    static {
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A04, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 125);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A04 = new byte[]{5};
    }

    public C2141aH(List<C2140aG> list) {
        this.A01 = list;
        this.A00 = list.size();
        this.A02 = new long[this.A00 * 2];
        for (int i = 0; i < this.A00; i++) {
            C2140aG c2140aG = list.get(i);
            int i2 = i * 2;
            this.A02[i2] = c2140aG.A01;
            this.A02[i2 + 1] = c2140aG.A00;
        }
        long[] jArr = this.A02;
        this.A03 = Arrays.copyOf(jArr, jArr.length);
        Arrays.sort(this.A03);
    }

    @Override // com.facebook.ads.redexgen.X.G6
    public final List<G5> A5w(long j) {
        ArrayList arrayList = null;
        C2140aG cue = null;
        SpannableStringBuilder normalCueTextBuilder = null;
        for (int i = 0; i < this.A00; i++) {
            long[] jArr = this.A02;
            if (jArr[i * 2] <= j && j < jArr[(i * 2) + 1]) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                C2140aG c2140aG = this.A01.get(i);
                if (c2140aG.A00()) {
                    if (cue == null) {
                        cue = c2140aG;
                    } else {
                        String strA00 = A00(0, 1, 126);
                        if (normalCueTextBuilder == null) {
                            normalCueTextBuilder = new SpannableStringBuilder();
                            normalCueTextBuilder.append(cue.A0C).append((CharSequence) strA00).append(c2140aG.A0C);
                        } else {
                            normalCueTextBuilder.append((CharSequence) strA00).append(c2140aG.A0C);
                        }
                    }
                } else {
                    arrayList.add(c2140aG);
                }
            }
        }
        if (normalCueTextBuilder != null) {
            arrayList.add(new C2140aG(normalCueTextBuilder));
        } else if (cue != null) {
            arrayList.add(cue);
        }
        if (arrayList != null) {
            return arrayList;
        }
        return Collections.emptyList();
    }

    @Override // com.facebook.ads.redexgen.X.G6
    public final long A6L(int i) {
        boolean z = true;
        C1662Hr.A03(i >= 0);
        if (i >= this.A03.length) {
            z = false;
        }
        C1662Hr.A03(z);
        return this.A03[i];
    }

    @Override // com.facebook.ads.redexgen.X.G6
    public final int A6M() {
        return this.A03.length;
    }

    @Override // com.facebook.ads.redexgen.X.G6
    public final int A6f(long j) {
        int iA0A = IW.A0A(this.A03, j, false, false);
        if (iA0A < this.A03.length) {
            return iA0A;
        }
        return -1;
    }
}
