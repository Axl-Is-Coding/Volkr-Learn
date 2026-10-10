package okio.internal;

import java.util.Arrays;
import kotlin.jvm.internal.i;
import okio.Utf8;

/* JADX INFO: compiled from: -Utf8.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class _Utf8Kt {
    public static final byte[] commonAsUtf8ToByteArray(String str) {
        int i;
        int i2;
        char cCharAt;
        i.b(str, "$this$commonAsUtf8ToByteArray");
        byte[] bArr = new byte[str.length() * 4];
        int length = str.length();
        int i3 = 0;
        while (i3 < length) {
            char cCharAt2 = str.charAt(i3);
            if (cCharAt2 >= 128) {
                int length2 = str.length();
                int i4 = i3;
                while (i3 < length2) {
                    char cCharAt3 = str.charAt(i3);
                    if (cCharAt3 < 128) {
                        int i5 = i4 + 1;
                        bArr[i4] = (byte) cCharAt3;
                        i3++;
                        while (i3 < length2 && str.charAt(i3) < 128) {
                            bArr[i5] = (byte) str.charAt(i3);
                            i3++;
                            i5++;
                        }
                        i4 = i5;
                    } else {
                        if (cCharAt3 < 2048) {
                            int i6 = i4 + 1;
                            bArr[i4] = (byte) ((cCharAt3 >> 6) | 192);
                            byte b2 = (byte) ((cCharAt3 & '?') | 128);
                            i = i6 + 1;
                            bArr[i6] = b2;
                        } else if (55296 > cCharAt3 || 57343 < cCharAt3) {
                            int i7 = i4 + 1;
                            bArr[i4] = (byte) ((cCharAt3 >> '\f') | 224);
                            int i8 = i7 + 1;
                            bArr[i7] = (byte) (((cCharAt3 >> 6) & 63) | 128);
                            byte b3 = (byte) ((cCharAt3 & '?') | 128);
                            i = i8 + 1;
                            bArr[i8] = b3;
                        } else if (cCharAt3 > 56319 || length2 <= (i2 = i3 + 1) || 56320 > (cCharAt = str.charAt(i2)) || 57343 < cCharAt) {
                            i = i4 + 1;
                            bArr[i4] = Utf8.REPLACEMENT_BYTE;
                        } else {
                            int iCharAt = ((cCharAt3 << '\n') + str.charAt(i2)) - 56613888;
                            int i9 = i4 + 1;
                            bArr[i4] = (byte) ((iCharAt >> 18) | 240);
                            int i10 = i9 + 1;
                            bArr[i9] = (byte) (((iCharAt >> 12) & 63) | 128);
                            int i11 = i10 + 1;
                            bArr[i10] = (byte) (((iCharAt >> 6) & 63) | 128);
                            byte b4 = (byte) ((iCharAt & 63) | 128);
                            i = i11 + 1;
                            bArr[i11] = b4;
                            i3 += 2;
                            i4 = i;
                        }
                        i3++;
                        i4 = i;
                    }
                }
                byte[] bArrCopyOf = Arrays.copyOf(bArr, i4);
                i.a((Object) bArrCopyOf, "java.util.Arrays.copyOf(this, newSize)");
                return bArrCopyOf;
            }
            bArr[i3] = (byte) cCharAt2;
            i3++;
        }
        byte[] bArrCopyOf2 = Arrays.copyOf(bArr, str.length());
        i.a((Object) bArrCopyOf2, "java.util.Arrays.copyOf(this, newSize)");
        return bArrCopyOf2;
    }

    /* JADX WARN: Removed duplicated region for block: B:87:0x0111 A[PHI: r6
      0x0111: PHI (r6v42 int) = (r6v39 int), (r6v44 int), (r6v44 int) binds: [B:100:0x0138, B:81:0x0104, B:86:0x010f] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0114 A[PHI: r6
      0x0114: PHI (r6v41 int) = (r6v40 int), (r6v44 int), (r6v44 int) binds: [B:94:0x0126, B:73:0x00f4, B:78:0x00ff] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.String commonToUtf8String(byte[] r17, int r18, int r19) {
        /*
            Method dump skipped, instruction units count: 467
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.internal._Utf8Kt.commonToUtf8String(byte[], int, int):java.lang.String");
    }

    public static /* synthetic */ String commonToUtf8String$default(byte[] bArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = bArr.length;
        }
        return commonToUtf8String(bArr, i, i2);
    }
}
