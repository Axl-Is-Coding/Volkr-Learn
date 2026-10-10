package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzcch implements zzeoy<String> {
    public static zzcch zzald() {
        return zzcck.zzfxb;
    }

    public static String zzale() {
        zzepe.zza("interstitial", "Cannot return null from a non-@Nullable @Provides method");
        return "interstitial";
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        return zzale();
    }
}
