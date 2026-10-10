package com.google.android.gms.common.config;

import android.content.Context;
import android.os.Binder;
import android.os.StrictMode;
import android.util.Log;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.Set;

/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@17.3.0 */
/* JADX INFO: loaded from: classes.dex */
@KeepForSdk
public abstract class GservicesValue<T> {
    private static final Object zzc = new Object();
    private static zza zzd = null;
    private static int zze = 0;
    private static Context zzf;
    private static Set<String> zzg;
    protected final String zza;
    protected final T zzb;
    private T zzh = null;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@17.3.0 */
    interface zza {
        Boolean zza(String str, Boolean bool);

        Float zza(String str, Float f2);

        Integer zza(String str, Integer num);

        Long zza(String str, Long l);

        String zza(String str, String str2);
    }

    protected GservicesValue(String str, T t) {
        this.zza = str;
        this.zzb = t;
    }

    @KeepForSdk
    public static boolean isInitialized() {
        synchronized (zzc) {
        }
        return false;
    }

    @KeepForSdk
    public static GservicesValue<Boolean> value(String str, boolean z) {
        return new zzb(str, Boolean.valueOf(z));
    }

    private static boolean zza() {
        synchronized (zzc) {
        }
        return false;
    }

    @KeepForSdk
    public final T get() {
        T t = this.zzh;
        if (t != null) {
            return t;
        }
        StrictMode.ThreadPolicy threadPolicyAllowThreadDiskReads = StrictMode.allowThreadDiskReads();
        synchronized (zzc) {
        }
        synchronized (zzc) {
            zzg = null;
            zzf = null;
        }
        try {
            try {
                T tZza = zza(this.zza);
                StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads);
                return tZza;
            } catch (SecurityException unused) {
                long jClearCallingIdentity = Binder.clearCallingIdentity();
                try {
                    T tZza2 = zza(this.zza);
                    StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads);
                    return tZza2;
                } finally {
                    Binder.restoreCallingIdentity(jClearCallingIdentity);
                }
            }
        } catch (Throwable th) {
            StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads);
            throw th;
        }
    }

    @KeepForSdk
    @Deprecated
    public final T getBinderSafe() {
        return get();
    }

    @VisibleForTesting
    @KeepForSdk
    public void override(T t) {
        Log.w("GservicesValue", "GservicesValue.override(): test should probably call initForTests() first");
        this.zzh = t;
        synchronized (zzc) {
            zza();
        }
    }

    @VisibleForTesting
    @KeepForSdk
    public void resetOverride() {
        this.zzh = null;
    }

    protected abstract T zza(String str);

    @KeepForSdk
    public static GservicesValue<Long> value(String str, Long l) {
        return new com.google.android.gms.common.config.zza(str, l);
    }

    @KeepForSdk
    public static GservicesValue<Integer> value(String str, Integer num) {
        return new zzd(str, num);
    }

    @KeepForSdk
    public static GservicesValue<Float> value(String str, Float f2) {
        return new zzc(str, f2);
    }

    @KeepForSdk
    public static GservicesValue<String> value(String str, String str2) {
        return new zze(str, str2);
    }
}
