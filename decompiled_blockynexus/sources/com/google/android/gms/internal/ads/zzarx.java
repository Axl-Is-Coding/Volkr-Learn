package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.android.gms.ads.query.QueryInfo;
import com.google.android.gms.ads.query.QueryInfoGenerationCallback;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzarx extends zzaxj {
    private final /* synthetic */ QueryInfoGenerationCallback zzdqe;

    zzarx(zzaru zzaruVar, QueryInfoGenerationCallback queryInfoGenerationCallback) {
        this.zzdqe = queryInfoGenerationCallback;
    }

    @Override // com.google.android.gms.internal.ads.zzaxg
    public final void onError(String str) {
        this.zzdqe.onFailure(str);
    }

    @Override // com.google.android.gms.internal.ads.zzaxg
    public final void zza(String str, String str2, Bundle bundle) {
        QueryInfo queryInfo = new QueryInfo(new zzzj(str, bundle));
        zzwm.zzqb().put(queryInfo, str2);
        this.zzdqe.onSuccess(queryInfo);
    }

    @Override // com.google.android.gms.internal.ads.zzaxg
    public final void zzk(String str, String str2) {
        QueryInfo queryInfo = new QueryInfo(new zzzj(str, null));
        zzwm.zzqb().put(queryInfo, str2);
        this.zzdqe.onSuccess(queryInfo);
    }
}
