package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzcov implements zzeoy<PackageInfo> {
    private final zzeph<Context> zzesu;
    private final zzeph<ApplicationInfo> zzgjm;

    private zzcov(zzeph<Context> zzephVar, zzeph<ApplicationInfo> zzephVar2) {
        this.zzesu = zzephVar;
        this.zzgjm = zzephVar2;
    }

    public static zzcov zzaq(zzeph<Context> zzephVar, zzeph<ApplicationInfo> zzephVar2) {
        return new zzcov(zzephVar, zzephVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        return zzcol.zza(this.zzesu.get(), this.zzgjm.get());
    }
}
