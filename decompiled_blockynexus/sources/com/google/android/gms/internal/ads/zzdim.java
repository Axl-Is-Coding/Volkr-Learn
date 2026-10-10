package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzdim implements zzeoy<zzdik> {
    private final zzeph<zzdzb> zzesr;
    private final zzeph<zzaxt> zzetv;
    private final zzeph<String> zzfuc;

    public zzdim(zzeph<zzaxt> zzephVar, zzeph<zzdzb> zzephVar2, zzeph<String> zzephVar3) {
        this.zzetv = zzephVar;
        this.zzesr = zzephVar2;
        this.zzfuc = zzephVar3;
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        return new zzdik(this.zzetv.get(), this.zzesr.get(), this.zzfuc.get());
    }
}
