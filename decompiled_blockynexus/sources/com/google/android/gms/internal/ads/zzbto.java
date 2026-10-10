package com.google.android.gms.internal.ads;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzbto implements zzeoy<zzbtm> {
    private final zzeph<zzayr> zzevu;
    private final zzeph<zzdgw<Bundle>> zzeys;
    private final zzeph<zzbbx> zzfov;
    private final zzeph<zzdsi> zzfqv;
    private final zzeph<ApplicationInfo> zzfub;
    private final zzeph<String> zzfuc;
    private final zzeph<List<String>> zzfud;
    private final zzeph<PackageInfo> zzfue;
    private final zzeph<zzdzc<String>> zzfuf;
    private final zzeph<String> zzfug;

    private zzbto(zzeph<zzdsi> zzephVar, zzeph<zzbbx> zzephVar2, zzeph<ApplicationInfo> zzephVar3, zzeph<String> zzephVar4, zzeph<List<String>> zzephVar5, zzeph<PackageInfo> zzephVar6, zzeph<zzdzc<String>> zzephVar7, zzeph<zzayr> zzephVar8, zzeph<String> zzephVar9, zzeph<zzdgw<Bundle>> zzephVar10) {
        this.zzfqv = zzephVar;
        this.zzfov = zzephVar2;
        this.zzfub = zzephVar3;
        this.zzfuc = zzephVar4;
        this.zzfud = zzephVar5;
        this.zzfue = zzephVar6;
        this.zzfuf = zzephVar7;
        this.zzevu = zzephVar8;
        this.zzfug = zzephVar9;
        this.zzeys = zzephVar10;
    }

    public static zzbto zza(zzeph<zzdsi> zzephVar, zzeph<zzbbx> zzephVar2, zzeph<ApplicationInfo> zzephVar3, zzeph<String> zzephVar4, zzeph<List<String>> zzephVar5, zzeph<PackageInfo> zzephVar6, zzeph<zzdzc<String>> zzephVar7, zzeph<zzayr> zzephVar8, zzeph<String> zzephVar9, zzeph<zzdgw<Bundle>> zzephVar10) {
        return new zzbto(zzephVar, zzephVar2, zzephVar3, zzephVar4, zzephVar5, zzephVar6, zzephVar7, zzephVar8, zzephVar9, zzephVar10);
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        return new zzbtm(this.zzfqv.get(), this.zzfov.get(), this.zzfub.get(), this.zzfuc.get(), this.zzfud.get(), this.zzfue.get(), zzeov.zzat(this.zzfuf), this.zzevu.get(), this.zzfug.get(), this.zzeys.get());
    }
}
