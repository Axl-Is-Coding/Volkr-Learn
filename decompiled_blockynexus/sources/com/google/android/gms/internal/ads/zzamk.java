package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzamk {
    private zzakr zzdjb;
    private zzdzc<zzalp> zzdjc;

    zzamk(zzakr zzakrVar) {
        this.zzdjb = zzakrVar;
    }

    private final void zztq() {
        if (this.zzdjc == null) {
            final zzbcg zzbcgVar = new zzbcg();
            this.zzdjc = zzbcgVar;
            this.zzdjb.zzb((zzeg) null).zza(new zzbck(zzbcgVar) { // from class: com.google.android.gms.internal.ads.zzamj
                private final zzbcg zzbvu;

                {
                    this.zzbvu = zzbcgVar;
                }

                @Override // com.google.android.gms.internal.ads.zzbck
                public final void zzh(Object obj) {
                    this.zzbvu.set((zzalp) obj);
                }
            }, new zzbci(zzbcgVar) { // from class: com.google.android.gms.internal.ads.zzamm
                private final zzbcg zzbvu;

                {
                    this.zzbvu = zzbcgVar;
                }

                @Override // com.google.android.gms.internal.ads.zzbci
                public final void run() {
                    this.zzbvu.setException(new zzalu("Cannot get Javascript Engine"));
                }
            });
        }
    }

    public final <I, O> zzamn<I, O> zzb(String str, zzaly<I> zzalyVar, zzalv<O> zzalvVar) {
        zztq();
        return new zzamn<>(this.zzdjc, str, zzalyVar, zzalvVar);
    }

    public final void zzc(final String str, final zzahq<? super zzalp> zzahqVar) {
        zztq();
        this.zzdjc = zzdyq.zzb(this.zzdjc, new zzdya(str, zzahqVar) { // from class: com.google.android.gms.internal.ads.zzaml
            private final String zzdgt;
            private final zzahq zzdgv;

            {
                this.zzdgt = str;
                this.zzdgv = zzahqVar;
            }

            @Override // com.google.android.gms.internal.ads.zzdya
            public final zzdzc zzf(Object obj) {
                zzalp zzalpVar = (zzalp) obj;
                zzalpVar.zza(this.zzdgt, this.zzdgv);
                return zzdyq.zzaf(zzalpVar);
            }
        }, zzbbz.zzeeu);
    }

    public final void zzd(final String str, final zzahq<? super zzalp> zzahqVar) {
        this.zzdjc = zzdyq.zzb(this.zzdjc, new zzdvu(str, zzahqVar) { // from class: com.google.android.gms.internal.ads.zzamo
            private final String zzdgt;
            private final zzahq zzdgv;

            {
                this.zzdgt = str;
                this.zzdgv = zzahqVar;
            }

            @Override // com.google.android.gms.internal.ads.zzdvu
            public final Object apply(Object obj) {
                zzalp zzalpVar = (zzalp) obj;
                zzalpVar.zzb(this.zzdgt, this.zzdgv);
                return zzalpVar;
            }
        }, zzbbz.zzeeu);
    }
}
