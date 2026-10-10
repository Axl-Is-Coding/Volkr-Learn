package com.google.android.gms.internal.ads;

import android.os.Bundle;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzdeh implements zzdgu<Bundle> {
    private final String zzdsh;
    private final String zzgws;
    private final Bundle zzgwt;

    private zzdeh(String str, String str2, Bundle bundle) {
        this.zzdsh = str;
        this.zzgws = str2;
        this.zzgwt = bundle;
    }

    @Override // com.google.android.gms.internal.ads.zzdgu
    public final /* synthetic */ void zzs(Bundle bundle) {
        Bundle bundle2 = bundle;
        bundle2.putString("consent_string", this.zzdsh);
        bundle2.putString("fc_consent", this.zzgws);
        bundle2.putBundle("iab_consent_info", this.zzgwt);
    }
}
