package com.facebook.ads.redexgen.X;

import com.umeng.analytics.pro.ci;
import java.lang.reflect.Constructor;
import java.util.Arrays;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class Y8 implements CD {
    public static byte[] A06;
    public static final Constructor<? extends CA> A07;
    public int A00;
    public int A01;
    public int A02;
    public int A03;
    public int A04;
    public int A05 = 1;

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A06, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 75);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A06 = new byte[]{4, 51, 51, 46, 51, 97, 40, 47, 50, 53, 32, 47, 53, 40, 32, 53, 40, 47, 38, 97, 7, ci.k, 0, 2, 97, 36, 57, 53, 36, 47, 50, 40, 46, 47, 37, 30, 21, 8, 0, 21, 19, 4, 21, 20, 80, 21, 2, 2, 31, 2, 80, 19, 2, 21, 17, 4, 25, 30, 23, 80, 54, 60, 49, 51, 80, 21, 8, 4, 2, 17, 19, 4, 31, 2, 98, 110, 108, 47, 103, 96, 98, 100, 99, 110, 110, 106, 47, 96, 101, 114, 47, 104, 111, 117, 100, 115, 111, 96, 109, 47, 100, 121, 110, 113, 109, 96, 120, 100, 115, 51, 47, 100, 121, 117, 47, 103, 109, 96, 98, 47, 71, 109, 96, 98, 68, 121, 117, 115, 96, 98, 117, 110, 115};
    }

    static {
        A01();
        Constructor<? extends CA> constructor = null;
        try {
            constructor = Class.forName(A00(74, 59, 74)).asSubclass(CA.class).getConstructor(new Class[0]);
        } catch (ClassNotFoundException unused) {
        } catch (Exception e2) {
            throw new RuntimeException(A00(0, 34, 10), e2);
        }
        A07 = constructor;
    }

    @Override // com.facebook.ads.redexgen.X.CD
    public final synchronized CA[] A4H() {
        CA[] caArr;
        caArr = new CA[A07 == null ? 12 : 13];
        caArr[0] = new YN(this.A01);
        caArr[1] = new YX(this.A00);
        caArr[2] = new YZ(this.A03);
        caArr[3] = new YQ(this.A02);
        caArr[4] = new C2091Yo();
        caArr[5] = new C2088Yl();
        caArr[6] = new Z7(this.A05, this.A04);
        caArr[7] = new YG();
        caArr[8] = new C2082Yf();
        caArr[9] = new Z1();
        caArr[10] = new Z9();
        caArr[11] = new YD();
        if (A07 != null) {
            try {
                caArr[12] = A07.newInstance(new Object[0]);
            } catch (Exception e2) {
                throw new IllegalStateException(A00(34, 40, 59), e2);
            }
        }
        return caArr;
    }
}
