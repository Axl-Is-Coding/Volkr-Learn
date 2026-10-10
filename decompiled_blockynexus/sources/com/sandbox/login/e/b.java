package com.sandbox.login.e;

import com.umeng.analytics.pro.ci;
import okio.Utf8;

/* JADX INFO: compiled from: Base64.java */
/* JADX INFO: loaded from: classes2.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final byte[] f15743a = new byte[128];

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final char[] f15744b = new char[64];

    static {
        int i;
        int i2;
        int i3 = 0;
        for (int i4 = 0; i4 < 128; i4++) {
            f15743a[i4] = -1;
        }
        for (int i5 = 90; i5 >= 65; i5--) {
            f15743a[i5] = (byte) (i5 - 65);
        }
        int i6 = 122;
        while (true) {
            i = 26;
            if (i6 < 97) {
                break;
            }
            f15743a[i6] = (byte) ((i6 - 97) + 26);
            i6--;
        }
        int i7 = 57;
        while (true) {
            i2 = 52;
            if (i7 < 48) {
                break;
            }
            f15743a[i7] = (byte) ((i7 - 48) + 52);
            i7--;
        }
        byte[] bArr = f15743a;
        bArr[43] = 62;
        bArr[47] = Utf8.REPLACEMENT_BYTE;
        for (int i8 = 0; i8 <= 25; i8++) {
            f15744b[i8] = (char) (i8 + 65);
        }
        int i9 = 0;
        while (i <= 51) {
            f15744b[i] = (char) (i9 + 97);
            i++;
            i9++;
        }
        while (i2 <= 61) {
            f15744b[i2] = (char) (i3 + 48);
            i2++;
            i3++;
        }
        char[] cArr = f15744b;
        cArr[62] = '+';
        cArr[63] = '/';
    }

    private static boolean a(char c2) {
        return c2 < 128 && f15743a[c2] != -1;
    }

    private static boolean b(char c2) {
        return c2 == '=';
    }

    private static boolean c(char c2) {
        return c2 == ' ' || c2 == '\r' || c2 == '\n' || c2 == '\t';
    }

    public static String a(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        int length = bArr.length * 8;
        if (length == 0) {
            return "";
        }
        int i = length % 24;
        int i2 = length / 24;
        char[] cArr = new char[(i != 0 ? i2 + 1 : i2) * 4];
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        while (i3 < i2) {
            int i6 = i4 + 1;
            byte b2 = bArr[i4];
            int i7 = i6 + 1;
            byte b3 = bArr[i6];
            int i8 = i7 + 1;
            byte b4 = bArr[i7];
            byte b5 = (byte) (b3 & ci.m);
            byte b6 = (byte) (b2 & 3);
            byte b7 = (byte) ((b2 & (-128)) == 0 ? b2 >> 2 : (b2 >> 2) ^ 192);
            byte b8 = (byte) ((b3 & (-128)) == 0 ? b3 >> 4 : (b3 >> 4) ^ 240);
            int i9 = (b4 & (-128)) == 0 ? b4 >> 6 : (b4 >> 6) ^ 252;
            int i10 = i5 + 1;
            char[] cArr2 = f15744b;
            cArr[i5] = cArr2[b7];
            int i11 = i10 + 1;
            cArr[i10] = cArr2[(b6 << 4) | b8];
            int i12 = i11 + 1;
            cArr[i11] = cArr2[(b5 << 2) | ((byte) i9)];
            cArr[i12] = cArr2[b4 & Utf8.REPLACEMENT_BYTE];
            i3++;
            i5 = i12 + 1;
            i4 = i8;
        }
        if (i == 8) {
            byte b9 = bArr[i4];
            byte b10 = (byte) (b9 & 3);
            int i13 = (b9 & (-128)) == 0 ? b9 >> 2 : (b9 >> 2) ^ 192;
            int i14 = i5 + 1;
            char[] cArr3 = f15744b;
            cArr[i5] = cArr3[(byte) i13];
            int i15 = i14 + 1;
            cArr[i14] = cArr3[b10 << 4];
            cArr[i15] = '=';
            cArr[i15 + 1] = '=';
        } else if (i == 16) {
            byte b11 = bArr[i4];
            byte b12 = bArr[i4 + 1];
            byte b13 = (byte) (b12 & ci.m);
            byte b14 = (byte) (b11 & 3);
            byte b15 = (byte) ((b11 & (-128)) == 0 ? b11 >> 2 : (b11 >> 2) ^ 192);
            int i16 = (b12 & (-128)) == 0 ? b12 >> 4 : (b12 >> 4) ^ 240;
            int i17 = i5 + 1;
            char[] cArr4 = f15744b;
            cArr[i5] = cArr4[b15];
            int i18 = i17 + 1;
            cArr[i17] = cArr4[((byte) i16) | (b14 << 4)];
            cArr[i18] = cArr4[b13 << 2];
            cArr[i18 + 1] = '=';
        }
        return new String(cArr);
    }

    public static byte[] a(String str) {
        if (str == null) {
            return null;
        }
        char[] charArray = str.toCharArray();
        int iA = a(charArray);
        if (iA % 4 != 0) {
            return null;
        }
        int i = iA / 4;
        if (i == 0) {
            return new byte[0];
        }
        byte[] bArr = new byte[i * 3];
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (i2 < i - 1) {
            int i5 = i3 + 1;
            char c2 = charArray[i3];
            if (a(c2)) {
                int i6 = i5 + 1;
                char c3 = charArray[i5];
                if (a(c3)) {
                    int i7 = i6 + 1;
                    char c4 = charArray[i6];
                    if (a(c4)) {
                        int i8 = i7 + 1;
                        char c5 = charArray[i7];
                        if (a(c5)) {
                            byte[] bArr2 = f15743a;
                            byte b2 = bArr2[c2];
                            byte b3 = bArr2[c3];
                            byte b4 = bArr2[c4];
                            byte b5 = bArr2[c5];
                            int i9 = i4 + 1;
                            bArr[i4] = (byte) ((b2 << 2) | (b3 >> 4));
                            int i10 = i9 + 1;
                            bArr[i9] = (byte) (((b3 & ci.m) << 4) | ((b4 >> 2) & 15));
                            i4 = i10 + 1;
                            bArr[i10] = (byte) ((b4 << 6) | b5);
                            i2++;
                            i3 = i8;
                        }
                    }
                }
            }
            return null;
        }
        int i11 = i3 + 1;
        char c6 = charArray[i3];
        if (!a(c6)) {
            return null;
        }
        int i12 = i11 + 1;
        char c7 = charArray[i11];
        if (!a(c7)) {
            return null;
        }
        byte[] bArr3 = f15743a;
        byte b6 = bArr3[c6];
        byte b7 = bArr3[c7];
        int i13 = i12 + 1;
        char c8 = charArray[i12];
        char c9 = charArray[i13];
        if (a(c8) && a(c9)) {
            byte[] bArr4 = f15743a;
            byte b8 = bArr4[c8];
            byte b9 = bArr4[c9];
            int i14 = i4 + 1;
            bArr[i4] = (byte) ((b6 << 2) | (b7 >> 4));
            bArr[i14] = (byte) (((b7 & ci.m) << 4) | ((b8 >> 2) & 15));
            bArr[i14 + 1] = (byte) (b9 | (b8 << 6));
            return bArr;
        }
        if (b(c8) && b(c9)) {
            if ((b7 & ci.m) != 0) {
                return null;
            }
            int i15 = i2 * 3;
            byte[] bArr5 = new byte[i15 + 1];
            System.arraycopy(bArr, 0, bArr5, 0, i15);
            bArr5[i4] = (byte) ((b6 << 2) | (b7 >> 4));
            return bArr5;
        }
        if (b(c8) || !b(c9)) {
            return null;
        }
        byte b10 = f15743a[c8];
        if ((b10 & 3) != 0) {
            return null;
        }
        int i16 = i2 * 3;
        byte[] bArr6 = new byte[i16 + 2];
        System.arraycopy(bArr, 0, bArr6, 0, i16);
        bArr6[i4] = (byte) ((b6 << 2) | (b7 >> 4));
        bArr6[i4 + 1] = (byte) (((b10 >> 2) & 15) | ((b7 & ci.m) << 4));
        return bArr6;
    }

    private static int a(char[] cArr) {
        if (cArr == null) {
            return 0;
        }
        int length = cArr.length;
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            if (!c(cArr[i2])) {
                cArr[i] = cArr[i2];
                i++;
            }
        }
        return i;
    }
}
