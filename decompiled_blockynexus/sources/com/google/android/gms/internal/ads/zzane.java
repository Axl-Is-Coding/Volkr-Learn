package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class zzane extends zzgt implements zzanb {
    public zzane() {
        super("com.google.android.gms.ads.internal.mediation.client.IAdapterCreator");
    }

    public static zzanb zzac(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IAdapterCreator");
        return iInterfaceQueryLocalInterface instanceof zzanb ? (zzanb) iInterfaceQueryLocalInterface : new zzand(iBinder);
    }

    @Override // com.google.android.gms.internal.ads.zzgt
    protected final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i == 1) {
            zzang zzangVarZzdi = zzdi(parcel.readString());
            parcel2.writeNoException();
            zzgw.zza(parcel2, zzangVarZzdi);
        } else if (i == 2) {
            boolean zZzdj = zzdj(parcel.readString());
            parcel2.writeNoException();
            zzgw.writeBoolean(parcel2, zZzdj);
        } else {
            if (i != 3) {
                return false;
            }
            zzaph zzaphVarZzdk = zzdk(parcel.readString());
            parcel2.writeNoException();
            zzgw.zza(parcel2, zzaphVarZzdk);
        }
        return true;
    }
}
