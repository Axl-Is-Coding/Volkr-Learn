package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamic.RemoteCreator;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzve extends RemoteCreator<zzxh> {
    @VisibleForTesting
    public zzve() {
        super("com.google.android.gms.ads.AdManagerCreatorImpl");
    }

    @Override // com.google.android.gms.dynamic.RemoteCreator
    protected final /* synthetic */ zzxh getRemoteCreator(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdManagerCreator");
        return iInterfaceQueryLocalInterface instanceof zzxh ? (zzxh) iInterfaceQueryLocalInterface : new zzxg(iBinder);
    }

    public final zzxc zza(Context context, zzvn zzvnVar, String str, zzanb zzanbVar, int i) {
        try {
            IBinder iBinderZza = getRemoteCreatorInstance(context).zza(ObjectWrapper.wrap(context), zzvnVar, str, zzanbVar, 202510000, i);
            if (iBinderZza == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinderZza.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdManager");
            return iInterfaceQueryLocalInterface instanceof zzxc ? (zzxc) iInterfaceQueryLocalInterface : new zzxe(iBinderZza);
        } catch (RemoteException | RemoteCreator.RemoteCreatorException e2) {
            zzbbq.zzb("Could not create remote AdManager.", e2);
            return null;
        }
    }
}
