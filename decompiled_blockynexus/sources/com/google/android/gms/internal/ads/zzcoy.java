package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzcoy implements zzeoy<String> {
    private final zzeph<Context> zzesu;

    private zzcoy(zzeph<Context> zzephVar) {
        this.zzesu = zzephVar;
    }

    public static zzcoy zzae(zzeph<Context> zzephVar) {
        return new zzcoy(zzephVar);
    }

    public static String zzch(Context context) {
        String packageName = context.getPackageName();
        zzepe.zza(packageName, "Cannot return null from a non-@Nullable @Provides method");
        return packageName;
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        return zzch(this.zzesu.get());
    }
}
