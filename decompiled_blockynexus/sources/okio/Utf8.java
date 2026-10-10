package okio;

import kotlin.jvm.a.b;
import kotlin.jvm.internal.i;
import kotlin.l;

/* JADX INFO: compiled from: Utf8.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class Utf8 {
    public static final int HIGH_SURROGATE_HEADER = 55232;
    public static final int LOG_SURROGATE_HEADER = 56320;
    public static final int MASK_2BYTES = 3968;
    public static final int MASK_3BYTES = -123008;
    public static final int MASK_4BYTES = 3678080;
    public static final byte REPLACEMENT_BYTE = 63;
    public static final char REPLACEMENT_CHARACTER = 65533;
    public static final int REPLACEMENT_CODE_POINT = 65533;

    public static final boolean isIsoControl(int i) {
        return (i >= 0 && 31 >= i) || (127 <= i && 159 >= i);
    }

    public static final boolean isUtf8Continuation(byte b2) {
        return (b2 & 192) == 128;
    }

    public static final int process2Utf8Bytes(byte[] bArr, int i, int i2, b<? super Integer, l> bVar) {
        i.b(bArr, "$this$process2Utf8Bytes");
        i.b(bVar, "yield");
        int i3 = i + 1;
        Integer numValueOf = Integer.valueOf(REPLACEMENT_CODE_POINT);
        if (i2 <= i3) {
            bVar.invoke(numValueOf);
            return 1;
        }
        byte b2 = bArr[i];
        byte b3 = bArr[i3];
        if (!((b3 & 192) == 128)) {
            bVar.invoke(numValueOf);
            return 1;
        }
        int i4 = (b3 ^ 3968) ^ (b2 << 6);
        if (i4 < 128) {
            bVar.invoke(numValueOf);
            return 2;
        }
        bVar.invoke(Integer.valueOf(i4));
        return 2;
    }

    public static final int process3Utf8Bytes(byte[] bArr, int i, int i2, b<? super Integer, l> bVar) {
        i.b(bArr, "$this$process3Utf8Bytes");
        i.b(bVar, "yield");
        int i3 = i + 2;
        Integer numValueOf = Integer.valueOf(REPLACEMENT_CODE_POINT);
        if (i2 <= i3) {
            bVar.invoke(numValueOf);
            int i4 = i + 1;
            if (i2 > i4) {
                if ((bArr[i4] & 192) == 128) {
                    return 2;
                }
            }
            return 1;
        }
        byte b2 = bArr[i];
        byte b3 = bArr[i + 1];
        if (!((b3 & 192) == 128)) {
            bVar.invoke(numValueOf);
            return 1;
        }
        byte b4 = bArr[i3];
        if (!((b4 & 192) == 128)) {
            bVar.invoke(numValueOf);
            return 2;
        }
        int i5 = ((b4 ^ (-123008)) ^ (b3 << 6)) ^ (b2 << 12);
        if (i5 < 2048) {
            bVar.invoke(numValueOf);
            return 3;
        }
        if (55296 <= i5 && 57343 >= i5) {
            bVar.invoke(numValueOf);
            return 3;
        }
        bVar.invoke(Integer.valueOf(i5));
        return 3;
    }

    public static final int process4Utf8Bytes(byte[] bArr, int i, int i2, b<? super Integer, l> bVar) {
        i.b(bArr, "$this$process4Utf8Bytes");
        i.b(bVar, "yield");
        int i3 = i + 3;
        Integer numValueOf = Integer.valueOf(REPLACEMENT_CODE_POINT);
        if (i2 <= i3) {
            bVar.invoke(numValueOf);
            int i4 = i + 1;
            if (i2 > i4) {
                if ((bArr[i4] & 192) == 128) {
                    int i5 = i + 2;
                    if (i2 > i5) {
                        if ((bArr[i5] & 192) == 128) {
                            return 3;
                        }
                    }
                    return 2;
                }
            }
            return 1;
        }
        byte b2 = bArr[i];
        byte b3 = bArr[i + 1];
        if (!((b3 & 192) == 128)) {
            bVar.invoke(numValueOf);
            return 1;
        }
        byte b4 = bArr[i + 2];
        if (!((b4 & 192) == 128)) {
            bVar.invoke(numValueOf);
            return 2;
        }
        byte b5 = bArr[i3];
        if (!((b5 & 192) == 128)) {
            bVar.invoke(numValueOf);
            return 3;
        }
        int i6 = (((b5 ^ 3678080) ^ (b4 << 6)) ^ (b3 << 12)) ^ (b2 << 18);
        if (i6 > 1114111) {
            bVar.invoke(numValueOf);
            return 4;
        }
        if (55296 <= i6 && 57343 >= i6) {
            bVar.invoke(numValueOf);
            return 4;
        }
        if (i6 < 65536) {
            bVar.invoke(numValueOf);
            return 4;
        }
        bVar.invoke(Integer.valueOf(i6));
        return 4;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0111  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0114  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void processUtf16Chars(byte[] r16, int r17, int r18, kotlin.jvm.a.b<? super java.lang.Character, kotlin.l> r19) {
        /*
            Method dump skipped, instruction units count: 424
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.Utf8.processUtf16Chars(byte[], int, int, kotlin.jvm.a.b):void");
    }

    public static final void processUtf8Bytes(String str, int i, int i2, b<? super Byte, l> bVar) {
        int i3;
        char cCharAt;
        i.b(str, "$this$processUtf8Bytes");
        i.b(bVar, "yield");
        while (i < i2) {
            char cCharAt2 = str.charAt(i);
            if (cCharAt2 < 128) {
                bVar.invoke(Byte.valueOf((byte) cCharAt2));
                i++;
                while (i < i2 && str.charAt(i) < 128) {
                    bVar.invoke(Byte.valueOf((byte) str.charAt(i)));
                    i++;
                }
            } else {
                if (cCharAt2 < 2048) {
                    bVar.invoke(Byte.valueOf((byte) ((cCharAt2 >> 6) | 192)));
                    bVar.invoke(Byte.valueOf((byte) ((cCharAt2 & '?') | 128)));
                } else if (55296 > cCharAt2 || 57343 < cCharAt2) {
                    bVar.invoke(Byte.valueOf((byte) ((cCharAt2 >> '\f') | 224)));
                    bVar.invoke(Byte.valueOf((byte) (((cCharAt2 >> 6) & 63) | 128)));
                    bVar.invoke(Byte.valueOf((byte) ((cCharAt2 & '?') | 128)));
                } else if (cCharAt2 > 56319 || i2 <= (i3 = i + 1) || 56320 > (cCharAt = str.charAt(i3)) || 57343 < cCharAt) {
                    bVar.invoke(Byte.valueOf(REPLACEMENT_BYTE));
                } else {
                    int iCharAt = ((cCharAt2 << '\n') + str.charAt(i3)) - 56613888;
                    bVar.invoke(Byte.valueOf((byte) ((iCharAt >> 18) | 240)));
                    bVar.invoke(Byte.valueOf((byte) (((iCharAt >> 12) & 63) | 128)));
                    bVar.invoke(Byte.valueOf((byte) (((iCharAt >> 6) & 63) | 128)));
                    bVar.invoke(Byte.valueOf((byte) ((iCharAt & 63) | 128)));
                    i += 2;
                }
                i++;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x010f  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0112  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void processUtf8CodePoints(byte[] r16, int r17, int r18, kotlin.jvm.a.b<? super java.lang.Integer, kotlin.l> r19) {
        /*
            Method dump skipped, instruction units count: 397
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.Utf8.processUtf8CodePoints(byte[], int, int, kotlin.jvm.a.b):void");
    }

    public static final long size(String str) {
        return size$default(str, 0, 0, 3, null);
    }

    public static final long size(String str, int i) {
        return size$default(str, i, 0, 2, null);
    }

    public static final long size(String str, int i, int i2) {
        int i3;
        i.b(str, "$this$utf8Size");
        if (!(i >= 0)) {
            throw new IllegalArgumentException(("beginIndex < 0: " + i).toString());
        }
        if (!(i2 >= i)) {
            throw new IllegalArgumentException(("endIndex < beginIndex: " + i2 + " < " + i).toString());
        }
        if (!(i2 <= str.length())) {
            throw new IllegalArgumentException(("endIndex > string.length: " + i2 + " > " + str.length()).toString());
        }
        long j = 0;
        while (i < i2) {
            char cCharAt = str.charAt(i);
            if (cCharAt < 128) {
                j++;
            } else {
                if (cCharAt < 2048) {
                    i3 = 2;
                } else if (cCharAt < 55296 || cCharAt > 57343) {
                    i3 = 3;
                } else {
                    int i4 = i + 1;
                    char cCharAt2 = i4 < i2 ? str.charAt(i4) : (char) 0;
                    if (cCharAt > 56319 || cCharAt2 < 56320 || cCharAt2 > 57343) {
                        j++;
                        i = i4;
                    } else {
                        j += (long) 4;
                        i += 2;
                    }
                }
                j += (long) i3;
            }
            i++;
        }
        return j;
    }

    public static /* synthetic */ long size$default(String str, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = str.length();
        }
        return size(str, i, i2);
    }
}
