package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class zzauc extends zzgt implements zzaud {
    public zzauc() {
        super("com.google.android.gms.ads.internal.reward.client.IRewardedVideoAd");
    }

    public static zzaud zzan(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.reward.client.IRewardedVideoAd");
        return iInterfaceQueryLocalInterface instanceof zzaud ? (zzaud) iInterfaceQueryLocalInterface : new zzauf(iBinder);
    }

    @Override // com.google.android.gms.internal.ads.zzgt
    protected final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i == 1) {
            zza((zzaum) zzgw.zza(parcel, zzaum.CREATOR));
            parcel2.writeNoException();
        } else if (i != 2) {
            zzaug zzauiVar = null;
            zzaub zzauaVar = null;
            if (i == 3) {
                IBinder strongBinder = parcel.readStrongBinder();
                if (strongBinder != null) {
                    IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.reward.client.IRewardedVideoAdListener");
                    zzauiVar = iInterfaceQueryLocalInterface instanceof zzaug ? (zzaug) iInterfaceQueryLocalInterface : new zzaui(strongBinder);
                }
                zza(zzauiVar);
                parcel2.writeNoException();
            } else if (i != 34) {
                switch (i) {
                    case 5:
                        boolean zIsLoaded = isLoaded();
                        parcel2.writeNoException();
                        zzgw.writeBoolean(parcel2, zIsLoaded);
                        break;
                    case 6:
                        pause();
                        parcel2.writeNoException();
                        break;
                    case 7:
                        resume();
                        parcel2.writeNoException();
                        break;
                    case 8:
                        destroy();
                        parcel2.writeNoException();
                        break;
                    case 9:
                        zzj(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        break;
                    case 10:
                        zzk(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        break;
                    case 11:
                        zzl(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        break;
                    case 12:
                        String mediationAdapterClassName = getMediationAdapterClassName();
                        parcel2.writeNoException();
                        parcel2.writeString(mediationAdapterClassName);
                        break;
                    case 13:
                        setUserId(parcel.readString());
                        parcel2.writeNoException();
                        break;
                    case 14:
                        zza(zzxi.zzd(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        break;
                    case 15:
                        Bundle adMetadata = getAdMetadata();
                        parcel2.writeNoException();
                        zzgw.zzb(parcel2, adMetadata);
                        break;
                    case 16:
                        IBinder strongBinder2 = parcel.readStrongBinder();
                        if (strongBinder2 != null) {
                            IInterface iInterfaceQueryLocalInterface2 = strongBinder2.queryLocalInterface("com.google.android.gms.ads.internal.reward.client.IRewardedAdSkuListener");
                            zzauaVar = iInterfaceQueryLocalInterface2 instanceof zzaub ? (zzaub) iInterfaceQueryLocalInterface2 : new zzaua(strongBinder2);
                        }
                        zza(zzauaVar);
                        parcel2.writeNoException();
                        break;
                    case 17:
                        setAppPackageName(parcel.readString());
                        parcel2.writeNoException();
                        break;
                    case 18:
                        zzi(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        break;
                    case 19:
                        setCustomData(parcel.readString());
                        parcel2.writeNoException();
                        break;
                    case 20:
                        boolean zZzra = zzra();
                        parcel2.writeNoException();
                        zzgw.writeBoolean(parcel2, zZzra);
                        break;
                    case 21:
                        zzyn zzynVarZzki = zzki();
                        parcel2.writeNoException();
                        zzgw.zza(parcel2, zzynVarZzki);
                        break;
                    default:
                        return false;
                }
            } else {
                setImmersiveMode(zzgw.zza(parcel));
                parcel2.writeNoException();
            }
        } else {
            show();
            parcel2.writeNoException();
        }
        return true;
    }
}
