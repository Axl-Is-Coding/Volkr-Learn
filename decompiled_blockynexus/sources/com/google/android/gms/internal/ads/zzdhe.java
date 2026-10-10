package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.map.geolocation.TencentLocation;
import com.umeng.analytics.pro.au;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzdhe implements zzdgu<Bundle> {
    private final String zzdur;
    private final int zzdus;
    private final int zzdut;
    private final int zzduu;
    private final boolean zzduv;
    private final int zzduw;

    public zzdhe(String str, int i, int i2, int i3, boolean z, int i4) {
        this.zzdur = str;
        this.zzdus = i;
        this.zzdut = i2;
        this.zzduu = i3;
        this.zzduv = z;
        this.zzduw = i4;
    }

    @Override // com.google.android.gms.internal.ads.zzdgu
    public final /* synthetic */ void zzs(Bundle bundle) {
        Bundle bundle2 = bundle;
        zzdot.zza(bundle2, au.O, this.zzdur, !TextUtils.isEmpty(r0));
        zzdot.zza(bundle2, "cnt", Integer.valueOf(this.zzdus), this.zzdus != -2);
        bundle2.putInt("gnt", this.zzdut);
        bundle2.putInt("pt", this.zzduu);
        Bundle bundleZza = zzdot.zza(bundle2, "device");
        bundle2.putBundle("device", bundleZza);
        Bundle bundleZza2 = zzdot.zza(bundleZza, TencentLocation.NETWORK_PROVIDER);
        bundleZza.putBundle(TencentLocation.NETWORK_PROVIDER, bundleZza2);
        bundleZza2.putInt("active_network_state", this.zzduw);
        bundleZza2.putBoolean("active_network_metered", this.zzduv);
    }
}
