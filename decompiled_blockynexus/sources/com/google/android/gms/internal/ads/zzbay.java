package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.StrictMode;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzbay {
    @Deprecated
    public static <T> T zza(Context context, Callable<T> callable) {
        try {
            return (T) zza(callable);
        } catch (Throwable th) {
            zzbbq.zzc("Unexpected exception.", th);
            zzasf.zzt(context).zza(th, "StrictModeUtil.runWithLaxStrictMode");
            return null;
        }
    }

    public static <T> T zza(zzdwe<T> zzdweVar) {
        StrictMode.ThreadPolicy threadPolicy = StrictMode.getThreadPolicy();
        try {
            StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder(threadPolicy).permitDiskReads().permitDiskWrites().build());
            return zzdweVar.get();
        } finally {
            StrictMode.setThreadPolicy(threadPolicy);
        }
    }

    private static <T> T zza(Callable<T> callable) throws Exception {
        StrictMode.ThreadPolicy threadPolicy = StrictMode.getThreadPolicy();
        try {
            StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder(threadPolicy).permitDiskReads().permitDiskWrites().build());
            return callable.call();
        } finally {
            StrictMode.setThreadPolicy(threadPolicy);
        }
    }
}
