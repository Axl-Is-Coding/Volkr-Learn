package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzbmc implements zzeoy<zzblz> {
    private final zzeph<zzayr> zzevu;

    private zzbmc(zzeph<zzayr> zzephVar) {
        this.zzevu = zzephVar;
    }

    public static zzbmc zza(zzeph<zzayr> zzephVar) {
        return new zzbmc(zzephVar);
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        return new zzblz(this.zzevu.get());
    }
}
