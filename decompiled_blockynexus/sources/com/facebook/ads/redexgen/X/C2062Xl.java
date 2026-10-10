package com.facebook.ads.redexgen.X;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Xl, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C2062Xl implements InterfaceC1502At {
    public static String[] A06;
    public boolean A05;
    public int A02 = -1;
    public int A00 = -1;
    public int A01 = 0;
    public ByteBuffer A03 = InterfaceC1502At.A00;
    public ByteBuffer A04 = InterfaceC1502At.A00;

    static {
        A00();
    }

    public static void A00() {
        A06 = new String[]{"5utGUnn02b5VIzuc1FLHs1Qqi0fGEzz2", "DaG3Y2wQcTFt6n6rQ7Gr6iJZtSjkgUIR", "I5wcdOmu3UXBpwLMhd1MA2dM71iQzRTS", "a3TfZcOy08z7kq2pPCWxFv40lmZdIopZ", "nCxl35vO69EqZhEDDoDcGzJRz4rMZlE7", "Y5761Ga76B4ReZAKlzLfDyZ1gXjGXB3L", "t1lur4hbWemc11jTFC6OlnNGsbjhQ3VM", "6CnjKSKlGDDfBCJgDd7Ssr26upnReJdk"};
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1502At
    public final boolean A47(int i, int i2, int i3) throws C1501As {
        if (i3 == 3 || i3 == 2 || i3 == Integer.MIN_VALUE || i3 == 1073741824) {
            if (this.A02 == i && this.A00 == i2 && this.A01 == i3) {
                return false;
            }
            this.A02 = i;
            this.A00 = i2;
            this.A01 = i3;
            return true;
        }
        throw new C1501As(i, i2, i3);
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1502At
    public final ByteBuffer A6h() {
        ByteBuffer byteBuffer = this.A04;
        this.A04 = InterfaceC1502At.A00;
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
        return this.A02;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1502At
    public final boolean A7j() {
        int i = this.A01;
        return (i == 0 || i == 2) ? false : true;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1502At
    public final boolean A7n() {
        return this.A05 && this.A04 == InterfaceC1502At.A00;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1502At
    public final void ACD() {
        this.A05 = true;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1502At
    public final void ACE(ByteBuffer byteBuffer) {
        int i;
        int size = byteBuffer.position();
        int resampledSize = byteBuffer.limit();
        int i2 = resampledSize - size;
        int i3 = this.A01;
        if (i3 == Integer.MIN_VALUE) {
            i = (i2 / 3) * 2;
        } else if (i3 == 3) {
            i = i2 * 2;
        } else if (i3 == 1073741824) {
            i = i2 / 2;
        } else {
            throw new IllegalStateException();
        }
        int iCapacity = this.A03.capacity();
        String[] strArr = A06;
        if (strArr[6].charAt(17) == strArr[3].charAt(17)) {
            String[] strArr2 = A06;
            strArr2[2] = "W94yXwDUFyNDAMV4dQ9gRwTb9HKmhar0";
            strArr2[1] = "UxSCLQ06z7wJwwSNZRUXPEmpHaH1zCeE";
            if (iCapacity < i) {
                this.A03 = ByteBuffer.allocateDirect(i).order(ByteOrder.nativeOrder());
            } else {
                this.A03.clear();
            }
            int i4 = this.A01;
            if (i4 == Integer.MIN_VALUE) {
                while (size < resampledSize) {
                    this.A03.put(byteBuffer.get(size + 1));
                    this.A03.put(byteBuffer.get(size + 2));
                    size += 3;
                }
            } else if (i4 == 3) {
                while (size < resampledSize) {
                    this.A03.put((byte) 0);
                    this.A03.put((byte) ((byteBuffer.get(size) & 255) - 128));
                    size++;
                }
            } else if (i4 == 1073741824) {
                while (size < resampledSize) {
                    ByteBuffer byteBuffer2 = this.A03;
                    String[] strArr3 = A06;
                    if (strArr3[2].charAt(9) != strArr3[1].charAt(9)) {
                        String[] strArr4 = A06;
                        strArr4[2] = "sfuVTkj8IwDRAmHRKMELNpZyhpVkIKBS";
                        strArr4[1] = "Fl4ka6a0nXkGByMLlkeuhoftQnViDXP0";
                        byteBuffer2.put(byteBuffer.get(size + 2));
                        this.A03.put(byteBuffer.get(size + 3));
                        size += 4;
                    }
                }
            } else {
                throw new IllegalStateException();
            }
            byteBuffer.position(byteBuffer.limit());
            this.A03.flip();
            this.A04 = this.A03;
            return;
        }
        throw new RuntimeException();
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1502At
    public final void flush() {
        this.A04 = InterfaceC1502At.A00;
        this.A05 = false;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1502At
    public final void reset() {
        flush();
        this.A02 = -1;
        this.A00 = -1;
        this.A01 = 0;
        this.A03 = InterfaceC1502At.A00;
    }
}
