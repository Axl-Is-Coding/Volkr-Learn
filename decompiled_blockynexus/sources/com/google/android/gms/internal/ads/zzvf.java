package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamic.RemoteCreator;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzvf extends RemoteCreator<zzxa> {
    public zzvf() {
        super("com.google.android.gms.ads.AdLoaderBuilderCreatorImpl");
    }

    @Override // com.google.android.gms.dynamic.RemoteCreator
    protected final /* synthetic */ zzxa getRemoteCreator(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdLoaderBuilderCreator");
        return iInterfaceQueryLocalInterface instanceof zzxa ? (zzxa) iInterfaceQueryLocalInterface : new zzxd(iBinder);
    }

    public final zzwz zza(Context context, String str, zzanb zzanbVar) {
        try {
            IBinder iBinderZzc = getRemoteCreatorInstance(context).zzc(ObjectWrapper.wrap(context), str, zzanbVar, 202510000);
            if (iBinderZzc == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinderZzc.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdLoaderBuilder");
            return iInterfaceQueryLocalInterface instanceof zzwz ? (zzwz) iInterfaceQueryLocalInterface : new zzxb(iBinderZzc);
        } catch (RemoteException | RemoteCreator.RemoteCreatorException e2) {
            zzbbq.zzd("Could not create remote builder for AdLoader.", e2);
            return null;
        }
    }
}
