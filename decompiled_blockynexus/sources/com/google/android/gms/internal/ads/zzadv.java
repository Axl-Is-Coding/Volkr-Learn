package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class zzadv extends zzgt implements zzadw {
    public zzadv() {
        super("com.google.android.gms.ads.internal.formats.client.IAttributionInfo");
    }

    public static zzadw zzm(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.IAttributionInfo");
        return iInterfaceQueryLocalInterface instanceof zzadw ? (zzadw) iInterfaceQueryLocalInterface : new zzady(iBinder);
    }

    @Override // com.google.android.gms.internal.ads.zzgt
    protected final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i == 2) {
            String text = getText();
            parcel2.writeNoException();
            parcel2.writeString(text);
            return true;
        }
        if (i != 3) {
            return false;
        }
        List<zzaee> listZzsb = zzsb();
        parcel2.writeNoException();
        parcel2.writeList(listZzsb);
        return true;
    }
}
