package com.google.android.gms.internal.ads;

import android.content.pm.ApplicationInfo;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzdja implements zzeoy<ApplicationInfo> {
    private final zzdiy zzgzp;

    public zzdja(zzdiy zzdiyVar) {
        this.zzgzp = zzdiyVar;
    }

    public static ApplicationInfo zzb(zzdiy zzdiyVar) {
        ApplicationInfo applicationInfoZzask = zzdiyVar.zzask();
        zzepe.zza(applicationInfoZzask, "Cannot return null from a non-@Nullable @Provides method");
        return applicationInfoZzask;
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        return zzb(this.zzgzp);
    }
}
