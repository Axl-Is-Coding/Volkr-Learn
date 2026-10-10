package okio;

import com.umeng.analytics.pro.ci;
import java.util.Arrays;
import kotlin.jvm.internal.i;

/* JADX INFO: renamed from: okio.-Base64, reason: invalid class name */
/* JADX INFO: compiled from: -Base64.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class Base64 {
    private static final byte[] BASE64 = ByteString.Companion.encodeUtf8("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/").getData$okio();
    private static final byte[] BASE64_URL_SAFE = ByteString.Companion.encodeUtf8("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_").getData$okio();

    public static final byte[] decodeBase64ToArray(String str) {
        int i;
        char cCharAt;
        i.b(str, "$this$decodeBase64ToArray");
        int length = str.length();
        while (length > 0 && ((cCharAt = str.charAt(length - 1)) == '=' || cCharAt == '\n' || cCharAt == '\r' || cCharAt == ' ' || cCharAt == '\t')) {
            length--;
        }
        byte[] bArr = new byte[(int) ((((long) length) * 6) / 8)];
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        for (int i5 = 0; i5 < length; i5++) {
            char cCharAt2 = str.charAt(i5);
            if ('A' <= cCharAt2 && 'Z' >= cCharAt2) {
                i = cCharAt2 - 'A';
            } else if ('a' <= cCharAt2 && 'z' >= cCharAt2) {
                i = cCharAt2 - 'G';
            } else if ('0' <= cCharAt2 && '9' >= cCharAt2) {
                i = cCharAt2 + 4;
            } else if (cCharAt2 == '+' || cCharAt2 == '-') {
                i = 62;
            } else if (cCharAt2 == '/' || cCharAt2 == '_') {
                i = 63;
            } else {
                if (cCharAt2 != '\n' && cCharAt2 != '\r' && cCharAt2 != ' ' && cCharAt2 != '\t') {
                    return null;
                }
            }
            i3 = (i3 << 6) | i;
            i2++;
            if (i2 % 4 == 0) {
                int i6 = i4 + 1;
                bArr[i4] = (byte) (i3 >> 16);
                int i7 = i6 + 1;
                bArr[i6] = (byte) (i3 >> 8);
                bArr[i7] = (byte) i3;
                i4 = i7 + 1;
            }
        }
        int i8 = i2 % 4;
        if (i8 == 1) {
            return null;
        }
        if (i8 == 2) {
            bArr[i4] = (byte) ((i3 << 12) >> 16);
            i4++;
        } else if (i8 == 3) {
            int i9 = i3 << 6;
            int i10 = i4 + 1;
            bArr[i4] = (byte) (i9 >> 16);
            i4 = i10 + 1;
            bArr[i10] = (byte) (i9 >> 8);
        }
        if (i4 == bArr.length) {
            return bArr;
        }
        byte[] bArrCopyOf = Arrays.copyOf(bArr, i4);
        i.a((Object) bArrCopyOf, "java.util.Arrays.copyOf(this, newSize)");
        return bArrCopyOf;
    }

    public static final String encodeBase64(byte[] bArr, byte[] bArr2) {
        i.b(bArr, "$this$encodeBase64");
        i.b(bArr2, "map");
        byte[] bArr3 = new byte[((bArr.length + 2) / 3) * 4];
        int length = bArr.length - (bArr.length % 3);
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int i3 = i + 1;
            byte b2 = bArr[i];
            int i4 = i3 + 1;
            byte b3 = bArr[i3];
            int i5 = i4 + 1;
            byte b4 = bArr[i4];
            int i6 = i2 + 1;
            bArr3[i2] = bArr2[(b2 & 255) >> 2];
            int i7 = i6 + 1;
            bArr3[i6] = bArr2[((b2 & 3) << 4) | ((b3 & 255) >> 4)];
            int i8 = i7 + 1;
            bArr3[i7] = bArr2[((b3 & ci.m) << 2) | ((b4 & 255) >> 6)];
            i2 = i8 + 1;
            bArr3[i8] = bArr2[b4 & Utf8.REPLACEMENT_BYTE];
            i = i5;
        }
        int length2 = bArr.length - length;
        if (length2 == 1) {
            byte b5 = bArr[i];
            int i9 = i2 + 1;
            bArr3[i2] = bArr2[(b5 & 255) >> 2];
            int i10 = i9 + 1;
            bArr3[i9] = bArr2[(b5 & 3) << 4];
            byte b6 = (byte) 61;
            bArr3[i10] = b6;
            bArr3[i10 + 1] = b6;
        } else if (length2 == 2) {
            int i11 = i + 1;
            byte b7 = bArr[i];
            byte b8 = bArr[i11];
            int i12 = i2 + 1;
            bArr3[i2] = bArr2[(b7 & 255) >> 2];
            int i13 = i12 + 1;
            bArr3[i12] = bArr2[((b7 & 3) << 4) | ((b8 & 255) >> 4)];
            bArr3[i13] = bArr2[(b8 & ci.m) << 2];
            bArr3[i13 + 1] = (byte) 61;
        }
        return Platform.toUtf8String(bArr3);
    }

    public static /* synthetic */ String encodeBase64$default(byte[] bArr, byte[] bArr2, int i, Object obj) {
        if ((i & 1) != 0) {
            bArr2 = BASE64;
        }
        return encodeBase64(bArr, bArr2);
    }

    public static final byte[] getBASE64() {
        return BASE64;
    }

    public static final byte[] getBASE64_URL_SAFE() {
        return BASE64_URL_SAFE;
    }
}
