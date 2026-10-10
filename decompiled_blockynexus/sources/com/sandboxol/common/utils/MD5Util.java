package com.sandboxol.common.utils;

import com.umeng.analytics.pro.ci;
import io.rong.common.dlog.DLog;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* JADX INFO: loaded from: classes3.dex */
public class MD5Util {
    protected static char[] hexDigits = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    private static void appendHexPair(byte b2, StringBuffer stringBuffer) {
        char[] cArr = hexDigits;
        char c2 = cArr[(b2 & 240) >> 4];
        char c3 = cArr[b2 & ci.m];
        stringBuffer.append(c2);
        stringBuffer.append(c3);
    }

    private static String bufferToHex(byte[] bArr) {
        return bufferToHex(bArr, 0, bArr.length);
    }

    public static boolean checkPassword(String str, String str2) {
        return getMD5String(str).equals(str2);
    }

    public static String getFileMD5String(File file) throws IOException {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            FileInputStream fileInputStream = new FileInputStream(file);
            byte[] bArr = new byte[DLog.CRS];
            while (true) {
                int i = fileInputStream.read(bArr);
                if (i == -1) {
                    fileInputStream.close();
                    return bufferToHex(messageDigest.digest());
                }
                messageDigest.update(bArr, 0, i);
            }
        } catch (NoSuchAlgorithmException e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public static String getMD5String(String str) {
        return getMD5String(str.getBytes());
    }

    private static String bufferToHex(byte[] bArr, int i, int i2) {
        StringBuffer stringBuffer = new StringBuffer(i2 * 2);
        int i3 = i2 + i;
        while (i < i3) {
            appendHexPair(bArr[i], stringBuffer);
            i++;
        }
        return stringBuffer.toString();
    }

    public static String getMD5String(byte[] bArr) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(bArr);
            return bufferToHex(messageDigest.digest());
        } catch (NoSuchAlgorithmException e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public static String getFileMD5String(InputStream inputStream) throws IOException {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            byte[] bArr = new byte[DLog.CRS];
            while (true) {
                int i = inputStream.read(bArr);
                if (i != -1) {
                    messageDigest.update(bArr, 0, i);
                } else {
                    inputStream.close();
                    return bufferToHex(messageDigest.digest());
                }
            }
        } catch (NoSuchAlgorithmException e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public static String getFileMD5String(InputStream inputStream, MessageDigest messageDigest) throws IOException {
        byte[] bArr = new byte[DLog.CRS];
        while (true) {
            int i = inputStream.read(bArr);
            if (i != -1) {
                messageDigest.update(bArr, 0, i);
            } else {
                inputStream.close();
                return bufferToHex(messageDigest.digest());
            }
        }
    }
}
