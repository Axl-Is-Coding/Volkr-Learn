package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.VisibleForTesting;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzdor {
    private final zzdnv zzeot;
    private final zzdnw zzeou;
    private final zzdst zzfnf;
    private final zzcsp zzgha;

    @VisibleForTesting
    public zzdor(zzcsp zzcspVar, zzdst zzdstVar, zzdnv zzdnvVar, zzdnw zzdnwVar) {
        this.zzeot = zzdnvVar;
        this.zzeou = zzdnwVar;
        this.zzgha = zzcspVar;
        this.zzfnf = zzdstVar;
    }

    private final void zzb(String str, int i) {
        if (!this.zzeot.zzhek) {
            this.zzfnf.zzes(str);
        } else {
            this.zzgha.zza(new zzcsv(com.google.android.gms.ads.internal.zzp.zzky().currentTimeMillis(), this.zzeou.zzdtb, str, i));
        }
    }

    /* JADX WARN: Incorrect types in method signature: (Ljava/util/List<Ljava/lang/String;>;Ljava/lang/Integer;)V */
    public final void zza(List list, int i) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            zzb((String) it.next(), i);
        }
    }

    public final void zzi(List<String> list) {
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            zzb(it.next(), zzcsq.zzgne);
        }
    }
}
