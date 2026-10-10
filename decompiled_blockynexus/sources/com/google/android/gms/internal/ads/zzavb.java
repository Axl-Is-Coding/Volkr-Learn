package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class zzavb extends zzgt implements zzauy {
    public zzavb() {
        super("com.google.android.gms.ads.internal.rewarded.client.IRewardedAd");
    }

    public static zzauy zzar(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.rewarded.client.IRewardedAd");
        return iInterfaceQueryLocalInterface instanceof zzauy ? (zzauy) iInterfaceQueryLocalInterface : new zzava(iBinder);
    }

    @Override // com.google.android.gms.internal.ads.zzgt
    protected final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        zzavg zzaviVar = null;
        zzavg zzaviVar2 = null;
        zzavl zzavkVar = null;
        zzavd zzavfVar = null;
        switch (i) {
            case 1:
                zzvg zzvgVar = (zzvg) zzgw.zza(parcel, zzvg.CREATOR);
                IBinder strongBinder = parcel.readStrongBinder();
                if (strongBinder != null) {
                    IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.rewarded.client.IRewardedAdLoadCallback");
                    zzaviVar = iInterfaceQueryLocalInterface instanceof zzavg ? (zzavg) iInterfaceQueryLocalInterface : new zzavi(strongBinder);
                }
                zza(zzvgVar, zzaviVar);
                parcel2.writeNoException();
                return true;
            case 2:
                IBinder strongBinder2 = parcel.readStrongBinder();
                if (strongBinder2 != null) {
                    IInterface iInterfaceQueryLocalInterface2 = strongBinder2.queryLocalInterface("com.google.android.gms.ads.internal.rewarded.client.IRewardedAdCallback");
                    zzavfVar = iInterfaceQueryLocalInterface2 instanceof zzavd ? (zzavd) iInterfaceQueryLocalInterface2 : new zzavf(strongBinder2);
                }
                zza(zzavfVar);
                parcel2.writeNoException();
                return true;
            case 3:
                boolean zIsLoaded = isLoaded();
                parcel2.writeNoException();
                zzgw.writeBoolean(parcel2, zIsLoaded);
                return true;
            case 4:
                String mediationAdapterClassName = getMediationAdapterClassName();
                parcel2.writeNoException();
                parcel2.writeString(mediationAdapterClassName);
                return true;
            case 5:
                zzh(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 6:
                IBinder strongBinder3 = parcel.readStrongBinder();
                if (strongBinder3 != null) {
                    IInterface iInterfaceQueryLocalInterface3 = strongBinder3.queryLocalInterface("com.google.android.gms.ads.internal.rewarded.client.IRewardedAdSkuListener");
                    zzavkVar = iInterfaceQueryLocalInterface3 instanceof zzavl ? (zzavl) iInterfaceQueryLocalInterface3 : new zzavk(strongBinder3);
                }
                zza(zzavkVar);
                parcel2.writeNoException();
                return true;
            case 7:
                zza((zzavt) zzgw.zza(parcel, zzavt.CREATOR));
                parcel2.writeNoException();
                return true;
            case 8:
                zza(zzyg.zzh(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 9:
                Bundle adMetadata = getAdMetadata();
                parcel2.writeNoException();
                zzgw.zzb(parcel2, adMetadata);
                return true;
            case 10:
                zza(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), zzgw.zza(parcel));
                parcel2.writeNoException();
                return true;
            case 11:
                zzaux zzauxVarZzqz = zzqz();
                parcel2.writeNoException();
                zzgw.zza(parcel2, zzauxVarZzqz);
                return true;
            case 12:
                zzyn zzynVarZzki = zzki();
                parcel2.writeNoException();
                zzgw.zza(parcel2, zzynVarZzki);
                return true;
            case 13:
                zza(zzyl.zzi(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 14:
                zzvg zzvgVar2 = (zzvg) zzgw.zza(parcel, zzvg.CREATOR);
                IBinder strongBinder4 = parcel.readStrongBinder();
                if (strongBinder4 != null) {
                    IInterface iInterfaceQueryLocalInterface4 = strongBinder4.queryLocalInterface("com.google.android.gms.ads.internal.rewarded.client.IRewardedAdLoadCallback");
                    zzaviVar2 = iInterfaceQueryLocalInterface4 instanceof zzavg ? (zzavg) iInterfaceQueryLocalInterface4 : new zzavi(strongBinder4);
                }
                zzb(zzvgVar2, zzaviVar2);
                parcel2.writeNoException();
                return true;
            default:
                return false;
        }
    }
}
