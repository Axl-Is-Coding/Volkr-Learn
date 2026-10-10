package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.dynamic.ObjectWrapper;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzcug implements zzcti<zzboq, zzaph, zzcuu> {
    private View view;
    private final zzbpm zzgoj;
    private final Context zzvr;

    public zzcug(Context context, zzbpm zzbpmVar) {
        this.zzvr = context;
        this.zzgoj = zzbpmVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcti
    public final void zza(zzdog zzdogVar, zzdnv zzdnvVar, zzctc<zzaph, zzcuu> zzctcVar) throws zzdos {
        try {
            zzctcVar.zzdlf.zzdr(zzdnvVar.zzdmk);
            zzctcVar.zzdlf.zza(zzdnvVar.zzera, zzdnvVar.zzhdu.toString(), zzdogVar.zzhev.zzfsk.zzhfa, ObjectWrapper.wrap(this.zzvr), new zzcuh(this, zzctcVar), (zzanh) zzctcVar.zzgns, zzdogVar.zzhev.zzfsk.zzbpf);
        } catch (RemoteException e2) {
            throw new zzdos(e2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcti
    public final /* synthetic */ zzboq zzb(zzdog zzdogVar, zzdnv zzdnvVar, final zzctc zzctcVar) throws zzcwn, zzdos {
        zzbop zzbopVarZza = this.zzgoj.zza(new zzbre(zzdogVar, zzdnvVar, zzctcVar.zzcib), new zzbot(this.view, null, new zzbql(zzctcVar) { // from class: com.google.android.gms.internal.ads.zzcuf
            private final zzctc zzgop;

            {
                this.zzgop = zzctcVar;
            }

            @Override // com.google.android.gms.internal.ads.zzbql
            public final zzyo getVideoController() {
                return zzcug.zza(this.zzgop);
            }
        }, zzdnvVar.zzhdt.get(0)));
        zzbopVarZza.zzagb().zzv(this.view);
        ((zzcuu) zzctcVar.zzgns).zzb(zzbopVarZza.zzaff());
        return zzbopVarZza.zzaga();
    }

    static final /* synthetic */ zzyo zza(zzctc zzctcVar) throws zzdos {
        try {
            return ((zzaph) zzctcVar.zzdlf).getVideoController();
        } catch (RemoteException e2) {
            throw new zzdos(e2);
        }
    }
}
