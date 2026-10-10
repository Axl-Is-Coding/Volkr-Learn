package com.facebook.ads.redexgen.X;

import androidx.annotation.Nullable;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Xf, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C2056Xf implements InterfaceC1502At {
    public static String[] A08;
    public boolean A04;
    public boolean A05;

    @Nullable
    public int[] A06;

    @Nullable
    public int[] A07;
    public ByteBuffer A02 = InterfaceC1502At.A00;
    public ByteBuffer A03 = InterfaceC1502At.A00;
    public int A00 = -1;
    public int A01 = -1;

    static {
        A00();
    }

    public static void A00() {
        A08 = new String[]{"hI95CJvP", "e7uFmzv8JlxhzV9w6wWiWm3C", "0BfqaNpqjs7ROgqNLFdYFDMF2kIE2JVl", "01nBjZj9wdoXPRYWJREYdbIjHTCf93fz", "xbIGt4PZ2jMEHXqvTGNBXf5J", "qzrNEKfdD0Je3OCcD1S0Cr1qEsV7v9mi", "0sM3QN", "C1cp7SniMnLQ2eyeNR7DTGSoW6Un2OTz"};
    }

    public final void A01(@Nullable int[] iArr) {
        this.A07 = iArr;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1502At
    public final boolean A47(int i, int i2, int i3) throws C1501As {
        boolean z = !Arrays.equals(this.A07, this.A06);
        this.A06 = this.A07;
        if (this.A06 == null) {
            this.A04 = false;
            return z;
        }
        if (i3 == 2) {
            if (!z && this.A01 == i) {
                int i4 = this.A00;
                String[] strArr = A08;
                if (strArr[6].length() == strArr[0].length()) {
                    throw new RuntimeException();
                }
                String[] strArr2 = A08;
                strArr2[6] = "gVI3SL";
                strArr2[0] = "1HQF1tqI";
                if (i4 == i2) {
                    return false;
                }
            }
            this.A01 = i;
            this.A00 = i2;
            this.A04 = i2 != this.A06.length;
            int i5 = 0;
            while (true) {
                int[] iArr = this.A06;
                if (i5 >= iArr.length) {
                    return true;
                }
                int i6 = iArr[i5];
                if (i6 < i2) {
                    this.A04 |= i6 != i5;
                    i5++;
                } else {
                    throw new C1501As(i, i2, i3);
                }
            }
        } else {
            throw new C1501As(i, i2, i3);
        }
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1502At
    public final ByteBuffer A6h() {
        ByteBuffer byteBuffer = this.A03;
        this.A03 = InterfaceC1502At.A00;
        return byteBuffer;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1502At
    public final int A6i() {
        int[] iArr = this.A06;
        return iArr == null ? this.A00 : iArr.length;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1502At
    public final int A6j() {
        return 2;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1502At
    public final int A6k() {
        return this.A01;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1502At
    public final boolean A7j() {
        return this.A04;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1502At
    public final boolean A7n() {
        return this.A05 && this.A03 == InterfaceC1502At.A00;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1502At
    public final void ACD() {
        this.A05 = true;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1502At
    public final void ACE(ByteBuffer byteBuffer) {
        C1662Hr.A04(this.A06 != null);
        int outputSize = byteBuffer.position();
        int iLimit = byteBuffer.limit();
        int limit = this.A00;
        int i = (iLimit - outputSize) / (limit * 2);
        int frameCount = this.A06.length;
        int i2 = frameCount * i * 2;
        int frameCount2 = this.A02.capacity();
        if (frameCount2 < i2) {
            this.A02 = ByteBuffer.allocateDirect(i2).order(ByteOrder.nativeOrder());
        } else {
            this.A02.clear();
        }
        while (outputSize < iLimit) {
            for (int frameCount3 : this.A06) {
                int channelIndex = frameCount3 * 2;
                this.A02.putShort(byteBuffer.getShort(channelIndex + outputSize));
            }
            outputSize += this.A00 * 2;
        }
        byteBuffer.position(iLimit);
        this.A02.flip();
        this.A03 = this.A02;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1502At
    public final void flush() {
        this.A03 = InterfaceC1502At.A00;
        this.A05 = false;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1502At
    public final void reset() {
        flush();
        this.A02 = InterfaceC1502At.A00;
        this.A00 = -1;
        this.A01 = -1;
        this.A06 = null;
        this.A07 = null;
        this.A04 = false;
    }
}
