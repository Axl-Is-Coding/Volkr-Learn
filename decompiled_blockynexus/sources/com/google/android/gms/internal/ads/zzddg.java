package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.umeng.analytics.pro.au;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzddg implements zzdgu<Bundle> {
    private final double zzdux;
    private final boolean zzduy;

    public zzddg(double d2, boolean z) {
        this.zzdux = d2;
        this.zzduy = z;
    }

    @Override // com.google.android.gms.internal.ads.zzdgu
    public final /* synthetic */ void zzs(Bundle bundle) {
        Bundle bundle2 = bundle;
        Bundle bundleZza = zzdot.zza(bundle2, "device");
        bundle2.putBundle("device", bundleZza);
        Bundle bundleZza2 = zzdot.zza(bundleZza, au.Y);
        bundleZza.putBundle(au.Y, bundleZza2);
        bundleZza2.putBoolean("is_charging", this.zzduy);
        bundleZza2.putDouble("battery_level", this.zzdux);
    }
}
