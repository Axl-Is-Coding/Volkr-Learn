package com.google.android.gms.internal.ads;

import android.util.Log;
import com.google.android.gms.common.util.VisibleForTesting;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public class zzbbq {
    public static boolean isLoggable(int i) {
        return i >= 5 || Log.isLoggable("Ads", i);
    }

    public static void zzb(String str, Throwable th) {
        if (isLoggable(3)) {
            Log.d("Ads", str, th);
        }
    }

    public static void zzc(String str, Throwable th) {
        if (isLoggable(6)) {
            Log.e("Ads", str, th);
        }
    }

    public static void zzd(String str, Throwable th) {
        if (isLoggable(5)) {
            Log.w("Ads", str, th);
        }
    }

    public static void zze(String str, Throwable th) {
        if (isLoggable(5)) {
            if (th != null) {
                zzd(zzff(str), th);
            } else {
                zzfe(zzff(str));
            }
        }
    }

    public static void zzef(String str) {
        if (isLoggable(3)) {
            Log.d("Ads", str);
        }
    }

    public static void zzfc(String str) {
        if (isLoggable(6)) {
            Log.e("Ads", str);
        }
    }

    public static void zzfd(String str) {
        if (isLoggable(4)) {
            Log.i("Ads", str);
        }
    }

    public static void zzfe(String str) {
        if (isLoggable(5)) {
            Log.w("Ads", str);
        }
    }

    @VisibleForTesting
    private static String zzff(String str) {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        if (stackTrace.length < 4) {
            return str;
        }
        int lineNumber = stackTrace[3].getLineNumber();
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 13);
        sb.append(str);
        sb.append(" @");
        sb.append(lineNumber);
        return sb.toString();
    }

    public static void zzfg(String str) {
        zze(str, null);
    }
}
