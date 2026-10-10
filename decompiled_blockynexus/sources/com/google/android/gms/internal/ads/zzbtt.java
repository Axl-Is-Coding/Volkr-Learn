package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzbtt implements zzeoy<String> {
    private final zzbtp zzfuk;

    private zzbtt(zzbtp zzbtpVar) {
        this.zzfuk = zzbtpVar;
    }

    public static zzbtt zzh(zzbtp zzbtpVar) {
        return new zzbtt(zzbtpVar);
    }

    public static String zzi(zzbtp zzbtpVar) {
        return zzbtpVar.zzaju();
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        return this.zzfuk.zzaju();
    }
}
