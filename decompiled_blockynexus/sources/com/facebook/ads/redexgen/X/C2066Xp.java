package com.facebook.ads.redexgen.X;

import com.sandboxol.center.config.VipSubscribeStatus;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Xp, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C2066Xp implements InterfaceC1502At {
    public static String[] A0B;
    public int A01;
    public int A02;
    public int A04;
    public int A05;
    public boolean A08;
    public boolean A09;
    public ByteBuffer A06 = InterfaceC1502At.A00;
    public ByteBuffer A07 = InterfaceC1502At.A00;
    public int A00 = -1;
    public int A03 = -1;
    public byte[] A0A = new byte[0];

    static {
        A00();
    }

    public static void A00() {
        A0B = new String[]{"r", VipSubscribeStatus.SUBSCRIPTION_PURCHASED, "I5O53mReJYgY4Jy6Te4gmLvwKot1lmjj", "5S", "zkj4NaHy3qG", "EJmI2pRz04", "Xqte5C1rywD", "1UQbdYDvzSk5pKr4kl4SZHHNZLcQI2bC"};
    }

    public final void A01(int i, int i2) {
        this.A05 = i;
        this.A04 = i2;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1502At
    public final boolean A47(int i, int i2, int i3) throws C1501As {
        if (i3 == 2) {
            this.A00 = i2;
            this.A03 = i;
            int i4 = this.A04;
            this.A0A = new byte[i4 * i2 * 2];
            this.A01 = 0;
            int i5 = this.A05;
            this.A02 = i5 * i2 * 2;
            boolean z = this.A09;
            this.A09 = (i5 == 0 && i4 == 0) ? false : true;
            return z != this.A09;
        }
        throw new C1501As(i, i2, i3);
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1502At
    public final ByteBuffer A6h() {
        ByteBuffer byteBuffer = this.A07;
        this.A07 = InterfaceC1502At.A00;
        return byteBuffer;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1502At
    public final int A6i() {
        return this.A00;
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
        return this.A09;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1502At
    public final boolean A7n() {
        return this.A08 && this.A07 == InterfaceC1502At.A00;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1502At
    public final void ACD() {
        this.A08 = true;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1502At
    public final void ACE(ByteBuffer byteBuffer) {
        int remaining = byteBuffer.position();
        int trimBytes = byteBuffer.limit();
        int i = trimBytes - remaining;
        int iMin = Math.min(i, this.A02);
        this.A02 -= iMin;
        byteBuffer.position(remaining + iMin);
        if (this.A02 > 0) {
            return;
        }
        int remainingBytesToOutput = i - iMin;
        int length = (this.A01 + remainingBytesToOutput) - this.A0A.length;
        if (this.A06.capacity() < length) {
            ByteBuffer byteBufferAllocateDirect = ByteBuffer.allocateDirect(length);
            if (A0B[3].length() == 18) {
                throw new RuntimeException();
            }
            String[] strArr = A0B;
            strArr[3] = "Xd8Hzn34smT7X798Wj1HPKCywQ0V";
            strArr[3] = "Xd8Hzn34smT7X798Wj1HPKCywQ0V";
            this.A06 = byteBufferAllocateDirect.order(ByteOrder.nativeOrder());
        } else {
            this.A06.clear();
        }
        int remaining2 = IW.A06(length, 0, this.A01);
        this.A06.put(this.A0A, 0, remaining2);
        int iA06 = IW.A06(length - remaining2, 0, remainingBytesToOutput);
        int inputBufferBytesToOutput = byteBuffer.position();
        byteBuffer.limit(inputBufferBytesToOutput + iA06);
        this.A06.put(byteBuffer);
        byteBuffer.limit(trimBytes);
        int remainingBytesToOutput2 = remainingBytesToOutput - iA06;
        int inputBufferBytesToOutput2 = this.A01;
        this.A01 = inputBufferBytesToOutput2 - remaining2;
        byte[] bArr = this.A0A;
        int inputBufferBytesToOutput3 = this.A01;
        System.arraycopy(bArr, remaining2, bArr, 0, inputBufferBytesToOutput3);
        byte[] bArr2 = this.A0A;
        int inputBufferBytesToOutput4 = this.A01;
        byteBuffer.get(bArr2, inputBufferBytesToOutput4, remainingBytesToOutput2);
        int inputBufferBytesToOutput5 = this.A01;
        this.A01 = inputBufferBytesToOutput5 + remainingBytesToOutput2;
        this.A06.flip();
        this.A07 = this.A06;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1502At
    public final void flush() {
        this.A07 = InterfaceC1502At.A00;
        this.A08 = false;
        this.A02 = 0;
        this.A01 = 0;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1502At
    public final void reset() {
        flush();
        this.A06 = InterfaceC1502At.A00;
        this.A00 = -1;
        this.A03 = -1;
        this.A0A = new byte[0];
    }
}
