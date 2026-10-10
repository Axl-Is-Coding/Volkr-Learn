package com.facebook.ads.redexgen.X;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Build;
import android.util.Log;
import androidx.annotation.Nullable;
import com.facebook.ads.internal.api.BuildConfigApi;
import com.umeng.analytics.pro.ci;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.util.Arrays;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Ky, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1740Ky {
    public static byte[] A00;
    public static final String A01;

    public static String A01(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 47);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A05() {
        A00 = new byte[]{115, -73, -67, -73, -72, -87, -79, 115, -91, -76, -76, 115, -105, -71, -76, -87, -74, -71, -73, -87, -74, 114, -91, -76, -81, -65, -108, -75, -90, -71, -83, 0, 29, 29, 34, 19, 18, -50, 17, 22, 19, 17, 25, -50, 20, ci.m, 23, 26, 19, 18, -52, -63, -70, -86, -89, 125, -124, 127, -120, -93, -91, 6, -9, 5, 6, -65, -3, -9, 11, 5};
    }

    static {
        A05();
        A01 = C1740Ky.class.getSimpleName();
    }

    public static EnumC1739Kx A00() {
        try {
            boolean isRooted = A07() || A06() || A08(A01(59, 2, 1));
            if (isRooted) {
                return EnumC1739Kx.A04;
            }
            return EnumC1739Kx.A06;
        } catch (Throwable th) {
            if (BuildConfigApi.isDebug()) {
                Log.e(A01, A01(31, 19, 127), th);
            }
            return EnumC1739Kx.A05;
        }
    }

    @Nullable
    public static String A02(Context context) {
        try {
            return A03(context);
        } catch (Exception unused) {
            return null;
        }
    }

    @SuppressLint({"PackageManagerGetSignatures"})
    public static String A03(Context context) throws PackageManager.NameNotFoundException, NoSuchAlgorithmException, CertificateException {
        StringBuilder sb = new StringBuilder();
        for (Signature signature : context.getPackageManager().getPackageInfo(context.getPackageName(), 64).signatures) {
            sb.append(L3.A03(MessageDigest.getInstance(A01(50, 4, 74)).digest(A04(signature).getEncoded())));
            sb.append(A01(26, 1, 42));
        }
        return sb.toString();
    }

    public static PublicKey A04(Signature signature) throws CertificateException {
        return CertificateFactory.getInstance(A01(54, 5, 32)).generateCertificate(new ByteArrayInputStream(signature.toByteArray())).getPublicKey();
    }

    public static boolean A06() {
        String buildTags = Build.TAGS;
        return buildTags != null && buildTags.contains(A01(61, 9, 99));
    }

    public static boolean A07() {
        File superUserApk = new File(A01(0, 25, 21));
        return superUserApk.exists();
    }

    public static boolean A08(String str) {
        File[] fileArrListFiles;
        for (String path : System.getenv(A01(27, 4, 54)).split(A01(25, 1, 86))) {
            File file = new File(path);
            if (file.exists() && file.isDirectory() && (fileArrListFiles = file.listFiles()) != null) {
                for (File fileInPath : fileArrListFiles) {
                    if (fileInPath.getName().equals(str)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
