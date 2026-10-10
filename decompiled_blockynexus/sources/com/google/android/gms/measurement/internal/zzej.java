package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.util.VisibleForTesting;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes2.dex */
@VisibleForTesting
public final class zzej<V> {
    private static final Object zzf = new Object();
    private final String zza;
    private final zzeh<V> zzb;
    private final V zzc;
    private final V zzd;
    private final Object zze;
    private volatile V zzg;
    private volatile V zzh;

    private zzej(String str, V v, V v2, zzeh<V> zzehVar) {
        this.zze = new Object();
        this.zzg = null;
        this.zzh = null;
        this.zza = str;
        this.zzc = v;
        this.zzd = v2;
        this.zzb = zzehVar;
    }

    public final String zza() {
        return this.zza;
    }

    public final V zza(V v) {
        synchronized (this.zze) {
            V v2 = this.zzg;
        }
        if (v != null) {
            return v;
        }
        if (zzeg.zza == null) {
            return this.zzc;
        }
        synchronized (zzf) {
            if (zzw.zza()) {
                return this.zzh == null ? this.zzc : this.zzh;
            }
            try {
                for (zzej zzejVar : zzas.zzco) {
                    if (zzw.zza()) {
                        throw new IllegalStateException("Refreshing flag cache must be done on a worker thread.");
                    }
                    V vZza = null;
                    try {
                        if (zzejVar.zzb != null) {
                            vZza = zzejVar.zzb.zza();
                        }
                    } catch (IllegalStateException unused) {
                    }
                    synchronized (zzf) {
                        zzejVar.zzh = vZza;
                    }
                }
            } catch (SecurityException unused2) {
            }
            zzeh<V> zzehVar = this.zzb;
            if (zzehVar == null) {
                return this.zzc;
            }
            try {
                return zzehVar.zza();
            } catch (IllegalStateException unused3) {
                return this.zzc;
            } catch (SecurityException unused4) {
                return this.zzc;
            }
        }
    }
}
