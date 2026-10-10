package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class zzass extends zzgt implements zzast {
    public zzass() {
        super("com.google.android.gms.ads.internal.request.IAdRequestService");
    }

    @Override // com.google.android.gms.internal.ads.zzgt
    protected final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i != 1) {
            zzasu zzasxVar = null;
            zzasw zzasyVar = null;
            zzasw zzasyVar2 = null;
            zzasw zzasyVar3 = null;
            zzasw zzasyVar4 = null;
            if (i == 2) {
                zzasn zzasnVar = (zzasn) zzgw.zza(parcel, zzasn.CREATOR);
                IBinder strongBinder = parcel.readStrongBinder();
                if (strongBinder != null) {
                    IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.request.IAdResponseListener");
                    zzasxVar = iInterfaceQueryLocalInterface instanceof zzasu ? (zzasu) iInterfaceQueryLocalInterface : new zzasx(strongBinder);
                }
                zza(zzasnVar, zzasxVar);
                parcel2.writeNoException();
            } else if (i == 4) {
                zzatc zzatcVar = (zzatc) zzgw.zza(parcel, zzatc.CREATOR);
                IBinder strongBinder2 = parcel.readStrongBinder();
                if (strongBinder2 != null) {
                    IInterface iInterfaceQueryLocalInterface2 = strongBinder2.queryLocalInterface("com.google.android.gms.ads.internal.request.INonagonStreamingResponseListener");
                    zzasyVar4 = iInterfaceQueryLocalInterface2 instanceof zzasw ? (zzasw) iInterfaceQueryLocalInterface2 : new zzasy(strongBinder2);
                }
                zza(zzatcVar, zzasyVar4);
                parcel2.writeNoException();
            } else if (i == 5) {
                zzatc zzatcVar2 = (zzatc) zzgw.zza(parcel, zzatc.CREATOR);
                IBinder strongBinder3 = parcel.readStrongBinder();
                if (strongBinder3 != null) {
                    IInterface iInterfaceQueryLocalInterface3 = strongBinder3.queryLocalInterface("com.google.android.gms.ads.internal.request.INonagonStreamingResponseListener");
                    zzasyVar3 = iInterfaceQueryLocalInterface3 instanceof zzasw ? (zzasw) iInterfaceQueryLocalInterface3 : new zzasy(strongBinder3);
                }
                zzb(zzatcVar2, zzasyVar3);
                parcel2.writeNoException();
            } else if (i == 6) {
                zzatc zzatcVar3 = (zzatc) zzgw.zza(parcel, zzatc.CREATOR);
                IBinder strongBinder4 = parcel.readStrongBinder();
                if (strongBinder4 != null) {
                    IInterface iInterfaceQueryLocalInterface4 = strongBinder4.queryLocalInterface("com.google.android.gms.ads.internal.request.INonagonStreamingResponseListener");
                    zzasyVar2 = iInterfaceQueryLocalInterface4 instanceof zzasw ? (zzasw) iInterfaceQueryLocalInterface4 : new zzasy(strongBinder4);
                }
                zzc(zzatcVar3, zzasyVar2);
                parcel2.writeNoException();
            } else {
                if (i != 7) {
                    return false;
                }
                String string = parcel.readString();
                IBinder strongBinder5 = parcel.readStrongBinder();
                if (strongBinder5 != null) {
                    IInterface iInterfaceQueryLocalInterface5 = strongBinder5.queryLocalInterface("com.google.android.gms.ads.internal.request.INonagonStreamingResponseListener");
                    zzasyVar = iInterfaceQueryLocalInterface5 instanceof zzasw ? (zzasw) iInterfaceQueryLocalInterface5 : new zzasy(strongBinder5);
                }
                zza(string, zzasyVar);
                parcel2.writeNoException();
            }
        } else {
            zzasp zzaspVarZza = zza((zzasn) zzgw.zza(parcel, zzasn.CREATOR));
            parcel2.writeNoException();
            zzgw.zzb(parcel2, zzaspVarZza);
        }
        return true;
    }
}
