package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.android.gms.ads.reward.AdMetadataListener;
import java.util.Set;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzbvv extends zzbyr<AdMetadataListener> implements zzagt {
    private Bundle zzfux;

    public zzbvv(Set<zzcab<AdMetadataListener>> set) {
        super(set);
        this.zzfux = new Bundle();
    }

    public final synchronized Bundle getAdMetadata() {
        return new Bundle(this.zzfux);
    }

    @Override // com.google.android.gms.internal.ads.zzagt
    public final synchronized void zza(String str, Bundle bundle) {
        this.zzfux.putAll(bundle);
        zza(zzbvu.zzfur);
    }
}
