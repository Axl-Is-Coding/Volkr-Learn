package com.facebook.ads.redexgen.X;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Base64OutputStream;
import androidx.annotation.Nullable;
import com.facebook.ads.internal.settings.AdSharedPreferences;
import com.umeng.analytics.pro.ci;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.zip.DeflaterOutputStream;
import okio.Utf8;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class XD implements AnonymousClass91 {

    @Nullable
    public static String A03;
    public static byte[] A04;
    public static String[] A05;
    public static final EnumC1739Kx A06;
    public static final AtomicBoolean A07;
    public static final AtomicInteger A08;
    public final C13755j A00;
    public final AnonymousClass87 A01;
    public final C14418i A02;

    public static String A01(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A04, i, i + i2);
        int i4 = 0;
        while (true) {
            int length = bArrCopyOfRange.length;
            if (A05[6].length() == 9) {
                throw new RuntimeException();
            }
            String[] strArr = A05;
            strArr[1] = "AJGqtkftO03LFXDJsHlFXR4ujVWNfKsn";
            strArr[7] = "0weTThgY8dzMPuXGgH30KJvXs1017h9U";
            if (i4 >= length) {
                return new String(bArrCopyOfRange);
            }
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 73);
            i4++;
        }
    }

    public static void A06() {
        A04 = new byte[]{40, ci.k, 21, 23, 23, 17, 7, 7, 29, 22, 29, 24, 29, 0, ci.k, 11, 17, 26, 21, 22, 24, 17, ci.n, 41, 46, 56, 45, 42, 60, 87, 98, 109, 98, 111, 108, 100, 85, 68, 68, 75, 89, 93, 90, 75, 71, 80, 95, 75, 66, 81, 70, 71, 93, 91, 90, 78, 92, 71, 78, 92, 44, 62, 36, 41, 86, 67, 67, 69, 94, 85, 66, 67, 94, 88, 89, 72, 94, 83, 106, 97, 108, 108, 109, 122, 119, 124, 103, 99, 109, 102, 119, 109, 112, 124, 122, 105, 123, 62, 41, 50, 56, 48, 57, 79, 77, 92, 92, 73, 72, 83, 69, 72, 95, 21, 23, 4, 4, 31, 19, 4, 67, 70, 83, 70, 88, 87, 85, 72, 68, 66, 84, 84, 78, 73, 64, 88, 72, 87, 83, 78, 72, 73, 84, 92, 89, 76, 89, 71, 72, 74, 87, 91, 93, 75, 75, 81, 86, 95, 71, 87, 72, 76, 81, 87, 86, 75, 71, 91, 87, 77, 86, 76, 74, 65, 111, 106, 127, 106, 116, 123, 121, 100, 104, 110, 120, 120, 98, 101, 108, 116, 100, 123, 127, 98, 100, 101, 120, 116, 120, 127, 106, 127, 110, 28, 29, 22, 11, 17, 12, 1, ci.k, 30, 5, 5, ci.l, 7, 20, 8, 4, 25, ci.l, 20, ci.l, 29, ci.l, 5, 31, 24, 48, 35, 56, 56, 51, 58, 41, 58, 57, 49, 49, 51, 50, 30, 57, 49, 52, 61, 60, 120, 44, 55, 120, 58, 45, 49, 52, 60, 120, 45, 43, 61, 42, 120, 44, 55, 51, 61, 54, 95, 86, 68, 72, 82, 79, 88, 71, 91, 86, 78, 82, 69, 52, 57, 59, 60, 48, 61, 38, 58, 56, 58, 49, 60, 38, 45, 42, 38, 52, 42, 37, 40, 51, Utf8.REPLACEMENT_BYTE, 35, 57, 62, 47, 41, 47, 40, 53, 50, 39, 42, 42, 35, 52, 75, 72, 68, 70, 75, 66, 109, 97, 107, 101, 5, ci.k, 12, 1, 9, 28, 1, 7, 6, 23, 27, ci.k, 26, 30, 1, 11, ci.k, 72, 67, 82, 81, 73, 84, 77, 89, 82, 95, 86, 67, 93, 64, 64, 91, 74, 75, ci.l, 30, ci.m, 24, 24, 19, 2, 21, 24, 20, 26, 21, 9, 97, 113, 96, 119, 119, 124, 109, 101, 123, 118, 102, 122, 97, 118, 121, 109, 113, 115, 98, 115, 112, 123, 126, 123, 102, 107, Utf8.REPLACEMENT_BYTE, 41, Utf8.REPLACEMENT_BYTE, Utf8.REPLACEMENT_BYTE, 37, 35, 34, 51, 56, 37, 33, 41, 121, 98, 101, 120, 117, 51, 53, 35, 52, 57, 39, 33, 35, 40, 50, 25, ci.l, 3, 31, ci.l, 29, ci.l, 2, 28, 116, 118, 125, 118, 97, 122, 112, 25, 2, 27, 27};
    }

    public static void A07() {
        A05 = new String[]{"rjWu3o3XUIKJimpXtRLH", "N3hUjd9gC1zTrolrzHWDwio6K0KaeF7v", "V8BOZxTrBek9nlJry76rEN1tEiA1lgnf", "2kaCuDD1e44XjFqxj97oS3bW7Y4jUXps", "VcJxC1jbHxk7XwGyeCWvHwY9E4qRcx1x", "dO6RHNbAuKw0kDbwpnJR", "8jPNINbp0cYAxxIn", "ugIdyp1aSJPFHYCiUHctz2XPYC5YD6Ud"};
    }

    static {
        A07();
        A06();
        A07 = new AtomicBoolean();
        A08 = new AtomicInteger(0);
        A03 = null;
        A06 = C1740Ky.A00();
    }

    public XD(AnonymousClass87 anonymousClass87, boolean z, C13755j c13755j) {
        this.A01 = anonymousClass87;
        this.A02 = new C14418i(anonymousClass87);
        this.A00 = c13755j;
        A08(anonymousClass87, z);
    }

    @Nullable
    @SuppressLint({"CatchGeneralException"})
    public static String A02(AnonymousClass87 anonymousClass87, String str) {
        try {
            return L3.A02(anonymousClass87.getPackageManager().getApplicationInfo(str, 0).sourceDir);
        } catch (Exception e2) {
            if (A07.compareAndSet(false, true)) {
                anonymousClass87.A04().A8H(A01(436, 7, 90), C8Y.A17, new C8Z(e2));
                return null;
            }
            return null;
        }
    }

    @SuppressLint({"CatchGeneralException"})
    public static void A08(final AnonymousClass87 anonymousClass87, boolean z) {
        if (!A08.compareAndSet(0, 1)) {
            return;
        }
        try {
            final SharedPreferences sharedPreferences = AdSharedPreferences.getSharedPreferences(anonymousClass87);
            final String str = A01(26, 4, 37) + new C14418i(anonymousClass87).A06();
            A03 = sharedPreferences.getString(str, null);
            FutureTask futureTask = new FutureTask(new Callable<Boolean>() { // from class: com.facebook.ads.redexgen.X.93
                /* JADX INFO: Access modifiers changed from: private */
                @Override // java.util.concurrent.Callable
                /* JADX INFO: renamed from: A00, reason: merged with bridge method [inline-methods] */
                public final Boolean call() throws Exception {
                    AnonymousClass87 anonymousClass872 = anonymousClass87;
                    String unused = XD.A03 = XD.A02(anonymousClass872, anonymousClass872.getPackageName());
                    sharedPreferences.edit().putString(str, XD.A03).apply();
                    XD.A08.set(2);
                    return true;
                }
            });
            Executors.newSingleThreadExecutor().submit(futureTask);
            if (z) {
                futureTask.get();
            }
        } catch (Exception unused) {
            AtomicInteger atomicInteger = A08;
            if (A05[2].charAt(4) == '1') {
                throw new RuntimeException();
            }
            String[] strArr = A05;
            strArr[0] = "BG3uZRuA0Chr9fB7D4fD";
            strArr[5] = "ED3rHXlImwDD4lq5TiwH";
            atomicInteger.set(0);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x01b7  */
    @Override // com.facebook.ads.redexgen.X.AnonymousClass91
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.util.Map<java.lang.String, java.lang.String> A6G() {
        /*
            Method dump skipped, instruction units count: 904
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.XD.A6G():java.util.Map");
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass91
    public final String A79() {
        return A7A(AnonymousClass90.A00());
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass91
    public final String A7A(InterfaceC14578z interfaceC14578z) {
        A08(this.A01, true);
        ByteArrayOutputStream byteArrayOutputStream = null;
        Base64OutputStream base64OutputStream = null;
        DeflaterOutputStream deflaterOutputStream = null;
        try {
            try {
                byteArrayOutputStream = new ByteArrayOutputStream();
                base64OutputStream = new Base64OutputStream(byteArrayOutputStream, 0);
                deflaterOutputStream = new DeflaterOutputStream(base64OutputStream);
                Map<String, String> mapA6G = A6G();
                if (TextUtils.isEmpty(C5V.A00().A03())) {
                    C5V.A08(this.A01);
                }
                mapA6G.put(A01(280, 4, 52), C5V.A00().A03());
                mapA6G.put(A01(417, 10, 47), AnonymousClass96.A06(this.A02, this.A01, false));
                if (C1693Iy.A18(this.A01)) {
                    mapA6G.put(A01(103, 10, 69), C12580t.A00());
                }
                Iterator<Map.Entry<String, String>> it = mapA6G.entrySet().iterator();
                while (it.hasNext()) {
                    if (!interfaceC14578z.A2O(it.next().getKey())) {
                        it.remove();
                    }
                }
                deflaterOutputStream.write(new JSONObject(mapA6G).toString().getBytes());
                deflaterOutputStream.close();
                String strReplaceAll = byteArrayOutputStream.toString().replaceAll(A01(0, 1, 107), A01(0, 0, 37));
                try {
                    deflaterOutputStream.close();
                    base64OutputStream.close();
                    byteArrayOutputStream.close();
                } catch (IOException unused) {
                }
                return strReplaceAll;
            } catch (IOException e2) {
                throw new RuntimeException(A01(241, 26, 17), e2);
            }
        } catch (Throwable th) {
            String[] strArr = A05;
            if (strArr[1].charAt(17) != strArr[7].charAt(17)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A05;
            strArr2[0] = "tBEywTa582eygB6ZDfuZ";
            strArr2[5] = "t5OASyUSxnrvHDDzBp0B";
            if (deflaterOutputStream != null) {
                try {
                    deflaterOutputStream.close();
                } catch (IOException unused2) {
                    throw th;
                }
            }
            if (base64OutputStream != null) {
                base64OutputStream.close();
            }
            if (byteArrayOutputStream != null) {
                byteArrayOutputStream.close();
            }
            throw th;
        }
    }
}
