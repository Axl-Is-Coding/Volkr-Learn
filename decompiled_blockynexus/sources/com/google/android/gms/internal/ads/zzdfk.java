package com.google.android.gms.internal.ads;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Bundle;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzdfk implements zzdgu<Bundle>, zzdgx<zzdgu<Bundle>> {
    private final ApplicationInfo applicationInfo;
    private final PackageInfo zzdqs;

    zzdfk(ApplicationInfo applicationInfo, PackageInfo packageInfo) {
        this.applicationInfo = applicationInfo;
        this.zzdqs = packageInfo;
    }

    @Override // com.google.android.gms.internal.ads.zzdgx
    public final zzdzc<zzdgu<Bundle>> zzarj() {
        return zzdyq.zzaf(this);
    }

    @Override // com.google.android.gms.internal.ads.zzdgu
    public final /* synthetic */ void zzs(Bundle bundle) {
        Bundle bundle2 = bundle;
        String str = this.applicationInfo.packageName;
        PackageInfo packageInfo = this.zzdqs;
        Integer numValueOf = packageInfo == null ? null : Integer.valueOf(packageInfo.versionCode);
        bundle2.putString("pn", str);
        if (numValueOf != null) {
            bundle2.putInt("vc", numValueOf.intValue());
        }
        if (((Boolean) zzwm.zzpx().zzd(zzabb.zzcvv)).booleanValue()) {
            PackageInfo packageInfo2 = this.zzdqs;
            String str2 = packageInfo2 != null ? packageInfo2.versionName : null;
            if (str2 != null) {
                bundle2.putString("vnm", str2);
            }
        }
    }
}
