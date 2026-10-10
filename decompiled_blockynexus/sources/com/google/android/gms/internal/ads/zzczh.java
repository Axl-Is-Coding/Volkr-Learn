package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.formats.PublisherAdViewOptions;
import com.google.android.gms.common.util.VisibleForTesting;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzczh extends zzwy {
    private zzwt zzbpj;
    private final zzbix zzgpt;
    private final Context zzgsl;

    @VisibleForTesting
    private final zzdom zzgsm = new zzdom();

    @VisibleForTesting
    private final zzcer zzgsn = new zzcer();

    public zzczh(zzbix zzbixVar, Context context, String str) {
        this.zzgpt = zzbixVar;
        this.zzgsm.zzgt(str);
        this.zzgsl = context;
    }

    @Override // com.google.android.gms.internal.ads.zzwz
    public final void zza(zzafe zzafeVar) {
        this.zzgsn.zzb(zzafeVar);
    }

    @Override // com.google.android.gms.internal.ads.zzwz
    public final void zzb(zzwt zzwtVar) {
        this.zzbpj = zzwtVar;
    }

    @Override // com.google.android.gms.internal.ads.zzwz
    public final zzwu zzqf() {
        zzcep zzcepVarZzamw = this.zzgsn.zzamw();
        this.zzgsm.zzc(zzcepVarZzamw.zzamu());
        this.zzgsm.zzd(zzcepVarZzamw.zzamv());
        zzdom zzdomVar = this.zzgsm;
        if (zzdomVar.zzkg() == null) {
            zzdomVar.zze(zzvn.zzpk());
        }
        return new zzczk(this.zzgsl, this.zzgpt, this.zzgsm, zzcepVarZzamw, this.zzbpj);
    }

    @Override // com.google.android.gms.internal.ads.zzwz
    public final void zza(zzaft zzaftVar) {
        this.zzgsn.zzb(zzaftVar);
    }

    @Override // com.google.android.gms.internal.ads.zzwz
    public final void zzb(zzxq zzxqVar) {
        this.zzgsm.zzc(zzxqVar);
    }

    @Override // com.google.android.gms.internal.ads.zzwz
    public final void zza(zzaff zzaffVar) {
        this.zzgsn.zzb(zzaffVar);
    }

    @Override // com.google.android.gms.internal.ads.zzwz
    public final void zza(String str, zzafl zzaflVar, zzafk zzafkVar) {
        this.zzgsn.zzb(str, zzaflVar, zzafkVar);
    }

    @Override // com.google.android.gms.internal.ads.zzwz
    public final void zza(zzadu zzaduVar) {
        this.zzgsm.zzb(zzaduVar);
    }

    @Override // com.google.android.gms.internal.ads.zzwz
    public final void zza(zzajc zzajcVar) {
        this.zzgsm.zzb(zzajcVar);
    }

    @Override // com.google.android.gms.internal.ads.zzwz
    public final void zza(zzajk zzajkVar) {
        this.zzgsn.zzb(zzajkVar);
    }

    @Override // com.google.android.gms.internal.ads.zzwz
    public final void zza(zzafs zzafsVar, zzvn zzvnVar) {
        this.zzgsn.zza(zzafsVar);
        this.zzgsm.zze(zzvnVar);
    }

    @Override // com.google.android.gms.internal.ads.zzwz
    public final void zza(PublisherAdViewOptions publisherAdViewOptions) {
        this.zzgsm.zzb(publisherAdViewOptions);
    }
}
