package com.facebook.ads.redexgen.X;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import android.webkit.WebSettings;
import android.webkit.WebView;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.facebook.ads.internal.api.BuildConfigApi;
import com.facebook.ads.internal.util.process.ProcessUtils;
import com.umeng.analytics.pro.ci;
import java.util.Arrays;
import java.util.Locale;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import okio.Utf8;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.96, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class AnonymousClass96 {
    public static String A00;
    public static byte[] A01;
    public static String[] A02;
    public static final AtomicBoolean A03;
    public static final AtomicReference<String> A04;

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A01, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 19);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A08() {
        A01 = new byte[]{76, 55, 42, 46, 45, 34, 67, 45, 25, 8, 5, 9, 2, ci.m, 9, 34, 9, 24, 27, 3, 30, 7, 42, 3, 30, 45, 2, 8, 30, 3, 5, 8, 87, 42, 46, Utf8.REPLACEMENT_BYTE, 34, 67, 71, 87, 42, 46, 45, 58, 67, 81, 44, 40, 40, 60, 69, 101, 24, 28, 18, 29, 113, 30, 99, 103, 118, 115, 10, 39, 8, 2, 20, 9, ci.m, 2, ci.n, 20, 23, 20, 121, 72, 76, 88, 93, 33, 17, 8, 30, ci.m, 20, ci.k, ci.k, 9, 50, 55, 50, 51, 43, 50, 38, 49, 61, Utf8.REPLACEMENT_BYTE, 124, 52, 51, 49, 55, 48, 61, 61, 57, 124, 51, 54, 33, 124, 59, 60, 38, 55, 32, 60, 51, 62, 124, 39, 51, 62, 60, 55, 60, 43, 48, 58, 59, 39, 39, 35, 125, 50, 52, 54, 61, 39, 60, 58, 44, 59, 22, 40, 46, 44, 39, 61, 50, 52, 34, 53, 24, 38, 32, 34, 41, 51, 24, 43, 38, 52, 51, 24, 53, 34, 33, 53, 34, 52, 47, 85, 71, 64, 125, 84, 75, 71, 85};
    }

    public static void A09() {
        A02 = new String[]{"Qr1EFu0kx1tI01867m6ODqfSZ9SwtWDI", "3TYgkAWbIjP9kMvunjr7VwfmqgOZ7ZQ4", "kyx9q1x7DLL5BxK3faNs604Sw4dxbCMr", "cJW9lkVABx2P1Kp63XktrUnlRFV2zQAL", "nhxLXaLaMxGTsXNVJcvnwyCHZZV2RS3H", "y9xLyKazRl3zNBUnfIZmAOMjGK0AXhl4", "DTEqb4TbXnNBCaxA5atVnYK0pSb9DMUi", "fZvghiN"};
    }

    static {
        A09();
        A08();
        A00 = A00(87, 7, 79);
        A03 = new AtomicBoolean();
        A04 = new AtomicReference<>();
    }

    @TargetApi(17)
    @VisibleForTesting
    public static String A01(AnonymousClass87 anonymousClass87) {
        return WebSettings.getDefaultUserAgent(anonymousClass87);
    }

    @Nullable
    @SuppressLint({"CatchGeneralException"})
    public static String A02(final AnonymousClass87 anonymousClass87) {
        FutureTask futureTask = new FutureTask(new Callable<String>() { // from class: com.facebook.ads.redexgen.X.95
            /* JADX INFO: Access modifiers changed from: private */
            @Override // java.util.concurrent.Callable
            /* JADX INFO: renamed from: A00, reason: merged with bridge method [inline-methods] */
            public final String call() {
                String str = (String) AnonymousClass96.A04.get();
                if (str != null) {
                    return str;
                }
                WebView webView = new WebView(anonymousClass87.getApplicationContext());
                String userAgentString = webView.getSettings().getUserAgentString();
                webView.destroy();
                if (userAgentString != null) {
                    AnonymousClass96.A04.set(userAgentString);
                }
                return userAgentString;
            }
        });
        for (int i = 0; i < 3; i++) {
            LS.A00(futureTask);
            try {
                return (String) futureTask.get();
            } catch (Throwable t) {
                A0A(anonymousClass87, t);
                SystemClock.sleep(500L);
            }
        }
        return null;
    }

    public static String A03(AnonymousClass87 anonymousClass87, C14418i c14418i) {
        String strA07 = c14418i.A07();
        if (TextUtils.isEmpty(strA07)) {
            boolean andSet = A03.getAndSet(true);
            String[] strArr = A02;
            if (strArr[4].charAt(26) != strArr[3].charAt(26)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A02;
            strArr2[1] = "SlGltdwaGCQXXY2U2bjZ1NfeES9SOW6r";
            strArr2[0] = "AnJMWH4pc3dV3Xqon1tLsffrk7nZCcYt";
            if (!andSet) {
                anonymousClass87.A04().A8H(A00(123, 7, 74), C8Y.A1H, new C8Z(A00(80, 7, 82)));
            }
        }
        return strA07;
    }

    @Nullable
    @SuppressLint({"CatchGeneralException"})
    public static String A04(AnonymousClass87 anonymousClass87, boolean z) {
        if (anonymousClass87 == null) {
            return A00;
        }
        if (z) {
            return System.getProperty(A00(130, 10, 64));
        }
        String str = A04.get();
        if (str != null) {
            return str;
        }
        long jA01 = C1692Ix.A01(anonymousClass87);
        String strA00 = A00(150, 23, 84);
        String strA002 = A00(140, 10, 90);
        String strA003 = A00(95, 28, 65);
        if (jA01 > 0) {
            SharedPreferences sharedPreferences = anonymousClass87.getSharedPreferences(ProcessUtils.getProcessSpecificName(strA003, anonymousClass87), 0);
            String string = sharedPreferences.getString(strA002, null);
            long j = sharedPreferences.getLong(strA00, 0L);
            if (!TextUtils.isEmpty(string) && System.currentTimeMillis() - j < jA01) {
                A04.set(string);
                return string;
            }
        }
        String strA01 = null;
        if (Build.VERSION.SDK_INT >= 17) {
            try {
                strA01 = A01(anonymousClass87);
                A04.set(strA01);
            } catch (Throwable th) {
                A0A(anonymousClass87, th);
            }
        }
        if (strA01 == null) {
            strA01 = A02(anonymousClass87);
        }
        if (strA01 == null) {
            String userAgentString = A00;
            return userAgentString;
        }
        String[] strArr = A02;
        if (strArr[4].charAt(26) != strArr[3].charAt(26)) {
            throw new RuntimeException();
        }
        String[] strArr2 = A02;
        strArr2[7] = "Kvz6zSF";
        strArr2[7] = "Kvz6zSF";
        if (jA01 > 0) {
            String userAgentString2 = ProcessUtils.getProcessSpecificName(strA003, anonymousClass87);
            SharedPreferences sharedPreferences2 = anonymousClass87.getSharedPreferences(userAgentString2, 0);
            SharedPreferences.Editor editorEdit = sharedPreferences2.edit();
            String userAgentString3 = A04.get();
            editorEdit.putString(strA002, userAgentString3).apply();
            sharedPreferences2.edit().putLong(strA00, System.currentTimeMillis()).apply();
        }
        return strA01;
    }

    public static String A05(C14418i c14418i, AnonymousClass87 anonymousClass87) {
        if (C1692Ix.A05(anonymousClass87)) {
            return A00(70, 5, 69) + A03(anonymousClass87, c14418i) + A00(39, 6, 127) + c14418i.A06() + A00(45, 6, 121) + c14418i.A04() + A00(38, 1, 111);
        }
        return A00(0, 0, 40);
    }

    public static String A06(C14418i c14418i, AnonymousClass87 anonymousClass87, boolean z) {
        return A04(anonymousClass87, z) + A00(0, 38, 127) + A00(63, 7, 117) + A00(57, 6, 54) + C14418i.A03 + A00(38, 1, 111) + A05(c14418i, anonymousClass87) + A00(75, 5, 29) + BuildConfigApi.getVersionName(anonymousClass87) + A00(51, 6, 77) + Locale.getDefault().toString() + A00(94, 1, 104);
    }

    public static void A0A(AnonymousClass87 anonymousClass87, Throwable th) {
        anonymousClass87.A04().A8H(A00(173, 8, 49), C8Y.A2F, new C8Z(th));
    }
}
