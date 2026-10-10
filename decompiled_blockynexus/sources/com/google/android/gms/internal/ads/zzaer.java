package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class zzaer extends zzgt implements zzaes {
    public zzaer() {
        super("com.google.android.gms.ads.internal.formats.client.INativeAppInstallAd");
    }

    @Override // com.google.android.gms.internal.ads.zzgt
    protected final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        switch (i) {
            case 2:
                IObjectWrapper iObjectWrapperZzsk = zzsk();
                parcel2.writeNoException();
                zzgw.zza(parcel2, iObjectWrapperZzsk);
                return true;
            case 3:
                String headline = getHeadline();
                parcel2.writeNoException();
                parcel2.writeString(headline);
                return true;
            case 4:
                List images = getImages();
                parcel2.writeNoException();
                parcel2.writeList(images);
                return true;
            case 5:
                String body = getBody();
                parcel2.writeNoException();
                parcel2.writeString(body);
                return true;
            case 6:
                zzaee zzaeeVarZzsl = zzsl();
                parcel2.writeNoException();
                zzgw.zza(parcel2, zzaeeVarZzsl);
                return true;
            case 7:
                String callToAction = getCallToAction();
                parcel2.writeNoException();
                parcel2.writeString(callToAction);
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
                Bundle extras = getExtras();
                parcel2.writeNoException();
                zzgw.zzb(parcel2, extras);
                return true;
            case 12:
                destroy();
                parcel2.writeNoException();
                return true;
            case 13:
                zzyo videoController = getVideoController();
                parcel2.writeNoException();
                zzgw.zza(parcel2, videoController);
                return true;
            case 14:
                performClick((Bundle) zzgw.zza(parcel, Bundle.CREATOR));
                parcel2.writeNoException();
                return true;
            case 15:
                boolean zRecordImpression = recordImpression((Bundle) zzgw.zza(parcel, Bundle.CREATOR));
                parcel2.writeNoException();
                zzgw.writeBoolean(parcel2, zRecordImpression);
                return true;
            case 16:
                reportTouchEvent((Bundle) zzgw.zza(parcel, Bundle.CREATOR));
                parcel2.writeNoException();
                return true;
            case 17:
                zzadw zzadwVarZzsm = zzsm();
                parcel2.writeNoException();
                zzgw.zza(parcel2, zzadwVarZzsm);
                return true;
            case 18:
                IObjectWrapper iObjectWrapperZzsn = zzsn();
                parcel2.writeNoException();
                zzgw.zza(parcel2, iObjectWrapperZzsn);
                return true;
            case 19:
                String mediationAdapterClassName = getMediationAdapterClassName();
                parcel2.writeNoException();
                parcel2.writeString(mediationAdapterClassName);
                return true;
            default:
                return false;
        }
    }
}
