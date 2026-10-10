package com.facebook.ads.redexgen.X;

import java.util.Arrays;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Gh, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1628Gh {
    public static byte[] A04;
    public static String[] A05;
    public static final String[] A06;
    public final int A00;
    public final String A01;
    public final String A02;
    public final String[] A03;

    public static String A02(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A04, i, i + i2);
        int i4 = 0;
        while (true) {
            int length = bArrCopyOfRange.length;
            if (A05[5].charAt(16) != 'R') {
                throw new RuntimeException();
            }
            String[] strArr = A05;
            strArr[1] = "hhyK";
            strArr[4] = "wZqiL";
            if (i4 >= length) {
                return new String(bArrCopyOfRange);
            }
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 6);
            i4++;
        }
    }

    public static void A03() {
        A04 = new byte[]{36, 114, 0};
    }

    public static void A04() {
        A05 = new String[]{"zFpRfifZkCIQawK1FUSg1K3EtGdV6Nz", "WEmq", "TVYpI9shQgf8MMEfvFWnKjXtFk1mYiaB", "WCXJZ", "VBPbo", "2erUCN4YfMxeKpPmRmxhBeZiE0shrr6A", "I2AaOQprvAMyyOLMUfVLbbt0mFwKyNVO", "ZVSAIqFm1ddnxSH"};
    }

    static {
        A04();
        A03();
        A06 = new String[0];
    }

    public C1628Gh(String str, int i, String str2, String[] strArr) {
        this.A00 = i;
        this.A01 = str;
        this.A02 = str2;
        this.A03 = strArr;
    }

    public static C1628Gh A00() {
        String strA02 = A02(0, 0, 1);
        return new C1628Gh(strA02, 0, strA02, new String[0]);
    }

    public static C1628Gh A01(String str, int i) {
        String strTrim;
        String[] strArr;
        String name = str.trim();
        if (name.isEmpty()) {
            return null;
        }
        int iIndexOf = name.indexOf(A02(0, 1, 2));
        if (iIndexOf == -1) {
            strTrim = A02(0, 0, 1);
        } else {
            strTrim = name.substring(iIndexOf).trim();
            String[] strArr2 = A05;
            if (strArr2[1].length() == strArr2[4].length()) {
                throw new RuntimeException();
            }
            String[] strArr3 = A05;
            strArr3[5] = "Nr5OesO8C9sIOUHXRuAUw2kYPHmeguzx";
            strArr3[5] = "Nr5OesO8C9sIOUHXRuAUw2kYPHmeguzx";
            name = name.substring(0, iIndexOf);
        }
        String[] strArrA0m = IW.A0m(name, A02(1, 2, 40));
        String str2 = strArrA0m[0];
        if (strArrA0m.length > 1) {
            strArr = (String[]) Arrays.copyOfRange(strArrA0m, 1, strArrA0m.length);
        } else {
            strArr = A06;
        }
        return new C1628Gh(str2, i, strTrim, strArr);
    }
}
