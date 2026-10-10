package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzclu implements zzeoy<zzcln> {
    private final zzeph<zzdmd> zzevr;
    private final zzeph<zzts> zzggl;

    private zzclu(zzeph<zzts> zzephVar, zzeph<zzdmd> zzephVar2) {
        this.zzggl = zzephVar;
        this.zzevr = zzephVar2;
    }

    public static zzclu zzag(zzeph<zzts> zzephVar, zzeph<zzdmd> zzephVar2) {
        return new zzclu(zzephVar, zzephVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        return new zzcln(this.zzggl.get(), this.zzevr.get());
    }
}
