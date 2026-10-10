package com.facebook.ads.redexgen.X;

import androidx.annotation.Nullable;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ShortBuffer;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Xo, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C2065Xo implements InterfaceC1502At {
    public static String[] A0D;
    public long A06;
    public long A07;

    @Nullable
    public BO A08;
    public boolean A0C;
    public float A01 = 1.0f;
    public float A00 = 1.0f;
    public int A02 = -1;
    public int A05 = -1;
    public int A03 = -1;
    public ByteBuffer A09 = InterfaceC1502At.A00;
    public ShortBuffer A0B = this.A09.asShortBuffer();
    public ByteBuffer A0A = InterfaceC1502At.A00;
    public int A04 = -1;

    static {
        A00();
    }

    public static void A00() {
        A0D = new String[]{"iVI49d2ZLsEdnN", "8nt9Mx90pYcLgm8jwIqfRxnuNB", "N5EnT7xPV04alRStuSSEb4qxGw0ypgBS", "CZFk7KMkAj1VPwfzqXgnV4RMFN6v0v1b", "0r4SPeKqFHrxpG", "Bbc1ECWkbstPDX5EGN6JJHjdPo9FJmAx", "C6RSY0Y2UTdbfyI9HBBCvYbiYc", "niyGYsc3TbIZXUeN92sM43TjCNQsZLKY"};
    }

    public final float A01(float f2) {
        float fA00 = IW.A00(f2, 0.1f, 8.0f);
        if (this.A00 != fA00) {
            this.A00 = fA00;
            this.A08 = null;
        }
        flush();
        return fA00;
    }

    public final float A02(float f2) {
        float fA00 = IW.A00(f2, 0.1f, 8.0f);
        if (this.A01 != fA00) {
            this.A01 = fA00;
            this.A08 = null;
        }
        flush();
        return fA00;
    }

    public final long A03(long j) {
        long j2 = this.A07;
        if (j2 >= 1024) {
            int i = this.A03;
            int i2 = this.A05;
            if (i == i2) {
                return IW.A0F(j, this.A06, j2);
            }
            return IW.A0F(j, this.A06 * ((long) i), j2 * ((long) i2));
        }
        return (long) (((double) this.A01) * j);
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1502At
    public final boolean A47(int i, int i2, int i3) throws C1501As {
        if (i3 == 2) {
            int i4 = this.A04;
            if (i4 == -1) {
                i4 = i;
            }
            if (this.A05 == i && this.A02 == i2 && this.A03 == i4) {
                return false;
            }
            this.A05 = i;
            this.A02 = i2;
            this.A03 = i4;
            this.A08 = null;
            return true;
        }
        throw new C1501As(i, i2, i3);
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1502At
    public final ByteBuffer A6h() {
        ByteBuffer byteBuffer = this.A0A;
        this.A0A = InterfaceC1502At.A00;
        return byteBuffer;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1502At
    public final int A6i() {
        return this.A02;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1502At
    public final int A6j() {
        return 2;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1502At
    public final int A6k() {
        return this.A03;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1502At
    public final boolean A7j() {
        if (this.A05 != -1) {
            if (Math.abs(this.A01 - 1.0f) < 0.01f) {
                float fAbs = Math.abs(this.A00 - 1.0f);
                String[] strArr = A0D;
                if (strArr[6].length() != strArr[1].length()) {
                    throw new RuntimeException();
                }
                String[] strArr2 = A0D;
                strArr2[4] = "vE55EECrsMoThx";
                strArr2[0] = "BaJHYxULwHsid1";
                if (fAbs >= 0.01f || this.A03 != this.A05) {
                }
            }
            return true;
        }
        return false;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1502At
    public final boolean A7n() {
        BO bo;
        return this.A0C && ((bo = this.A08) == null || bo.A0I() == 0);
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1502At
    public final void ACD() {
        C1662Hr.A04(this.A08 != null);
        this.A08.A0K();
        this.A0C = true;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1502At
    public final void ACE(ByteBuffer byteBuffer) {
        C1662Hr.A04(this.A08 != null);
        if (byteBuffer.hasRemaining()) {
            ShortBuffer shortBufferAsShortBuffer = byteBuffer.asShortBuffer();
            int iRemaining = byteBuffer.remaining();
            this.A06 += (long) iRemaining;
            this.A08.A0M(shortBufferAsShortBuffer);
            byteBuffer.position(byteBuffer.position() + iRemaining);
        }
        int iA0I = this.A08.A0I() * this.A02 * 2;
        if (iA0I > 0) {
            if (this.A09.capacity() < iA0I) {
                this.A09 = ByteBuffer.allocateDirect(iA0I).order(ByteOrder.nativeOrder());
                this.A0B = this.A09.asShortBuffer();
            } else {
                this.A09.clear();
                this.A0B.clear();
            }
            this.A08.A0L(this.A0B);
            this.A07 += (long) iA0I;
            this.A09.limit(iA0I);
            this.A0A = this.A09;
        }
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1502At
    public final void flush() {
        if (A7j()) {
            BO bo = this.A08;
            if (bo == null) {
                this.A08 = new BO(this.A05, this.A02, this.A01, this.A00, this.A03);
            } else {
                bo.A0J();
            }
        }
        this.A0A = InterfaceC1502At.A00;
        this.A06 = 0L;
        this.A07 = 0L;
        this.A0C = false;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1502At
    public final void reset() {
        this.A01 = 1.0f;
        this.A00 = 1.0f;
        this.A02 = -1;
        this.A05 = -1;
        this.A03 = -1;
        this.A09 = InterfaceC1502At.A00;
        this.A0B = this.A09.asShortBuffer();
        this.A0A = InterfaceC1502At.A00;
        this.A04 = -1;
        this.A08 = null;
        this.A06 = 0L;
        this.A07 = 0L;
        this.A0C = false;
    }
}
