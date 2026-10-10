package com.tendcloud.tenddata;

import com.tendcloud.tenddata.t;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;

/* JADX INFO: compiled from: td */
/* JADX INFO: loaded from: classes5.dex */
final class av {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static IvParameterSpec f19803a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static byte[] f19804b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static SecretKey f19805c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final int f19806d = 128;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final int f19807e = 10000;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final String f19808f = "iv";
    private static final String g = "salt";
    private static final int h = 16;
    private static final int i = 32;
    private static final String j = "AES/CBC/PKCS5Padding";
    private static final String k = "PBKDF2WithHmacSHA1";
    private static final String l = ax.a() + "";
    private static final String m = "AES";

    static {
        try {
            f19805c = a(l.toCharArray(), b());
        } catch (Throwable unused) {
        }
    }

    av() {
    }

    private static IvParameterSpec a() {
        IvParameterSpec ivParameterSpec = f19803a;
        if (ivParameterSpec != null) {
            return ivParameterSpec;
        }
        try {
            t.getFileLock(t.b.AES_IV_LOCK.toString());
            byte[] bArrA = aw.a(f19808f, 16);
            if (bArrA == null) {
                bArrA = a(16);
                aw.a(f19808f, bArrA);
            }
            f19803a = new IvParameterSpec(bArrA);
        } catch (Throwable unused) {
        }
        t.releaseFileLock(t.b.AES_IV_LOCK.toString());
        return f19803a;
    }

    private static byte[] b() {
        byte[] bArr = f19804b;
        if (bArr != null) {
            return bArr;
        }
        try {
            t.getFileLock(t.b.AES_SALT_LOCK.toString());
            f19804b = aw.a(g, 32);
            if (f19804b == null || f19804b.length == 0) {
                f19804b = a(32);
                aw.a(g, f19804b);
            }
        } catch (Throwable unused) {
        }
        t.releaseFileLock(t.b.AES_SALT_LOCK.toString());
        return f19804b;
    }

    private static byte[] a(int i2) {
        byte[] bArr = new byte[i2];
        af.b().nextBytes(bArr);
        return bArr;
    }

    static byte[] b(byte[] bArr) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, InvalidAlgorithmParameterException {
        if (f19805c == null) {
            f19805c = a(String.valueOf(ax.a()).toCharArray(), b());
        }
        Cipher cipher = Cipher.getInstance(af.b(19) ? m : j);
        cipher.init(2, f19805c, a());
        return cipher.doFinal(bArr);
    }

    private static SecretKey a(char[] cArr, byte[] bArr) {
        return SecretKeyFactory.getInstance(k).generateSecret(new PBEKeySpec(cArr, bArr, 10000, 128));
    }

    static byte[] a(byte[] bArr) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, InvalidAlgorithmParameterException {
        if (f19805c == null) {
            f19805c = a(String.valueOf(ax.a()).toCharArray(), b());
        }
        Cipher cipher = Cipher.getInstance(af.b(19) ? m : j);
        cipher.init(1, f19805c, a());
        return cipher.doFinal(bArr);
    }
}
