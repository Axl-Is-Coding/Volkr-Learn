package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzavo {
    public static zzauy zzd(Context context, String str, zzanb zzanbVar) {
        try {
            IBinder iBinderZzd = ((zzave) zzbbt.zza(context, "com.google.android.gms.ads.rewarded.ChimeraRewardedAdCreatorImpl", zzavr.zzbxx)).zzd(ObjectWrapper.wrap(context), str, zzanbVar, 202510000);
            if (iBinderZzd == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinderZzd.queryLocalInterface("com.google.android.gms.ads.internal.rewarded.client.IRewardedAd");
            return iInterfaceQueryLocalInterface instanceof zzauy ? (zzauy) iInterfaceQueryLocalInterface : new zzava(iBinderZzd);
        } catch (RemoteException | zzbbv e2) {
            zzbbq.zze("#007 Could not call remote method.", e2);
            return null;
        }
    }
}
