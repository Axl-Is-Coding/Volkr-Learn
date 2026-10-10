package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class zzym extends zzgt implements zzyn {
    public zzym() {
        super("com.google.android.gms.ads.internal.client.IResponseInfo");
    }

    public static zzyn zzj(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IResponseInfo");
        return iInterfaceQueryLocalInterface instanceof zzyn ? (zzyn) iInterfaceQueryLocalInterface : new zzyp(iBinder);
    }

    @Override // com.google.android.gms.internal.ads.zzgt
    protected final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i == 1) {
            String mediationAdapterClassName = getMediationAdapterClassName();
            parcel2.writeNoException();
            parcel2.writeString(mediationAdapterClassName);
        } else if (i == 2) {
            String responseId = getResponseId();
            parcel2.writeNoException();
            parcel2.writeString(responseId);
        } else {
            if (i != 3) {
                return false;
            }
            List<zzvr> adapterResponses = getAdapterResponses();
            parcel2.writeNoException();
            parcel2.writeTypedList(adapterResponses);
        }
        return true;
    }
}
