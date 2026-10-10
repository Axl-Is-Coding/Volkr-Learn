package com.localapi;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.nio.charset.StandardCharsets;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Arrays;
import javax.crypto.Cipher;

/* JADX INFO: loaded from: classes6.dex */
public final class RsaCipher {
    private static final char[] B64 = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".toCharArray();
    private static final int CHUNK_MAX = 117;
    private static final String PRIVATE_KEY_B64 = "MIICdwIBADANBgkqhkiG9w0BAQEFAASCAmEwggJdAgEAAoGBAKnjrpuTJyQCS5VFE9i6wM3Jbe6uOV7LPWmz/+spcjaM/MUAxnpoj89syYV3G/dqWedJ47bS+OaB7YLBEAgVolunqH85C9841OErJ8T9jZK2m4F1hMM5w6JVRC4TRgj5E4IcAqV4ugkMUTUfvQEHISrTsdryyVaIfF8lQwCLfrDDAgMBAAECgYA/ISUEGKVlwxiVCks6sQLuNViNZd5ZtEpI2iNSHl+bl75h8kzOtcYivPkRiFYzFSj9Qj7E9BabiVJZ0SYE6w0eSOwCjLZyOUe3Op421pOpLbgKK32tx5CMmbDuwGIlgtSsDRaBeAvJL0TNshaHriVz4PPQX6dHIUnVI6FT49EHAQJBANFAstrgFz0+xM8480YFf8MbDetx9Tw/cnlNV5Zn6NywMuM7OFvCOx1KIrZ8FRFrINzFePKB3/Bn0gHy5wQzI4ECQQDP18SKDxLMxt7vBfukJF6qXfvFHFjEkbF1tTeKzsdpEkinfyEFaGWHBYGJAhVGjCCKSNfo7M9B3F7T1j0Rd2ZDAkEAtXIgpOJDxHu1NOrxJ/qEuq2u+EYsnD14Ce8iz+zyYsr2lUs4p3hYwiES0KHvstbt/AHPypkLke60j7QM1ftyAQJAWENB5HsoOawOiiTZS0hipyjIPVmfXMKeQOVXE+xiBH3OOssjA7/ktaUh8EPhMxdYzkDG59SA43ApGP626k7xLwJBAMTSTHa/9vIVNlS7XlTAgUXX6X7mSoOBsId/1CpuR4n9BwFA7QlWv/7TRqbsYCIBFpvVpo+WdL0iLh41SM5u73c=";
    public static final String PUBLIC_KEY_B64 = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCp466bkyckAkuVRRPYusDNyW3urjleyz1ps//rKXI2jPzFAMZ6aI/PbMmFdxv3alnnSeO20vjmge2CwRAIFaJbp6h/OQvfONThKyfE/Y2StpuBdYTDOcOiVUQuE0YI+ROCHAKleLoJDFE1H70BByEq07Ha8slWiHxfJUMAi36wwwIDAQAB";
    private static final int RSA_BYTES = 128;

    private RsaCipher() {
    }

    public static String encrypt(String str) {
        try {
            Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            cipher.init(1, publicKey());
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(str.getBytes(StandardCharsets.UTF_8));
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr = new byte[117];
            while (true) {
                int i = byteArrayInputStream.read(bArr);
                if (i != -1) {
                    cipher.update(i == 117 ? bArr : Arrays.copyOf(bArr, i));
                } else {
                    str = b64Encode(byteArrayOutputStream.toByteArray());
                    return str;
                }
            }
        } catch (Exception unused) {
            return str;
        }
    }

    public static String decryptIfEncrypted(String str) {
        byte[] bArrB64Decode;
        if (str != null && str.length() >= 128 && (bArrB64Decode = b64Decode(str)) != null && bArrB64Decode.length != 0 && bArrB64Decode.length % 128 == 0) {
            try {
                Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
                cipher.init(2, privateKey());
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                for (int i = 0; i < bArrB64Decode.length; i += 128) {
                    byteArrayOutputStream.write(cipher.doFinal(bArrB64Decode, i, 128));
                }
                return new String(byteArrayOutputStream.toByteArray(), StandardCharsets.UTF_8);
            } catch (Exception unused) {
            }
        }
        return str;
    }

    private static PublicKey publicKey() throws Exception {
        return KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(b64Decode(PUBLIC_KEY_B64)));
    }

    private static PrivateKey privateKey() throws Exception {
        return KeyFactory.getInstance("RSA").generatePrivate(new PKCS8EncodedKeySpec(b64Decode(PRIVATE_KEY_B64)));
    }

    private static String b64Encode(byte[] bArr) {
        StringBuilder sb = new StringBuilder(((bArr.length + 2) / 3) * 4);
        for (int i = 0; i < bArr.length; i += 3) {
            byte b2 = bArr[i];
            int i2 = b2 & 255;
            int i3 = i + 1;
            int i4 = i3 < bArr.length ? bArr[i3] & 255 : 0;
            int i5 = i + 2;
            int i6 = i5 < bArr.length ? bArr[i5] & 255 : 0;
            char[] cArr = B64;
            sb.append(cArr[i2 >> 2]);
            sb.append(cArr[((b2 & 3) << 4) | (i4 >> 4)]);
            char c2 = '=';
            sb.append(i3 < bArr.length ? cArr[((i4 & 15) << 2) | (i6 >> 6)] : '=');
            if (i5 < bArr.length) {
                c2 = cArr[i6 & 63];
            }
            sb.append(c2);
        }
        return sb.toString();
    }

    private static byte[] b64Decode(String str) {
        if (str == null) {
            return null;
        }
        int[] iArr = new int[128];
        Arrays.fill(iArr, -1);
        int i = 0;
        while (true) {
            char[] cArr = B64;
            if (i >= cArr.length) {
                break;
            }
            iArr[cArr[i]] = i;
            i++;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream((str.length() * 3) / 4);
        int i2 = 0;
        int i3 = 0;
        for (int i4 = 0; i4 < str.length(); i4++) {
            char cCharAt = str.charAt(i4);
            if (cCharAt != '=' && cCharAt != '\n' && cCharAt != '\r' && !Character.isWhitespace(cCharAt)) {
                int i5 = cCharAt < 128 ? iArr[cCharAt] : -1;
                if (i5 < 0) {
                    return null;
                }
                i2 = (i2 << 6) | i5;
                int i6 = i3 + 6;
                if (i6 >= 8) {
                    i3 -= 2;
                    byteArrayOutputStream.write((i2 >> i3) & 255);
                } else {
                    i3 = i6;
                }
            }
        }
        return byteArrayOutputStream.toByteArray();
    }
}
