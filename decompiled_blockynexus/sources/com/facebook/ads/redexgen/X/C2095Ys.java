package com.facebook.ads.redexgen.X;

import com.facebook.ads.internal.exoplayer2.Format;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Ys, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C2095Ys implements DG {
    public static byte[] A06;
    public static String[] A07;
    public int A00;
    public int A01;
    public long A02;
    public boolean A03;
    public final List<DR> A04;
    public final CM[] A05;

    static {
        A02();
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A06, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 76);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A06 = new byte[]{117, 100, 100, 120, 125, 119, 117, 96, 125, 123, 122, 59, 112, 98, 118, 103, 97, 118, 103};
    }

    public static void A02() {
        A07 = new String[]{"Jiy", "2wEJIBTa4RvP8yrIwKSodHRjo9", "akcZBAKpF", "EuZb8kUx1OZ", "XeLxT4hCbfpB8vk3L3qpbFThh9kK", "oaj", "R8TqjunyKtvNfOkCV", "nGIequV"};
    }

    public C2095Ys(List<DR> list) {
        this.A04 = list;
        this.A05 = new CM[list.size()];
    }

    private boolean A03(IG ig, int i) {
        if (ig.A05() == 0) {
            return false;
        }
        if (ig.A0F() != i) {
            this.A03 = false;
        }
        this.A00--;
        return this.A03;
    }

    @Override // com.facebook.ads.redexgen.X.DG
    public final void A48(IG ig) {
        if (this.A03) {
            if (this.A00 == 2 && !A03(ig, 32)) {
                return;
            }
            if (this.A00 == 1 && !A03(ig, 0)) {
                return;
            }
            int iA07 = ig.A07();
            int iA05 = ig.A05();
            for (CM output : this.A05) {
                ig.A0Z(iA07);
                output.ACx(ig, iA05);
            }
            this.A01 += iA05;
        }
    }

    @Override // com.facebook.ads.redexgen.X.DG
    public final void A4U(CC cc, DU du) {
        int i = 0;
        while (true) {
            CM[] cmArr = this.A05;
            String[] strArr = A07;
            if (strArr[7].length() == strArr[1].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A07;
            strArr2[6] = "6Yign7KSgGvnaQ3UG";
            strArr2[0] = "Q7U";
            if (i < cmArr.length) {
                DR dr = this.A04.get(i);
                du.A06();
                CM cmADr = cc.ADr(du.A04(), 3);
                cmADr.A5I(Format.A0A(du.A05(), A00(0, 19, 88), null, -1, 0, Collections.singletonList(dr.A02), dr.A01, null));
                this.A05[i] = cmADr;
                i++;
            } else {
                return;
            }
        }
    }

    @Override // com.facebook.ads.redexgen.X.DG
    public final void ABo() {
        if (this.A03) {
            for (CM cm : this.A05) {
                cm.ACy(this.A02, 1, this.A01, 0, null);
            }
            this.A03 = false;
        }
    }

    @Override // com.facebook.ads.redexgen.X.DG
    public final void ABp(long j, boolean z) {
        if (!z) {
            return;
        }
        this.A03 = true;
        this.A02 = j;
        this.A01 = 0;
        this.A00 = 2;
    }

    @Override // com.facebook.ads.redexgen.X.DG
    public final void AD1() {
        this.A03 = false;
    }
}
