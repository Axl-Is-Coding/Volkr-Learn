package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.ads.zzbvp;
import java.util.Iterator;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzcxv<AdT, AdapterT, ListenerT extends zzbvp> implements zzcta<AdT> {
    private final zzctb<AdapterT, ListenerT> zzfmb;
    private final zzdsi zzfsl;
    private final zzcti<AdT, AdapterT, ListenerT> zzgrb;
    private final zzdzb zzgrc;

    public zzcxv(zzdsi zzdsiVar, zzdzb zzdzbVar, zzctb<AdapterT, ListenerT> zzctbVar, zzcti<AdT, AdapterT, ListenerT> zzctiVar) {
        this.zzfsl = zzdsiVar;
        this.zzgrc = zzdzbVar;
        this.zzgrb = zzctiVar;
        this.zzfmb = zzctbVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcta
    public final boolean zza(zzdog zzdogVar, zzdnv zzdnvVar) {
        return !zzdnvVar.zzhds.isEmpty();
    }

    @Override // com.google.android.gms.internal.ads.zzcta
    public final zzdzc<AdT> zzb(final zzdog zzdogVar, final zzdnv zzdnvVar) {
        final zzctc<AdapterT, ListenerT> zzctcVarZzf;
        Iterator<String> it = zzdnvVar.zzhds.iterator();
        while (true) {
            if (!it.hasNext()) {
                zzctcVarZzf = null;
                break;
            }
            try {
                zzctcVarZzf = this.zzfmb.zzf(it.next(), zzdnvVar.zzhdu);
                break;
            } catch (zzdos unused) {
            }
        }
        if (zzctcVarZzf == null) {
            return zzdyq.immediateFailedFuture(new zzcvz("unable to instantiate mediation adapter class"));
        }
        zzbcg zzbcgVar = new zzbcg();
        zzctcVarZzf.zzgns.zza(new zzcya(this, zzctcVarZzf, zzbcgVar));
        if (zzdnvVar.zzduj) {
            Bundle bundle = zzdogVar.zzhev.zzfsk.zzhfa.zzchi;
            Bundle bundle2 = bundle.getBundle(AdMobAdapter.class.getName());
            if (bundle2 == null) {
                bundle2 = new Bundle();
                bundle.putBundle(AdMobAdapter.class.getName(), bundle2);
            }
            bundle2.putBoolean("render_test_ad_label", true);
        }
        return this.zzfsl.zzu(zzdsf.ADAPTER_LOAD_AD_SYN).zza(new zzdrs(this, zzdogVar, zzdnvVar, zzctcVarZzf) { // from class: com.google.android.gms.internal.ads.zzcxy
            private final zzdnv zzfqn;
            private final zzdog zzgcx;
            private final zzctc zzgqx;
            private final zzcxv zzgrd;

            {
                this.zzgrd = this;
                this.zzgcx = zzdogVar;
                this.zzfqn = zzdnvVar;
                this.zzgqx = zzctcVarZzf;
            }

            @Override // com.google.android.gms.internal.ads.zzdrs
            public final void run() throws Exception {
                this.zzgrd.zzd(this.zzgcx, this.zzfqn, this.zzgqx);
            }
        }, this.zzgrc).zzw(zzdsf.ADAPTER_LOAD_AD_ACK).zze(zzbcgVar).zzw(zzdsf.ADAPTER_WRAP_ADAPTER).zzb(new zzdrp(this, zzdogVar, zzdnvVar, zzctcVarZzf) { // from class: com.google.android.gms.internal.ads.zzcxx
            private final zzdnv zzfqn;
            private final zzdog zzgcx;
            private final zzctc zzgqx;
            private final zzcxv zzgrd;

            {
                this.zzgrd = this;
                this.zzgcx = zzdogVar;
                this.zzfqn = zzdnvVar;
                this.zzgqx = zzctcVarZzf;
            }

            @Override // com.google.android.gms.internal.ads.zzdrp
            public final Object apply(Object obj) {
                return this.zzgrd.zza(this.zzgcx, this.zzfqn, this.zzgqx, (Void) obj);
            }
        }).zzavs();
    }

    final /* synthetic */ void zzd(zzdog zzdogVar, zzdnv zzdnvVar, zzctc zzctcVar) throws Exception {
        this.zzgrb.zza(zzdogVar, zzdnvVar, zzctcVar);
    }

    @VisibleForTesting
    static String zza(String str, int i) {
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 31);
        sb.append("Error from: ");
        sb.append(str);
        sb.append(", code: ");
        sb.append(i);
        return sb.toString();
    }

    final /* synthetic */ Object zza(zzdog zzdogVar, zzdnv zzdnvVar, zzctc zzctcVar, Void r4) throws Exception {
        return this.zzgrb.zzb(zzdogVar, zzdnvVar, zzctcVar);
    }
}
