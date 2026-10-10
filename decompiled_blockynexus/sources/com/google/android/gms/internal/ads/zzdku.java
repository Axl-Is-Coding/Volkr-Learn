package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbqo;
import com.google.android.gms.internal.ads.zzbtn;
import java.util.Iterator;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzdku<R extends zzbtn<AdT>, AdT extends zzbqo> implements zzdlv<R, zzdqk<AdT>> {
    private final Executor executor = zzdze.zzayh();
    private R zzhbc;

    @Override // com.google.android.gms.internal.ads.zzdlv
    public final zzdzc<zzdqk<AdT>> zza(zzdlw zzdlwVar, zzdlx<R> zzdlxVar) {
        zzbtq<R> zzbtqVarZzc = zzdlxVar.zzc(zzdlwVar.zzhcf);
        zzbtqVarZzc.zza(new zzdmd(true));
        this.zzhbc = zzbtqVarZzc.zzaey();
        final zzbrl zzbrlVarZzaev = this.zzhbc.zzaev();
        final zzdqk zzdqkVar = new zzdqk();
        zzatc zzatcVar = zzdlwVar.zzhce;
        return zzdyl.zzg(zzatcVar != null ? zzbrlVarZzaev.zza(zzatcVar) : zzbrlVarZzaev.zzajg()).zzb(new zzdya(this, zzdqkVar, zzbrlVarZzaev) { // from class: com.google.android.gms.internal.ads.zzdkx
            private final zzdku zzhbe;
            private final zzdqk zzhbf;
            private final zzbrl zzhbg;

            {
                this.zzhbe = this;
                this.zzhbf = zzdqkVar;
                this.zzhbg = zzbrlVarZzaev;
            }

            @Override // com.google.android.gms.internal.ads.zzdya
            public final zzdzc zzf(Object obj) {
                zzdku zzdkuVar = this.zzhbe;
                zzdqk zzdqkVar2 = this.zzhbf;
                zzbrl zzbrlVar = this.zzhbg;
                zzdog zzdogVar = (zzdog) obj;
                zzdqkVar2.zzevd = zzdogVar;
                Iterator<zzdnv> it = zzdogVar.zzhew.zzhet.iterator();
                boolean z = false;
                boolean z2 = false;
                loop0: while (true) {
                    if (!it.hasNext()) {
                        z = z2;
                        break;
                    }
                    Iterator<String> it2 = it.next().zzhdi.iterator();
                    while (it2.hasNext()) {
                        if (!it2.next().contains("FirstPartyRenderer")) {
                            break loop0;
                        }
                        z2 = true;
                    }
                }
                return !z ? zzdyq.zzaf(null) : zzbrlVar.zzb(zzdyq.zzaf(zzdogVar));
            }
        }, this.executor).zza(new zzdvu(zzdqkVar) { // from class: com.google.android.gms.internal.ads.zzdkw
            private final zzdqk zzhbd;

            {
                this.zzhbd = zzdqkVar;
            }

            @Override // com.google.android.gms.internal.ads.zzdvu
            public final Object apply(Object obj) {
                zzdqk zzdqkVar2 = this.zzhbd;
                zzdqkVar2.zzhir = (AdT) obj;
                return zzdqkVar2;
            }
        }, this.executor);
    }

    @Override // com.google.android.gms.internal.ads.zzdlv
    public final /* synthetic */ Object zzasv() {
        return this.zzhbc;
    }
}
