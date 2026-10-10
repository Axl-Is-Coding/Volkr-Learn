package com.google.android.gms.internal.ads;

import android.content.pm.PackageInfo;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzdff implements zzeoy<zzdey> {
    private final zzeph<zzdzb> zzesr;
    private final zzeph<zzayr> zzevu;
    private final zzeph<zzdok> zzfqr;
    private final zzeph<PackageInfo> zzfue;

    public zzdff(zzeph<zzdzb> zzephVar, zzeph<zzdok> zzephVar2, zzeph<PackageInfo> zzephVar3, zzeph<zzayr> zzephVar4) {
        this.zzesr = zzephVar;
        this.zzfqr = zzephVar2;
        this.zzfue = zzephVar3;
        this.zzevu = zzephVar4;
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        return new zzdey(this.zzesr.get(), this.zzfqr.get(), this.zzfue.get(), this.zzevu.get());
    }
}
