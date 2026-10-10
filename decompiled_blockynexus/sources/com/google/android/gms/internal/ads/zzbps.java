package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzbps implements zzeoy<String> {
    public static zzbps zzaip() {
        return zzbpr.zzfqu;
    }

    public static String zzaiq() {
        zzepe.zza("banner", "Cannot return null from a non-@Nullable @Provides method");
        return "banner";
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        return zzaiq();
    }
}
