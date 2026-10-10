package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzdlz {
    public static zzdlv<zzbnq, zzbnv> zza(Context context, zzdpw zzdpwVar, zzdqo zzdqoVar) {
        return zzc(context, zzdpwVar, zzdqoVar);
    }

    public static zzdlv<zzbob, zzboh> zzb(Context context, zzdpw zzdpwVar, zzdqo zzdqoVar) {
        return zzc(context, zzdpwVar, zzdqoVar);
    }

    private static <AppOpenAdRequestComponent extends zzbtn<AppOpenAd>, AppOpenAd extends zzbqo> zzdlv<AppOpenAdRequestComponent, AppOpenAd> zzc(Context context, zzdpw zzdpwVar, zzdqo zzdqoVar) {
        if (((Integer) zzwm.zzpx().zzd(zzabb.zzcxf)).intValue() <= 0) {
            return new zzdln();
        }
        zzdqn zzdqnVarZza = zzdqoVar.zza(zzdqf.AppOpen, context, zzdpwVar, new zzdld(new zzdku()));
        return new zzdkz(new zzdlm(new zzdln()), new zzdle(zzdqnVarZza.zzhbu, zzbbz.zzeep), zzdqnVarZza.zzhiu, zzbbz.zzeep);
    }
}
