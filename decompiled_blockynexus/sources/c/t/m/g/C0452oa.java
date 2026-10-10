package c.t.m.g;

import com.umeng.analytics.pro.ci;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

/* JADX INFO: renamed from: c.t.m.g.oa, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0452oa {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static byte[] f3321a = {-128, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long[] f3322b = new long[4];

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long[] f3323c = new long[2];

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private byte[] f3324d = new byte[64];

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private byte[] f3325e = new byte[16];

    public C0452oa() {
        a();
    }

    private static long a(long j, long j2, long j3, long j4, long j5, long j6, long j7) {
        int i = (int) (j + ((j3 & j2) | (j4 & ((-1) ^ j2))) + j5 + j7);
        return ((long) ((i << ((int) j6)) | (i >>> ((int) (32 - j6))))) + j2;
    }

    private void a() {
        long[] jArr = this.f3323c;
        jArr[0] = 0;
        jArr[1] = 0;
        long[] jArr2 = this.f3322b;
        jArr2[0] = 1732584193;
        jArr2[1] = 4023233417L;
        jArr2[2] = 2562383102L;
        jArr2[3] = 271733878;
    }

    private static void a(byte[] bArr, long[] jArr, int i) {
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3 += 4) {
            bArr[i3] = (byte) (jArr[i2] & 255);
            bArr[i3 + 1] = (byte) ((jArr[i2] >>> 8) & 255);
            bArr[i3 + 2] = (byte) ((jArr[i2] >>> 16) & 255);
            bArr[i3 + 3] = (byte) (255 & (jArr[i2] >>> 24));
            i2++;
        }
    }

    private boolean a(InputStream inputStream, long j) {
        byte[] bArr = new byte[64];
        long[] jArr = this.f3323c;
        int i = ((int) (jArr[0] >>> 3)) & 63;
        long j2 = j << 3;
        long j3 = jArr[0] + j2;
        jArr[0] = j3;
        if (j3 < j2) {
            jArr[1] = jArr[1] + 1;
        }
        long[] jArr2 = this.f3323c;
        jArr2[1] = jArr2[1] + (j >>> 29);
        int i2 = 64 - i;
        if (j >= i2) {
            byte[] bArr2 = new byte[i2];
            try {
                inputStream.read(bArr2, 0, i2);
                byte[] bArr3 = this.f3324d;
                for (int i3 = 0; i3 < i2; i3++) {
                    bArr3[i + i3] = bArr2[i3];
                }
                a(this.f3324d);
                while (i2 + 63 < j) {
                    try {
                        inputStream.read(bArr);
                        a(bArr);
                        i2 += 64;
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        return false;
                    }
                }
                i = 0;
            } catch (Exception e3) {
                e3.printStackTrace();
                return false;
            }
        } else {
            i2 = 0;
        }
        byte[] bArr4 = new byte[(int) (j - ((long) i2))];
        try {
            inputStream.read(bArr4);
            byte[] bArr5 = this.f3324d;
            int length = bArr4.length;
            for (int i4 = 0; i4 < length; i4++) {
                bArr5[i + i4] = bArr4[i4];
            }
            return true;
        } catch (Exception e4) {
            e4.printStackTrace();
            return false;
        }
    }

    private static long b(long j, long j2, long j3, long j4, long j5, long j6, long j7) {
        int i = (int) (((j2 & j4) | (((-1) ^ j4) & j3)) + j5 + j7 + j);
        return ((long) ((i >>> ((int) (32 - j6))) | (i << ((int) j6)))) + j2;
    }

    private static long c(long j, long j2, long j3, long j4, long j5, long j6, long j7) {
        int i = (int) (j + ((j3 ^ j2) ^ j4) + j5 + j7);
        return ((long) ((i << ((int) j6)) | (i >>> ((int) (32 - j6))))) + j2;
    }

    private static long d(long j, long j2, long j3, long j4, long j5, long j6, long j7) {
        int i = (int) (j + (j3 ^ ((j4 ^ (-1)) | j2)) + j5 + j7);
        return ((long) ((i << ((int) j6)) | (i >>> ((int) (32 - j6))))) + j2;
    }

    private void a(byte[] bArr, int i) {
        byte[] bArr2 = new byte[64];
        long[] jArr = this.f3323c;
        int i2 = ((int) (jArr[0] >>> 3)) & 63;
        long j = i << 3;
        long j2 = jArr[0] + j;
        jArr[0] = j2;
        if (j2 < j) {
            jArr[1] = jArr[1] + 1;
        }
        long[] jArr2 = this.f3323c;
        jArr2[1] = jArr2[1] + ((long) (i >>> 29));
        int i3 = 64 - i2;
        if (i >= i3) {
            byte[] bArr3 = this.f3324d;
            for (int i4 = 0; i4 < i3; i4++) {
                bArr3[i2 + i4] = bArr[i4];
            }
            a(this.f3324d);
            while (i3 + 63 < i) {
                for (int i5 = 0; i5 < 64; i5++) {
                    bArr2[i5] = bArr[i3 + i5];
                }
                a(bArr2);
                i3 += 64;
            }
            i2 = 0;
        } else {
            i3 = 0;
        }
        byte[] bArr4 = this.f3324d;
        int i6 = i - i3;
        for (int i7 = 0; i7 < i6; i7++) {
            bArr4[i2 + i7] = bArr[i3 + i7];
        }
    }

    private void a(byte[] bArr) {
        long[] jArr = this.f3322b;
        long j = jArr[0];
        long j2 = jArr[1];
        long j3 = jArr[2];
        long j4 = jArr[3];
        long[] jArr2 = new long[16];
        int i = 0;
        for (int i2 = 0; i2 < 64; i2 += 4) {
            int i3 = bArr[i2];
            if (i3 < 0) {
                i3 &= 255;
            }
            long j5 = i3;
            int i4 = bArr[i2 + 1];
            if (i4 < 0) {
                i4 &= 255;
            }
            long j6 = j5 | (((long) i4) << 8);
            int i5 = bArr[i2 + 2];
            if (i5 < 0) {
                i5 &= 255;
            }
            long j7 = j6 | (((long) i5) << 16);
            int i6 = bArr[i2 + 3];
            if (i6 < 0) {
                i6 &= 255;
            }
            jArr2[i] = j7 | (((long) i6) << 24);
            i++;
        }
        long jA = a(j, j2, j3, j4, jArr2[0], 7L, 3614090360L);
        long jA2 = a(j4, jA, j2, j3, jArr2[1], 12L, 3905402710L);
        long jA3 = a(j3, jA2, jA, j2, jArr2[2], 17L, 606105819L);
        long jA4 = a(j2, jA3, jA2, jA, jArr2[3], 22L, 3250441966L);
        long jA5 = a(jA, jA4, jA3, jA2, jArr2[4], 7L, 4118548399L);
        long jA6 = a(jA2, jA5, jA4, jA3, jArr2[5], 12L, 1200080426L);
        long jA7 = a(jA3, jA6, jA5, jA4, jArr2[6], 17L, 2821735955L);
        long jA8 = a(jA4, jA7, jA6, jA5, jArr2[7], 22L, 4249261313L);
        long jA9 = a(jA5, jA8, jA7, jA6, jArr2[8], 7L, 1770035416L);
        long jA10 = a(jA6, jA9, jA8, jA7, jArr2[9], 12L, 2336552879L);
        long jA11 = a(jA7, jA10, jA9, jA8, jArr2[10], 17L, 4294925233L);
        long jA12 = a(jA8, jA11, jA10, jA9, jArr2[11], 22L, 2304563134L);
        long jA13 = a(jA9, jA12, jA11, jA10, jArr2[12], 7L, 1804603682L);
        long jA14 = a(jA10, jA13, jA12, jA11, jArr2[13], 12L, 4254626195L);
        long jA15 = a(jA11, jA14, jA13, jA12, jArr2[14], 17L, 2792965006L);
        long jA16 = a(jA12, jA15, jA14, jA13, jArr2[15], 22L, 1236535329L);
        long jB = b(jA13, jA16, jA15, jA14, jArr2[1], 5L, 4129170786L);
        long jB2 = b(jA14, jB, jA16, jA15, jArr2[6], 9L, 3225465664L);
        long jB3 = b(jA15, jB2, jB, jA16, jArr2[11], 14L, 643717713L);
        long jB4 = b(jA16, jB3, jB2, jB, jArr2[0], 20L, 3921069994L);
        long jB5 = b(jB, jB4, jB3, jB2, jArr2[5], 5L, 3593408605L);
        long jB6 = b(jB2, jB5, jB4, jB3, jArr2[10], 9L, 38016083L);
        long jB7 = b(jB3, jB6, jB5, jB4, jArr2[15], 14L, 3634488961L);
        long jB8 = b(jB4, jB7, jB6, jB5, jArr2[4], 20L, 3889429448L);
        long jB9 = b(jB5, jB8, jB7, jB6, jArr2[9], 5L, 568446438L);
        long jB10 = b(jB6, jB9, jB8, jB7, jArr2[14], 9L, 3275163606L);
        long jB11 = b(jB7, jB10, jB9, jB8, jArr2[3], 14L, 4107603335L);
        long jB12 = b(jB8, jB11, jB10, jB9, jArr2[8], 20L, 1163531501L);
        long jB13 = b(jB9, jB12, jB11, jB10, jArr2[13], 5L, 2850285829L);
        long jB14 = b(jB10, jB13, jB12, jB11, jArr2[2], 9L, 4243563512L);
        long jB15 = b(jB11, jB14, jB13, jB12, jArr2[7], 14L, 1735328473L);
        long jB16 = b(jB12, jB15, jB14, jB13, jArr2[12], 20L, 2368359562L);
        long jC = c(jB13, jB16, jB15, jB14, jArr2[5], 4L, 4294588738L);
        long jC2 = c(jB14, jC, jB16, jB15, jArr2[8], 11L, 2272392833L);
        long jC3 = c(jB15, jC2, jC, jB16, jArr2[11], 16L, 1839030562L);
        long jC4 = c(jB16, jC3, jC2, jC, jArr2[14], 23L, 4259657740L);
        long jC5 = c(jC, jC4, jC3, jC2, jArr2[1], 4L, 2763975236L);
        long jC6 = c(jC2, jC5, jC4, jC3, jArr2[4], 11L, 1272893353L);
        long jC7 = c(jC3, jC6, jC5, jC4, jArr2[7], 16L, 4139469664L);
        long jC8 = c(jC4, jC7, jC6, jC5, jArr2[10], 23L, 3200236656L);
        long jC9 = c(jC5, jC8, jC7, jC6, jArr2[13], 4L, 681279174L);
        long jC10 = c(jC6, jC9, jC8, jC7, jArr2[0], 11L, 3936430074L);
        long jC11 = c(jC7, jC10, jC9, jC8, jArr2[3], 16L, 3572445317L);
        long jC12 = c(jC8, jC11, jC10, jC9, jArr2[6], 23L, 76029189L);
        long jC13 = c(jC9, jC12, jC11, jC10, jArr2[9], 4L, 3654602809L);
        long jC14 = c(jC10, jC13, jC12, jC11, jArr2[12], 11L, 3873151461L);
        long jC15 = c(jC11, jC14, jC13, jC12, jArr2[15], 16L, 530742520L);
        long jC16 = c(jC12, jC15, jC14, jC13, jArr2[2], 23L, 3299628645L);
        long jD = d(jC13, jC16, jC15, jC14, jArr2[0], 6L, 4096336452L);
        long jD2 = d(jC14, jD, jC16, jC15, jArr2[7], 10L, 1126891415L);
        long jD3 = d(jC15, jD2, jD, jC16, jArr2[14], 15L, 2878612391L);
        long jD4 = d(jC16, jD3, jD2, jD, jArr2[5], 21L, 4237533241L);
        long jD5 = d(jD, jD4, jD3, jD2, jArr2[12], 6L, 1700485571L);
        long jD6 = d(jD2, jD5, jD4, jD3, jArr2[3], 10L, 2399980690L);
        long jD7 = d(jD3, jD6, jD5, jD4, jArr2[10], 15L, 4293915773L);
        long jD8 = d(jD4, jD7, jD6, jD5, jArr2[1], 21L, 2240044497L);
        long jD9 = d(jD5, jD8, jD7, jD6, jArr2[8], 6L, 1873313359L);
        long jD10 = d(jD6, jD9, jD8, jD7, jArr2[15], 10L, 4264355552L);
        long jD11 = d(jD7, jD10, jD9, jD8, jArr2[6], 15L, 2734768916L);
        long jD12 = d(jD8, jD11, jD10, jD9, jArr2[13], 21L, 1309151649L);
        long jD13 = d(jD9, jD12, jD11, jD10, jArr2[4], 6L, 4149444226L);
        long jD14 = d(jD10, jD13, jD12, jD11, jArr2[11], 10L, 3174756917L);
        long jD15 = d(jD11, jD14, jD13, jD12, jArr2[2], 15L, 718787259L);
        long jD16 = d(jD12, jD15, jD14, jD13, jArr2[9], 21L, 3951481745L);
        long[] jArr3 = this.f3322b;
        jArr3[0] = jArr3[0] + jD13;
        jArr3[1] = jArr3[1] + jD16;
        jArr3[2] = jArr3[2] + jD15;
        jArr3[3] = jArr3[3] + jD14;
    }

    public static String a(String str) {
        byte[] bytes;
        try {
            bytes = str.getBytes("ISO8859_1");
        } catch (UnsupportedEncodingException unused) {
            bytes = str.getBytes();
        }
        C0452oa c0452oa = new C0452oa();
        c0452oa.a();
        c0452oa.a(new ByteArrayInputStream(bytes), bytes.length);
        byte[] bArr = new byte[8];
        a(bArr, c0452oa.f3323c, 8);
        int i = ((int) (c0452oa.f3323c[0] >>> 3)) & 63;
        c0452oa.a(f3321a, i < 56 ? 56 - i : 120 - i);
        c0452oa.a(bArr, 8);
        a(c0452oa.f3325e, c0452oa.f3322b, 16);
        byte[] bArr2 = c0452oa.f3325e;
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < 16; i2++) {
            byte b2 = bArr2[i2];
            char[] cArr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
            sb.append(new String(new char[]{cArr[(b2 >>> 4) & 15], cArr[b2 & ci.m]}));
        }
        return sb.toString();
    }
}
