package com.google.android.gms.ads.internal.overlay;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.google.android.gms.ads.AdActivity;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.internal.ads.zzayu;
import com.google.android.gms.internal.ads.zzux;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zzl {
    public static void zza(Context context, AdOverlayInfoParcel adOverlayInfoParcel, boolean z) {
        if (adOverlayInfoParcel.zzdpr == 4 && adOverlayInfoParcel.zzdpm == null) {
            zzux zzuxVar = adOverlayInfoParcel.zzcgv;
            if (zzuxVar != null) {
                zzuxVar.onAdClicked();
            }
            com.google.android.gms.ads.internal.zzp.zzkp();
            zza.zza(context, adOverlayInfoParcel.zzdpl, adOverlayInfoParcel.zzdpq);
            return;
        }
        Intent intent = new Intent();
        intent.setClassName(context, AdActivity.CLASS_NAME);
        intent.putExtra("com.google.android.gms.ads.internal.overlay.useClientJar", adOverlayInfoParcel.zzbpe.zzeen);
        intent.putExtra("shouldCallOnOverlayOpened", z);
        AdOverlayInfoParcel.zza(intent, adOverlayInfoParcel);
        if (!PlatformVersion.isAtLeastLollipop()) {
            intent.addFlags(524288);
        }
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        com.google.android.gms.ads.internal.zzp.zzkr();
        zzayu.zza(context, intent);
    }
}
