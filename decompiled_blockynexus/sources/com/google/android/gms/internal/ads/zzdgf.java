package com.google.android.gms.internal.ads;

import android.os.Bundle;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzdgf implements zzdgu<Bundle> {
    private final String zzdxp;
    private final String zzgxn;
    private final String zzgxo;
    private final String zzgxp;
    private final Long zzgxq;

    public zzdgf(String str, String str2, String str3, String str4, Long l) {
        this.zzdxp = str;
        this.zzgxn = str2;
        this.zzgxo = str3;
        this.zzgxp = str4;
        this.zzgxq = l;
    }

    @Override // com.google.android.gms.internal.ads.zzdgu
    public final /* synthetic */ void zzs(Bundle bundle) {
        Bundle bundle2 = bundle;
        zzdot.zza(bundle2, "gmp_app_id", this.zzdxp);
        zzdot.zza(bundle2, "fbs_aiid", this.zzgxn);
        zzdot.zza(bundle2, "fbs_aeid", this.zzgxo);
        zzdot.zza(bundle2, "apm_id_origin", this.zzgxp);
        Long l = this.zzgxq;
        if (l != null) {
            bundle2.putLong("sai_timeout", l.longValue());
        }
    }
}
