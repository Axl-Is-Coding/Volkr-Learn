package com.google.android.gms.internal.ads;

import java.util.Set;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzbwh implements zzeoy<zzbwa> {
    private final zzeph<Set<zzcab<com.google.android.gms.ads.internal.overlay.zzp>>> zzfqq;

    private zzbwh(zzeph<Set<zzcab<com.google.android.gms.ads.internal.overlay.zzp>>> zzephVar) {
        this.zzfqq = zzephVar;
    }

    public static zzbwh zzo(zzeph<Set<zzcab<com.google.android.gms.ads.internal.overlay.zzp>>> zzephVar) {
        return new zzbwh(zzephVar);
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        return new zzbwa(this.zzfqq.get());
    }
}
