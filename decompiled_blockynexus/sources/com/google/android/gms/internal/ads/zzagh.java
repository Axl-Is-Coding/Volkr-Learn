package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamic.RemoteCreator;
import java.util.HashMap;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzagh extends RemoteCreator<zzaeq> {
    @VisibleForTesting
    public zzagh() {
        super("com.google.android.gms.ads.NativeAdViewHolderDelegateCreatorImpl");
    }

    @Override // com.google.android.gms.dynamic.RemoteCreator
    protected final /* synthetic */ zzaeq getRemoteCreator(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.INativeAdViewHolderDelegateCreator");
        return iInterfaceQueryLocalInterface instanceof zzaeq ? (zzaeq) iInterfaceQueryLocalInterface : new zzaep(iBinder);
    }

    public final zzael zzb(View view, HashMap<String, View> map, HashMap<String, View> map2) {
        try {
            IBinder iBinderZzb = getRemoteCreatorInstance(view.getContext()).zzb(ObjectWrapper.wrap(view), ObjectWrapper.wrap(map), ObjectWrapper.wrap(map2));
            if (iBinderZzb == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinderZzb.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.INativeAdViewHolderDelegate");
            return iInterfaceQueryLocalInterface instanceof zzael ? (zzael) iInterfaceQueryLocalInterface : new zzaen(iBinderZzb);
        } catch (RemoteException | RemoteCreator.RemoteCreatorException e2) {
            zzbbq.zzd("Could not create remote NativeAdViewHolderDelegate.", e2);
            return null;
        }
    }
}
