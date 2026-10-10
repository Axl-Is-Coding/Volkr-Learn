package org.apache.commons.compress.archivers.a;

import java.io.IOException;
import java.math.BigInteger;

/* JADX INFO: compiled from: TarUtils.java */
/* JADX INFO: loaded from: classes5.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final org.apache.commons.compress.archivers.zip.d f23525a = org.apache.commons.compress.archivers.zip.e.a(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static final org.apache.commons.compress.archivers.zip.d f23526b = new e();

    private static long a(byte[] bArr, int i, int i2, boolean z) {
        int i3 = i2 - 1;
        byte[] bArr2 = new byte[i3];
        System.arraycopy(bArr, i + 1, bArr2, 0, i3);
        BigInteger bigInteger = new BigInteger(bArr2);
        if (z) {
            bigInteger = bigInteger.add(BigInteger.valueOf(-1L)).not();
        }
        if (bigInteger.bitLength() <= 63) {
            return z ? -bigInteger.longValue() : bigInteger.longValue();
        }
        throw new IllegalArgumentException("At offset " + i + ", " + i2 + " byte binary number exceeds maximum signed long value");
    }

    public static long b(byte[] bArr, int i, int i2) {
        int i3 = i + i2;
        if (i2 < 2) {
            throw new IllegalArgumentException("Length " + i2 + " must be at least 2");
        }
        long j = 0;
        if (bArr[i] == 0) {
            return 0L;
        }
        int i4 = i;
        while (i4 < i3 && bArr[i4] == 32) {
            i4++;
        }
        byte b2 = bArr[i3 - 1];
        while (i4 < i3 && (b2 == 0 || b2 == 32)) {
            i3--;
            b2 = bArr[i3 - 1];
        }
        while (i4 < i3) {
            byte b3 = bArr[i4];
            if (b3 < 48 || b3 > 55) {
                throw new IllegalArgumentException(a(bArr, i, i2, i4, b3));
            }
            j = (j << 3) + ((long) (b3 - 48));
            i4++;
        }
        return j;
    }

    public static long c(byte[] bArr, int i, int i2) {
        if ((bArr[i] & 128) == 0) {
            return b(bArr, i, i2);
        }
        boolean z = bArr[i] == -1;
        return i2 < 9 ? b(bArr, i, i2, z) : a(bArr, i, i2, z);
    }

    public static boolean a(byte[] bArr, int i) {
        return bArr[i] == 1;
    }

    private static String a(byte[] bArr, int i, int i2, int i3, byte b2) {
        return "Invalid byte " + ((int) b2) + " at offset " + (i3 - i) + " in '" + new String(bArr, i, i2).replaceAll("\u0000", "{NUL}") + "' len=" + i2;
    }

    private static long b(byte[] bArr, int i, int i2, boolean z) {
        if (i2 >= 9) {
            throw new IllegalArgumentException("At offset " + i + ", " + i2 + " byte binary number exceeds maximum signed long value");
        }
        long jPow = 0;
        for (int i3 = 1; i3 < i2; i3++) {
            jPow = (jPow << 8) + ((long) (bArr[i + i3] & 255));
        }
        if (z) {
            double d2 = i2 - 1;
            Double.isNaN(d2);
            jPow = (jPow - 1) ^ (((long) Math.pow(2.0d, d2 * 8.0d)) - 1);
        }
        return z ? -jPow : jPow;
    }

    public static String a(byte[] bArr, int i, int i2) {
        try {
            try {
                return a(bArr, i, i2, f23525a);
            } catch (IOException unused) {
                return a(bArr, i, i2, f23526b);
            }
        } catch (IOException e2) {
            throw new RuntimeException(e2);
        }
    }

    public static String a(byte[] bArr, int i, int i2, org.apache.commons.compress.archivers.zip.d dVar) throws IOException {
        int i3 = i;
        int i4 = 0;
        while (i4 < i2 && bArr[i3] != 0) {
            i3++;
            i4++;
        }
        if (i4 <= 0) {
            return "";
        }
        byte[] bArr2 = new byte[i4];
        System.arraycopy(bArr, i, bArr2, 0, i4);
        return dVar.decode(bArr2);
    }

    public static boolean a(byte[] bArr) {
        long jB = b(bArr, 148, 8);
        long j = 0;
        long j2 = 0;
        for (int i = 0; i < bArr.length; i++) {
            byte b2 = bArr[i];
            if (148 <= i && i < 156) {
                b2 = 32;
            }
            j2 += (long) (b2 & 255);
            j += (long) b2;
        }
        return jB == j2 || jB == j;
    }
}
