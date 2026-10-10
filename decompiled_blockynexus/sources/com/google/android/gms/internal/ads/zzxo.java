package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class zzxo extends zzgt implements zzxp {
    public zzxo() {
        super("com.google.android.gms.ads.internal.client.IClientApi");
    }

    @Override // com.google.android.gms.internal.ads.zzgt
    protected final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        switch (i) {
            case 1:
                zzxc zzxcVarZza = zza(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), (zzvn) zzgw.zza(parcel, zzvn.CREATOR), parcel.readString(), zzane.zzac(parcel.readStrongBinder()), parcel.readInt());
                parcel2.writeNoException();
                zzgw.zza(parcel2, zzxcVarZza);
                return true;
            case 2:
                zzxc zzxcVarZzb = zzb(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), (zzvn) zzgw.zza(parcel, zzvn.CREATOR), parcel.readString(), zzane.zzac(parcel.readStrongBinder()), parcel.readInt());
                parcel2.writeNoException();
                zzgw.zza(parcel2, zzxcVarZzb);
                return true;
            case 3:
                zzwz zzwzVarZza = zza(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), parcel.readString(), zzane.zzac(parcel.readStrongBinder()), parcel.readInt());
                parcel2.writeNoException();
                zzgw.zza(parcel2, zzwzVarZza);
                return true;
            case 4:
                zzxs zzxsVarZzc = zzc(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()));
                parcel2.writeNoException();
                zzgw.zza(parcel2, zzxsVarZzc);
                return true;
            case 5:
                zzaei zzaeiVarZza = zza(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()));
                parcel2.writeNoException();
                zzgw.zza(parcel2, zzaeiVarZza);
                return true;
            case 6:
                zzaud zzaudVarZza = zza(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), zzane.zzac(parcel.readStrongBinder()), parcel.readInt());
                parcel2.writeNoException();
                zzgw.zza(parcel2, zzaudVarZza);
                return true;
            case 7:
                zzarn zzarnVarZzd = zzd(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()));
                parcel2.writeNoException();
                zzgw.zza(parcel2, zzarnVarZzd);
                return true;
            case 8:
                zzaqy zzaqyVarZzb = zzb(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()));
                parcel2.writeNoException();
                zzgw.zza(parcel2, zzaqyVarZzb);
                return true;
            case 9:
                zzxs zzxsVarZza = zza(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt());
                parcel2.writeNoException();
                zzgw.zza(parcel2, zzxsVarZza);
                return true;
            case 10:
                zzxc zzxcVarZza2 = zza(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), (zzvn) zzgw.zza(parcel, zzvn.CREATOR), parcel.readString(), parcel.readInt());
                parcel2.writeNoException();
                zzgw.zza(parcel2, zzxcVarZza2);
                return true;
            case 11:
                zzael zzaelVarZza = zza(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()));
                parcel2.writeNoException();
                zzgw.zza(parcel2, zzaelVarZza);
                return true;
            case 12:
                zzauy zzauyVarZzb = zzb(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), parcel.readString(), zzane.zzac(parcel.readStrongBinder()), parcel.readInt());
                parcel2.writeNoException();
                zzgw.zza(parcel2, zzauyVarZzb);
                return true;
            case 13:
                zzxc zzxcVarZzc = zzc(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), (zzvn) zzgw.zza(parcel, zzvn.CREATOR), parcel.readString(), zzane.zzac(parcel.readStrongBinder()), parcel.readInt());
                parcel2.writeNoException();
                zzgw.zza(parcel2, zzxcVarZzc);
                return true;
            case 14:
                zzaxl zzaxlVarZzb = zzb(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), zzane.zzac(parcel.readStrongBinder()), parcel.readInt());
                parcel2.writeNoException();
                zzgw.zza(parcel2, zzaxlVarZzb);
                return true;
            case 15:
                zzaqp zzaqpVarZzc = zzc(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), zzane.zzac(parcel.readStrongBinder()), parcel.readInt());
                parcel2.writeNoException();
                zzgw.zza(parcel2, zzaqpVarZzc);
                return true;
            default:
                return false;
        }
    }
}
