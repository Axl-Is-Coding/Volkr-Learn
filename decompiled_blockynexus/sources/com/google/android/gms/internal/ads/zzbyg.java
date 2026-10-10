package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzua;
import java.util.Set;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzbyg extends zzbyr<zzbyo> implements zzbyo {
    public zzbyg(Set<zzcab<zzbyo>> set) {
        super(set);
    }

    @Override // com.google.android.gms.internal.ads.zzbyo
    public final void zzake() {
        zza(zzbym.zzfur);
    }

    @Override // com.google.android.gms.internal.ads.zzbyo
    public final void zzbg(final boolean z) {
        zza(new zzbyt(z) { // from class: com.google.android.gms.internal.ads.zzbyk
            private final boolean zzeok;

            {
                this.zzeok = z;
            }

            @Override // com.google.android.gms.internal.ads.zzbyt
            public final void zzp(Object obj) {
                ((zzbyo) obj).zzbg(this.zzeok);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzbyo
    public final void zzbh(final boolean z) {
        zza(new zzbyt(z) { // from class: com.google.android.gms.internal.ads.zzbyn
            private final boolean zzeok;

            {
                this.zzeok = z;
            }

            @Override // com.google.android.gms.internal.ads.zzbyt
            public final void zzp(Object obj) {
                ((zzbyo) obj).zzbh(this.zzeok);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzbyo
    public final void zzc(final zzua.zzb zzbVar) {
        zza(new zzbyt(zzbVar) { // from class: com.google.android.gms.internal.ads.zzbyj
            private final zzua.zzb zzfvp;

            {
                this.zzfvp = zzbVar;
            }

            @Override // com.google.android.gms.internal.ads.zzbyt
            public final void zzp(Object obj) {
                ((zzbyo) obj).zzc(this.zzfvp);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzbyo
    public final void zzd(final zzua.zzb zzbVar) {
        zza(new zzbyt(zzbVar) { // from class: com.google.android.gms.internal.ads.zzbyi
            private final zzua.zzb zzfvp;

            {
                this.zzfvp = zzbVar;
            }

            @Override // com.google.android.gms.internal.ads.zzbyt
            public final void zzp(Object obj) {
                ((zzbyo) obj).zzd(this.zzfvp);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzbyo
    public final void zze(final zzua.zzb zzbVar) {
        zza(new zzbyt(zzbVar) { // from class: com.google.android.gms.internal.ads.zzbyl
            private final zzua.zzb zzfvp;

            {
                this.zzfvp = zzbVar;
            }

            @Override // com.google.android.gms.internal.ads.zzbyt
            public final void zzp(Object obj) {
                ((zzbyo) obj).zze(this.zzfvp);
            }
        });
    }
}
