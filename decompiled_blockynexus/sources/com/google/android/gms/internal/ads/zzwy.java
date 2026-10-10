package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.ads.formats.PublisherAdViewOptions;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class zzwy extends zzgt implements zzwz {
    public zzwy() {
        super("com.google.android.gms.ads.internal.client.IAdLoaderBuilder");
    }

    @Override // com.google.android.gms.internal.ads.zzgt
    protected final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        zzwt zzwvVar = null;
        zzxq zzxtVar = null;
        switch (i) {
            case 1:
                zzwu zzwuVarZzqf = zzqf();
                parcel2.writeNoException();
                zzgw.zza(parcel2, zzwuVarZzqf);
                return true;
            case 2:
                IBinder strongBinder = parcel.readStrongBinder();
                if (strongBinder != null) {
                    IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdListener");
                    zzwvVar = iInterfaceQueryLocalInterface instanceof zzwt ? (zzwt) iInterfaceQueryLocalInterface : new zzwv(strongBinder);
                }
                zzb(zzwvVar);
                parcel2.writeNoException();
                return true;
            case 3:
                zza(zzafd.zzs(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 4:
                zza(zzafi.zzt(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 5:
                zza(parcel.readString(), zzafo.zzv(parcel.readStrongBinder()), zzafj.zzu(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 6:
                zza((zzadu) zzgw.zza(parcel, zzadu.CREATOR));
                parcel2.writeNoException();
                return true;
            case 7:
                IBinder strongBinder2 = parcel.readStrongBinder();
                if (strongBinder2 != null) {
                    IInterface iInterfaceQueryLocalInterface2 = strongBinder2.queryLocalInterface("com.google.android.gms.ads.internal.client.ICorrelationIdProvider");
                    zzxtVar = iInterfaceQueryLocalInterface2 instanceof zzxq ? (zzxq) iInterfaceQueryLocalInterface2 : new zzxt(strongBinder2);
                }
                zzb(zzxtVar);
                parcel2.writeNoException();
                return true;
            case 8:
                zza(zzafr.zzw(parcel.readStrongBinder()), (zzvn) zzgw.zza(parcel, zzvn.CREATOR));
                parcel2.writeNoException();
                return true;
            case 9:
                zza((PublisherAdViewOptions) zzgw.zza(parcel, PublisherAdViewOptions.CREATOR));
                parcel2.writeNoException();
                return true;
            case 10:
                zza(zzafw.zzx(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 11:
            case 12:
            default:
                return false;
            case 13:
                zza((zzajc) zzgw.zza(parcel, zzajc.CREATOR));
                parcel2.writeNoException();
                return true;
            case 14:
                zza(zzajj.zzab(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
        }
    }
}
