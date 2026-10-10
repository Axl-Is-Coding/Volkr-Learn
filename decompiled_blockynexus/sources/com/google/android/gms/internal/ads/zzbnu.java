package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzbnu implements zzeoy<String> {
    public static zzbnu zzahu() {
        return zzbnt.zzfpm;
    }

    public static String zzahv() {
        zzepe.zza("app_open_ad", "Cannot return null from a non-@Nullable @Provides method");
        return "app_open_ad";
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        return zzahv();
    }
}
