package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamic.RemoteCreator;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzzl extends RemoteCreator<zzxx> {
    public zzzl() {
        super("com.google.android.gms.ads.MobileAdsSettingManagerCreatorImpl");
    }

    @Override // com.google.android.gms.dynamic.RemoteCreator
    protected final /* synthetic */ zzxx getRemoteCreator(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IMobileAdsSettingManagerCreator");
        return iInterfaceQueryLocalInterface instanceof zzxx ? (zzxx) iInterfaceQueryLocalInterface : new zzxw(iBinder);
    }

    public final zzxs zzi(Context context) {
        try {
            IBinder iBinderZzb = getRemoteCreatorInstance(context).zzb(ObjectWrapper.wrap(context), 202510000);
            if (iBinderZzb == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinderZzb.queryLocalInterface("com.google.android.gms.ads.internal.client.IMobileAdsSettingManager");
            return iInterfaceQueryLocalInterface instanceof zzxs ? (zzxs) iInterfaceQueryLocalInterface : new zzxu(iBinderZzb);
        } catch (RemoteException | RemoteCreator.RemoteCreatorException e2) {
            zzbbq.zzd("Could not get remote MobileAdsSettingManager.", e2);
            return null;
        }
    }
}
