package com.facebook.ads.redexgen.X;

import android.util.Log;
import com.facebook.ads.internal.exoplayer2.Format;
import java.util.Arrays;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Yw, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C2099Yw implements DG {
    public static byte[] A06;
    public int A00;
    public int A01;
    public long A02;
    public CM A03;
    public boolean A04;
    public final IG A05 = new IG(10);

    static {
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A06, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 123);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A06 = new byte[]{25, 62, 72, 56, 54, 71, 57, 62, 67, 60, -11, 62, 67, 75, 54, 65, 62, 57, -11, 30, 25, 8, -11, 73, 54, 60, -16, 11, -38, -7, 12, 8, 11, 12, 25, 89, 104, 104, 100, 97, 91, 89, 108, 97, 103, 102, 39, 97, 92, 43};
    }

    @Override // com.facebook.ads.redexgen.X.DG
    public final void A48(IG ig) {
        if (!this.A04) {
            return;
        }
        int iA05 = ig.A05();
        int i = this.A00;
        if (i < 10) {
            int iMin = Math.min(iA05, 10 - i);
            System.arraycopy(ig.A00, ig.A07(), this.A05.A00, this.A00, iMin);
            if (this.A00 + iMin == 10) {
                this.A05.A0Z(0);
                if (73 != this.A05.A0F() || 68 != this.A05.A0F() || 51 != this.A05.A0F()) {
                    Log.w(A00(26, 9, 44), A00(0, 26, 90));
                    this.A04 = false;
                    return;
                } else {
                    this.A05.A0a(3);
                    this.A01 = this.A05.A0E() + 10;
                }
            }
        }
        int iMin2 = Math.min(iA05, this.A01 - this.A00);
        this.A03.ACx(ig, iMin2);
        this.A00 += iMin2;
    }

    @Override // com.facebook.ads.redexgen.X.DG
    public final void A4U(CC cc, DU du) {
        du.A06();
        this.A03 = cc.ADr(du.A04(), 4);
        this.A03.A5I(Format.A0B(du.A05(), A00(35, 15, 125), null, -1, null));
    }

    @Override // com.facebook.ads.redexgen.X.DG
    public final void ABo() {
        int i;
        if (!this.A04 || (i = this.A01) == 0 || this.A00 != i) {
            return;
        }
        this.A03.ACy(this.A02, 1, i, 0, null);
        this.A04 = false;
    }

    @Override // com.facebook.ads.redexgen.X.DG
    public final void ABp(long j, boolean z) {
        if (!z) {
            return;
        }
        this.A04 = true;
        this.A02 = j;
        this.A01 = 0;
        this.A00 = 0;
    }

    @Override // com.facebook.ads.redexgen.X.DG
    public final void AD1() {
        this.A04 = false;
    }
}
