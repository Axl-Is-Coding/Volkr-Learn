package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class zzxv extends zzgt implements zzxs {
    public zzxv() {
        super("com.google.android.gms.ads.internal.client.IMobileAdsSettingManager");
    }

    @Override // com.google.android.gms.internal.ads.zzgt
    protected final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        switch (i) {
            case 1:
                initialize();
                parcel2.writeNoException();
                return true;
            case 2:
                setAppVolume(parcel.readFloat());
                parcel2.writeNoException();
                return true;
            case 3:
                zzch(parcel.readString());
                parcel2.writeNoException();
                return true;
            case 4:
                setAppMuted(zzgw.zza(parcel));
                parcel2.writeNoException();
                return true;
            case 5:
                zzb(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), parcel.readString());
                parcel2.writeNoException();
                return true;
            case 6:
                zza(parcel.readString(), IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 7:
                float fZzqg = zzqg();
                parcel2.writeNoException();
                parcel2.writeFloat(fZzqg);
                return true;
            case 8:
                boolean zZzqh = zzqh();
                parcel2.writeNoException();
                zzgw.writeBoolean(parcel2, zZzqh);
                return true;
            case 9:
                String versionString = getVersionString();
                parcel2.writeNoException();
                parcel2.writeString(versionString);
                return true;
            case 10:
                zzci(parcel.readString());
                parcel2.writeNoException();
                return true;
            case 11:
                zza(zzane.zzac(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 12:
                zza(zzaiw.zzaa(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 13:
                List<zzaiq> listZzqi = zzqi();
                parcel2.writeNoException();
                parcel2.writeTypedList(listZzqi);
                return true;
            case 14:
                zza((zzaae) zzgw.zza(parcel, zzaae.CREATOR));
                parcel2.writeNoException();
                return true;
            case 15:
                zzqj();
                parcel2.writeNoException();
                return true;
            default:
                return false;
        }
    }
}
