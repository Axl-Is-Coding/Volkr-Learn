package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.pm.ApplicationInfo;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzbdm extends zzbde {
    @Override // com.google.android.gms.internal.ads.zzbde
    public final zzbdf zza(Context context, zzbdu zzbduVar, int i, boolean z, zzabs zzabsVar, zzbdv zzbdvVar) {
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        if (applicationInfo == null || applicationInfo.targetSdkVersion >= 11) {
            return i == 2 ? new zzbeb(context, new zzbdx(context, zzbduVar.zzzx(), zzbduVar.getRequestId(), zzabsVar, zzbduVar.zzzt()), zzbduVar, z, zzbde.zza(zzbduVar), zzbdvVar) : new zzbcs(context, z, zzbde.zza(zzbduVar), zzbdvVar, new zzbdx(context, zzbduVar.zzzx(), zzbduVar.getRequestId(), zzabsVar, zzbduVar.zzzt()));
        }
        return null;
    }
}
