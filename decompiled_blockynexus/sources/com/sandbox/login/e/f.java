package com.sandbox.login.e;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;

/* JADX INFO: compiled from: RSAUtils.java */
/* JADX INFO: loaded from: classes2.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String f15753a = "RSA/ECB/PKCS1Padding";

    public static String a(String str, String str2) {
        byte[] bArr;
        try {
            Cipher cipher = Cipher.getInstance(f15753a);
            cipher.init(1, a(str));
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(str2.getBytes());
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr2 = new byte[117];
            while (true) {
                int i = byteArrayInputStream.read(bArr2);
                if (i == -1) {
                    return b.a(byteArrayOutputStream.toByteArray());
                }
                if (bArr2.length == i) {
                    bArr = bArr2;
                } else {
                    bArr = new byte[i];
                    for (int i2 = 0; i2 < i; i2++) {
                        bArr[i2] = bArr2[i2];
                    }
                }
                byteArrayOutputStream.write(cipher.doFinal(bArr));
            }
        } catch (InvalidKeyException e2) {
            e2.printStackTrace();
            return null;
        } catch (BadPaddingException e3) {
            e3.printStackTrace();
            return null;
        } catch (IllegalBlockSizeException e4) {
            e4.printStackTrace();
            return null;
        } catch (Exception e5) {
            e5.printStackTrace();
            return null;
        }
    }

    public static PublicKey a(String str) throws Exception {
        return KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(b.a(str)));
    }
}
