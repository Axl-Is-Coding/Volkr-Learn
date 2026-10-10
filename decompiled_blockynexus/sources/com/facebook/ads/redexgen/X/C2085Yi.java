package com.facebook.ads.redexgen.X;

import com.facebook.ads.internal.exoplayer2.Format;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Yi, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C2085Yi extends D6 {
    public static byte[] A05;
    public static String[] A06;
    public int A00;
    public D8 A01;
    public DA A02;
    public DC A03;
    public boolean A04;

    static {
        A05();
        A04();
    }

    public static String A03(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A05, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 51);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A04() {
        A05 = new byte[]{61, 41, 56, 53, 51, 115, 42, 51, 46, 62, 53, 47};
    }

    public static void A05() {
        A06 = new String[]{"Wz5kpI", "Qu4rCXWHGrZxyCLJ91nJYm9HwbbNBaAB", "jcFxTUNQ9mBSPSNjMUJY07wGvzfGS2C0", "wRecpgZSCUfboq2e81nqZjs5B", "2wu5mHiieWPMNFHGOEN0thCm6IWO9Xya", "P54DBngSoaRE6HRNMaW6H3WNUnBy8S0x", "u1kez8Hi5IXqm6uzKKQ3Ad3inAYpSzVQ", "yOq9tmgmQLY5WHe8QvjpkSndY9PHYfSY"};
    }

    public static int A00(byte b2, int i, int i2) {
        return (b2 >> i2) & (255 >>> (8 - i));
    }

    public static int A01(byte b2, D8 d8) {
        if (!d8.A04[A00(b2, d8.A00, 1)].A03) {
            return d8.A02.A03;
        }
        return d8.A02.A04;
    }

    private final D8 A02(IG ig) throws IOException {
        if (this.A03 == null) {
            this.A03 = DD.A04(ig);
            return null;
        }
        DA da = this.A02;
        if (A06[7].charAt(1) != 'O') {
            throw new RuntimeException();
        }
        String[] strArr = A06;
        strArr[3] = "EnVW7ymY5FyvrkHYKpVAYit2P";
        strArr[0] = "59lsEN";
        if (da == null) {
            this.A02 = DD.A03(ig);
            return null;
        }
        byte[] bArr = new byte[ig.A08()];
        System.arraycopy(ig.A00, 0, bArr, 0, ig.A08());
        return new D8(this.A03, this.A02, bArr, DD.A0D(ig, this.A03.A05), DD.A00(r4.length - 1));
    }

    public static void A06(IG ig, long j) {
        ig.A0Y(ig.A08() + 4);
        ig.A00[ig.A08() - 4] = (byte) (j & 255);
        ig.A00[ig.A08() - 3] = (byte) ((j >>> 8) & 255);
        ig.A00[ig.A08() - 2] = (byte) ((j >>> 16) & 255);
        ig.A00[ig.A08() - 1] = (byte) (255 & (j >>> 24));
    }

    public static boolean A07(IG ig) {
        try {
            return DD.A0B(1, ig, true);
        } catch (AD unused) {
            return false;
        }
    }

    @Override // com.facebook.ads.redexgen.X.D6
    public final long A08(IG ig) {
        if ((ig.A00[0] & 1) == 1) {
            return -1L;
        }
        int iA01 = A01(ig.A00[0], this.A01);
        int i = this.A04 ? (this.A00 + iA01) / 4 : 0;
        A06(ig, i);
        this.A04 = true;
        this.A00 = iA01;
        return i;
    }

    @Override // com.facebook.ads.redexgen.X.D6
    public final void A09(long j) {
        super.A09(j);
        this.A04 = j != 0;
        DC dc = this.A03;
        this.A00 = dc != null ? dc.A03 : 0;
    }

    @Override // com.facebook.ads.redexgen.X.D6
    public final void A0A(boolean z) {
        super.A0A(z);
        if (z) {
            this.A01 = null;
            this.A03 = null;
            this.A02 = null;
        }
        this.A00 = 0;
        this.A04 = false;
    }

    @Override // com.facebook.ads.redexgen.X.D6
    public final boolean A0B(IG ig, long j, D5 d5) throws InterruptedException, IOException {
        if (this.A01 != null) {
            String[] strArr = A06;
            if (strArr[5].charAt(2) != strArr[1].charAt(2)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A06;
            strArr2[2] = "mO0nJ77ourwQSXFSw31DnFJId1Q3DZ07";
            strArr2[2] = "mO0nJ77ourwQSXFSw31DnFJId1Q3DZ07";
            return false;
        }
        this.A01 = A02(ig);
        if (this.A01 == null) {
            return true;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.A01.A02.A09);
        arrayList.add(this.A01.A03);
        d5.A00 = Format.A07(null, A03(0, 12, 111), null, this.A01.A02.A02, -1, this.A01.A02.A05, (int) this.A01.A02.A06, arrayList, null, 0, null);
        return true;
    }
}
