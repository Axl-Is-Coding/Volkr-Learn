package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.content.Context;
import android.telephony.TelephonyManager;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
@TargetApi(26)
public class zzazl extends zzazi {
    @Override // com.google.android.gms.internal.ads.zzazd
    public final zzuk zza(Context context, TelephonyManager telephonyManager) {
        com.google.android.gms.ads.internal.zzp.zzkr();
        return zzayu.zzr(context, "android.permission.ACCESS_NETWORK_STATE") ? telephonyManager.isDataEnabled() ? zzuk.ENUM_TRUE : zzuk.ENUM_FALSE : zzuk.ENUM_FALSE;
    }
}
