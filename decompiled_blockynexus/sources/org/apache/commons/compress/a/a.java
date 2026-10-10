package org.apache.commons.compress.a;

import java.io.UnsupportedEncodingException;

/* JADX INFO: compiled from: ArchiveUtils.java */
/* JADX INFO: loaded from: classes5.dex */
public class a {
    public static boolean a(String str, byte[] bArr, int i, int i2) {
        try {
            byte[] bytes = str.getBytes("US-ASCII");
            return a(bytes, 0, bytes.length, bArr, i, i2, false);
        } catch (UnsupportedEncodingException e2) {
            throw new RuntimeException(e2);
        }
    }

    public static boolean a(byte[] bArr, int i, int i2, byte[] bArr2, int i3, int i4, boolean z) {
        int i5 = i2 < i4 ? i2 : i4;
        for (int i6 = 0; i6 < i5; i6++) {
            if (bArr[i + i6] != bArr2[i3 + i6]) {
                return false;
            }
        }
        if (i2 == i4) {
            return true;
        }
        if (!z) {
            return false;
        }
        if (i2 > i4) {
            while (i4 < i2) {
                if (bArr[i + i4] != 0) {
                    return false;
                }
                i4++;
            }
        } else {
            while (i2 < i4) {
                if (bArr2[i3 + i2] != 0) {
                    return false;
                }
                i2++;
            }
        }
        return true;
    }

    public static boolean a(byte[] bArr, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            if (bArr[i2] != 0) {
                return false;
            }
        }
        return true;
    }
}
