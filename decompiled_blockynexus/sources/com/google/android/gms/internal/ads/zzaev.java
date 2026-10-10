package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class zzaev extends zzgt implements zzaew {
    public zzaev() {
        super("com.google.android.gms.ads.internal.formats.client.INativeContentAd");
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
                zzaee zzaeeVarZzso = zzso();
                parcel2.writeNoException();
                zzgw.zza(parcel2, zzaeeVarZzso);
                return true;
            case 7:
                String callToAction = getCallToAction();
                parcel2.writeNoException();
                parcel2.writeString(callToAction);
                return true;
            case 8:
                String advertiser = getAdvertiser();
                parcel2.writeNoException();
                parcel2.writeString(advertiser);
                return true;
            case 9:
                Bundle extras = getExtras();
                parcel2.writeNoException();
                zzgw.zzb(parcel2, extras);
                return true;
            case 10:
                destroy();
                parcel2.writeNoException();
                return true;
            case 11:
                zzyo videoController = getVideoController();
                parcel2.writeNoException();
                zzgw.zza(parcel2, videoController);
                return true;
            case 12:
                performClick((Bundle) zzgw.zza(parcel, Bundle.CREATOR));
                parcel2.writeNoException();
                return true;
            case 13:
                boolean zRecordImpression = recordImpression((Bundle) zzgw.zza(parcel, Bundle.CREATOR));
                parcel2.writeNoException();
                zzgw.writeBoolean(parcel2, zRecordImpression);
                return true;
            case 14:
                reportTouchEvent((Bundle) zzgw.zza(parcel, Bundle.CREATOR));
                parcel2.writeNoException();
                return true;
            case 15:
                zzadw zzadwVarZzsm = zzsm();
                parcel2.writeNoException();
                zzgw.zza(parcel2, zzadwVarZzsm);
                return true;
            case 16:
                IObjectWrapper iObjectWrapperZzsn = zzsn();
                parcel2.writeNoException();
                zzgw.zza(parcel2, iObjectWrapperZzsn);
                return true;
            case 17:
                String mediationAdapterClassName = getMediationAdapterClassName();
                parcel2.writeNoException();
                parcel2.writeString(mediationAdapterClassName);
                return true;
            default:
                return false;
        }
    }
}
