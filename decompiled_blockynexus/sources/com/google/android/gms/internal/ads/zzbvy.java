package com.google.android.gms.internal.ads;

import java.util.Set;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzbvy implements zzeoy<zzbvw> {
    private final zzeph<Set<zzcab<zzbwb>>> zzfqq;

    private zzbvy(zzeph<Set<zzcab<zzbwb>>> zzephVar) {
        this.zzfqq = zzephVar;
    }

    public static zzbvy zzn(zzeph<Set<zzcab<zzbwb>>> zzephVar) {
        return new zzbvy(zzephVar);
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        return new zzbvw(this.zzfqq.get());
    }
}
