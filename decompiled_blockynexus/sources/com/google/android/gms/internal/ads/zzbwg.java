package com.google.android.gms.internal.ads;

import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzbwg extends zzbyr<zzbwl> implements zzbuz, zzbwb {
    private final zzdnv zzfmx;
    private AtomicBoolean zzfuy;

    public zzbwg(Set<zzcab<zzbwl>> set, zzdnv zzdnvVar) {
        super(set);
        this.zzfuy = new AtomicBoolean();
        this.zzfmx = zzdnvVar;
    }

    private final void zzajy() {
        zzvp zzvpVar;
        if (((Boolean) zzwm.zzpx().zzd(zzabb.zzcxt)).booleanValue() && this.zzfuy.compareAndSet(false, true) && (zzvpVar = this.zzfmx.zzheg) != null && zzvpVar.type == 3) {
            zza(new zzbyt(this) { // from class: com.google.android.gms.internal.ads.zzbwj
                private final zzbwg zzfuz;

                {
                    this.zzfuz = this;
                }

                @Override // com.google.android.gms.internal.ads.zzbyt
                public final void zzp(Object obj) throws Exception {
                    this.zzfuz.zza((zzbwl) obj);
                }
            });
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbuz
    public final void onAdImpression() {
        int i = this.zzfmx.zzhdj;
        if (i == 2 || i == 5 || i == 4) {
            zzajy();
        }
    }

    final /* synthetic */ void zza(zzbwl zzbwlVar) throws Exception {
        zzbwlVar.zzb(this.zzfmx.zzheg);
    }

    @Override // com.google.android.gms.internal.ads.zzbwb
    public final void zzajx() {
        if (this.zzfmx.zzhdj == 1) {
            zzajy();
        }
    }
}
