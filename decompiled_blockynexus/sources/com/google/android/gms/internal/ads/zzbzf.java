package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.reward.AdMetadataListener;
import java.util.Set;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzbzf implements zzeoy<Set<zzcab<AdMetadataListener>>> {
    private final zzbys zzfwg;

    private zzbzf(zzbys zzbysVar) {
        this.zzfwg = zzbysVar;
    }

    public static zzbzf zzr(zzbys zzbysVar) {
        return new zzbzf(zzbysVar);
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        Set<zzcab<AdMetadataListener>> setZzakj = this.zzfwg.zzakj();
        zzepe.zza(setZzakj, "Cannot return null from a non-@Nullable @Provides method");
        return setZzakj;
    }
}
