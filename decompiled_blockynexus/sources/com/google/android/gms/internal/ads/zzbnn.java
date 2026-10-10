package com.google.android.gms.internal.ads;

import com.google.firebase.analytics.FirebaseAnalytics;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzbnn {
    private final zzdog zzevd;
    private final zzcmu zzfpk;

    public zzbnn(zzcmu zzcmuVar, zzdog zzdogVar) {
        this.zzfpk = zzcmuVar;
        this.zzevd = zzdogVar;
    }

    public final void zzfd(long j) {
        this.zzfpk.zzapf().zza(this.zzevd.zzhew.zzeou).zzr("action", "ad_closed").zzr("show_time", String.valueOf(j)).zzr(FirebaseAnalytics.Param.AD_FORMAT, "appopen").zzapc();
    }
}
