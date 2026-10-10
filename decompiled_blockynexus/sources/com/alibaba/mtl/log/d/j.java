package com.alibaba.mtl.log.d;

import com.umeng.analytics.pro.ci;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* JADX INFO: compiled from: MD5Utils.java */
/* JADX INFO: loaded from: classes.dex */
public class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static char[] f3638a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public static String a(byte[] bArr) {
        StringBuilder sb = new StringBuilder(bArr.length * 2);
        for (int i = 0; i < bArr.length; i++) {
            sb.append(f3638a[(bArr[i] & 240) >>> 4]);
            sb.append(f3638a[bArr[i] & ci.m]);
        }
        return sb.toString();
    }

    public static String b(byte[] bArr) {
        byte[] bArrM24a = m24a(bArr);
        return bArrM24a != null ? a(bArrM24a) : "0000000000000000";
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static byte[] m24a(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(bArr);
            return messageDigest.digest();
        } catch (NoSuchAlgorithmException e2) {
            e2.printStackTrace();
            return null;
        }
    }
}
