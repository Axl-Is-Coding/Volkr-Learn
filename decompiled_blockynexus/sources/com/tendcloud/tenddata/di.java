package com.tendcloud.tenddata;

import android.content.Context;
import android.content.pm.PackageManager;
import java.io.ByteArrayInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;

/* JADX INFO: compiled from: td */
/* JADX INFO: loaded from: classes5.dex */
class di {

    /* JADX INFO: compiled from: td */
    static class a {
        a() {
        }

        public static String encode(byte[] bArr) {
            char[] cArr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
            StringBuilder sb = new StringBuilder(bArr.length * 2);
            for (int i = 0; i < bArr.length; i++) {
                sb.append(cArr[(bArr[i] & 240) >> 4]);
                sb.append(cArr[bArr[i] & com.umeng.analytics.pro.ci.m]);
            }
            return sb.toString();
        }
    }

    di() {
    }

    protected static String a(Context context) {
        String packageName = context.getPackageName();
        return a(context, packageName) + packageName;
    }

    protected static String a(Context context, String str) {
        String strA;
        try {
            strA = a((X509Certificate) CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(context.getPackageManager().getPackageInfo(str, 64).signatures[0].toByteArray())));
        } catch (PackageManager.NameNotFoundException | CertificateException unused) {
            strA = "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < strA.length(); i++) {
            stringBuffer.append(strA.charAt(i));
            if (i > 0 && i % 2 == 1 && i < strA.length() - 1) {
                stringBuffer.append(":");
            }
        }
        return stringBuffer.toString();
    }

    static String a(X509Certificate x509Certificate) {
        try {
            return a.encode(a(x509Certificate.getEncoded()));
        } catch (CertificateEncodingException unused) {
            return null;
        }
    }

    static byte[] a(byte[] bArr) {
        byte[] bArr2 = new byte[0];
        try {
            return MessageDigest.getInstance("SHA1").digest(bArr);
        } catch (NoSuchAlgorithmException unused) {
            return bArr2;
        }
    }
}
