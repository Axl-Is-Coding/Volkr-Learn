package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzcpa implements zzeoy<String> {
    public static zzcpa zzapw() {
        return zzcoz.zzgjo;
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        com.google.android.gms.ads.internal.zzp.zzkr();
        String strZzxs = zzayu.zzxs();
        zzepe.zza(strZzxs, "Cannot return null from a non-@Nullable @Provides method");
        return strZzxs;
    }
}
