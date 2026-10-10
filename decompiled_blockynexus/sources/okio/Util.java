package okio;

import com.umeng.analytics.pro.au;
import com.umeng.analytics.pro.ci;
import kotlin.jvm.internal.i;
import okio.internal.ByteStringKt;

/* JADX INFO: renamed from: okio.-Util, reason: invalid class name */
/* JADX INFO: compiled from: -Util.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class Util {
    public static final int and(byte b2, int i) {
        return b2 & i;
    }

    public static final long and(byte b2, long j) {
        return j & ((long) b2);
    }

    public static final long and(int i, long j) {
        return j & ((long) i);
    }

    public static final boolean arrayRangeEquals(byte[] bArr, int i, byte[] bArr2, int i2, int i3) {
        i.b(bArr, au.at);
        i.b(bArr2, "b");
        for (int i4 = 0; i4 < i3; i4++) {
            if (bArr[i4 + i] != bArr2[i4 + i2]) {
                return false;
            }
        }
        return true;
    }

    public static final void checkOffsetAndCount(long j, long j2, long j3) {
        if ((j2 | j3) < 0 || j2 > j || j - j2 < j3) {
            throw new ArrayIndexOutOfBoundsException("size=" + j + " offset=" + j2 + " byteCount=" + j3);
        }
    }

    public static final long minOf(long j, int i) {
        return Math.min(j, i);
    }

    public static final int reverseBytes(int i) {
        return ((i & 255) << 24) | (((-16777216) & i) >>> 24) | ((16711680 & i) >>> 8) | ((65280 & i) << 8);
    }

    public static final long reverseBytes(long j) {
        return ((j & 255) << 56) | (((-72057594037927936L) & j) >>> 56) | ((71776119061217280L & j) >>> 40) | ((280375465082880L & j) >>> 24) | ((1095216660480L & j) >>> 8) | ((4278190080L & j) << 8) | ((16711680 & j) << 24) | ((65280 & j) << 40);
    }

    public static final short reverseBytes(short s) {
        int i = s & 65535;
        return (short) (((i & 255) << 8) | ((65280 & i) >>> 8));
    }

    public static final int shl(byte b2, int i) {
        return b2 << i;
    }

    public static final int shr(byte b2, int i) {
        return b2 >> i;
    }

    public static final String toHexString(byte b2) {
        return new String(new char[]{'0', 'x', ByteStringKt.getHEX_DIGIT_CHARS()[(b2 >> 4) & 15], ByteStringKt.getHEX_DIGIT_CHARS()[b2 & ci.m]});
    }

    public static final long minOf(int i, long j) {
        return Math.min(i, j);
    }

    public static final String toHexString(int i) {
        char[] cArr = new char[10];
        cArr[2] = ByteStringKt.getHEX_DIGIT_CHARS()[(i >> 28) & 15];
        cArr[3] = ByteStringKt.getHEX_DIGIT_CHARS()[(i >> 24) & 15];
        cArr[4] = ByteStringKt.getHEX_DIGIT_CHARS()[(i >> 20) & 15];
        cArr[5] = ByteStringKt.getHEX_DIGIT_CHARS()[(i >> 16) & 15];
        cArr[6] = ByteStringKt.getHEX_DIGIT_CHARS()[(i >> 12) & 15];
        cArr[7] = ByteStringKt.getHEX_DIGIT_CHARS()[(i >> 8) & 15];
        cArr[8] = ByteStringKt.getHEX_DIGIT_CHARS()[(i >> 4) & 15];
        cArr[9] = ByteStringKt.getHEX_DIGIT_CHARS()[i & 15];
        int i2 = 2;
        while (i2 < 10 && cArr[i2] == '0') {
            i2++;
        }
        int i3 = i2 - 2;
        cArr[i3] = '0';
        cArr[i3 + 1] = 'x';
        return new String(cArr, i3, 10 - i3);
    }
}
