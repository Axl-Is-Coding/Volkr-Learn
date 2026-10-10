package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzxr extends zzgu implements zzxp {
    zzxr(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IClientApi");
    }

    @Override // com.google.android.gms.internal.ads.zzxp
    public final zzxc zza(IObjectWrapper iObjectWrapper, zzvn zzvnVar, String str, zzanb zzanbVar, int i) throws RemoteException {
        zzxc zzxeVar;
        Parcel parcelObtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzgw.zza(parcelObtainAndWriteInterfaceToken, iObjectWrapper);
        zzgw.zza(parcelObtainAndWriteInterfaceToken, zzvnVar);
        parcelObtainAndWriteInterfaceToken.writeString(str);
        zzgw.zza(parcelObtainAndWriteInterfaceToken, zzanbVar);
        parcelObtainAndWriteInterfaceToken.writeInt(i);
        Parcel parcelTransactAndReadException = transactAndReadException(1, parcelObtainAndWriteInterfaceToken);
        IBinder strongBinder = parcelTransactAndReadException.readStrongBinder();
        if (strongBinder == null) {
            zzxeVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdManager");
            zzxeVar = iInterfaceQueryLocalInterface instanceof zzxc ? (zzxc) iInterfaceQueryLocalInterface : new zzxe(strongBinder);
        }
        parcelTransactAndReadException.recycle();
        return zzxeVar;
    }

    @Override // com.google.android.gms.internal.ads.zzxp
    public final zzxc zzb(IObjectWrapper iObjectWrapper, zzvn zzvnVar, String str, zzanb zzanbVar, int i) throws RemoteException {
        zzxc zzxeVar;
        Parcel parcelObtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzgw.zza(parcelObtainAndWriteInterfaceToken, iObjectWrapper);
        zzgw.zza(parcelObtainAndWriteInterfaceToken, zzvnVar);
        parcelObtainAndWriteInterfaceToken.writeString(str);
        zzgw.zza(parcelObtainAndWriteInterfaceToken, zzanbVar);
        parcelObtainAndWriteInterfaceToken.writeInt(i);
        Parcel parcelTransactAndReadException = transactAndReadException(2, parcelObtainAndWriteInterfaceToken);
        IBinder strongBinder = parcelTransactAndReadException.readStrongBinder();
        if (strongBinder == null) {
            zzxeVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdManager");
            zzxeVar = iInterfaceQueryLocalInterface instanceof zzxc ? (zzxc) iInterfaceQueryLocalInterface : new zzxe(strongBinder);
        }
        parcelTransactAndReadException.recycle();
        return zzxeVar;
    }

    @Override // com.google.android.gms.internal.ads.zzxp
    public final zzxs zzc(IObjectWrapper iObjectWrapper) throws RemoteException {
        zzxs zzxuVar;
        Parcel parcelObtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzgw.zza(parcelObtainAndWriteInterfaceToken, iObjectWrapper);
        Parcel parcelTransactAndReadException = transactAndReadException(4, parcelObtainAndWriteInterfaceToken);
        IBinder strongBinder = parcelTransactAndReadException.readStrongBinder();
        if (strongBinder == null) {
            zzxuVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IMobileAdsSettingManager");
            zzxuVar = iInterfaceQueryLocalInterface instanceof zzxs ? (zzxs) iInterfaceQueryLocalInterface : new zzxu(strongBinder);
        }
        parcelTransactAndReadException.recycle();
        return zzxuVar;
    }

    @Override // com.google.android.gms.internal.ads.zzxp
    public final zzarn zzd(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel parcelObtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzgw.zza(parcelObtainAndWriteInterfaceToken, iObjectWrapper);
        Parcel parcelTransactAndReadException = transactAndReadException(7, parcelObtainAndWriteInterfaceToken);
        zzarn zzarnVarZzak = zzarm.zzak(parcelTransactAndReadException.readStrongBinder());
        parcelTransactAndReadException.recycle();
        return zzarnVarZzak;
    }

    @Override // com.google.android.gms.internal.ads.zzxp
    public final zzxc zzc(IObjectWrapper iObjectWrapper, zzvn zzvnVar, String str, zzanb zzanbVar, int i) throws RemoteException {
        zzxc zzxeVar;
        Parcel parcelObtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzgw.zza(parcelObtainAndWriteInterfaceToken, iObjectWrapper);
        zzgw.zza(parcelObtainAndWriteInterfaceToken, zzvnVar);
        parcelObtainAndWriteInterfaceToken.writeString(str);
        zzgw.zza(parcelObtainAndWriteInterfaceToken, zzanbVar);
        parcelObtainAndWriteInterfaceToken.writeInt(i);
        Parcel parcelTransactAndReadException = transactAndReadException(13, parcelObtainAndWriteInterfaceToken);
        IBinder strongBinder = parcelTransactAndReadException.readStrongBinder();
        if (strongBinder == null) {
            zzxeVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdManager");
            if (iInterfaceQueryLocalInterface instanceof zzxc) {
                zzxeVar = (zzxc) iInterfaceQueryLocalInterface;
            } else {
                zzxeVar = new zzxe(strongBinder);
            }
        }
        parcelTransactAndReadException.recycle();
        return zzxeVar;
    }

    @Override // com.google.android.gms.internal.ads.zzxp
    public final zzwz zza(IObjectWrapper iObjectWrapper, String str, zzanb zzanbVar, int i) throws RemoteException {
        zzwz zzxbVar;
        Parcel parcelObtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzgw.zza(parcelObtainAndWriteInterfaceToken, iObjectWrapper);
        parcelObtainAndWriteInterfaceToken.writeString(str);
        zzgw.zza(parcelObtainAndWriteInterfaceToken, zzanbVar);
        parcelObtainAndWriteInterfaceToken.writeInt(i);
        Parcel parcelTransactAndReadException = transactAndReadException(3, parcelObtainAndWriteInterfaceToken);
        IBinder strongBinder = parcelTransactAndReadException.readStrongBinder();
        if (strongBinder == null) {
            zzxbVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdLoaderBuilder");
            if (iInterfaceQueryLocalInterface instanceof zzwz) {
                zzxbVar = (zzwz) iInterfaceQueryLocalInterface;
            } else {
                zzxbVar = new zzxb(strongBinder);
            }
        }
        parcelTransactAndReadException.recycle();
        return zzxbVar;
    }

    @Override // com.google.android.gms.internal.ads.zzxp
    public final zzaqy zzb(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel parcelObtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzgw.zza(parcelObtainAndWriteInterfaceToken, iObjectWrapper);
        Parcel parcelTransactAndReadException = transactAndReadException(8, parcelObtainAndWriteInterfaceToken);
        zzaqy zzaqyVarZzai = zzarb.zzai(parcelTransactAndReadException.readStrongBinder());
        parcelTransactAndReadException.recycle();
        return zzaqyVarZzai;
    }

    @Override // com.google.android.gms.internal.ads.zzxp
    public final zzauy zzb(IObjectWrapper iObjectWrapper, String str, zzanb zzanbVar, int i) throws RemoteException {
        Parcel parcelObtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzgw.zza(parcelObtainAndWriteInterfaceToken, iObjectWrapper);
        parcelObtainAndWriteInterfaceToken.writeString(str);
        zzgw.zza(parcelObtainAndWriteInterfaceToken, zzanbVar);
        parcelObtainAndWriteInterfaceToken.writeInt(i);
        Parcel parcelTransactAndReadException = transactAndReadException(12, parcelObtainAndWriteInterfaceToken);
        zzauy zzauyVarZzar = zzavb.zzar(parcelTransactAndReadException.readStrongBinder());
        parcelTransactAndReadException.recycle();
        return zzauyVarZzar;
    }

    @Override // com.google.android.gms.internal.ads.zzxp
    public final zzaqp zzc(IObjectWrapper iObjectWrapper, zzanb zzanbVar, int i) throws RemoteException {
        Parcel parcelObtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzgw.zza(parcelObtainAndWriteInterfaceToken, iObjectWrapper);
        zzgw.zza(parcelObtainAndWriteInterfaceToken, zzanbVar);
        parcelObtainAndWriteInterfaceToken.writeInt(i);
        Parcel parcelTransactAndReadException = transactAndReadException(15, parcelObtainAndWriteInterfaceToken);
        zzaqp zzaqpVarZzag = zzaqs.zzag(parcelTransactAndReadException.readStrongBinder());
        parcelTransactAndReadException.recycle();
        return zzaqpVarZzag;
    }

    @Override // com.google.android.gms.internal.ads.zzxp
    public final zzaei zza(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2) throws RemoteException {
        Parcel parcelObtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzgw.zza(parcelObtainAndWriteInterfaceToken, iObjectWrapper);
        zzgw.zza(parcelObtainAndWriteInterfaceToken, iObjectWrapper2);
        Parcel parcelTransactAndReadException = transactAndReadException(5, parcelObtainAndWriteInterfaceToken);
        zzaei zzaeiVarZzp = zzaeh.zzp(parcelTransactAndReadException.readStrongBinder());
        parcelTransactAndReadException.recycle();
        return zzaeiVarZzp;
    }

    @Override // com.google.android.gms.internal.ads.zzxp
    public final zzaxl zzb(IObjectWrapper iObjectWrapper, zzanb zzanbVar, int i) throws RemoteException {
        Parcel parcelObtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzgw.zza(parcelObtainAndWriteInterfaceToken, iObjectWrapper);
        zzgw.zza(parcelObtainAndWriteInterfaceToken, zzanbVar);
        parcelObtainAndWriteInterfaceToken.writeInt(i);
        Parcel parcelTransactAndReadException = transactAndReadException(14, parcelObtainAndWriteInterfaceToken);
        zzaxl zzaxlVarZzas = zzaxk.zzas(parcelTransactAndReadException.readStrongBinder());
        parcelTransactAndReadException.recycle();
        return zzaxlVarZzas;
    }

    @Override // com.google.android.gms.internal.ads.zzxp
    public final zzaud zza(IObjectWrapper iObjectWrapper, zzanb zzanbVar, int i) throws RemoteException {
        Parcel parcelObtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzgw.zza(parcelObtainAndWriteInterfaceToken, iObjectWrapper);
        zzgw.zza(parcelObtainAndWriteInterfaceToken, zzanbVar);
        parcelObtainAndWriteInterfaceToken.writeInt(i);
        Parcel parcelTransactAndReadException = transactAndReadException(6, parcelObtainAndWriteInterfaceToken);
        zzaud zzaudVarZzan = zzauc.zzan(parcelTransactAndReadException.readStrongBinder());
        parcelTransactAndReadException.recycle();
        return zzaudVarZzan;
    }

    @Override // com.google.android.gms.internal.ads.zzxp
    public final zzxs zza(IObjectWrapper iObjectWrapper, int i) throws RemoteException {
        zzxs zzxuVar;
        Parcel parcelObtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzgw.zza(parcelObtainAndWriteInterfaceToken, iObjectWrapper);
        parcelObtainAndWriteInterfaceToken.writeInt(i);
        Parcel parcelTransactAndReadException = transactAndReadException(9, parcelObtainAndWriteInterfaceToken);
        IBinder strongBinder = parcelTransactAndReadException.readStrongBinder();
        if (strongBinder == null) {
            zzxuVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IMobileAdsSettingManager");
            if (iInterfaceQueryLocalInterface instanceof zzxs) {
                zzxuVar = (zzxs) iInterfaceQueryLocalInterface;
            } else {
                zzxuVar = new zzxu(strongBinder);
            }
        }
        parcelTransactAndReadException.recycle();
        return zzxuVar;
    }

    @Override // com.google.android.gms.internal.ads.zzxp
    public final zzxc zza(IObjectWrapper iObjectWrapper, zzvn zzvnVar, String str, int i) throws RemoteException {
        zzxc zzxeVar;
        Parcel parcelObtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzgw.zza(parcelObtainAndWriteInterfaceToken, iObjectWrapper);
        zzgw.zza(parcelObtainAndWriteInterfaceToken, zzvnVar);
        parcelObtainAndWriteInterfaceToken.writeString(str);
        parcelObtainAndWriteInterfaceToken.writeInt(i);
        Parcel parcelTransactAndReadException = transactAndReadException(10, parcelObtainAndWriteInterfaceToken);
        IBinder strongBinder = parcelTransactAndReadException.readStrongBinder();
        if (strongBinder == null) {
            zzxeVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdManager");
            if (iInterfaceQueryLocalInterface instanceof zzxc) {
                zzxeVar = (zzxc) iInterfaceQueryLocalInterface;
            } else {
                zzxeVar = new zzxe(strongBinder);
            }
        }
        parcelTransactAndReadException.recycle();
        return zzxeVar;
    }

    @Override // com.google.android.gms.internal.ads.zzxp
    public final zzael zza(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, IObjectWrapper iObjectWrapper3) throws RemoteException {
        Parcel parcelObtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzgw.zza(parcelObtainAndWriteInterfaceToken, iObjectWrapper);
        zzgw.zza(parcelObtainAndWriteInterfaceToken, iObjectWrapper2);
        zzgw.zza(parcelObtainAndWriteInterfaceToken, iObjectWrapper3);
        Parcel parcelTransactAndReadException = transactAndReadException(11, parcelObtainAndWriteInterfaceToken);
        zzael zzaelVarZzq = zzaeo.zzq(parcelTransactAndReadException.readStrongBinder());
        parcelTransactAndReadException.recycle();
        return zzaelVarZzq;
    }
}
