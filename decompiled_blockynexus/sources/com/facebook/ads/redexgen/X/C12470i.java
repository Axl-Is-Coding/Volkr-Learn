package com.facebook.ads.redexgen.X;

import android.content.pm.PackageManager;
import android.text.TextUtils;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.0i, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C12470i {
    public static byte[] A00;
    public static String[] A01;

    static {
        A03();
        A02();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 56);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A02() {
        A00 = new byte[]{101, 64, 4, 77, 87, 4, 77, 74, 82, 69, 72, 77, 64, 69, 80, 65, 64, 4, 83, 77, 80, 76, 75, 81, 80, 4, 80, 75, 79, 65, 74, 10, 10, 27, 2};
    }

    public static void A03() {
        A01 = new String[]{"4Fi3cRKjKwjo", "pfwDmZC0EgnSHGG3akphHDiSxRpjxWfc", "OwKyFlCBYoW0NHpoiuFf2exuC", "FTixXnraWBf7yQ9sseM6khJqknPB2", "87lno6sBf8EnLpq9v2WrftgOrdI4V", "hcLSbPhFObKmfxN2jEGb0Jf71EM4", "MV7VLhl", "AE1L1nhQpeYYJvXkfFkincgpQRIdvuit"};
    }

    /* JADX WARN: Incorrect condition in loop: B:9:0x0014 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.util.Collection<java.lang.String> A01(org.json.JSONArray r3) {
        /*
            if (r3 == 0) goto L8
            int r0 = r3.length()
            if (r0 != 0) goto La
        L8:
            r0 = 0
            return r0
        La:
            java.util.HashSet r2 = new java.util.HashSet
            r2.<init>()
            r1 = 0
        L10:
            int r0 = r3.length()
            if (r1 >= r0) goto L20
            java.lang.String r0 = r3.optString(r1)
            r2.add(r0)
            int r1 = r1 + 1
            goto L10
        L20:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C12470i.A01(org.json.JSONArray):java.util.Collection");
    }

    public static boolean A04(C2026Wb c2026Wb, InterfaceC12460h interfaceC12460h, J5 j5) {
        EnumC12450g enumC12450gA6X = interfaceC12460h.A6X();
        if (enumC12450gA6X == null || enumC12450gA6X == EnumC12450g.A03) {
            return false;
        }
        boolean z = false;
        Collection<String> collectionA68 = interfaceC12460h.A68();
        if (collectionA68 == null || collectionA68.isEmpty()) {
            return false;
        }
        Iterator<String> it = collectionA68.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            String packageName = it.next();
            if (A05(c2026Wb, packageName)) {
                z = true;
                break;
            }
        }
        if (z != (enumC12450gA6X == EnumC12450g.A02)) {
            return false;
        }
        String strA5q = interfaceC12460h.A5q();
        boolean zIsEmpty = TextUtils.isEmpty(strA5q);
        String[] strArr = A01;
        if (strArr[7].charAt(25) != strArr[1].charAt(25)) {
            throw new RuntimeException();
        }
        String[] strArr2 = A01;
        strArr2[2] = "Y0XUyINdugWnNFuKX72emGLWk";
        strArr2[2] = "Y0XUyINdugWnNFuKX72emGLWk";
        if (!zIsEmpty) {
            j5.A8N(strA5q, null);
            return true;
        }
        C8X c8xA04 = c2026Wb.A04();
        int i = C8Y.A0O;
        String packageName2 = A00(0, 32, 28);
        C8Z c8z = new C8Z(packageName2);
        String packageName3 = A00(32, 3, 83);
        c8xA04.A8H(packageName3, i, c8z);
        return true;
    }

    public static boolean A05(C2026Wb c2026Wb, String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            c2026Wb.getPackageManager().getPackageInfo(str, 1);
            return true;
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        } catch (RuntimeException unused2) {
            return false;
        }
    }
}
