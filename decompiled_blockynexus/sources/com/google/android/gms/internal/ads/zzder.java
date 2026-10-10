package com.google.android.gms.internal.ads;

import android.os.Bundle;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzder implements zzdgu<Bundle> {
    private final Bundle zzdrq;

    public zzder(Bundle bundle) {
        this.zzdrq = bundle;
    }

    @Override // com.google.android.gms.internal.ads.zzdgu
    public final /* synthetic */ void zzs(Bundle bundle) {
        Bundle bundle2 = bundle;
        Bundle bundleZza = zzdot.zza(bundle2, "device");
        bundleZza.putBundle("android_mem_info", this.zzdrq);
        bundle2.putBundle("device", bundleZza);
    }
}
