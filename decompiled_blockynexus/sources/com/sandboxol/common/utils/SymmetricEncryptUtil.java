package com.sandboxol.common.utils;

import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: classes3.dex */
public class SymmetricEncryptUtil {
    public static String encryption(String str, String str2) {
        return parseByte2HexStr(getEncryptByteArr(str, str2));
    }

    private static byte[] getEncryptByteArr(String str, String str2) {
        try {
            KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
            SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG");
            secureRandom.setSeed(str2.getBytes());
            keyGenerator.init(128, secureRandom);
            SecretKeySpec secretKeySpec = new SecretKeySpec(keyGenerator.generateKey().getEncoded(), "AES");
            Cipher cipher = Cipher.getInstance("AES");
            byte[] bytes = str.getBytes("utf-8");
            cipher.init(1, secretKeySpec);
            return cipher.doFinal(bytes);
        } catch (Exception e2) {
            e2.printStackTrace();
            return new byte[0];
        }
    }

    private static String parseByte2HexStr(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer();
        for (byte b2 : bArr) {
            String hexString = Integer.toHexString(b2 & 255);
            if (hexString.length() == 1) {
                hexString = '0' + hexString;
            }
            stringBuffer.append(hexString.toUpperCase());
        }
        return stringBuffer.toString();
    }
}
