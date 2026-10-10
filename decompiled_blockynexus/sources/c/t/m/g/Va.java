package c.t.m.g;

import android.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: compiled from: TL */
/* JADX INFO: loaded from: classes.dex */
public final class Va {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final byte[] f3025a = {84, 101, 110, 99, 101, 110, 116, 76, 111, 99, 97, 116, 105, 111, 110, 49};

    private static String a(String str, String str2, int i) {
        if (i != 1 && i != 2) {
            throw new IllegalArgumentException("wrong mode.");
        }
        if (str != null && str.length() != 0) {
            try {
                byte[] bytes = i == 1 ? str.getBytes() : i == 2 ? Base64.decode(str.getBytes(), 2) : null;
                if (bytes != null && bytes.length != 0) {
                    byte[] bArrA = a(bytes, bytes.length, str2, i);
                    if (i == 1) {
                        return Base64.encodeToString(bArrA, 2);
                    }
                    if (i == 2) {
                        return new String(bArrA);
                    }
                    return null;
                }
            } catch (Throwable unused) {
            }
        }
        return "";
    }

    public static String b(String str, String str2) {
        return a(str, str2, 2);
    }

    private static byte[] a(byte[] bArr, int i, String str, int i2) {
        if (i2 != 1 && i2 != 2) {
            throw new IllegalArgumentException("wrong mode.");
        }
        if (bArr != null && bArr.length != 0 && i != 0) {
            try {
                SecretKeySpec secretKeySpec = new SecretKeySpec(str.getBytes("UTF-8"), "AES");
                Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
                cipher.init(i2, secretKeySpec, new IvParameterSpec(f3025a));
                if (cipher == null) {
                    return Ta.f3014a;
                }
                return cipher.doFinal(bArr, 0, i);
            } catch (Throwable unused) {
                return Ta.f3014a;
            }
        }
        return Ta.f3014a;
    }

    public static String a(String str, String str2) {
        return a(str, str2, 1);
    }

    public static byte[] a(byte[] bArr, String str) {
        return a(bArr, bArr.length, str, 1);
    }
}
