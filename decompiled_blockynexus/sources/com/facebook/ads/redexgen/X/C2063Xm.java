package com.facebook.ads.redexgen.X;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Xm, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C2063Xm implements InterfaceC1502At {
    public static String[] A0E;
    public int A00;
    public int A02;
    public int A03;
    public int A05;
    public long A06;
    public boolean A09;
    public boolean A0A;
    public boolean A0B;
    public ByteBuffer A07 = InterfaceC1502At.A00;
    public ByteBuffer A08 = InterfaceC1502At.A00;
    public int A01 = -1;
    public int A04 = -1;
    public byte[] A0C = new byte[0];
    public byte[] A0D = new byte[0];

    static {
        A03();
    }

    public static void A03() {
        A0E = new String[]{"tvm2mqRs7a3ehYHdc1yBQoSNsWCnK", "tOWfSaULM8EnbecBF3SZtCA", "iNgvpQne2", "1AcoT6GEPIUQ3JZIKBz6KhI4GHeuy79P", "lryhUlLd6yxpw4rz006xnThMb", "3cZRB", "VTjWgXugqiR9aqruhTtZOoVTfcJyB76i", "EEKliZG5v6PVzs3xPcyqxwhc3FAivYta"};
    }

    private int A00(long j) {
        return (int) ((((long) this.A04) * j) / 1000000);
    }

    private int A01(ByteBuffer byteBuffer) {
        for (int iLimit = byteBuffer.limit() - 1; iLimit >= byteBuffer.position(); iLimit -= 2) {
            if (Math.abs((int) byteBuffer.get(iLimit)) > 4) {
                int i = this.A00;
                return ((iLimit / i) * i) + i;
            }
        }
        int iPosition = byteBuffer.position();
        String[] strArr = A0E;
        if (strArr[5].length() == strArr[1].length()) {
            throw new RuntimeException();
        }
        String[] strArr2 = A0E;
        strArr2[5] = "KbmXU";
        strArr2[1] = "sStp2WQndpDzY5UDNElAkrU";
        return iPosition;
    }

    private int A02(ByteBuffer byteBuffer) {
        for (int iPosition = byteBuffer.position() + 1; iPosition < byteBuffer.limit(); iPosition += 2) {
            if (Math.abs((int) byteBuffer.get(iPosition)) > 4) {
                int i = this.A00;
                return i * (iPosition / i);
            }
        }
        return byteBuffer.limit();
    }

    private void A04(int i) {
        if (this.A07.capacity() < i) {
            this.A07 = ByteBuffer.allocateDirect(i).order(ByteOrder.nativeOrder());
        } else {
            this.A07.clear();
        }
        if (i > 0) {
            this.A0A = true;
        }
    }

    private void A05(ByteBuffer byteBuffer) {
        A04(byteBuffer.remaining());
        this.A07.put(byteBuffer);
        this.A07.flip();
        this.A08 = this.A07;
    }

    private void A06(ByteBuffer byteBuffer) {
        int maybeSilenceInputSize = byteBuffer.limit();
        int iA02 = A02(byteBuffer);
        int iPosition = iA02 - byteBuffer.position();
        byte[] bArr = this.A0C;
        int length = bArr.length;
        int maybeSilenceBufferRemaining = this.A02;
        int i = length - maybeSilenceBufferRemaining;
        if (iA02 < maybeSilenceInputSize && iPosition < i) {
            A0A(bArr, maybeSilenceBufferRemaining);
            this.A02 = 0;
            this.A05 = 0;
            return;
        }
        int iMin = Math.min(iPosition, i);
        byteBuffer.limit(byteBuffer.position() + iMin);
        String[] strArr = A0E;
        if (strArr[0].length() == strArr[2].length()) {
            throw new RuntimeException();
        }
        String[] strArr2 = A0E;
        strArr2[6] = "wWIHZuTOncQcUu5TT4FAsoGOHgVjS7Hw";
        strArr2[3] = "FL1HwHnzDnNmmMdWBTP73LL49pAAT75M";
        byteBuffer.get(this.A0C, this.A02, iMin);
        this.A02 += iMin;
        int i2 = this.A02;
        byte[] bArr2 = this.A0C;
        if (i2 == bArr2.length) {
            if (this.A0A) {
                A0A(bArr2, this.A03);
                this.A06 += (long) ((this.A02 - (this.A03 * 2)) / this.A00);
            } else {
                this.A06 += (long) ((i2 - this.A03) / this.A00);
            }
            A09(byteBuffer, this.A0C, this.A02);
            this.A02 = 0;
            this.A05 = 2;
        }
        byteBuffer.limit(maybeSilenceInputSize);
    }

    private void A07(ByteBuffer byteBuffer) {
        int iLimit = byteBuffer.limit();
        byteBuffer.limit(Math.min(iLimit, byteBuffer.position() + this.A0C.length));
        int iA01 = A01(byteBuffer);
        if (iA01 == byteBuffer.position()) {
            this.A05 = 1;
        } else {
            byteBuffer.limit(iA01);
            A05(byteBuffer);
        }
        byteBuffer.limit(iLimit);
    }

    private void A08(ByteBuffer byteBuffer) {
        int iLimit = byteBuffer.limit();
        int iA02 = A02(byteBuffer);
        byteBuffer.limit(iA02);
        this.A06 += (long) (byteBuffer.remaining() / this.A00);
        A09(byteBuffer, this.A0D, this.A03);
        if (iA02 < iLimit) {
            A0A(this.A0D, this.A03);
            this.A05 = 0;
            byteBuffer.limit(iLimit);
        }
    }

    private void A09(ByteBuffer byteBuffer, byte[] bArr, int i) {
        int iMin = Math.min(byteBuffer.remaining(), this.A03);
        int i2 = this.A03 - iMin;
        System.arraycopy(bArr, i - i2, this.A0D, 0, i2);
        byteBuffer.position(byteBuffer.limit() - iMin);
        byteBuffer.get(this.A0D, i2, iMin);
    }

    private void A0A(byte[] bArr, int i) {
        A04(i);
        this.A07.put(bArr, 0, i);
        this.A07.flip();
        this.A08 = this.A07;
    }

    public final long A0B() {
        return this.A06;
    }

    public final void A0C(boolean z) {
        this.A09 = z;
        flush();
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1502At
    public final boolean A47(int i, int i2, int i3) throws C1501As {
        if (i3 == 2) {
            if (this.A04 == i) {
                int i4 = this.A01;
                if (A0E[4].length() != 25) {
                    throw new RuntimeException();
                }
                String[] strArr = A0E;
                strArr[0] = "H8XMnFWveFctl2wFWM9cW2gP9UHr1";
                strArr[2] = "PgSQZHBtM";
                if (i4 == i2) {
                    return false;
                }
            }
            this.A04 = i;
            this.A01 = i2;
            this.A00 = i2 * 2;
            return true;
        }
        throw new C1501As(i, i2, i3);
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1502At
    public final ByteBuffer A6h() {
        ByteBuffer byteBuffer = this.A08;
        this.A08 = InterfaceC1502At.A00;
        return byteBuffer;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1502At
    public final int A6i() {
        return this.A01;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1502At
    public final int A6j() {
        return 2;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1502At
    public final int A6k() {
        return this.A04;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1502At
    public final boolean A7j() {
        return this.A04 != -1 && this.A09;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1502At
    public final boolean A7n() {
        return this.A0B && this.A08 == InterfaceC1502At.A00;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1502At
    public final void ACD() {
        this.A0B = true;
        int i = this.A02;
        if (i > 0) {
            A0A(this.A0C, i);
        }
        if (!this.A0A) {
            this.A06 += (long) (this.A03 / this.A00);
        }
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1502At
    public final void ACE(ByteBuffer byteBuffer) {
        while (byteBuffer.hasRemaining() && !this.A08.hasRemaining()) {
            int i = this.A05;
            if (i != 0) {
                String[] strArr = A0E;
                if (strArr[5].length() == strArr[1].length()) {
                    throw new RuntimeException();
                }
                String[] strArr2 = A0E;
                strArr2[4] = "AiWUvfGcxq4zga3HVbzIicdLH";
                strArr2[4] = "AiWUvfGcxq4zga3HVbzIicdLH";
                if (i == 1) {
                    A06(byteBuffer);
                } else if (i == 2) {
                    A08(byteBuffer);
                } else {
                    throw new IllegalStateException();
                }
            } else {
                A07(byteBuffer);
            }
        }
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1502At
    public final void flush() {
        if (A7j()) {
            int iA00 = A00(150000L) * this.A00;
            if (this.A0C.length != iA00) {
                this.A0C = new byte[iA00];
            }
            this.A03 = A00(20000L) * this.A00;
            int length = this.A0D.length;
            int i = this.A03;
            if (length != i) {
                this.A0D = new byte[i];
            }
        }
        this.A05 = 0;
        this.A08 = InterfaceC1502At.A00;
        this.A0B = false;
        this.A06 = 0L;
        String[] strArr = A0E;
        if (strArr[5].length() == strArr[1].length()) {
            throw new RuntimeException();
        }
        String[] strArr2 = A0E;
        strArr2[5] = "CYbGl";
        strArr2[1] = "FkXGzwkTO5dsiSfEVL3DvOQ";
        this.A02 = 0;
        this.A0A = false;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1502At
    public final void reset() {
        this.A09 = false;
        flush();
        this.A07 = InterfaceC1502At.A00;
        this.A01 = -1;
        this.A04 = -1;
        this.A03 = 0;
        this.A0C = new byte[0];
        this.A0D = new byte[0];
    }
}
