package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class zzaez extends zzgt implements zzafa {
    public zzaez() {
        super("com.google.android.gms.ads.internal.formats.client.INativeCustomTemplateAd");
    }

    public static zzafa zzr(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.INativeCustomTemplateAd");
        return iInterfaceQueryLocalInterface instanceof zzafa ? (zzafa) iInterfaceQueryLocalInterface : new zzafc(iBinder);
    }

    @Override // com.google.android.gms.internal.ads.zzgt
    protected final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        switch (i) {
            case 1:
                String strZzcx = zzcx(parcel.readString());
                parcel2.writeNoException();
                parcel2.writeString(strZzcx);
                return true;
            case 2:
                zzaee zzaeeVarZzcy = zzcy(parcel.readString());
                parcel2.writeNoException();
                zzgw.zza(parcel2, zzaeeVarZzcy);
                return true;
            case 3:
                List<String> availableAssetNames = getAvailableAssetNames();
                parcel2.writeNoException();
                parcel2.writeStringList(availableAssetNames);
                return true;
            case 4:
                String customTemplateId = getCustomTemplateId();
                parcel2.writeNoException();
                parcel2.writeString(customTemplateId);
                return true;
            case 5:
                performClick(parcel.readString());
                parcel2.writeNoException();
                return true;
            case 6:
                recordImpression();
                parcel2.writeNoException();
                return true;
            case 7:
                zzyo videoController = getVideoController();
                parcel2.writeNoException();
                zzgw.zza(parcel2, videoController);
                return true;
            case 8:
                destroy();
                parcel2.writeNoException();
                return true;
            case 9:
                IObjectWrapper iObjectWrapperZzsp = zzsp();
                parcel2.writeNoException();
                zzgw.zza(parcel2, iObjectWrapperZzsp);
                return true;
            case 10:
                boolean zZzp = zzp(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()));
                parcel2.writeNoException();
                zzgw.writeBoolean(parcel2, zZzp);
                return true;
            case 11:
                IObjectWrapper iObjectWrapperZzsk = zzsk();
                parcel2.writeNoException();
                zzgw.zza(parcel2, iObjectWrapperZzsk);
                return true;
            case 12:
                boolean zZzsq = zzsq();
                parcel2.writeNoException();
                zzgw.writeBoolean(parcel2, zZzsq);
                return true;
            case 13:
                boolean zZzsr = zzsr();
                parcel2.writeNoException();
                zzgw.writeBoolean(parcel2, zZzsr);
                return true;
            case 14:
                zzq(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 15:
                zzss();
                parcel2.writeNoException();
                return true;
            default:
                return false;
        }
    }
}
