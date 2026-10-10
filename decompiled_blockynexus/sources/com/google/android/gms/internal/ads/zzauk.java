package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamic.RemoteCreator;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzauk extends RemoteCreator<zzaue> {
    public zzauk() {
        super("com.google.android.gms.ads.reward.RewardedVideoAdCreatorImpl");
    }

    @Override // com.google.android.gms.dynamic.RemoteCreator
    protected final /* synthetic */ zzaue getRemoteCreator(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.reward.client.IRewardedVideoAdCreator");
        return iInterfaceQueryLocalInterface instanceof zzaue ? (zzaue) iInterfaceQueryLocalInterface : new zzauh(iBinder);
    }

    public final zzaud zzc(Context context, zzanb zzanbVar) {
        try {
            IBinder iBinderZzd = getRemoteCreatorInstance(context).zzd(ObjectWrapper.wrap(context), zzanbVar, 202510000);
            if (iBinderZzd == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinderZzd.queryLocalInterface("com.google.android.gms.ads.internal.reward.client.IRewardedVideoAd");
            return iInterfaceQueryLocalInterface instanceof zzaud ? (zzaud) iInterfaceQueryLocalInterface : new zzauf(iBinderZzd);
        } catch (RemoteException | RemoteCreator.RemoteCreatorException e2) {
            zzbbq.zzd("Could not get remote RewardedVideoAd.", e2);
            return null;
        }
    }
}
