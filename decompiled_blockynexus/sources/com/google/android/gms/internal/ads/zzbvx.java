package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.reward.AdMetadataListener;
import java.util.Set;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzbvx implements zzeoy<zzbvv> {
    private final zzeph<Set<zzcab<AdMetadataListener>>> zzfqq;

    private zzbvx(zzeph<Set<zzcab<AdMetadataListener>>> zzephVar) {
        this.zzfqq = zzephVar;
    }

    public static zzbvx zzm(zzeph<Set<zzcab<AdMetadataListener>>> zzephVar) {
        return new zzbvx(zzephVar);
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        return new zzbvv(this.zzfqq.get());
    }
}
