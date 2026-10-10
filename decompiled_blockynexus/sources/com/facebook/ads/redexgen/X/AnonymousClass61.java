package com.facebook.ads.redexgen.X;

import android.annotation.SuppressLint;
import android.util.Log;
import java.util.Arrays;
import okio.Utf8;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.61, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class AnonymousClass61 {
    public static AnonymousClass60 A00;
    public static byte[] A01;
    public static String[] A02;
    public static final String A03;

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A01, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 118);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        byte[] bArr = {20, 71, 50, 52, Utf8.REPLACEMENT_BYTE, 67, 56, 62, 61, -17, 51, 68, 65, 56, 61, 54, -17, 52, 71, 52, 50, 68, 67, 56, 62, 61, -3};
        String[] strArr = A02;
        if (strArr[3].length() != strArr[5].length()) {
            throw new RuntimeException();
        }
        String[] strArr2 = A02;
        strArr2[0] = "lreKiDhdf1OAP";
        strArr2[0] = "lreKiDhdf1OAP";
        A01 = bArr;
    }

    public static void A02() {
        A02 = new String[]{"sp1TByEGG7e0GADwDzlASPV0aap3ieHh", "uzFI86KB8SuPvllmns5EhrThmrxeiZB", "WffZMJDQYz5YPWrNy4ctgABXEOCgIES3", "xNvoCKy4p7HAo2gXsjU", "die", "gYyZIkzjV9FAWz0BtKI", "Id5RyLkBfkqUUkVvBGvirNkAkhkz8uh0", "U7WQUa4wbg5Ag319WkF2HwzvOv4zz"};
    }

    static {
        A02();
        A01();
        A03 = AnonymousClass61.class.getSimpleName();
    }

    public static void A03(AnonymousClass60 anonymousClass60) {
        A00 = anonymousClass60;
    }

    @SuppressLint({"BadMethodUse-android.util.Log.e"})
    public static void A04(Throwable th) {
        AnonymousClass60 anonymousClass60 = A00;
        if (anonymousClass60 != null) {
            anonymousClass60.ACn(th);
        } else {
            Log.e(A03, A00(0, 27, 89), th);
        }
    }
}
