package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.pm.PackageInfo;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public interface zzaxx {
    zzdzc<String> zza(Context context, int i);

    zzdzc<String> zza(String str, PackageInfo packageInfo);

    zzdzc<AdvertisingIdClient.Info> zzal(Context context);
}
