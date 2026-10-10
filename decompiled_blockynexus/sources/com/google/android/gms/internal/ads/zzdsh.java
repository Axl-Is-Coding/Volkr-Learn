package com.google.android.gms.internal.ads;

import java.util.Set;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzdsh extends zzbyr<zzdso> implements zzdsg<zzdsf> {
    zzdsh(Set<zzcab<zzdso>> set) {
        super(set);
    }

    @Override // com.google.android.gms.internal.ads.zzdsg
    public final void zza(final zzdrr<zzdsf, ?> zzdrrVar) {
        zza(new zzbyt(zzdrrVar) { // from class: com.google.android.gms.internal.ads.zzdsk
            private final zzdrr zzhlk;

            {
                this.zzhlk = zzdrrVar;
            }

            @Override // com.google.android.gms.internal.ads.zzbyt
            public final void zzp(Object obj) {
                zzdrr zzdrrVar2 = this.zzhlk;
                ((zzdso) obj).zza((zzdsf) zzdrrVar2.zzavp(), zzdrrVar2.zzavq());
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzdsg
    public final void zzb(final zzdrr<zzdsf, ?> zzdrrVar) {
        zza(new zzbyt(zzdrrVar) { // from class: com.google.android.gms.internal.ads.zzdsj
            private final zzdrr zzhlk;

            {
                this.zzhlk = zzdrrVar;
            }

            @Override // com.google.android.gms.internal.ads.zzbyt
            public final void zzp(Object obj) {
                zzdrr zzdrrVar2 = this.zzhlk;
                ((zzdso) obj).zzb((zzdsf) zzdrrVar2.zzavp(), zzdrrVar2.zzavq());
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzdsg
    public final void zzc(final zzdrr<zzdsf, ?> zzdrrVar) {
        zza(new zzbyt(zzdrrVar) { // from class: com.google.android.gms.internal.ads.zzdsl
            private final zzdrr zzhlk;

            {
                this.zzhlk = zzdrrVar;
            }

            @Override // com.google.android.gms.internal.ads.zzbyt
            public final void zzp(Object obj) {
                zzdrr zzdrrVar2 = this.zzhlk;
                ((zzdso) obj).zzc((zzdsf) zzdrrVar2.zzavp(), zzdrrVar2.zzavq());
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzdsg
    public final void zza(final zzdrr<zzdsf, ?> zzdrrVar, final Throwable th) {
        zza(new zzbyt(zzdrrVar, th) { // from class: com.google.android.gms.internal.ads.zzdsm
            private final zzdrr zzhlk;
            private final Throwable zzhll;

            {
                this.zzhlk = zzdrrVar;
                this.zzhll = th;
            }

            @Override // com.google.android.gms.internal.ads.zzbyt
            public final void zzp(Object obj) {
                zzdrr zzdrrVar2 = this.zzhlk;
                ((zzdso) obj).zza((zzdsf) zzdrrVar2.zzavp(), zzdrrVar2.zzavq(), this.zzhll);
            }
        });
    }
}
