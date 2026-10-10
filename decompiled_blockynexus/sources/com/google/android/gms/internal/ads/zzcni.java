package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.doubleclick.AppEventListener;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzcni {
    public static Set<zzcab<zzbuy>> zza(zzcns zzcnsVar, Executor executor) {
        return zzc(zzcnsVar, executor);
    }

    public static Set<zzcab<AppEventListener>> zzb(zzcns zzcnsVar, Executor executor) {
        return zzc(zzcnsVar, executor);
    }

    public static Set<zzcab<zzbvs>> zzc(zzcns zzcnsVar, Executor executor) {
        return zzc(zzcnsVar, executor);
    }

    public static Set<zzcab<zzbui>> zzd(zzcns zzcnsVar, Executor executor) {
        return zzc(zzcnsVar, executor);
    }

    public static Set<zzcab<zzbuh>> zze(zzcns zzcnsVar, Executor executor) {
        return zzc(zzcnsVar, executor);
    }

    public static Set<zzcab<zzbuz>> zzf(zzcns zzcnsVar, Executor executor) {
        return zzc(zzcnsVar, executor);
    }

    public static Set<zzcab<zzux>> zzg(zzcns zzcnsVar, Executor executor) {
        return zzc(zzcnsVar, executor);
    }

    public static Set<zzcab<zzdso>> zzh(zzcns zzcnsVar, Executor executor) {
        return zzc(zzcnsVar, executor);
    }

    public static Set<zzcab<zzbws>> zzi(zzcns zzcnsVar, Executor executor) {
        return zzc(zzcnsVar, executor);
    }

    private static <T> Set<zzcab<T>> zzc(T t, Executor executor) {
        return zzacv.zzdbq.get().booleanValue() ? Collections.singleton(new zzcab(t, executor)) : Collections.emptySet();
    }
}
