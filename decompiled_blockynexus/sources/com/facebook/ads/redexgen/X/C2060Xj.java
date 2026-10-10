package com.facebook.ads.redexgen.X;

import cn.qqtheme.framework.widget.WheelView;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Xj, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C2060Xj implements InterfaceC1502At {
    public static String[] A06;
    public static final int A07;
    public boolean A05;
    public int A01 = -1;
    public int A00 = -1;
    public int A02 = 0;
    public ByteBuffer A03 = InterfaceC1502At.A00;
    public ByteBuffer A04 = InterfaceC1502At.A00;

    public static void A00() {
        A06 = new String[]{"grqzXl31Ib3CwgbOGLAhXGiUSybb3G6k", "HqCRL2sDmMVhvd9OffyzWNuXpbgyFlqg", "IpTiYMxyYV6xHW6l8ixVEePHdVdY3VZ5", "ZRTEafxouxRK9cmvY3V1KAxZT1cXIFF2", "yUYM5z5ItqNmKdZaBdfrwPcFTl5oQFEz", "Jf72zunVfpVe04eAXULupQi0ZX1Zqvmv", "BX9HD2aywQJTDQtUbY1GrFeREy6of4gh", "vYXD58apfp8PH7rmktr19THixNAKPTAD"};
    }

    static {
        A00();
        A07 = Float.floatToIntBits(Float.NaN);
    }

    public static void A01(int i, ByteBuffer byteBuffer) {
        int iFloatToIntBits = Float.floatToIntBits((float) (((double) i) * 4.656612875245797E-10d));
        if (iFloatToIntBits == A07) {
            iFloatToIntBits = Float.floatToIntBits(WheelView.DividerConfig.FILL);
        }
        byteBuffer.putInt(iFloatToIntBits);
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1502At
    public final boolean A47(int i, int i2, int i3) throws C1501As {
        if (IW.A0c(i3)) {
            int i4 = this.A01;
            String[] strArr = A06;
            if (strArr[1].charAt(10) != strArr[5].charAt(10)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A06;
            strArr2[0] = "leVPKBI8NIDC3IwFclJng7rkdIPGoQ7e";
            strArr2[0] = "leVPKBI8NIDC3IwFclJng7rkdIPGoQ7e";
            if (i4 == i && this.A00 == i2 && this.A02 == i3) {
                return false;
            }
            this.A01 = i;
            this.A00 = i2;
            this.A02 = i3;
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
        return 4;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1502At
    public final int A6k() {
        return this.A01;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1502At
    public final boolean A7j() {
        return IW.A0c(this.A02);
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
        int resampledSize = this.A02 == 1073741824 ? 1 : 0;
        int i = byteBuffer.position();
        int iLimit = byteBuffer.limit();
        int i2 = iLimit - i;
        if (resampledSize == 0) {
            int size = i2 / 3;
            i2 = size * 4;
        }
        int iCapacity = this.A03.capacity();
        String[] strArr = A06;
        String str = strArr[1];
        String str2 = strArr[5];
        int limit = str.charAt(10);
        int size2 = str2.charAt(10);
        if (limit != size2) {
            throw new RuntimeException();
        }
        String[] strArr2 = A06;
        strArr2[2] = "93WHocDEPVvmBm0SxxEdEuUxxAP6dl6i";
        strArr2[2] = "93WHocDEPVvmBm0SxxEdEuUxxAP6dl6i";
        if (iCapacity < i2) {
            this.A03 = ByteBuffer.allocateDirect(i2).order(ByteOrder.nativeOrder());
        } else {
            this.A03.clear();
        }
        if (resampledSize != 0) {
            while (i < iLimit) {
                int size3 = byteBuffer.get(i);
                int limit2 = size3 & 255;
                int size4 = i + 1;
                int limit3 = limit2 | ((byteBuffer.get(size4) & 255) << 8);
                int size5 = i + 2;
                int limit4 = limit3 | ((byteBuffer.get(size5) & 255) << 16);
                int size6 = i + 3;
                A01(limit4 | ((byteBuffer.get(size6) & 255) << 24), this.A03);
                i += 4;
            }
        } else {
            while (i < iLimit) {
                int size7 = byteBuffer.get(i);
                int limit5 = (size7 & 255) << 8;
                int size8 = i + 1;
                int limit6 = limit5 | ((byteBuffer.get(size8) & 255) << 16);
                int size9 = i + 2;
                A01(limit6 | ((byteBuffer.get(size9) & 255) << 24), this.A03);
                i += 3;
            }
        }
        int size10 = byteBuffer.limit();
        byteBuffer.position(size10);
        this.A03.flip();
        this.A04 = this.A03;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1502At
    public final void flush() {
        this.A04 = InterfaceC1502At.A00;
        this.A05 = false;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1502At
    public final void reset() {
        flush();
        this.A01 = -1;
        this.A00 = -1;
        this.A02 = 0;
        this.A03 = InterfaceC1502At.A00;
    }
}
