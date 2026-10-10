package io.rong.imlib.common;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import com.umeng.analytics.pro.ci;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* JADX INFO: loaded from: classes5.dex */
public class SignatureUtils {
    private static final char[] HEX_DIGITS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    public static String bytes2HexString(byte[] bArr) {
        char[] cArr = new char[bArr.length << 1];
        int i = 0;
        for (int i2 = 0; i2 < bArr.length; i2++) {
            int i3 = i + 1;
            char[] cArr2 = HEX_DIGITS;
            cArr[i] = cArr2[(bArr[i2] >>> 4) & 15];
            i = i3 + 1;
            cArr[i3] = cArr2[bArr[i2] & ci.m];
        }
        return new String(cArr);
    }

    private static byte[] encryptAlgorithm(byte[] bArr, String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(str);
            messageDigest.update(bArr);
            return messageDigest.digest();
        } catch (NoSuchAlgorithmException e2) {
            e2.printStackTrace();
            return new byte[0];
        }
    }

    public static byte[] encryptSHA1(byte[] bArr) {
        return encryptAlgorithm(bArr, "SHA-1");
    }

    public static String encryptSHA1ToString(byte[] bArr) {
        return bytes2HexString(encryptSHA1(bArr));
    }

    @SuppressLint({"PackageManagerGetSignatures"})
    public static Signature[] getAppSignature(Context context, String str) {
        if (isNullString(str)) {
            return null;
        }
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 64);
            if (packageInfo == null) {
                return null;
            }
            return packageInfo.signatures;
        } catch (PackageManager.NameNotFoundException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static String getAppSignatureSHA1(Context context, String str) {
        Signature[] appSignature = getAppSignature(context, str);
        if (appSignature == null) {
            return null;
        }
        return encryptSHA1ToString(appSignature[0].toByteArray()).replaceAll("(?<=[0-9A-F]{2})[0-9A-F]{2}", ":$0");
    }

    public static String getAppSignatureSHA1NoSign(Context context) {
        Signature[] appSignature = getAppSignature(context, context.getPackageName());
        if (appSignature == null) {
            return null;
        }
        return encryptSHA1ToString(appSignature[0].toByteArray());
    }

    public static boolean isNullString(String str) {
        return str == null || str.length() == 0 || "null".equals(str);
    }

    public static String getAppSignatureSHA1(Context context) {
        return getAppSignatureSHA1(context, context.getPackageName());
    }
}
