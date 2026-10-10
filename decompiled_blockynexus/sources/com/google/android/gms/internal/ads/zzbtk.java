package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.ArrayList;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzbtk implements zzbuy, zzbvs {
    private final zzarj zzbom;
    private final zzdnv zzeot;
    private final Context zzvr;

    public zzbtk(Context context, zzdnv zzdnvVar, zzarj zzarjVar) {
        this.zzvr = context;
        this.zzeot = zzdnvVar;
        this.zzbom = zzarjVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbvs
    public final void onAdLoaded() {
        zzarh zzarhVar = this.zzeot.zzhef;
        if (zzarhVar == null || !zzarhVar.zzdpy) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        if (!this.zzeot.zzhef.zzdpz.isEmpty()) {
            arrayList.add(this.zzeot.zzhef.zzdpz);
        }
        this.zzbom.zza(this.zzvr, arrayList);
    }

    @Override // com.google.android.gms.internal.ads.zzbuy
    public final void zzca(Context context) {
    }

    @Override // com.google.android.gms.internal.ads.zzbuy
    public final void zzcb(Context context) {
    }

    @Override // com.google.android.gms.internal.ads.zzbuy
    public final void zzcc(Context context) {
        this.zzbom.detach();
    }
}
