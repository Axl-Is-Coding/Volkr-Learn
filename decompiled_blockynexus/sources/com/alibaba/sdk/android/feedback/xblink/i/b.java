package com.alibaba.sdk.android.feedback.xblink.i;

import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;

/* JADX INFO: loaded from: classes.dex */
public class b {
    public static String a(String str) {
        if (str == null) {
            return null;
        }
        try {
            return b(str.getBytes("utf-8"), "MD5");
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    private static byte[] a(byte[] bArr, String str) {
        try {
            return MessageDigest.getInstance(str).digest(bArr);
        } catch (GeneralSecurityException e2) {
            throw new IllegalStateException("Security exception", e2);
        }
    }

    private static String b(byte[] bArr, String str) {
        return c.a(a(bArr, str));
    }
}
