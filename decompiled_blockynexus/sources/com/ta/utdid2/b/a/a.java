package com.ta.utdid2.b.a;

import com.umeng.analytics.pro.ci;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: compiled from: AESUtils.java */
/* JADX INFO: loaded from: classes5.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static byte[] f19339a = {48, 48, 49, 55, 68, 67, 49, 66, 69, 50, 50, 53, 56, 53, 53, 52, 67, 70, 48, 50, 67, 53, 55, 66, 55, 56, 69, 55, 52, 48, 65, 53};

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    private static byte[] m93a(byte[] bArr) throws Exception {
        return a(new String(f19339a, 0, 32));
    }

    private static byte[] b(byte[] bArr, byte[] bArr2) throws Exception {
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "AES");
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(2, secretKeySpec, new IvParameterSpec(new byte[cipher.getBlockSize()]));
        return cipher.doFinal(bArr2);
    }

    public static String d(String str, String str2) {
        byte[] bArrA;
        try {
            bArrA = a(m93a(str.getBytes()), str2.getBytes());
        } catch (Exception unused) {
            bArrA = null;
        }
        if (bArrA != null) {
            return a(bArrA);
        }
        return null;
    }

    public static String e(String str, String str2) {
        try {
            return new String(b(m93a(str.getBytes()), a(str2)));
        } catch (Exception unused) {
            return null;
        }
    }

    private static byte[] a(byte[] bArr, byte[] bArr2) throws Exception {
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "AES");
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(1, secretKeySpec, new IvParameterSpec(new byte[cipher.getBlockSize()]));
        return cipher.doFinal(bArr2);
    }

    public static byte[] a(String str) {
        int length = str.length() / 2;
        byte[] bArr = new byte[length];
        for (int i = 0; i < length; i++) {
            int i2 = i * 2;
            bArr[i] = Integer.valueOf(str.substring(i2, i2 + 2), 16).byteValue();
        }
        return bArr;
    }

    public static String a(byte[] bArr) {
        if (bArr == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer(bArr.length * 2);
        for (byte b2 : bArr) {
            a(stringBuffer, b2);
        }
        return stringBuffer.toString();
    }

    private static void a(StringBuffer stringBuffer, byte b2) {
        stringBuffer.append("0123456789ABCDEF".charAt((b2 >> 4) & 15));
        stringBuffer.append("0123456789ABCDEF".charAt(b2 & ci.m));
    }
}
