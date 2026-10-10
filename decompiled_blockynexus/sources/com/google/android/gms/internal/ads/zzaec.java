package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class zzaec extends zzgt implements zzadz {
    public zzaec() {
        super("com.google.android.gms.ads.internal.formats.client.IMediaContent");
    }

    public static zzadz zzn(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.IMediaContent");
        return iInterfaceQueryLocalInterface instanceof zzadz ? (zzadz) iInterfaceQueryLocalInterface : new zzaeb(iBinder);
    }

    @Override // com.google.android.gms.internal.ads.zzgt
    protected final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        zzafq zzafpVar;
        switch (i) {
            case 2:
                float aspectRatio = getAspectRatio();
                parcel2.writeNoException();
                parcel2.writeFloat(aspectRatio);
                return true;
            case 3:
                zzo(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 4:
                IObjectWrapper iObjectWrapperZzsj = zzsj();
                parcel2.writeNoException();
                zzgw.zza(parcel2, iObjectWrapperZzsj);
                return true;
            case 5:
                float duration = getDuration();
                parcel2.writeNoException();
                parcel2.writeFloat(duration);
                return true;
            case 6:
                float currentTime = getCurrentTime();
                parcel2.writeNoException();
                parcel2.writeFloat(currentTime);
                return true;
            case 7:
                zzyo videoController = getVideoController();
                parcel2.writeNoException();
                zzgw.zza(parcel2, videoController);
                return true;
            case 8:
                boolean zHasVideoContent = hasVideoContent();
                parcel2.writeNoException();
                zzgw.writeBoolean(parcel2, zHasVideoContent);
                return true;
            case 9:
                IBinder strongBinder = parcel.readStrongBinder();
                if (strongBinder == null) {
                    zzafpVar = null;
                } else {
                    IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.IOnMediaContentChangedListener");
                    zzafpVar = iInterfaceQueryLocalInterface instanceof zzafq ? (zzafq) iInterfaceQueryLocalInterface : new zzafp(strongBinder);
                }
                zza(zzafpVar);
                parcel2.writeNoException();
                return true;
            default:
                return false;
        }
    }
}
