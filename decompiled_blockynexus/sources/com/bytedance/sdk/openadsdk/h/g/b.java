package com.bytedance.sdk.openadsdk.h.g;

import com.umeng.analytics.pro.ci;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* JADX INFO: compiled from: MD5.java */
/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final MessageDigest f6943a = a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final char[] f6944b = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    private b() {
    }

    private static MessageDigest a() {
        try {
            return MessageDigest.getInstance("md5");
        } catch (NoSuchAlgorithmException unused) {
            return null;
        }
    }

    public static String a(String str) {
        byte[] bArrDigest;
        MessageDigest messageDigest = f6943a;
        if (messageDigest == null) {
            return "";
        }
        byte[] bytes = str.getBytes(d.f6950a);
        synchronized (b.class) {
            bArrDigest = messageDigest.digest(bytes);
        }
        return a(bArrDigest);
    }

    public static String a(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        char[] cArr = new char[bArr.length << 1];
        int i = 0;
        for (byte b2 : bArr) {
            int i2 = i + 1;
            char[] cArr2 = f6944b;
            cArr[i] = cArr2[(b2 & 240) >> 4];
            i = i2 + 1;
            cArr[i2] = cArr2[b2 & ci.m];
        }
        return new String(cArr);
    }
}
