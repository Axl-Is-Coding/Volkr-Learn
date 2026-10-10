package com.google.zxing.oned;

import com.google.zxing.FormatException;

/* JADX INFO: compiled from: UPCEANReader.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class o extends l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final int[] f14486a = {1, 1, 1};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static final int[] f14487b = {1, 1, 1, 1, 1};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    static final int[] f14488c = {1, 1, 1, 1, 1, 1};

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    static final int[][] f14489d = {new int[]{3, 2, 1, 1}, new int[]{2, 2, 2, 1}, new int[]{2, 1, 2, 2}, new int[]{1, 4, 1, 1}, new int[]{1, 1, 3, 2}, new int[]{1, 2, 3, 1}, new int[]{1, 1, 1, 4}, new int[]{1, 3, 1, 2}, new int[]{1, 2, 1, 3}, new int[]{3, 1, 1, 2}};

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    static final int[][] f14490e = new int[20][];

    static {
        System.arraycopy(f14489d, 0, f14490e, 0, 10);
        for (int i = 10; i < 20; i++) {
            int[] iArr = f14489d[i - 10];
            int[] iArr2 = new int[iArr.length];
            for (int i2 = 0; i2 < iArr.length; i2++) {
                iArr2[i2] = iArr[(iArr.length - i2) - 1];
            }
            f14490e[i] = iArr2;
        }
    }

    static boolean a(CharSequence charSequence) throws FormatException {
        int length = charSequence.length();
        if (length == 0) {
            return false;
        }
        int i = length - 1;
        return b(charSequence.subSequence(0, i)) == Character.digit(charSequence.charAt(i), 10);
    }

    static int b(CharSequence charSequence) throws FormatException {
        int length = charSequence.length();
        int i = 0;
        for (int i2 = length - 1; i2 >= 0; i2 -= 2) {
            int iCharAt = charSequence.charAt(i2) - '0';
            if (iCharAt < 0 || iCharAt > 9) {
                throw FormatException.getFormatInstance();
            }
            i += iCharAt;
        }
        int i3 = i * 3;
        for (int i4 = length - 2; i4 >= 0; i4 -= 2) {
            int iCharAt2 = charSequence.charAt(i4) - '0';
            if (iCharAt2 < 0 || iCharAt2 > 9) {
                throw FormatException.getFormatInstance();
            }
            i3 += iCharAt2;
        }
        return (1000 - i3) % 10;
    }
}
