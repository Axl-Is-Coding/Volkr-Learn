package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.text.TextUtils;
import java.util.ArrayList;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzdha implements zzdgu<Bundle> {
    private final boolean zzdvb;
    private final boolean zzdvc;
    private final String zzdvd;
    private final boolean zzdve;
    private final boolean zzdvf;
    private final boolean zzdvg;
    private final String zzdvh;
    private final String zzdvi;
    private final String zzdvj;
    private final boolean zzdvk;
    private final ArrayList<String> zzgyi;
    private final String zzgyj;
    private final String zzgyk;
    private final long zzgyl;

    public zzdha(boolean z, boolean z2, String str, boolean z3, boolean z4, boolean z5, String str2, ArrayList<String> arrayList, String str3, String str4, String str5, boolean z6, String str6, long j) {
        this.zzdvb = z;
        this.zzdvc = z2;
        this.zzdvd = str;
        this.zzdve = z3;
        this.zzdvf = z4;
        this.zzdvg = z5;
        this.zzdvh = str2;
        this.zzgyi = arrayList;
        this.zzdvi = str3;
        this.zzdvj = str4;
        this.zzgyj = str5;
        this.zzdvk = z6;
        this.zzgyk = str6;
        this.zzgyl = j;
    }

    @Override // com.google.android.gms.internal.ads.zzdgu
    public final /* synthetic */ void zzs(Bundle bundle) {
        Bundle bundle2 = bundle;
        bundle2.putBoolean("cog", this.zzdvb);
        bundle2.putBoolean("coh", this.zzdvc);
        bundle2.putString("gl", this.zzdvd);
        bundle2.putBoolean("simulator", this.zzdve);
        bundle2.putBoolean("is_latchsky", this.zzdvf);
        bundle2.putBoolean("is_sidewinder", this.zzdvg);
        bundle2.putString("hl", this.zzdvh);
        if (!this.zzgyi.isEmpty()) {
            bundle2.putStringArrayList("hl_list", this.zzgyi);
        }
        bundle2.putString("mv", this.zzdvi);
        bundle2.putString("submodel", this.zzgyk);
        Bundle bundleZza = zzdot.zza(bundle2, "device");
        bundle2.putBundle("device", bundleZza);
        bundleZza.putString("build", this.zzgyj);
        if (((Boolean) zzwm.zzpx().zzd(zzabb.zzcrq)).booleanValue()) {
            bundleZza.putLong("remaining_data_partition_space", this.zzgyl);
        }
        Bundle bundleZza2 = zzdot.zza(bundleZza, "browser");
        bundleZza.putBundle("browser", bundleZza2);
        bundleZza2.putBoolean("is_browser_custom_tabs_capable", this.zzdvk);
        if (TextUtils.isEmpty(this.zzdvj)) {
            return;
        }
        Bundle bundleZza3 = zzdot.zza(bundleZza, "play_store");
        bundleZza.putBundle("play_store", bundleZza3);
        bundleZza3.putString("package_version", this.zzdvj);
    }
}
