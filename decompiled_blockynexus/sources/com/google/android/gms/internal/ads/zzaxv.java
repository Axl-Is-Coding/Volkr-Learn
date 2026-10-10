package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.pm.PackageInfo;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzaxv implements zzaxx {
    @Override // com.google.android.gms.internal.ads.zzaxx
    public final zzdzc<String> zza(String str, PackageInfo packageInfo) {
        return zzdyq.zzaf(str);
    }

    @Override // com.google.android.gms.internal.ads.zzaxx
    public final zzdzc<AdvertisingIdClient.Info> zzal(Context context) {
        zzbcg zzbcgVar = new zzbcg();
        zzwm.zzpt();
        if (zzbbg.zzbp(context)) {
            zzbbz.zzeep.execute(new zzaxu(this, context, zzbcgVar));
        }
        return zzbcgVar;
    }

    @Override // com.google.android.gms.internal.ads.zzaxx
    public final zzdzc<String> zza(Context context, int i) {
        return zzdyq.zzaf(null);
    }
}
