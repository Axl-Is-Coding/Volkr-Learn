package com.facebook.ads.redexgen.X;

import com.facebook.ads.internal.exoplayer2.drm.DrmInitData;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Cn, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1536Cn {
    public static String[] A0A;
    public int A00;
    public int A01;
    public int A02;
    public int A03;
    public C1530Ch A04;
    public C1545Cw A05;
    public final CM A06;
    public final C1547Cy A07 = new C1547Cy();
    public final IG A09 = new IG(1);
    public final IG A08 = new IG();

    static {
        A02();
    }

    public static void A02() {
        A0A = new String[]{"3clh", "In2mDQuCVOg3ihkf16hWdIIfuM6sFv5F", "x02l2Vae1akitXdZsfkSin5rPssADgyF", "voDg", "hUzVtg6QDcg3AayaGyy4Y5hfj2RvIx7z", "AYA0HHhZRav1tOhmR967ChnIf", "RG8", "bQ6q4wCv1qa3psjbWrVNO9D1ADq5zdw2"};
    }

    public C1536Cn(CM cm) {
        this.A06 = cm;
    }

    private C1546Cx A00() {
        int i = this.A07.A07.A02;
        if (this.A07.A08 != null) {
            C1547Cy c1547Cy = this.A07;
            String[] strArr = A0A;
            if (strArr[1].charAt(10) != strArr[4].charAt(10)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0A;
            strArr2[1] = "mhitCTNVD2gTcCiZ9jaRAXWaAA0g9dMw";
            strArr2[4] = "MwiogHOaq0gqmibDd9x4nD1rPGRVV4il";
            return c1547Cy.A08;
        }
        return this.A05.A00(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A01() {
        if (!this.A07.A0A) {
            return;
        }
        IG ig = this.A07.A09;
        C1546Cx c1546CxA00 = A00();
        if (c1546CxA00.A00 != 0) {
            ig.A0a(c1546CxA00.A00);
        }
        if (this.A07.A0H[this.A01]) {
            ig.A0a(ig.A0J() * 6);
        }
    }

    public final int A04() {
        IG ig;
        int length;
        if (!this.A07.A0A) {
            return 0;
        }
        C1546Cx c1546CxA00 = A00();
        if (c1546CxA00.A00 != 0) {
            ig = this.A07.A09;
            length = c1546CxA00.A00;
        } else {
            byte[] bArr = c1546CxA00.A04;
            String[] strArr = A0A;
            if (strArr[3].length() != strArr[0].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0A;
            strArr2[1] = "Pfb0S5CneQgYrjeMjOJgtR7T7eyOdr1R";
            strArr2[4] = "zLY8KEVp0MgNhcadjz3HGMWIKnjSbq4p";
            this.A08.A0c(bArr, bArr.length);
            ig = this.A08;
            length = bArr.length;
        }
        boolean[] zArr = this.A07.A0H;
        int vectorSize = this.A01;
        boolean z = zArr[vectorSize];
        byte[] bArr2 = this.A09.A00;
        int vectorSize2 = z ? 128 : 0;
        bArr2[0] = (byte) (vectorSize2 | length);
        this.A09.A0Z(0);
        this.A06.ACx(this.A09, 1);
        this.A06.ACx(ig, length);
        if (!z) {
            int vectorSize3 = length + 1;
            return vectorSize3;
        }
        IG ig2 = this.A07.A09;
        int iA0J = ig2.A0J();
        ig2.A0a(-2);
        int subsampleCount = iA0J * 6;
        int i = subsampleCount + 2;
        this.A06.ACx(ig2, i);
        int subsampleDataLength = length + 1;
        return subsampleDataLength + i;
    }

    public final void A05() {
        this.A07.A02();
        this.A01 = 0;
        this.A02 = 0;
        this.A00 = 0;
        this.A03 = 0;
    }

    public final void A06(long j) {
        long jA01 = C14729o.A01(j);
        for (int i = this.A01; i < this.A07.A00 && this.A07.A01(i) < jA01; i++) {
            boolean[] zArr = this.A07.A0I;
            String[] strArr = A0A;
            if (strArr[3].length() != strArr[0].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0A;
            strArr2[1] = "yYyJ6pNJ0kgjmttu9OhrBT2GfQD0mn7b";
            strArr2[4] = "spdSEizAECgh3deYwyaUKu4kY7nul1tj";
            if (zArr[i]) {
                this.A03 = i;
            }
        }
    }

    public final void A07(DrmInitData drmInitData) {
        C1546Cx c1546CxA00 = this.A05.A00(this.A07.A07.A02);
        this.A06.A5I(this.A05.A07.A0J(drmInitData.A03(c1546CxA00 != null ? c1546CxA00.A02 : null)));
    }

    public final void A08(C1545Cw c1545Cw, C1530Ch c1530Ch) {
        this.A05 = (C1545Cw) C1662Hr.A01(c1545Cw);
        this.A04 = (C1530Ch) C1662Hr.A01(c1530Ch);
        this.A06.A5I(c1545Cw.A07);
        A05();
    }

    public final boolean A09() {
        this.A01++;
        this.A00++;
        int i = this.A00;
        int[] iArr = this.A07.A0E;
        int i2 = this.A02;
        if (i != iArr[i2]) {
            return true;
        }
        this.A02 = i2 + 1;
        String[] strArr = A0A;
        if (strArr[2].charAt(8) != strArr[7].charAt(8)) {
            throw new RuntimeException();
        }
        String[] strArr2 = A0A;
        strArr2[6] = "24SILmm";
        strArr2[6] = "24SILmm";
        this.A00 = 0;
        return false;
    }
}
