package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.pm.PackageManager;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.ads.zzcf;

/* JADX INFO: compiled from: com.google.android.gms:play-services-gass@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
@VisibleForTesting
final class zzdtw implements zzdtv {
    private static final zzcf.zza zzhmx = (zzcf.zza) zzcf.zza.zzaq().zzw("E").zzbgt();

    zzdtw() {
    }

    @Override // com.google.android.gms.internal.ads.zzdtv
    public final zzcf.zza zzawe() {
        return zzhmx;
    }

    @Override // com.google.android.gms.internal.ads.zzdtv
    public final zzcf.zza zzck(Context context) throws PackageManager.NameNotFoundException {
        return zzdtj.zzj(context, context.getPackageName(), Integer.toString(context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode));
    }
}
