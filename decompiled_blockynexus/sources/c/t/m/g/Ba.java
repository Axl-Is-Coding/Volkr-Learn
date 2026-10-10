package c.t.m.g;

import android.util.Base64;
import java.security.MessageDigest;

/* JADX INFO: compiled from: TL */
/* JADX INFO: loaded from: classes.dex */
public final class Ba {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final byte[] f2877a = new byte[0];

    public static byte[] a(String str) {
        try {
            byte[] bArrA = Va.a(C0458qa.b(str.getBytes("UTF-8")), "0PEq^X$sjtWqEqa2$dg4TG2PT^4dFEep");
            if (!C0458qa.c(bArrA)) {
                byte[] bArrEncode = Base64.encode(bArrA, 2);
                if (!C0458qa.c(bArrEncode)) {
                    return bArrEncode;
                }
            }
            return f2877a;
        } catch (Throwable unused) {
            return f2877a;
        }
    }

    public static String b(String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(str.getBytes());
            byte[] bArrDigest = messageDigest.digest();
            StringBuilder sb = new StringBuilder();
            for (byte b2 : bArrDigest) {
                sb.append(Integer.toHexString(b2 & 255));
                sb.append("");
            }
            return sb.toString();
        } catch (Throwable unused) {
            return "abcdefgh".concat(String.valueOf(str));
        }
    }
}
