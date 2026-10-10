package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.pm.ApplicationInfo;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzcou implements zzeoy<ApplicationInfo> {
    private final zzeph<Context> zzesu;

    private zzcou(zzeph<Context> zzephVar) {
        this.zzesu = zzephVar;
    }

    public static zzcou zzac(zzeph<Context> zzephVar) {
        return new zzcou(zzephVar);
    }

    public static ApplicationInfo zzcf(Context context) {
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        zzepe.zza(applicationInfo, "Cannot return null from a non-@Nullable @Provides method");
        return applicationInfo;
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        return zzcf(this.zzesu.get());
    }
}
