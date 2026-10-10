package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class zzaed extends zzgt implements zzaee {
    public zzaed() {
        super("com.google.android.gms.ads.internal.formats.client.INativeAdImage");
    }

    public static zzaee zzo(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.INativeAdImage");
        return iInterfaceQueryLocalInterface instanceof zzaee ? (zzaee) iInterfaceQueryLocalInterface : new zzaeg(iBinder);
    }

    @Override // com.google.android.gms.internal.ads.zzgt
    protected final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i == 1) {
            IObjectWrapper iObjectWrapperZzsg = zzsg();
            parcel2.writeNoException();
            zzgw.zza(parcel2, iObjectWrapperZzsg);
        } else if (i == 2) {
            Uri uri = getUri();
            parcel2.writeNoException();
            zzgw.zzb(parcel2, uri);
        } else if (i == 3) {
            double scale = getScale();
            parcel2.writeNoException();
            parcel2.writeDouble(scale);
        } else if (i == 4) {
            int width = getWidth();
            parcel2.writeNoException();
            parcel2.writeInt(width);
        } else {
            if (i != 5) {
                return false;
            }
            int height = getHeight();
            parcel2.writeNoException();
            parcel2.writeInt(height);
        }
        return true;
    }
}
