package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class zzank extends zzgt implements zzanh {
    public zzank() {
        super("com.google.android.gms.ads.internal.mediation.client.IMediationAdapterListener");
    }

    public static zzanh zzad(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapterListener");
        return iInterfaceQueryLocalInterface instanceof zzanh ? (zzanh) iInterfaceQueryLocalInterface : new zzanj(iBinder);
    }

    @Override // com.google.android.gms.internal.ads.zzgt
    protected final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        zzanm zzanlVar;
        switch (i) {
            case 1:
                onAdClicked();
                break;
            case 2:
                onAdClosed();
                break;
            case 3:
                onAdFailedToLoad(parcel.readInt());
                break;
            case 4:
                onAdLeftApplication();
                break;
            case 5:
                onAdOpened();
                break;
            case 6:
                onAdLoaded();
                break;
            case 7:
                IBinder strongBinder = parcel.readStrongBinder();
                if (strongBinder == null) {
                    zzanlVar = null;
                } else {
                    IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IMediationResponseMetadata");
                    zzanlVar = iInterfaceQueryLocalInterface instanceof zzanm ? (zzanm) iInterfaceQueryLocalInterface : new zzanl(strongBinder);
                }
                zza(zzanlVar);
                break;
            case 8:
                onAdImpression();
                break;
            case 9:
                onAppEvent(parcel.readString(), parcel.readString());
                break;
            case 10:
                zza(zzaez.zzr(parcel.readStrongBinder()), parcel.readString());
                break;
            case 11:
                onVideoEnd();
                break;
            case 12:
                zzdn(parcel.readString());
                break;
            case 13:
                zzuc();
                break;
            case 14:
                zzb((zzauv) zzgw.zza(parcel, zzauv.CREATOR));
                break;
            case 15:
                onVideoPause();
                break;
            case 16:
                zza(zzauw.zzaq(parcel.readStrongBinder()));
                break;
            case 17:
                zzdd(parcel.readInt());
                break;
            case 18:
                zzud();
                break;
            case 19:
                zzb((Bundle) zzgw.zza(parcel, Bundle.CREATOR));
                break;
            case 20:
                onVideoPlay();
                break;
            case 21:
                zzdo(parcel.readString());
                break;
            case 22:
                zzc(parcel.readInt(), parcel.readString());
                break;
            case 23:
                zzc((zzva) zzgw.zza(parcel, zzva.CREATOR));
                break;
            case 24:
                zze((zzva) zzgw.zza(parcel, zzva.CREATOR));
                break;
            default:
                return false;
        }
        parcel2.writeNoException();
        return true;
    }
}
