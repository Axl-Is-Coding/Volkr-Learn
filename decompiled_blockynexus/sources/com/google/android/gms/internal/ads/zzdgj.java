package com.google.android.gms.internal.ads;

import android.os.Bundle;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzdgj implements zzdgu<Bundle> {
    private final String zzbre;
    private final int zzdri;
    private final boolean zzdsf;
    private final boolean zzeeo;
    private final boolean zzgxs;
    private final int zzgxt;
    private final int zzgxu;

    public zzdgj(boolean z, boolean z2, String str, boolean z3, int i, int i2, int i3) {
        this.zzgxs = z;
        this.zzeeo = z2;
        this.zzbre = str;
        this.zzdsf = z3;
        this.zzdri = i;
        this.zzgxt = i2;
        this.zzgxu = i3;
    }

    @Override // com.google.android.gms.internal.ads.zzdgu
    public final /* synthetic */ void zzs(Bundle bundle) {
        Bundle bundle2 = bundle;
        bundle2.putString("js", this.zzbre);
        bundle2.putBoolean("is_nonagon", true);
        bundle2.putString("extra_caps", (String) zzwm.zzpx().zzd(zzabb.zzcrs));
        bundle2.putInt("target_api", this.zzdri);
        bundle2.putInt("dv", this.zzgxt);
        bundle2.putInt("lv", this.zzgxu);
        Bundle bundleZza = zzdot.zza(bundle2, "sdk_env");
        bundleZza.putBoolean("mf", zzacw.zzdbr.get().booleanValue());
        bundleZza.putBoolean("instant_app", this.zzgxs);
        bundleZza.putBoolean("lite", this.zzeeo);
        bundleZza.putBoolean("is_privileged_process", this.zzdsf);
        bundle2.putBundle("sdk_env", bundleZza);
        Bundle bundleZza2 = zzdot.zza(bundleZza, "build_meta");
        bundleZza2.putString("cl", "330794610");
        bundleZza2.putString("rapid_rc", "dev");
        bundleZza2.putString("rapid_rollup", "HEAD");
        bundleZza.putBundle("build_meta", bundleZza2);
    }
}
