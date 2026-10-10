package com.alibaba.sdk.android.utils;

import com.umeng.analytics.pro.ci;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* JADX INFO: compiled from: Toolkit.java */
/* JADX INFO: loaded from: classes.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final char[] f3963a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static boolean m38a(String str) {
        return str == null || str.length() == 0;
    }

    public static String b(String str) throws NoSuchAlgorithmException {
        return a(MessageDigest.getInstance("SHA-1").digest(str.getBytes()));
    }

    public static void a(double d2) {
        try {
            Thread.sleep((long) (d2 * 1000.0d));
        } catch (InterruptedException e2) {
            e2.printStackTrace();
        }
    }

    public static String a(String str) throws NoSuchAlgorithmException {
        return a(MessageDigest.getInstance("MD5").digest(str.getBytes()));
    }

    public static String a(byte[] bArr) {
        StringBuilder sb = new StringBuilder(bArr.length * 2);
        for (int i = 0; i < bArr.length; i++) {
            sb.append(f3963a[(bArr[i] & 240) >>> 4]);
            sb.append(f3963a[bArr[i] & ci.m]);
        }
        return sb.toString();
    }
}
