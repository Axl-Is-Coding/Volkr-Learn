package com.facebook.ads.redexgen.X;

import com.umeng.analytics.pro.ci;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class IY {
    public static byte[] A05;
    public static String[] A06;
    public final float A00;
    public final int A01;
    public final int A02;
    public final int A03;
    public final List<byte[]> A04;

    static {
        A03();
        A02();
    }

    public static String A01(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A05, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            byte b2 = bArrCopyOfRange[i4];
            String[] strArr = A06;
            if (strArr[2].charAt(1) != strArr[1].charAt(1)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A06;
            strArr2[3] = "kNkKJeUYPfq8eMd2tA59MaBH22H8N5Ts";
            strArr2[3] = "kNkKJeUYPfq8eMd2tA59MaBH22H8N5Ts";
            bArrCopyOfRange[i4] = (byte) ((b2 - i3) - 81);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A02() {
        A05 = new byte[]{ci.k, 58, 58, 55, 58, -24, 56, 41, 58, 59, 49, 54, 47, -24, 9, 30, 11, -24, 43, 55, 54, 46, 49, 47};
    }

    public static void A03() {
        A06 = new String[]{"6HhNm3cPNapwaqbb", "rETS2R3vEEslStUJRpCBgfLkJK0S9xqh", "MEYGBk1oMmhBWHD5huW8XB9PkOXmJxmW", "Ebyfs41o5airltqaiKadsdL394JDYdET", "45eNA9gLGf59sMGZ1iMI", "", "A0Zue4QITY9ZnpF1VrB6IK97BmW1DYMt", "lY4WeGl5g11cW0QvoH9uVkbc4B0XWsja"};
    }

    public IY(List<byte[]> initializationData, int i, int i2, int i3, float f2) {
        this.A04 = initializationData;
        this.A02 = i;
        this.A03 = i2;
        this.A01 = i3;
        this.A00 = f2;
    }

    public static IY A00(IG ig) throws AD {
        try {
            ig.A0a(4);
            int iA0F = (ig.A0F() & 3) + 1;
            if (iA0F != 3) {
                ArrayList arrayList = new ArrayList();
                int numSequenceParameterSets = ig.A0F() & 31;
                for (int j = 0; j < numSequenceParameterSets; j++) {
                    arrayList.add(A04(ig));
                }
                int iA0F2 = ig.A0F();
                for (int numPictureParameterSets = 0; numPictureParameterSets < iA0F2; numPictureParameterSets++) {
                    arrayList.add(A04(ig));
                }
                int i = -1;
                int i2 = -1;
                float f2 = 1.0f;
                int width = A06[4].length();
                if (width == 27) {
                    throw new RuntimeException();
                }
                String[] strArr = A06;
                strArr[2] = "yEkjaL4nSOxIxbdygxb0eg7rmaPMv2Rh";
                strArr[1] = "JEi8k2PtpDNktftvz60xHr0NAbywlG3U";
                if (numSequenceParameterSets > 0) {
                    byte[] bArr = (byte[]) arrayList.get(0);
                    byte[] bArr2 = (byte[]) arrayList.get(0);
                    int height = bArr.length;
                    IB ibA06 = IC.A06(bArr2, iA0F, height);
                    i = ibA06.A06;
                    i2 = ibA06.A02;
                    f2 = ibA06.A00;
                }
                return new IY(arrayList, iA0F, i, i2, f2);
            }
            throw new IllegalStateException();
        } catch (ArrayIndexOutOfBoundsException e2) {
            throw new AD(A01(0, 24, 119), e2);
        }
    }

    public static byte[] A04(IG ig) {
        int offset = ig.A0J();
        int iA07 = ig.A07();
        ig.A0a(offset);
        return C1666Hv.A09(ig.A00, iA07, offset);
    }
}
