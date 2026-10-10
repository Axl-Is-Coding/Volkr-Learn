package com.google.android.gms.internal.ads;

import java.util.Iterator;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzcwl {
    private final zzcmu zzfpk;
    private final zzckp zzgfy;
    private final zzdow zzggz;

    public zzcwl(zzdow zzdowVar, zzckp zzckpVar, zzcmu zzcmuVar) {
        this.zzggz = zzdowVar;
        this.zzgfy = zzckpVar;
        this.zzfpk = zzcmuVar;
    }

    public final void zza(zzdnw zzdnwVar, zzdnv zzdnvVar, int i, zzcte zzcteVar, long j) {
        zzckq zzckqVarZzgg;
        zzcmt zzcmtVarZzr = this.zzfpk.zzapf().zza(zzdnwVar).zzd(zzdnvVar).zzr("action", "adapter_status").zzr("adapter_l", String.valueOf(j));
        zzcmtVarZzr.zzr("sc", Integer.toString(i));
        if (zzcteVar != null) {
            zzcmtVarZzr.zzr("arec", Integer.toString(zzcteVar.zzaqj().errorCode));
            String strZzgu = this.zzggz.zzgu(zzcteVar.getMessage());
            if (strZzgu != null) {
                zzcmtVarZzr.zzr("areec", strZzgu);
            }
        }
        zzckp zzckpVar = this.zzgfy;
        Iterator<String> it = zzdnvVar.zzhds.iterator();
        while (true) {
            if (!it.hasNext()) {
                zzckqVarZzgg = null;
                break;
            } else {
                zzckqVarZzgg = zzckpVar.zzgg(it.next());
                if (zzckqVarZzgg != null) {
                    break;
                }
            }
        }
        if (zzckqVarZzgg != null) {
            zzcmtVarZzr.zzr("ancn", zzckqVarZzgg.zzdfz);
            zzapv zzapvVar = zzckqVarZzgg.zzgfv;
            if (zzapvVar != null) {
                zzcmtVarZzr.zzr("adapter_v", zzapvVar.toString());
            }
            zzapv zzapvVar2 = zzckqVarZzgg.zzgfw;
            if (zzapvVar2 != null) {
                zzcmtVarZzr.zzr("adapter_sv", zzapvVar2.toString());
            }
        }
        zzcmtVarZzr.zzapc();
    }
}
