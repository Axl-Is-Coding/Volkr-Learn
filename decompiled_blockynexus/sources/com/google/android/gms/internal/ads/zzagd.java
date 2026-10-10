package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class zzagd extends zzgt implements zzage {
    public zzagd() {
        super("com.google.android.gms.ads.internal.formats.client.IUnifiedNativeAd");
    }

    @Override // com.google.android.gms.internal.ads.zzgt
    protected final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        zzafz zzagbVar;
        switch (i) {
            case 2:
                String headline = getHeadline();
                parcel2.writeNoException();
                parcel2.writeString(headline);
                return true;
            case 3:
                List images = getImages();
                parcel2.writeNoException();
                parcel2.writeList(images);
                return true;
            case 4:
                String body = getBody();
                parcel2.writeNoException();
                parcel2.writeString(body);
                return true;
            case 5:
                zzaee zzaeeVarZzsl = zzsl();
                parcel2.writeNoException();
                zzgw.zza(parcel2, zzaeeVarZzsl);
                return true;
            case 6:
                String callToAction = getCallToAction();
                parcel2.writeNoException();
                parcel2.writeString(callToAction);
                return true;
            case 7:
                String advertiser = getAdvertiser();
                parcel2.writeNoException();
                parcel2.writeString(advertiser);
                return true;
            case 8:
                double starRating = getStarRating();
                parcel2.writeNoException();
                parcel2.writeDouble(starRating);
                return true;
            case 9:
                String store = getStore();
                parcel2.writeNoException();
                parcel2.writeString(store);
                return true;
            case 10:
                String price = getPrice();
                parcel2.writeNoException();
                parcel2.writeString(price);
                return true;
            case 11:
                zzyo videoController = getVideoController();
                parcel2.writeNoException();
                zzgw.zza(parcel2, videoController);
                return true;
            case 12:
                String mediationAdapterClassName = getMediationAdapterClassName();
                parcel2.writeNoException();
                parcel2.writeString(mediationAdapterClassName);
                return true;
            case 13:
                destroy();
                parcel2.writeNoException();
                return true;
            case 14:
                zzadw zzadwVarZzsm = zzsm();
                parcel2.writeNoException();
                zzgw.zza(parcel2, zzadwVarZzsm);
                return true;
            case 15:
                performClick((Bundle) zzgw.zza(parcel, Bundle.CREATOR));
                parcel2.writeNoException();
                return true;
            case 16:
                boolean zRecordImpression = recordImpression((Bundle) zzgw.zza(parcel, Bundle.CREATOR));
                parcel2.writeNoException();
                zzgw.writeBoolean(parcel2, zRecordImpression);
                return true;
            case 17:
                reportTouchEvent((Bundle) zzgw.zza(parcel, Bundle.CREATOR));
                parcel2.writeNoException();
                return true;
            case 18:
                IObjectWrapper iObjectWrapperZzsk = zzsk();
                parcel2.writeNoException();
                zzgw.zza(parcel2, iObjectWrapperZzsk);
                return true;
            case 19:
                IObjectWrapper iObjectWrapperZzsn = zzsn();
                parcel2.writeNoException();
                zzgw.zza(parcel2, iObjectWrapperZzsn);
                return true;
            case 20:
                Bundle extras = getExtras();
                parcel2.writeNoException();
                zzgw.zzb(parcel2, extras);
                return true;
            case 21:
                IBinder strongBinder = parcel.readStrongBinder();
                if (strongBinder == null) {
                    zzagbVar = null;
                } else {
                    IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.IUnconfirmedClickListener");
                    zzagbVar = iInterfaceQueryLocalInterface instanceof zzafz ? (zzafz) iInterfaceQueryLocalInterface : new zzagb(strongBinder);
                }
                zza(zzagbVar);
                parcel2.writeNoException();
                return true;
            case 22:
                cancelUnconfirmedClick();
                parcel2.writeNoException();
                return true;
            case 23:
                List muteThisAdReasons = getMuteThisAdReasons();
                parcel2.writeNoException();
                parcel2.writeList(muteThisAdReasons);
                return true;
            case 24:
                boolean zIsCustomMuteThisAdEnabled = isCustomMuteThisAdEnabled();
                parcel2.writeNoException();
                zzgw.writeBoolean(parcel2, zIsCustomMuteThisAdEnabled);
                return true;
            case 25:
                zza(zzyc.zzg(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 26:
                zza(zzxy.zzf(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 27:
                zzsv();
                parcel2.writeNoException();
                return true;
            case 28:
                recordCustomClickGesture();
                parcel2.writeNoException();
                return true;
            case 29:
                zzadz zzadzVarZzsw = zzsw();
                parcel2.writeNoException();
                zzgw.zza(parcel2, zzadzVarZzsw);
                return true;
            case 30:
                boolean zIsCustomClickGestureEnabled = isCustomClickGestureEnabled();
                parcel2.writeNoException();
                zzgw.writeBoolean(parcel2, zIsCustomClickGestureEnabled);
                return true;
            case 31:
                zzyn zzynVarZzki = zzki();
                parcel2.writeNoException();
                zzgw.zza(parcel2, zzynVarZzki);
                return true;
            case 32:
                zza(zzyl.zzi(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            default:
                return false;
        }
    }
}
