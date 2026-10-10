package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamic.RemoteCreator;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzaqz extends RemoteCreator<zzard> {
    public zzaqz() {
        super("com.google.android.gms.ads.AdOverlayCreatorImpl");
    }

    @Override // com.google.android.gms.dynamic.RemoteCreator
    protected final /* synthetic */ zzard getRemoteCreator(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.overlay.client.IAdOverlayCreator");
        return iInterfaceQueryLocalInterface instanceof zzard ? (zzard) iInterfaceQueryLocalInterface : new zzarc(iBinder);
    }

    public final zzaqy zzc(Activity activity) {
        try {
            IBinder iBinderZzae = getRemoteCreatorInstance(activity).zzae(ObjectWrapper.wrap(activity));
            if (iBinderZzae == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinderZzae.queryLocalInterface("com.google.android.gms.ads.internal.overlay.client.IAdOverlay");
            return iInterfaceQueryLocalInterface instanceof zzaqy ? (zzaqy) iInterfaceQueryLocalInterface : new zzara(iBinderZzae);
        } catch (RemoteException e2) {
            zzbbq.zzd("Could not create remote AdOverlay.", e2);
            return null;
        } catch (RemoteCreator.RemoteCreatorException e3) {
            zzbbq.zzd("Could not create remote AdOverlay.", e3);
            return null;
        }
    }
}
