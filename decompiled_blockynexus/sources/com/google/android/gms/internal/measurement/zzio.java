package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
/* JADX INFO: loaded from: classes2.dex */
public class zzio {
    private static final zzhl zza = zzhl.zza();
    private zzgp zzb;
    private volatile zzjj zzc;
    private volatile zzgp zzd;

    private final zzjj zzb(zzjj zzjjVar) {
        if (this.zzc == null) {
            synchronized (this) {
                if (this.zzc == null) {
                    try {
                        this.zzc = zzjjVar;
                        this.zzd = zzgp.zza;
                    } catch (zzij unused) {
                        this.zzc = zzjjVar;
                        this.zzd = zzgp.zza;
                    }
                }
            }
        }
        return this.zzc;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzio)) {
            return false;
        }
        zzio zzioVar = (zzio) obj;
        zzjj zzjjVar = this.zzc;
        zzjj zzjjVar2 = zzioVar.zzc;
        return (zzjjVar == null && zzjjVar2 == null) ? zzc().equals(zzioVar.zzc()) : (zzjjVar == null || zzjjVar2 == null) ? zzjjVar != null ? zzjjVar.equals(zzioVar.zzb(zzjjVar.zzbv())) : zzb(zzjjVar2.zzbv()).equals(zzjjVar2) : zzjjVar.equals(zzjjVar2);
    }

    public int hashCode() {
        return 1;
    }

    public final zzjj zza(zzjj zzjjVar) {
        zzjj zzjjVar2 = this.zzc;
        this.zzb = null;
        this.zzd = null;
        this.zzc = zzjjVar;
        return zzjjVar2;
    }

    public final zzgp zzc() {
        if (this.zzd != null) {
            return this.zzd;
        }
        synchronized (this) {
            if (this.zzd != null) {
                return this.zzd;
            }
            if (this.zzc == null) {
                this.zzd = zzgp.zza;
            } else {
                this.zzd = this.zzc.zzbj();
            }
            return this.zzd;
        }
    }

    public final int zzb() {
        if (this.zzd != null) {
            return this.zzd.zza();
        }
        if (this.zzc != null) {
            return this.zzc.zzbp();
        }
        return 0;
    }
}
