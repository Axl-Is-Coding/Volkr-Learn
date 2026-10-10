package io.rong.imlib.httpdns;

import android.util.Base64;
import com.umeng.analytics.pro.ci;
import io.rong.common.rlog.RLog;
import java.io.UnsupportedEncodingException;
import java.security.Key;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.regex.Pattern;
import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;

/* JADX INFO: loaded from: classes5.dex */
final class RongHttpDnsUtil {
    private static final String ALGORITHM = "DES";
    private static final String HEX = "0123456789ABCDEF";
    private static final String IVPARAMETERSPEC = "01020304";
    private static final String SHA1PRNG = "SHA1PRNG";
    private static final String TAG = "RongHttpDnsUtil";
    private static final String TRANSFORMATION = "DES/CBC/PKCS5Padding";
    private static String dynamickey = generateKey();
    private static final String IPV4_PATTERN = "^((0|1\\d?\\d?|2[0-4]?\\d?|25[0-5]?|[3-9]\\d?)\\.){3}(0|1\\d?\\d?|2[0-4]?\\d?|25[0-5]?|[3-9]\\d?)$";
    private static Pattern ipv4Pattern = Pattern.compile(IPV4_PATTERN);

    private RongHttpDnsUtil() {
    }

    private static void appendHex(StringBuffer stringBuffer, byte b2) {
        stringBuffer.append(HEX.charAt((b2 >> 4) & 15));
        stringBuffer.append(HEX.charAt(b2 & ci.m));
    }

    static String decode(String str) {
        return decode(dynamickey, Base64.decode(str, 0));
    }

    static String encode(String str) {
        return encode(dynamickey, str.getBytes());
    }

    private static String generateKey() {
        try {
            byte[] bArr = new byte[20];
            SecureRandom.getInstance(SHA1PRNG).nextBytes(bArr);
            return toHex(bArr);
        } catch (Exception e2) {
            RLog.e(TAG, "generateKey Exception", e2);
            return null;
        }
    }

    private static Key getRawKey(String str) throws Exception {
        return SecretKeyFactory.getInstance(ALGORITHM).generateSecret(new DESKeySpec(str.getBytes()));
    }

    private static boolean isIPV6Compress(String str) {
        return Pattern.matches("^((?:[0-9A-Fa-f]{1,4}(?::[0-9A-Fa-f]{1,4})*)?)::((?:[0-9A-Fa-f]{1,4}(?::[0-9A-Fa-f]{1,4})*)?)$", str);
    }

    private static boolean isIPv6Std(String str) {
        return Pattern.matches("^(?:[0-9a-fA-F]{1,4}:){7}[0-9a-fA-F]{1,4}$", str);
    }

    static String md5(String str) {
        try {
            byte[] bArrDigest = MessageDigest.getInstance("MD5").digest(str.getBytes("UTF-8"));
            StringBuilder sb = new StringBuilder(bArrDigest.length * 2);
            for (byte b2 : bArrDigest) {
                int i = b2 & 255;
                if (i < 16) {
                    sb.append("0");
                }
                sb.append(Integer.toHexString(i));
            }
            return sb.toString();
        } catch (UnsupportedEncodingException e2) {
            RLog.e(TAG, "md5 UnsupportedEncodingException", e2);
            return null;
        } catch (NoSuchAlgorithmException e3) {
            RLog.e(TAG, "md5 NoSuchAlgorithmException", e3);
            return null;
        }
    }

    private static String toHex(byte[] bArr) {
        if (bArr == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer(bArr.length * 2);
        for (byte b2 : bArr) {
            appendHex(stringBuffer, b2);
        }
        return stringBuffer.toString();
    }

    static boolean validateIpv4(String str) {
        return ipv4Pattern.matcher(str).matches();
    }

    static boolean validateIpv6(String str) {
        String strReplaceAll = str.replaceAll("[\\[\\]]", "");
        return isIPv6Std(strReplaceAll) || isIPV6Compress(strReplaceAll);
    }

    private static String decode(String str, byte[] bArr) {
        try {
            Cipher cipher = Cipher.getInstance(TRANSFORMATION);
            cipher.init(2, getRawKey(str), new IvParameterSpec(IVPARAMETERSPEC.getBytes()));
            return new String(cipher.doFinal(bArr));
        } catch (Exception unused) {
            return null;
        }
    }

    private static String encode(String str, byte[] bArr) {
        try {
            Cipher cipher = Cipher.getInstance(TRANSFORMATION);
            cipher.init(1, getRawKey(str), new IvParameterSpec(IVPARAMETERSPEC.getBytes()));
            return Base64.encodeToString(cipher.doFinal(bArr), 0);
        } catch (Exception unused) {
            return null;
        }
    }
}
