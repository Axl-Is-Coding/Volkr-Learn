package com.google.android.gms.internal.ads;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzdfn implements zzeoy<zzdfk> {
    private final zzeph<PackageInfo> zzfue;
    private final zzeph<ApplicationInfo> zzgjm;

    private zzdfn(zzeph<ApplicationInfo> zzephVar, zzeph<PackageInfo> zzephVar2) {
        this.zzgjm = zzephVar;
        this.zzfue = zzephVar2;
    }

    public static zzdfk zza(ApplicationInfo applicationInfo, PackageInfo packageInfo) {
        return new zzdfk(applicationInfo, packageInfo);
    }

    public static zzdfn zzbc(zzeph<ApplicationInfo> zzephVar, zzeph<PackageInfo> zzephVar2) {
        return new zzdfn(zzephVar, zzephVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        return zza(this.zzgjm.get(), this.zzfue.get());
    }
}
